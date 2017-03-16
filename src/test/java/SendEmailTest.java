

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wzzx.rose.junit.RoseTestCase;
import com.yeepay.credit.mail.model.EmailPojo;
import com.yeepay.credit.mail.service.TemplateEmailService;

public class SendEmailTest extends RoseTestCase {

	@Autowired
	private TemplateEmailService templateEmailService;

	@Test
	public void sendEmail() {
		String type = "1";
		if (type.equals("1")) {
			this.sendSimpleEmail();
		} else if (type.equals("2")) {
			this.sendHtmlEmail();
		} else if (type.equals("3")) {
			this.sendTemplateEmail();
		}
	}

	private boolean sendSimpleEmail() {
		EmailPojo emailPojo = new EmailPojo();
		emailPojo
				.setEmailContent("邮件内容测试, sfdsfsf,fdsfdsf,fdsfsf sfdsfsfsfsfsfsfsfsdfsfsfsffsfsdfsfsfsdfdfdfdfdfdfdfdffdfd");
		emailPojo.setEmailTitle("我的第一个邮件");
		emailPojo.setEmailType("1");
		emailPojo.setSetTo(new String[] { "huaiyang.liu@tcredit.com" });
		// emailPojo.setSetTo(new
		// String[]{"422981784@qq.com","627435924f@qq.com"});
		// emailPojo.setSetToCc(new String[]{"10000liuhuaiyang@163.com"});
		boolean ret = templateEmailService.send(emailPojo);
		return ret;
	}

	private boolean sendHtmlEmail() {
		EmailPojo emailPojo = new EmailPojo();
		emailPojo.setEmailContent("<html><head></head><body><div><font size='10' color='red'>邮件内容测试<br>html格式的邮件，可以自定义格式，传入html格式字符串</font></div></body>");
		emailPojo.setEmailTitle("我的第一个HTML邮件");
		emailPojo.setEmailType("2");
		emailPojo.setSetTo(new String[] { "10000liuhuaiyang@163.com" });
		//emailPojo.setSetToBcc(new String[]{"hui.yang-1@yeepay.com"});
		//emailPojo.setSetToCc(new String[]{"hui.yang-1@yeepay.com"});
		//附件
		List<String> fileIdList = new ArrayList<String>();
		fileIdList.add("/Users/yp-tc-m-2608/work/20150915110101.xlsx");
		fileIdList.add("/Users/yp-tc-m-2608/work/20150915161920.xlsx");
		//fileIdList.add("/Users/yp-tc-m-2608/work/test.png");
		// 添加image
		List<String> imageIdList = new ArrayList<String>();
		imageIdList.add("/Users/yp-tc-m-2608/work/test.png");
		emailPojo.setFileIdList(fileIdList);
		emailPojo.setImageFileIdList(imageIdList);
		return templateEmailService.send(emailPojo);
	}

	private boolean sendTemplateEmail() {
		EmailPojo emailPojo = new EmailPojo();
		emailPojo.setEmailContent("邮件内容测试");
		emailPojo.setEmailTitle("我的第一个模板邮件");
		emailPojo.setEmailType("3");
		emailPojo.setTemplateFileName("demo.ftl");
		emailPojo.setSetTo(new String[] { "10000liuhuaiyang@163.com" });
		// emailPojo.setSetToBcc(new String[]{"10000liuhuaiyang@163.com"});
		// 添加显示信息
		Map<String, String> emailValue = new HashMap<String, String>();
		emailValue.put("userName",
				"<font color='red'>添加用户名,<br>模板邮件也可以传入定义好的html格式串</font>");
		emailPojo.setEmailValue(emailValue);
		// 添加附件
		List<String> fileIdList = new ArrayList<String>();
		fileIdList.add("/Users/yp-tc-m-2608/work/20150915110101.xlsx");
		fileIdList.add("/Users/yp-tc-m-2608/work/20150915161920.xlsx");
		// 添加image
		List<String> imageIdList = new ArrayList<String>();
		imageIdList.add("/Users/yp-tc-m-2608/work/test.png");
		emailPojo.setFileIdList(fileIdList);
		emailPojo.setImageFileIdList(imageIdList);
		boolean ret = templateEmailService.send(emailPojo);
		return ret;
	}
}
