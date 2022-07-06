package pro;
import java.io.*;
import java.sql.*;
import java.util.Properties;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;

public class Staticinfo
{
public static String adminuname,adminPsw,substr,mailstr;
public static int sid,bid,mailflag; 
public Connection con = null;

public Statement stmt = null,stmt1=null;
  
public ResultSet rs,rs1;


	public Staticinfo()
	{
	try

		{
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
			 stmt=con.createStatement();
			 stmt1=con.createStatement();


		}

		catch(Exception e)

		{

			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	/*public void sendEmail(String to1) 
	{

		System.out.println("to="+to1+"\nsub="+substr+"\nmail="+mailstr);
      		
		// Recipient's email ID needs to be mentioned.
      		String to = to1;//change accordingly

      		// Sender's email ID needs to be mentioned
      		String from = "skatingacadamypune@gmail.com";//change accordingly
      		final String username = "fandfacademy@gmail.com";//change accordingly
      		final String password = "intexcloud4g";//change accordingly
//final String username = "ruchiphalke.2013@gmail.com";//change accordingly
      		//final String password = "9552514500";//change accordingly


	      	// Assuming you are sending email through relay.jangosmtp.net
      		String host = "smtp.gmail.com";

      		Properties props = new Properties();
      		props.put("mail.smtp.auth", "true");
      		props.put("mail.smtp.starttls.enable", "true");
      		props.put("mail.smtp.host", host);
      		props.put("mail.smtp.port", "587");

      		// Get the Session object.
      		Session session = Session.getInstance(props,new javax.mail.Authenticator() 
		{
         		protected PasswordAuthentication getPasswordAuthentication() 
			{
            				return new PasswordAuthentication(username, password);
         		}

   		});

      		try 
		{
         	// Create a default MimeMessage object.
         	Message message = new MimeMessage(session);

         	// Set From: header field of the header.
         	message.setFrom(new InternetAddress(from));

         	// Set To: header field of the header.
         	message.setRecipients(Message.RecipientType.TO,
         	InternetAddress.parse(to));

         	// Set Subject: header field
         	 	//message.setSubject(substr);
		message.setSubject(substr);

         	// Now set the actual message
        		//message.setText("Hello, this is sample for to check send "+ "email using JavaMailAPI ");
		message.setText(mailstr);


         	// Send message
         	Transport.send(message);

         	System.out.println("Message sent successfully....");

      		}
		catch (MessagingException e) 
		{
        	   	 throw new RuntimeException(e);
      		}
   	}*/

}