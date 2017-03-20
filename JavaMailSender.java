package com.epsoft.efastpay.utils;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailSender {

	public static void sendMail(String subject, String content)
			throws MessagingException {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.sina.com");// 存储发送邮件服务器的信息
		props.put("mail.smtp.auth", "true");// 同时通过验证

		// 基本的邮件会话
		Session session = Session.getInstance(props);
		session.setDebug(true);// 设置调试标志
		// 构造信息体
		MimeMessage message = new MimeMessage(session);

		// 发件地址
		Address fromAddress = null;
		fromAddress = new InternetAddress("empiresoft2015@sina.com");

		message.setFrom(fromAddress);

		// 收件地址
		Address toAddress[] = { new InternetAddress("yang_shao_swjtu@126.com"),
				new InternetAddress("abc123_yz@163.com"),
				new InternetAddress("982586194@qq.com") };
		message.addRecipients(Message.RecipientType.TO, toAddress);

		// 解析邮件内容
		message.setSubject(subject);// 设置信件的标题
		message.setText(content);// 设置信件内容
		message.saveChanges(); // implicit with send()//存储信息

		// send e-mail message
		Transport transport = session.getTransport("smtp");
		transport.connect("smtp.sina.com", "empiresoft2015@sina.com",
				"empire2015");
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}
}