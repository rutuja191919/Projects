import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import pro.*;

class DelAdmin extends JFrame implements ActionListener
{
  static int ano;
  JLabel name,cno,mid,uname, pswrd,cnpswrd;
  JLabel nam,cono,mail,user;
  JLabel pwd;
  JButton back,submit;
Staticinfo s;
 
 public DelAdmin ()
  {
    super ("Delete Admin");
   s=new Staticinfo();    	
String rsname,rscono,rsmid,rsuname,rspswd;
rsname=new String();
rscono=new String();
rsmid=new String();
rsuname=new String();
rspswd=new String();

try
{
		s.rs=s.stmt.executeQuery("select * from admin");
		while(s.rs.next())
		{	
			if(s.adminuname.equals(s.rs.getString(5)) && s.adminPsw.equals(s.rs.getString(6)))
			{
			ano=s.rs.getInt(1);
			rsname=s.rs.getString(2);
			rscono=s.rs.getString(3);
			rsmid=s.rs.getString(4);
			rsuname=s.rs.getString(5);
			rspswd=s.rs.getString(6);
			}
		 }
}
catch(Exception e )
{
System.out.println(e);
}
  JLabel background=new JLabel();
				  this.add(background);
    this.setSize (1366,786);


    this.setDefaultCloseOperation (EXIT_ON_CLOSE);


    name = new JLabel ("Name:");
    cno= new JLabel ("Contact No:");
    mid = new JLabel ("Mail ID:");
    uname = new JLabel ("UserName:");
    pswrd = new JLabel ("Password:");
    cnpswrd = new JLabel ("Confirm Password:");

    nam=new JLabel();
    cono=new JLabel();
    mail=new JLabel();
    user=new JLabel();
    pwd=new JLabel();    
    
nam.setText(rsname);
cono.setText(rscono);
mail.setText(rsmid);
user.setText(rsuname);
pwd.setText(rspswd);

submit=new JButton("Confirm");
back=new JButton ("Back",
		   new ImageIcon (ClassLoader.
				  getSystemResource ("pics/back.png")));

    name.setBounds(200,100,160,30);
    cno.setBounds(200,140,160,30);
    mid.setBounds(200,180,160,30);
    uname.setBounds(200,220,160,30);
    pswrd.setBounds(200,260,160,30);
  

    nam.setBounds(320,100,200,30);
    cono.setBounds(320,140,200,30);
    mail.setBounds(320,180,200,30);
    user.setBounds(320,220,200,30);
    pwd.setBounds(320,260,200,30);
   
submit.setBounds(700,450,120,32);
    back.setBounds(700,490,120,32);

    background.add (name);
    background.add (cno);
    background.add (mid);
    background.add (uname);
    background.add (pswrd);
    background.add (submit);

    background.add (nam);
    background.add (cono);
    background.add (mail);
    background.add (user);
    background.add (pwd);


    background.add (back);
    back.addActionListener(this);
submit.addActionListener(this);
	this.setVisible (true);
}


  public static void main (String s[])
  {
    new DelAdmin();
  }

public int delete()

{

int i=0;

try

	{
		
		
PreparedStatement ps;

		ps=s.con.prepareStatement("delete from admin where aid=?");

		ps.setInt(1,ano);
		
i=ps.executeUpdate();
	
}

catch(Exception e)

	{
		
System.out.println(e);
	
}
return i;

}



  public void actionPerformed (ActionEvent e3)
  {
int i;
	if(e3.getSource()==submit)
	{
	     i=delete();
			if(i==1)

			{
				
				JOptionPane.showMessageDialog (null,
					       "Admin Successfully Deleted","Process Complete",
					       JOptionPane.DEFAULT_OPTION);
new DAdmin();
	dispose();
			}
			
		
	     
	}
	if(e3.getSource()==back)
	{
	new DAdmin();
	dispose();
	}

}
}
