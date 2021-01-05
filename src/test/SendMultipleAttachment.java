package test;


import java.util.Properties;

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

import org.testng.annotations.Test;

public class SendMultipleAttachment {
	
@Test
public static void sendMail() throws Exception {
	String to="sappanimuthub@benseron.com"; 
	final String user="automationreport1benseron@gmail.com"; 
	final String password="test@1234"; 

	//1) get the session object 
	Properties pro=new Properties(); 
	pro.put("mail.smtp.host","smtp.gmail.com"); 
	pro.put("mail.smtp.socketFactory.port","465"); 
	pro.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
	pro.put("mail.smtp.auth", "true"); 
	pro.put("mail.smtp.port", "465"); 

	Session session = Session.getDefaultInstance(pro, 
	new javax.mail.Authenticator() { 
	protected PasswordAuthentication getPasswordAuthentication() { 
	return new PasswordAuthentication(user,password); 
	} 
	}); 

	//2) compose message 
	try{ 
	MimeMessage message = new MimeMessage(session); 
	message.setFrom(new InternetAddress(user)); 
	message.addRecipient(Message.RecipientType.TO,new InternetAddress(to)); 
	message.setSubject("Message Aleart"); 

	//3) create MimeBodyPart object and set your message content 
	MimeBodyPart messageBodyPart1 = new MimeBodyPart(); 
	messageBodyPart1.setContent("<h1>ki hall ne rajeev veere<br>theek thaak ho<br>Java Mail Api use krke send kr reha veere tenu</h1>","text/html"); 
	//art1.setText("<h1>This is message body ki hall ne rajeev veere<br>theek thaak ho</h1>"); 

	//4) create new MimeBodyPart object and set DataHandler object to this object 
	MimeBodyPart messageBodyPart2 = new MimeBodyPart(); 
	messageBodyPart2.attachFile("E:\\Hari\\Personal\\Learnings\\Benseron1\\Benseron_TestNG_BO_Mail\\reports.html"); 

	//messageBodyPart2.attachFile("E:\\Hari\\Personal\\Learnings\\Benseron1\\Benseron_TestNG_BO_Mail\\reports.html"); 
	//String filename1 = "E:/Java/Listener.txt";//change accordingly 
	//DataSource source1 = new FileDataSource(filename1); 
	//messageBodyPart2.setDataHandler(new DataHandler(source1)); 
	//messageBodyPart2.setFileName(filename1); 

	MimeBodyPart messageBodyPart3 = new MimeBodyPart(); 
	//String filename2 = "E:/Java/connect.txt";//change accordingly 
	//DataSource source2 = new FileDataSource(filename2); 
	//messageBodyPart3.setDataHandler(new DataHandler(source2)); 
	//messageBodyPart3.setFileName(filename2); 
	//messageBodyPart3.attachFile(System.getProperty(“user.dir”)+”\\test-output\\”+”emailable-report.html”);
	messageBodyPart3.attachFile("E:\\Hari\\Personal\\Learnings\\Benseron1\\Benseron_TestNG_BO_Mail\\test-output\\emailable-report.html");



	//5) create Multipart object and add MimeBodyPart objects to this object 
	Multipart multipart = new MimeMultipart(); 
	multipart.addBodyPart(messageBodyPart2); 
	//multipart.addBodyPart(messageBodyPart2); 
	multipart.addBodyPart(messageBodyPart3); 


	//6) set the multiplart object to the message object 
	message.setContent(multipart); 

	//7) send message 
	Transport.send(message); 

	System.out.println("message sent...."); 
	}catch (MessagingException ex) {ex.printStackTrace();} 
}

}
