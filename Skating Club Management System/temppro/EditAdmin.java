import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import pro.*;

class EditAdmin extends JFrame implements ActionListener
{
  static int ano;
  JLabel name,cno,mid,uname, pswrd,cnpswrd;
  JTextField nam,cono,mail,user;
  JPasswordField pwd,cnpwd;
  JButton submit,back;
  Staticinfo s;
  Connection con = null;
  Statement stmt = null;
  ResultSet rs;

   
public EditAdmin ()
  {
    super ("Edit Admin Records");
       	
  JLabel background=new JLabel();
				  this.add(background);
    this.setSize (1366,786);

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
    this.setDefaultCloseOperation (EXIT_ON_CLOSE);


    name = new JLabel ("Name:");
    cno= new JLabel ("Contact No:");
    mid = new JLabel ("Mail Id:");
    uname = new JLabel ("UserName:");
    pswrd = new JLabel ("Password:");
    cnpswrd = new JLabel ("Confirm Password:");

    nam=new JTextField();
    cono=new JTextField();
    mail=new JTextField();
    user=new JTextField();
    pwd=new JPasswordField();    
    cnpwd=new JPasswordField();
	
nam.setText(rsname);
cono.setText(rscono);
mail.setText(rsmid);
user.setText(rsuname);
pwd.setText(rspswd);
cnpwd.setText(rspswd);

    submit =
      new JButton ("Update");

back=new JButton ("Back",
		   new ImageIcon (ClassLoader.
				  getSystemResource ("pics/back.png")));

    name.setBounds(200,100,160,30);
    cno.setBounds(200,140,160,30);
    mid.setBounds(200,180,160,30);
    uname.setBounds(200,220,160,30);
    pswrd.setBounds(200,260,160,30);
    cnpswrd.setBounds(200,300,160,30);

    nam.setBounds(320,100,200,30);
    cono.setBounds(320,140,200,30);
    mail.setBounds(320,180,200,30);
    user.setBounds(320,220,200,30);
    pwd.setBounds(320,260,200,30);
    cnpwd.setBounds(320,300,200,30);

    submit.setBounds(550,450,120,32);
    back.setBounds(550,490,120,32);

    background.add (name);
    background.add (cno);
    background.add (mid);
    background.add (uname);
    background.add (pswrd);
    background.add (cnpswrd);

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


public int update()

{

int i=0;

try

	{
		
		
PreparedStatement ps;

		ps=con.prepareStatement("Update admin set name=?,contact=?,mail=?,uname=?,passward=? where aid=?");

		ps.setString(1,nam.getText());
		ps.setString(2,cono.getText())
;
		ps.setString(3,mail.getText());
		ps.setString(4,user.getText());
		ps.setString(5,pwd.getText());
		ps.setInt(6,ano);
		
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
    new EditAdmin();

  }
  public void actionPerformed (ActionEvent e3)
  {
int i;
	if(e3.getSource()==submit)
	{
	     
			i=update();
			if(i==1)

			{
				
				JOptionPane.showMessageDialog (null,"Record Updated Successfully","Process Complete",JOptionPane.DEFAULT_OPTION);
			}
		        else
			JOptionPane.showMessageDialog (null,"Fail to Updated","Process Complete",JOptionPane.DEFAULT_OPTION);	    
	}
	if(e3.getSource()==back)
	{
	new DAdmin();
	dispose();
	}

}
}
