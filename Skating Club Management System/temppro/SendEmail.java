import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

class SendEmail
{
public static void main(String args[])
	{
	String to=new String("ruchiphalke.2013@gmail.com");
	String from=new String("scsawant1997@gmail.com");
	String host=new String("localhost");
	System.out.println(to+"    "+from +"   "+host);
	Properties p=System.getProperties();
	p.setProperty("mail.smtp.host",host);
	Session s=Session.getDefaultInstance(p);
		try
		{
		MimeMessage m=new MimeMessage(s);
		m.setFrom(new InternetAddress(from));
		m.addRecipient(m.getRecipientType.TO,new InternateAddress(to));
		m.setSubject("Ping");
		m.setText("helllo>>>>>>>>>>>>");
		Transport.send(m);
		System.out.println("message is send");
		}
		catch(MessagingException me)
		{
		me.printStackTrace();
		}
	}

}