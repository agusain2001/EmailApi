package com.email.EmailApi.Service;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public boolean sendEmail(String subject,String msg,String to){
        boolean f=false;
        // Set properties for the SMTP connection
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587"); // Set the port here

        // Create a Session with the properties
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("agusain2001@gmail.com","quuxuajhyrpiledm");
            }
        });

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);

            // Set the From and To addresses
            message.setFrom(new InternetAddress("agusain2001@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Set the subject and content of the email
            message.setSubject(subject);
            String htmlContent="<h1> this is a html email</h1> <marquee>hlw Ashish</marquee>";
            message.setText(msg);
//            message.setContent(htmlContent,"text/html");
            // Send the email
            Transport.send(message);
f=true;
            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();

        }
        return f;
    }


}
