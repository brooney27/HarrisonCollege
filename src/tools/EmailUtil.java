package tools;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailUtil {
	public static void sendEmail(String to, String from, String subject, String body){
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "localhost");
		props.put("mail.smtp.port", 8081);
		props.put("mail.smtp.auth", "false");
		props.put("mail.smtp.quitwait", "false");
		//NOTE: Session object is part of javax.mail.Session
		javax.mail.Session session = javax.mail.Session.getDefaultInstance(props);
		session.setDebug(true);
		
		try{
			Message message = new MimeMessage(session);
			message.setSubject(subject);
				message.setText(body);

			Address fromAddress = new InternetAddress(from);
			Address toAddress = new InternetAddress(to);
			message.setFrom(fromAddress);
			message.setRecipient(Message.RecipientType.TO, toAddress);

			Transport transport = session.getTransport();
			transport.connect();
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}
