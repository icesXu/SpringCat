package com.yeepay.credit.mail.service;

import com.yeepay.credit.mail.model.EmailPojo;

public interface TemplateEmailService {
	
	/**
	 * 发送邮件接口
	 * 
	 * @param emailPojo
	 * @return
	 */
	public boolean send(EmailPojo emailPojo);
}
