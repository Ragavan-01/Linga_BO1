package templates;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendMail {

	public static void sendmail() throws EmailException
	{
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("automationreport1benseron@gmail.com", "test@1234"));
		email.setSSLOnConnect(true);
		email.setFrom("automationreportbenseron@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("sappanimuthub@benseron.com");
		email.send();
	}
	
	public static void snedMailWithAttachment()
	{
		// Create object of Property file
		Properties props = new Properties();
 
		// this will set host of server- you can change based on your requirement 
		props.put("mail.smtp.host", "smtp.gmail.com");
 
		// set the port of socket factory 
		props.put("mail.smtp.socketFactory.port", "465");
 
		// set socket factory
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
 
		// set the authentication to true
		props.put("mail.smtp.auth", "true");
 
		// set the port of SMTP server
		props.put("mail.smtp.port", "465");
 
		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,
 
				new javax.mail.Authenticator() {
 
					protected PasswordAuthentication getPasswordAuthentication() {
 
					return new PasswordAuthentication("automationreport1benseron@gmail.com", "test@1234");
 
					}
 
				});
 
		try {
 
			// Create object of MimeMessage class
			Message message = new MimeMessage(session);
 
			// Set the from address
			message.setFrom(new InternetAddress("automationreportbenseron@gmail.com"));
 
			// Set the recipient address
			//message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("esyogeswari@benseron.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("sappanimuthub@benseron.com"));

			
                        // Add the subject link
			message.setSubject("Testing Subject");
 
			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();
 
			// Set the body of email
			messageBodyPart1.setText("This is message body");
 
			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
 
			// Mention the file which you want to send
			String filename = "E:\\Hari\\Personal\\Learnings\\Benseron1\\Benseron_TestNG_BO_Mails\\res\\Screen_Shot.png";
							   
			// Create data source and pass the filename
			DataSource source = new FileDataSource(filename);
 
			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));
 
			// set the file
			messageBodyPart2.setFileName(filename);
 
			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();
 
			// add body part 1
			multipart.addBodyPart(messageBodyPart2);
 
			// add body part 2
			multipart.addBodyPart(messageBodyPart1);
 
			// set the content
			message.setContent(multipart);
 
			// finally send the email
			Transport.send(message);
 
			System.out.println("=====Email Sent=====");
 
		} catch (MessagingException e) {
 
			throw new RuntimeException(e);
 
		}
	}

	public static void snedMailWithExcelAttachment() throws Exception
	{
		// Create object of Property file
		Properties props = new Properties();
 
		// this will set host of server- you can change based on your requirement 
		props.put("mail.smtp.host", "smtp.gmail.com");
 
		// set the port of socket factory 
		props.put("mail.smtp.socketFactory.port", "465");
 
		// set socket factory
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
 
		// set the authentication to true
		props.put("mail.smtp.auth", "true");
 
		// set the port of SMTP server
		props.put("mail.smtp.port", "465");
 
		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,
 
				new javax.mail.Authenticator() {
 
					protected PasswordAuthentication getPasswordAuthentication() {
 
					return new PasswordAuthentication("automationreport1benseron@gmail.com", "test@1234");
 
					}
 
				});
 
		try {
 
			// Create object of MimeMessage class
			Message message = new MimeMessage(session);
 
			// Set the from address
			message.setFrom(new InternetAddress("automationreportbenseron@gmail.com"));
 
			// Set the recipient address
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("Hariprasanth.J@benseron.com"));			
			message.setRecipients(Message.RecipientType.CC,InternetAddress.parse("krishnar.k@benseron.com"));
			message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse("sappanimuthub@benseron.com"));
			
			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();
			
		     // Add the subject link
			message.setSubject("Regards Report Verification");
					
			// Set the body of email
			messageBodyPart1.setText("This mail for Report verification for different Store");

			
/*			if(Utility.getProperty("userName").equalsIgnoreCase("support@ridgway.com"))
			{
			     // Add the subject link
				message.setSubject("Ridgway bar and Grill store Report");
						
				// Set the body of email
				messageBodyPart1.setText("This mail for Report verification for Ridgway bar and Grill Store");
			}
			else if(Utility.getProperty("userName").equalsIgnoreCase("support@bevy.com"))
			{
			     // Add the subject link
				message.setSubject("The Bevy store Report");
						
				// Set the body of email
				messageBodyPart1.setText("This mail for Report verification for The Bevy Store");
			}
			else if(Utility.getProperty("userName").equalsIgnoreCase("admin@austinfiregrill.com"))
			{
			     // Add the subject link
				message.setSubject("Austin Firegrill store Report");
						
				// Set the body of email
				messageBodyPart1.setText("This mail for Report verification for Austin Firegrill Store");
			}
			else if(Utility.getProperty("userName").equalsIgnoreCase("admin@aldar.com"))
			{
			     // Add the subject link
				message.setSubject("Aldar store Report");
						
				// Set the body of email
				messageBodyPart1.setText("This mail for Report verification for Aldar Store");
			}
			else
			{
			     // Add the subject link
				message.setSubject("The Hide store Report");
						
				// Set the body of email
				messageBodyPart1.setText("This mail for Report verification for The Hide Store");
			}*/
			 
			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
 
			// Mention the file which you want to send
			String filename = "E:\\Automation\\Reports_Burn.xlsx";
							   
			// Create data source and pass the filename
			DataSource source = new FileDataSource(filename);
 
			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));
 
			// set the file
			messageBodyPart2.setFileName(filename);
 
			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();
 
			// add body part 1
			multipart.addBodyPart(messageBodyPart2);
 
			// add body part 2
			multipart.addBodyPart(messageBodyPart1);
 
			// set the content
			message.setContent(multipart);
 
			// finally send the email
			Transport.send(message);
 
			System.out.println("=====Email Sent=====");
 
		} catch (MessagingException e) {
 
			throw new RuntimeException(e);
 
		}
	}

}
