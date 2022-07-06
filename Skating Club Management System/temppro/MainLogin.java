import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.Color;

class MainLogin extends JFrame implements ActionListener
{
 public JLabel uname, pswrd;
 public JTextField user;
 public JPasswordField pwd;
 public JButton login,cancel;
 public static String struser, strpwd;
 boolean flag;
Font f;
 Connection con = null;
  Statement stmt = null;
  ResultSet rs;

  public MainLogin ()
  {
    super ("Login Page");
       	
    JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/main111.jpg")));
				  this.add(background);
    this.setSize (1366,786);

f=new Font("Cosmic SANS MS",Font.BOLD,18);
    this.setDefaultCloseOperation (EXIT_ON_CLOSE);

this.getContentPane().setBackground(Color.BLACK);

Color c=new Color(51,255,51);
    uname = new JLabel ("User Name:");
uname.setFont(f); 
uname.setForeground(c);
   pswrd = new JLabel ("Password:");
pswrd.setFont(f); 
pswrd.setForeground(c);
    user=new JTextField();
    pwd=new JPasswordField();    

    login =
      new JButton ("Login",
		   new ImageIcon (ClassLoader.
				  getSystemResource ("pics/button_ok.png")));
    cancel =
      new JButton ("Cancel",
		   new ImageIcon (ClassLoader.
				  getSystemResource
				  ("pics/button_cancel.png")));

    uname.setBounds(190,370,160,25);
    pswrd.setBounds(190,405,100,25);
    user.setBounds(350,370,160,25);
    pwd.setBounds(350,405,160,25);
    login.setBounds(200,450,130,30);
    cancel.setBounds(360,450,130,30);

    background.add (uname);
    background.add (pswrd);
    background.add (user);
    background.add (pwd);
    background.add (login);
    background.add (cancel);

    login.addActionListener (this);
    cancel.addActionListener (this);

	this.setVisible (true);

  }

public void connect()

{

try

	{
		Class.forName("com.mysql.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
		 stmt=con.createStatement();

	}

catch(Exception e)

	{

		System.out.println(e);

	}


}


  public static void main (String s[])
  {
    new MainLogin ();

  }

public int search()
{
int i=0;
try
{	rs=stmt.executeQuery("select * from admin");
		while(rs.next())
		{
			if(user.getText().equals(rs.getString(5)) && pwd.getText().equals(rs.getString(6)))
			{
				i=rs.getInt(1);
				break;
			}
		 }
return i;
}
catch(Exception e )
{
System.out.println(e);
return i;
}

}

  public void actionPerformed (ActionEvent e)
  {
     try
    {
     	//while ()
		{connect();
			 struser= "abc";
			 strpwd= "123";
	  		if (struser.equals (user.getText ()) && (strpwd.equals (pwd.getText())))
	    		{
				System.out.println("*************************");
	      			flag = true;	
	    		}
			else if(search()!=0)
			{
				flag=true;
			}
	  		else
	    		flag = false;
		}

    	}
    catch (Exception ce)
    {
      System.out.println (ce);
    }


if (e.getSource() == login)
{
	if (flag == true)
	  {
		{
			new ManMain1();
			dispose();
		}
		
	  }
	else
	  {
	    	if (user.getText ().equals (""))
	     {
			JOptionPane.showMessageDialog (null,
					       "Please enter the Username","Login Failed",
					       JOptionPane.DEFAULT_OPTION);
		user.requestFocus ();
	      }

	    else if (pwd.getText ().equals (""))
	      {
			JOptionPane.showMessageDialog (null,
					       "Please enter the Password","Login Failed",
					       JOptionPane.DEFAULT_OPTION);
		pwd.requestFocus ();
	      }

	    else
	      {
				JOptionPane.showMessageDialog (null, "Invalid Username or Password","Login Failed",
					       JOptionPane.DEFAULT_OPTION);
			pwd.setText ("");
			pwd.requestFocus ();
	      }
	  }
     }
    		else
      	{
			dispose ();
			new MainScreen ();
      	}
  }
 }
