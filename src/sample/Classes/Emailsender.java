package sample.Classes;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class Emailsender {
    PreparedMethods pm = new PreparedMethods();


    public void sendEmail(String email, String order, int orderid, double totalsum) {
        try {

            String host = "smtp.gmail.com";
            String user = "thecatstoreproject@gmail.com";
            String pass = "kattmat!";
            String to = email;
            String from = "thecatsstoreproject@gmail.com";
            String subject = "Your order details";
            String messagetext = "You order:\n" + order + "\n" + "Your order id: " + orderid + "\n" + "Totalsum: " + totalsum + " SEK" + "\n" + "Thank you for ordering from The Store!";
            boolean sessiondebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", 587);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessiondebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(messagetext);

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            transport.close();
            System.out.print("message sent!");

            pm.showAlert("Order went Succesful!", "Your order has been confirmed and will be sent soon", "Thanks for using our service! See you soon");


        } catch (Exception e) {
            e.printStackTrace();

            pm.showAlert("Error", "Please register an account", "You must create an account to make an order");

        }//Source: https://www.youtube.com/watch?v=UMfjndwGwnM&t=189s
    }

    public void forgotPassword(String email,String password) {
        try {

            String host = "smtp.gmail.com";
            String user = "thecatstoreproject@gmail.com";
            String pass = "kattmat!";
            String to = email;
            String from = "thecatsstoreproject@gmail.com";
            String subject = "Password";
            String messagetext = "Your password: "+password;
            boolean sessiondebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", 587);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessiondebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(messagetext);

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            transport.close();
            System.out.print("message sent!");

            pm.showAlert("Password sent", "Your password has been sent to your email", "");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}









