import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import pro.*;

class ViewServ extends JFrame implements ActionListener
{
  JLabel name,lname,cno,id,d1,d2,type;
  JLabel nam,lnam,cono,id1,dt1,dt2,tp;
 
  JButton back;

Staticinfo s;
 
  public ViewServ()
  {
    super ("Servicing Details");
s=new Staticinfo();
	String rsfname,rslname,rscono,rsid,rsd1,rsd2,rstp;
	rsfname=new String();
	rslname=new String();	
	rscono=new String();
	rsid=new String();
	rsd1=new String();
	rsd2=new String();
	rstp=new String();

       	try
	{
	s.rs=s.stmt.executeQuery("select sr.sid,fname,lname,contact,sdate,nsdate,type from student,sr where student.sid="+s.sid+" and sr.sid="+s.sid);
		while(s.rs.next())
		{	
			rsid=s.rs.getString(1);
			rsfname=s.rs.getString(2);
			rslname=s.rs.getString(3);
			rscono=s.rs.getString(4);
			rsd1=s.rs.getString(5);
			rsd2=s.rs.getString(6);
			rstp=s.rs.getString(7);		
		 }
	}

	catch(Exception e )
	{
	System.out.println(e);
	}

  JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/patins.jpg")));
				  this.add(background);
    this.setSize (1366,786);


    this.setDefaultCloseOperation (EXIT_ON_CLOSE);

    name = new JLabel ("First Name:");
  lname = new JLabel ("Last Name:");
    id = new JLabel ("Student Id:");
    cno= new JLabel ("Contact No:");
    type = new JLabel ("Type of Servicing:");
    d1 = new JLabel ("Servicing Date:");
    d2 = new JLabel ("Next Servicing Date:");
 
    nam=new JLabel();
   lnam=new JLabel(); 
   cono=new JLabel();
    id1=new JLabel();
    dt1=new JLabel();
    dt2=new JLabel();
    tp=new JLabel();    
    
	
nam.setText(rsfname);
lnam.setText(rslname);
	id1.setText(rsid);
	cono.setText(rscono);
	dt1.setText(rsd1);
	dt2.setText(rsd2);
	tp.setText(rstp);


	back=new JButton ("Back",
		   new ImageIcon (ClassLoader.
				  getSystemResource ("pics/back.png")));

    name.setBounds(200,100,160,30);
    lname.setBounds(200,140,160,30);
   id.setBounds(200,180,160,30);
    cno.setBounds(200,220,160,30);
    type.setBounds(200,260,160,30);
    d1.setBounds(200,300,160,30);
    d2.setBounds(200,340,160,30);
  

   lnam.setBounds(320,140,160,30);
    nam.setBounds(320,100,200,30);
    id1.setBounds(320,180,200,30);
    cono.setBounds(320,220,200,30);
    tp.setBounds(320,260,200,30);
    dt1.setBounds(320,300,200,30);
    dt2.setBounds(320,340,200,30);
   

   back.setBounds(950,580,180,40);

    background.add (name);
    background.add (cno);
    background.add (id);
    background.add (type);
    background.add (d1);
    background.add (d2);
    background.add (lname);
    background.add (nam);
    background.add (lnam);
    background.add (cono);
    background.add (id1);
    background.add (tp);
    background.add (dt1);
    background.add (dt2);


    background.add (back);
    back.addActionListener(this);

	this.setVisible (true);

  }
  	public static void main (String s[])
  	{
   		 new ViewServ();

  	}

	  public void actionPerformed (ActionEvent e3)
 	 {

		if(e3.getSource()==back)
		{
			new OpenServRec();
			dispose();
		}

	}
}
