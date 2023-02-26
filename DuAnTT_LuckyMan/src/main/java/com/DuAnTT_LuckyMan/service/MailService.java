package com.DuAnTT_LuckyMan.service;

import java.util.Locale;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailService {
	@Autowired
	JavaMailSender mailSender;
	@Autowired
	TemplateEngine templateEngine;

//	public void sendEmail(String subject, String message, String recipientEmail) throws MessagingException {
//		Locale locale = LocaleContextHolder.getLocale();
//		// Prepare the evaluation context
//		Context ctx = new Context(locale);
//		ctx.setVariable("message",message);
//		// Prepare message using a Spring helper
//		MimeMessage mimeMessage = mailSender.createMimeMessage();
//		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
//		mimeMessageHelper.setSubject("Phản hồi mail luật sư");
//		mimeMessageHelper.setTo(recipientEmail);
//		// Create the HTML body using Thymeleaf
//		String htmlContent = "";
//		htmlContent = templateEngine.process("hello/email_en.html", ctx);
//		mimeMessageHelper.setText(htmlContent, true);
//		// Send email
//		mailSender.send(mimeMessage);
//	}
	
	public boolean sendEmaillh( String message) throws MessagingException {
		Locale locale = LocaleContextHolder.getLocale();
//		Prepare the evaluation context
		Context ctx = new Context(locale);
		ctx.setVariable("message",message);
//		 Prepare message using a Spring helper
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
		mimeMessageHelper.setSubject("Phản hồi mail liên hệ");
		mimeMessageHelper.setTo("pkduy003@gmail.com");
//		Create the HTML body using Thymeleaf
		String htmlContent = "";
		htmlContent = templateEngine.process("layout/email_en.html", ctx);
		mimeMessageHelper.setText(htmlContent, true);
//		Send email
		mailSender.send(mimeMessage);
		return true;
	}
	
	public boolean sendEmailqmk(String recipientEmail,String message) throws MessagingException{
		Locale locale = LocaleContextHolder.getLocale();
		// Prepare the evaluation context
		Context ctx = new Context(locale);
//		ctx.setVariable("message", "Đăng ký thành công");
		ctx.setVariable("message", message);
		// Prepare message using a Spring helper
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
		mimeMessageHelper.setSubject("LucKy Man");
		mimeMessageHelper.setTo(recipientEmail);
		// Create the HTML body using Thymeleaf
		String htmlContent = "";
		htmlContent = templateEngine.process("layout/email_en.html", ctx);
		mimeMessageHelper.setText(htmlContent, true);
		// Send email

//		mailSender.send(mimeMessage);
			mailSender.send(mimeMessage);
		return true;
		
}
}
