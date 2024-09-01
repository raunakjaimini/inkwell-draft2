//package org.martynas.blogapp.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//@Service
//public class EmailService {
//
//    private final JavaMailSender mailSender;
//
//    @Autowired
//    public EmailService(JavaMailSender mailSender) {
//        this.mailSender = mailSender;
//    }
//
//    public void sendWelcomeEmail(String to, String username) throws MessagingException {
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//
//        helper.setTo(to);
//        helper.setSubject("Welcome to Our Blog!");
//
//        // Load email template
//        String content = "<h1>Welcome, " + username + "!</h1>"
//                       + "<p>Thank you for signing up. We're glad to have you with us.</p>";
//
//        helper.setText(content, true);
//
//        mailSender.send(message);
//    }
//}
package org.martynas.blogapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendWelcomeEmail(String to, String username) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject("Welcome to Our Blog!");

        // Load email template
        String content = "<html>" +
                "<head>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f4; }" +
                ".container { max-width: 600px; margin: 0 auto; padding: 20px; background-color: #ffffff; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }" +
                "h1 { color: #333333; }" +
                "p { color: #555555; }" +
                ".footer { margin-top: 20px; font-size: 12px; color: #999999; }" +
                ".footer a { color: #007bff; text-decoration: none; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='container'>" +
                "<h1>Welcome " + username + "!</h1>" +
                "<p>Thank you for signing up for our blog. We're excited to have you join our community. Here’s what you can look forward to:</p>" +
                "<ul>" +
                "<li>Regular updates on the latest blog posts.</li>" +
                "<li>Exclusive content and insights from our team.</li>" +
                "<li>Opportunities to engage with other members of our community.</li>" +
                "</ul>" +
                "<p>If you have any questions or need assistance, feel free to reply to this email or visit our <a href='https://yourblogsite.com/support'>support page</a>.</p>" +
                "<p>Best regards,<br>The Blog Team</p>" +

                "</div>" +
                "</body>" +
                "</html>";

        helper.setText(content, true);

        mailSender.send(message);
    }
}
