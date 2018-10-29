package com.appium.torenzo.android;

import static com.appium.torenzo.android.StaticVariable.screenshotName2;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Practicedemo {
	// File Name SendFileEmail.java
  public static void main(String [] args) throws InterruptedException {     
	  
		/*Process p = Runtime.getRuntime().exec("TASKKILL /F /IM cmd.exe");
		 System.exit(0);*/
	    String to = "arjunthaokar10@gmail.com";
     String from = "arjunthawkar84@gmail.com";
       final String username = "arjunthawkar84@gmail.com";//change accordingly
	    final String password = "thawkar95";//change accordingly	
	    String host = "smtp.googlemail.com";
        String host1 = "localhost";
       Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("pro.turbo-smtp.com", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.port", 587);
	    props.put("-Djava.net.preferIPv4Stack", "true");
	    props.setProperty("mail.smtp.host", host);

	    Session session = Session.getDefaultInstance(props,
	  		  
	  		         new javax.mail.Authenticator() {
	  		           protected javax.mail.PasswordAuthentication getPasswordAuthentication()  {
	  		
	  		           return new javax.mail.PasswordAuthentication( username, password.toString());
	  	
	  		          }
	  		  
	  		          });
		
	    try {
	     System.out.println("Attache capture screenshot and here is screenshot name ==>"+screenshotName2);
         Message message = new MimeMessage(session);
	       message.setFrom(new InternetAddress(from));
	       message.setRecipients(Message.RecipientType.TO,
	          InternetAddress.parse(to));
	       message.setSubject("Testing Report");
	       //
	       BodyPart messageBodyPart = new MimeBodyPart();
	       messageBodyPart.setText("It's execution reprot of the test cases and it's conatin log , screenshot and .html file");
	
	       MimeMultipart multipart1 = new MimeMultipart("related");

	         // first part (the html)
	         BodyPart messageBodyPart1 = new MimeBodyPart();
	       
	         String image = ("user.dir") + "/Screenshot/"  + screenshotName2 + ".png";
	 
	         messageBodyPart1.setContent(image, "text/html");
	         // add it
	         multipart1.addBodyPart(messageBodyPart1);

	         // second part (the image)
	         messageBodyPart1 = new MimeBodyPart();
	      
	         DataSource fds = new FileDataSource
	            (("user.dir") + "/Screenshot/"  + screenshotName2 + ".png");

	         messageBodyPart1.setDataHandler(new DataHandler(fds));
	         messageBodyPart1.setHeader("Content-ID", "<image>");
   
	         // add image to the multipart
	         multipart1.addBodyPart(messageBodyPart1);
			
	         // put everything together
	         message.setContent(multipart1);
	   
	         // Send message
	         Transport.send(message);
	         System.out.println("Screenshot Sent successfully....");
	         
		     
	     	
	    } catch (MessagingException e) {
	       throw new RuntimeException(e);
	    }
	         
	        try {
	   	     System.out.println("Attaching .html report from TestNG");
	              Message message = new MimeMessage(session);
	   	       message.setFrom(new InternetAddress(from));
	   	       message.setRecipients(Message.RecipientType.TO,
	   	          InternetAddress.parse(to));
	   	       message.setSubject("Testing Report");
	   	       //
	   	       BodyPart messageBodyPart = new MimeBodyPart();
	   	       messageBodyPart.setText("It's execution reprot of the test cases and it's conatin log , screenshot and .html file");
	         Multipart multipart = new MimeMultipart();
		       multipart.addBodyPart(messageBodyPart);
		       messageBodyPart = new MimeBodyPart();
		    
		    
		     // String filename = "/C:/Users/nikhil.sonawane/Desktop/swap.txt";
		       Thread.sleep(5000);
		    String filename = ("user.dir")+"/test-output/emailable-report.html";
		     // String filename = "E:/Appium1/Appium/test-output/Default suite/Default test.html";
		     DataSource source = new FileDataSource(filename);
			    messageBodyPart.setDataHandler(new DataHandler(source));
			     messageBodyPart.setFileName(filename);
		       multipart.addBodyPart(messageBodyPart);

		      messageBodyPart = new MimeBodyPart();
		       // Send the complete message parts
		       message.setContent(multipart);
		     

		         // put everything together
		     
		        Transport.send(message);

	         
	         System.out.println(".HTML report Sent successfully....");

	     
	
	    } catch (MessagingException e) {
	       throw new RuntimeException(e);
	    }
		}}  
	


