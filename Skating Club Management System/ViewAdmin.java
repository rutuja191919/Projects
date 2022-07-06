import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import pro.*;

class ViewAdmin extends JFrame implements ActionListener
{static int ano;
  JLabel name,cno,mid,uname, pswrd,cnpswrd;
  JLabel nam,cono,mail,user;
  JLabel pwd;
  JButton back;
Staticinfo s;
 Connection con = null;
  Statement stmt = null;
  ResultSet rs;

   

  public ViewAdmin ()
  {
    super ("Admin Details");
String rsname,rscono,rsmid,rsuname,rspswd;
rsname=new String();
rscono=new String();
rsmid=new String();
rsuname=new String();
rspswd=new String();
       	connect();
try
{
		rs=stmt.executeQuery("select * from admin");
		while(rs.next())
		{	
			if(s.adminuname.equals(rs.getString(5)) && s.adminPsw.equals(rs.getString(6)))
			{
			ano=rs.getInt(1);
			rsname=rs.getString(2);
			rscono=rs.getString(3);
			rsmid=rs.getString(4);
			rsuname=rs.getString(5);
			rspswd=rs.getString(6);
			}
		 }
}
catch(Exception e )
{
System.out.println(e);
}
  JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/8.jpg")));
				  this.add(background);
    this.setSize (1366,786);


    this.setDefaultCloseOperation (EXIT_ON_CLOSE);


    name = new JLabel ("Name:");
    cno= new JLabel ("Contact No:");
    mid = new JLabel ("Mail ID:");
    uname = new JLabel ("User Name:");
    pswrd = new JLabel ("Password:");
    cnpswrd = new JLabel ("Confirm Password:");

    nam=new JLabel();
    cono=new JLabel();
    mail=new JLabel();;
    user=new JLabel();
    pwd=new JLabel();    
    
nam.setText(rsname);
cono.setText(rscono);
mail.setText(rsmid);
user.setText(rsuname);
pwd.setText(rspswd);


back=new JButton ("<<Back");

    name.setBounds(200,160,160,30);
    cno.setBounds(200,200,160,30);
    mid.setBounds(200,240,160,30);
    uname.setBounds(200,280,160,30);
    pswrd.setBounds(200,320,160,30);
  

    nam.setBounds(320,160,200,30);
    cono.setBounds(320,200,200,30);
    mail.setBounds(320,240,200,30);
    user.setBounds(320,280,200,30);
    pwd.setBounds(320,320,200,30);
   
   back.setBounds(50,40,140,30);

    background.add (name);
    background.add (cno);
    background.add (mid);
    background.add (uname);
    background.add (pswrd);
   

    background.add (nam);
    background.add (cono);
    background.add (mail);
    background.add (user);
    background.add (pwd);


    background.add (back);
    back.addActionListener(this);

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
    new ViewAdmin();

  }
  public void actionPerformed (ActionEvent e3)
  {

	if(e3.getSource()==back)
	{
	new DAdmin();
	dispose();
	}

}
}
