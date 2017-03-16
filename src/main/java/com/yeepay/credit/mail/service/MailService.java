package com.yeepay.credit.mail.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.StringUtils;

import com.yeepay.credit.mail.contant.MessageConstants;
import com.yeepay.credit.mail.model.EmailPojo;

/**
 * 发送邮件工具类,此类不能发送模板邮件
 * 
 * @author huaiyang.liu
 *
 */
public class MailService {
	private static MailService instance = new MailService();
	// 日志记录
	private static Logger logger;
	// 发送邮件的处理类
	private static JavaMailSenderImpl sender;
	// 发送邮件的配置参数
	private static Properties prop;

	private MailService() {
		logger = LoggerFactory.getLogger(MailService.class);
		sender = new JavaMailSenderImpl();
		prop = new Properties();
		try {
			setSenderInfo();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static MailService getInstance() {
		return instance;
	}

	/**
	 * 设置邮件发送初始化参数
	 * 
	 * @throws IOException
	 */
	private void setSenderInfo() throws IOException {
		logger.info("初始化邮件服务器相关信息开始...");
		// SMTP主机地址和端口
		Properties settings = PropertiesLoaderUtils
				.loadAllProperties("settings.properties");
		sender.setHost(settings.getProperty(MessageConstants.EMAIL_SMTP_HOST));
		if (StringUtils.hasText(settings
				.getProperty(MessageConstants.EMAIL_SMTP_PORT))) {
			sender.setPort(Integer.parseInt(settings
					.getProperty(MessageConstants.EMAIL_SMTP_PORT)));
		}
		if (StringUtils.hasText(settings
				.getProperty(MessageConstants.EMAIL_SMTP_TIMEOUT))) {
			prop.setProperty(MessageConstants.EMAIL_SMTP_TIMEOUT,
					settings.getProperty(MessageConstants.EMAIL_SMTP_TIMEOUT));
		}
		if (StringUtils.hasText(settings
				.getProperty(MessageConstants.EMAIL_SMTP_STARTTLS))) {
			prop.setProperty(MessageConstants.EMAIL_SMTP_STARTTLS,
					settings.getProperty(MessageConstants.EMAIL_SMTP_STARTTLS));
		}
		if (StringUtils.hasText(settings
				.getProperty(MessageConstants.EMAIL_SMTP_TRUST))) {
			prop.setProperty(MessageConstants.EMAIL_SMTP_TRUST,
					settings.getProperty(MessageConstants.EMAIL_SMTP_TRUST));
		}
		if (StringUtils.hasText(settings.getProperty("")))
			prop.setProperty(MessageConstants.EMAIL_SMTP_AUTH,
					settings.getProperty(MessageConstants.EMAIL_SMTP_AUTH));
		// SMTP验证时，需要用户名和密码
		sender.setUsername(settings
				.getProperty(MessageConstants.EMAIL_SMTP_USER));
		sender.setPassword(settings
				.getProperty(MessageConstants.EMAIL_SMTP_PASSWORD));
		sender.setJavaMailProperties(prop); // 如果要密码验证,这里必须加,不然会报553错误
		logger.info("初始化邮件服务器相关信息结束...");
	}

	/**
	 * 发送邮件接口
	 * 
	 * @throws IOException
	 */
	public boolean send(EmailPojo emailPojo) throws IOException {
		// 校验参数是否正确
		boolean ret = this.validEmailInfo(emailPojo);
		if (!ret) {
			return ret;
		}
		// 发送邮件
		try {
			if (MessageConstants.EMAIL_TYPE_SIMPLE.equals(emailPojo
					.getEmailType())) {
				this.sendSimpleEmail(emailPojo);
			} else if (MessageConstants.EMAIL_TYPE_HTML.equals(emailPojo
					.getEmailType())) {
				this.sendHtmlEmail(emailPojo);
			}
			logger.info("发送邮件成功!");
		} catch (Exception e) {
			logger.info("发送邮件失败：>>>" + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 发送普通的文本邮件
	 * 
	 * @param emailPojo
	 * @throws Exception
	 */
	private void sendSimpleEmail(EmailPojo emailPojo) throws Exception {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		// 设置寄件人、主题与email内容
		mailMessage.setFrom(sender.getUsername());// 这里必须和用户名一样,不然会报553错误
		mailMessage.setSubject(emailPojo.getEmailTitle());
		mailMessage.setText(emailPojo.getEmailContent());
		// 设置邮件接受者信息
		this.setMailSetToInfo(mailMessage, null, emailPojo);
		// 发送邮件
		sender.send(mailMessage);
	}

	/**
	 * 发送html格式的邮件
	 * 
	 * @param emailPojo
	 * @throws Exception
	 */
	private void sendHtmlEmail(EmailPojo emailPojo) throws Exception {
		MimeMessage mimeMessage = sender.createMimeMessage(); // MimeMessage-->java的
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,
				true, MessageConstants.EMAIL_ECODING); // MimeMessageHelper-->spring的
														// 不加后面两个参数会乱码
		// 设置寄件人、主题与email内容
		messageHelper.setSubject(emailPojo.getEmailTitle());
		messageHelper.setFrom(sender.getUsername());
		messageHelper.setText(emailPojo.getEmailContent(), true); // 为true-->发送转义HTML
		// 设置邮件接受者信息
		this.setMailSetToInfo(null, messageHelper, emailPojo);
		// 添加附件
		this.editAddFile(messageHelper, emailPojo);
		// 发送邮件
		sender.send(mimeMessage);
	}

	/**
	 * 添加附件
	 * 
	 * @param messageHelper
	 * @param emailPojo
	 * @throws Exception
	 */
	private void editAddFile(MimeMessageHelper messageHelper,
			EmailPojo emailPojo) throws Exception {
		// 添加附件信息
		if (null != emailPojo.getFileIdList()
				&& emailPojo.getFileIdList().size() > 0) {
			// 在邮件中添加附件
			for (int i = 0; i < emailPojo.getFileIdList().size(); i++) {
				String fileName = emailPojo.getFileIdList().get(i);
				FileSystemResource file = new FileSystemResource(fileName);
				messageHelper.addAttachment(
						MimeUtility.encodeWord(file.getFilename()), file);
			}
		}
		// 添加图片信息
		if (null != emailPojo.getImageFileIdList()
				&& emailPojo.getImageFileIdList().size() > 0) {
			for (int i = 0; i < emailPojo.getImageFileIdList().size(); i++) {
				String fileName = emailPojo.getImageFileIdList().get(i);
				FileSystemResource file = new FileSystemResource(fileName);
				messageHelper.addInline(
						MimeUtility.encodeWord(file.getFilename()), file);
			}
		}
	}

	/**
	 * 编辑邮件接收者
	 * 
	 * @param emailPojo
	 * @return
	 */
	private Map<String, String[]> editRecivers(EmailPojo emailPojo) {
		Map<String, String[]> ret = new HashMap<String, String[]>();
		if (null != emailPojo.getSetToBcc()
				&& emailPojo.getSetToBcc().length > 0) {
			Set<String> bccSet = new HashSet<String>();
			for (int i = 0; i < emailPojo.getSetToBcc().length; i++) {
				bccSet.add(emailPojo.getSetToBcc()[i]);
			}
			ret.put(MessageConstants.EMAIL_SET_BC,
					(String[]) bccSet.toArray(new String[bccSet.size()]));
		}
		if (null != emailPojo.getSetToCc() && emailPojo.getSetToCc().length > 0) {
			Set<String> ccSet = new HashSet<String>();
			for (int i = 0; i < emailPojo.getSetToCc().length; i++) {
				ccSet.add(emailPojo.getSetToCc()[i]);
			}
			ret.put(MessageConstants.EMAIL_SET_CC,
					(String[]) ccSet.toArray(new String[ccSet.size()]));
		}
		if (null != emailPojo.getSetTo() && emailPojo.getSetTo().length > 0) {
			Set<String> setToSet = new HashSet<String>();
			for (int i = 0; i < emailPojo.getSetTo().length; i++) {
				setToSet.add(emailPojo.getSetTo()[i]);
			}
			ret.put(MessageConstants.EMAIL_SET_TO,
					(String[]) setToSet.toArray(new String[setToSet.size()]));
		}
		return ret;
	}

	/**
	 * 设置邮件接受者信息包括抄送人列表，密件人列表，接收人列表
	 * 
	 * @param simpleMessage
	 * @param mimeMessage
	 * @param emailPojo
	 * @throws Exception
	 */
	private void setMailSetToInfo(SimpleMailMessage simpleMessage,
			MimeMessageHelper mimeMessage, EmailPojo emailPojo)
			throws Exception {
		Map<String, String[]> receivers = this.editRecivers(emailPojo);
		String[] setTo = receivers.get(MessageConstants.EMAIL_SET_TO);
		String[] setBcc = receivers.get(MessageConstants.EMAIL_SET_BC);
		String[] setCc = receivers.get(MessageConstants.EMAIL_SET_CC);

		if (receivers != null) {
			if (null != setTo) {
				if (MessageConstants.EMAIL_TYPE_SIMPLE.equals(emailPojo
						.getEmailType())) {
					simpleMessage.setTo(setTo);
				} else {
					mimeMessage.setTo(setTo);
				}

			}
			if (null != setBcc) {
				if (MessageConstants.EMAIL_TYPE_SIMPLE.equals(emailPojo
						.getEmailType())) {
					simpleMessage.setBcc(setBcc);
				} else {
					mimeMessage.setBcc(setBcc);
				}
			}
			if (null != setCc) {
				if (MessageConstants.EMAIL_TYPE_SIMPLE.equals(emailPojo
						.getEmailType())) {
					simpleMessage.setCc(setCc);
				} else {
					mimeMessage.setCc(setCc);
				}
			}
		}
	}

	/**
	 * 校验邮件参数
	 * 
	 * @param emailPojo
	 * @return
	 */
	private boolean validEmailInfo(EmailPojo emailPojo) {
		if (null == emailPojo) {
			logger.info("邮件参数不能为空!");
			return false;
		}
		if (!StringUtils.hasText(emailPojo.getEmailTitle())) {
			logger.info("邮件标题不能为空!");
			return false;
		}
		if (!StringUtils.hasText(emailPojo.getEmailType())) {
			logger.info("邮件类型不能为空!");
			return false;
		}
		if (null == emailPojo.getSetTo() || emailPojo.getSetTo().length == 0) {
			logger.info("邮件接收人不能为空!");
			return false;
		}
		if (!this.isValidEmailFormat(emailPojo.getSetTo())) {
			return false;
		}
		if (!this.isValidEmailFormat(emailPojo.getSetToBcc())) {
			return false;
		}
		if (!this.isValidEmailFormat(emailPojo.getSetToCc())) {
			return false;
		}
		return true;
	}

	/**
	 * 验证email格式是否正确
	 * 
	 * @param emails
	 * @return
	 */
	private boolean isValidEmailFormat(String[] emails) {
		boolean flag = true;
		if (null != emails && emails.length > 0) {
			Pattern p = Pattern.compile(MessageConstants.EMAIL_ZH);
			for (int i = 0; i < emails.length; i++) {
				String email = emails[i];
				Matcher matcher = p.matcher(email);
				flag = matcher.matches();
				if (!flag) {
					logger.info("email格式校验不通过，email为： " + email);
					return false;
				}
			}
		}
		return flag;
	}
}
