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


    public void sendEmail(String email,String order){
        try {

        String host = "smtp.gmail.com";
        String user = "thecatstoreproject@gmail.com";
        String pass = "kattmat!";
        String to = email;
        String from = "thecatsstoreproject@gmail.com";
        String subject = "Your order details";
        String messagetext = order;
        boolean sessiondebug = false;

        Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable","true");
            props.put("mail.smtp.host",host);
            props.put("mail.smtp.port",587);
            props.put("mail.smtp.auth","true");
            props.put("mail.smtp.starttls.required","true");

        java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

        Session mailSession = Session.getDefaultInstance(props, null);
        mailSession.setDebug(sessiondebug);
        Message msg = new MimeMessage(mailSession);
        msg.setFrom(new InternetAddress(from));
        InternetAddress[] address = {new InternetAddress(to)};
        msg.setRecipients(Message.RecipientType.TO,address);
        msg.setSubject(subject); msg.setSentDate(new Date());
        msg.setText(messagetext);

        Transport transport=mailSession.getTransport("smtp");
        transport.connect(host,user,pass);
        transport.sendMessage(msg,msg.getAllRecipients());
        transport.close();
        transport.close();
        System.out.print("message sent!");


    } catch (Exception e) {
        e.printStackTrace();

        pm.showAlert("Error", "Please register an account", "You must create an account to make an order");

    }
}



    }









