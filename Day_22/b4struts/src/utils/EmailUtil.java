package utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class EmailUtil {
	/*
	public static void main(String args[]) {
		
		EmailUtil email = new EmailUtil();
		
		try {
			
			email.generateAndSendEmail("smtp.gmail.com", "587", "", "", "Mail From Mail Service Rmi", "Hi Email from Client Rmi","umesh.lewa@yahoo.com");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	public boolean generateAndSendEmail(String host, 
			String port, 
			String user, 
			String password,
            String subject, 
            String mailContents, 
            String to) throws MessagingException {


	Properties mailServerProperties;
	// Setup Server Properties
	mailServerProperties = System.getProperties();
	mailServerProperties.put("mail.smtp.port", port);
	mailServerProperties.put("mail.smtp.auth", "true");
	mailServerProperties.put("mail.smtp.starttls.enable", "true");
	
	// Setup mail session
	//getMailSession = Session.getDefaultInstance(mailServerProperties, null);
	
	Session getMailSession = Session.getInstance(mailServerProperties,
	new javax.mail.Authenticator() {
	protected PasswordAuthentication getPasswordAuthentication() {
	return new PasswordAuthentication(user, password);
	}
	});
	
	MimeMessage generateMailMessage = new MimeMessage(getMailSession);  
	generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	generateMailMessage.setSubject(subject);
	//generateMailMessage.setContent(mailContents, "text/html");
	//generateMailMessage.setText(mailContents, "text/html");
	
	// Send Email
	Transport transport = getMailSession.getTransport("smtp");
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	
	System.out.println("Email sent at :"+dateFormat.format(date));
	
	boolean isSuccess=true; 
	try {
				
	    BodyPart messageBodyPart1 = new MimeBodyPart();  
	    messageBodyPart1.setText(mailContents);  
	          
	    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
	  
	    String filename = "Invoice.pdf";
	    DataSource source = new FileDataSource(filename);  
	    messageBodyPart2.setDataHandler(new DataHandler(source));  
	    messageBodyPart2.setFileName(filename);  
	     	         
	    Multipart multipart = new MimeMultipart();  
	    multipart.addBodyPart(messageBodyPart1);  
	    multipart.addBodyPart(messageBodyPart2);  
	  
	    generateMailMessage.setContent(multipart );  
		
		// email and password goes here
		transport.connect(host, user, password);
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		System.out.println("Email Sent....!!!");
	} catch(Exception e) {
		e.printStackTrace();
		isSuccess=false;
		} finally {
		transport.close();
	}
	
	System.out.println("Email sent status :"+isSuccess);
	
	return isSuccess;
	
	}
}