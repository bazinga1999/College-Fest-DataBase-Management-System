package fest4;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import static fest.Fest.dates;
import static fest.Fest.meetings;


public class JavaMailUtil {
    public static void sendMail(String recepient) throws Exception {
        if (dates.size()==0){
            return;
        }
        String myAccountEmail = "prutyaygautam@gmail.com";
        String password = "iamanindian123";

        System.out.println("Preparing to send email");
        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");




        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, recepient);


        System.out.println("Message sent successfully");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        String s="";
        if (dates.size()==0){
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate d=LocalDate.parse("2100-05-20", formatter);
        int j;
        for (int i=0;i<dates.size();i++){
            if (dates.get(i).compareTo(d)<0){
                d=dates.get(i);
                s=meetings.get(i);
            }
        }
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Meeting on "+d.toString());
            message.setText(s);
            Transport.send(message);

            return message;
        } catch (Exception ex) {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
