import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import java.io.*;

import java.util.*;
import pro.*;

class AddAdmin extends JFrame implements ActionListener
{
  static int ano=1;
  JLabel inf,name,cno,mid,uname, pswrd,cnpswrd;
  JTextField nam,cono,mail,user;
  JPasswordField pwd,cnpwd;
  JButton submit,back;
  Staticinfo s;
  Validation v;  
  public AddAdmin ()
  {
    super ("Registration of Admin");
   s=new Staticinfo();    	
  JLabel background=new JLabel();
				  this.add(background);
    this.setSize (1366,786);


    this.setDefaultCloseOperation (EXIT_ON_CLOSE);


    name = new JLabel ("*Name:");
    cno= new JLabel ("*Contact No:");
    mid = new JLabel ("*Mail ID:");
    uname = new JLabel ("*UserName:");
    pswrd = new JLabel ("*Password:");
    cnpswrd = new JLabel ("*Confirm Password:");
    inf=new JLabel("NOTE:=* Indicate Compulsory Fields");

    nam=new JTextField();
    cono=new JTextField();
    mail=new JTextField();
    user=new JTextField();
    pwd=new JPasswordField();    
    cnpwd=new JPasswordField();

    submit =new JButton ("Submit");
back=new JButton ("<<Back");

    name.setBounds(200,100,160,30);
    cno.setBounds(200,140,160,30);
    mid.setBounds(200,180,160,30);
    uname.setBounds(200,220,160,30);
    pswrd.setBounds(200,260,160,30);
    cnpswrd.setBounds(200,300,160,30);
    inf.setBounds(200,340,250,30);

    nam.setBounds(330,100,220,30);
    cono.setBounds(330,140,220,30);
    mail.setBounds(330,180,220,30);
    user.setBounds(330,220,220,30);
    pwd.setBounds(330,260,220,30);
    cnpwd.setBounds(330,300,220,30);


    submit.setBounds(570,400,160,32);
    back.setBounds(620,490,160,32);

    background.add (name);
    background.add (cno);
    background.add (mid);
    background.add (uname);
    background.add (pswrd);
    background.add (cnpswrd);
    background.add (inf); 

    background.add (nam);
    background.add (cono);
    background.add (mail);
    background.add (user);
    background.add (pwd);
    background.add (cnpwd);

    background.add (submit);
    background.add (back);

    submit.addActionListener (this);
     back.addActionListener(this);

	this.setVisible (true);

  }
	 

public int insert()

{

int j,i=0;

try

	{
		s.rs=s.stmt.executeQuery("select max(aid) from admin");
		while(s.rs.next())
		{ano=Integer.parseInt(s.rs.getString(1));ano++; }
		
PreparedStatement ps;

		ps=s.con.prepareStatement("Insert into Admin values(?,?,?,?,?,?)");

		ps.setInt(1,ano);
		ps.setString(2,nam.getText());
		ps.setString(3,cono.getText())
;
		ps.setString(4,mail.getText());
		ps.setString(5,user.getText());

		ps.setString(6,pwd.getText());
		
i=ps.executeUpdate();
	
}

catch(Exception e)

	{
		
System.out.println(e);
	
}
return i;

}

	

public static void main (String s[])
{
    new AddAdmin();

}


public void actionPerformed (ActionEvent e3)
{

int i=0;
v=new Validation();
	if(e3.getSource()==submit)
	{
	if (nam.getText ().equals ("")  || cono.getText ().equals ("") || mail.getText ().equals ("") || user.getText ().equals ("") || pwd.getText ().equals ("") || cnpwd.getText ().equals ("")) 
	     {
		
			JOptionPane.showMessageDialog (null,
					       "All entrys  with * are must","Submission Fail",
					       JOptionPane.DEFAULT_OPTION);
		nam.requestFocus ();
	      }
		else 
	      {          
	
			if(v.validname(nam.getText())==1 && v.validphone(cono.getText())==1 && v.validemail(mail.getText())==1)		
			{i=insert();}
			if(i==1)

			{
		
						
				JOptionPane.showMessageDialog (null,"Submitted Successfully","Process complete",JOptionPane.DEFAULT_OPTION);
			}
	      }
	
	}

	if(e3.getSource()==back)
	{
	new Admin();
	dispose();
	}

}
}
