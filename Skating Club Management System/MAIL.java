import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

class tester {
 public static void main(String args[]) {
   Properties props = new Properties();
   props.put("mail.smtp.com" , "smtp.gmail.com");
   Session session  = Session.getDefaultInstance( props , null);
   String to = "me@gmail.com";
   String from = "from@gmail.com";
   String subject = "Testing...";
   Message msg = new MimeMessage(session);
    try {
      msg.setFrom(new InternetAddress(from));
      msg.setRecipient(Message.RecipientType.TO , new InternetAddress(to));
      msg.setSubject(subject);
      msg.setText("Working fine..!");
    }  catch(Exception exc) {
       }
 }
}