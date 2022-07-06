import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import pro.*;

class ViewServ extends JFrame implements ActionListener
{
  JLabel name,lname,cno,id,d1,d2,type,cnt;
  JLabel nam,lnam,cono,id1,dt1,dt2,tp,ctr;
 
  JButton back;

Staticinfo s;
 
  public ViewServ()
  {
    super ("Servicing Details");
s=new Staticinfo();
	String rsfname,rsmname,rslname,rscono,rsid,rsd1,rsd2,rstp,rstid;
	rsfname=new String();
	rsmname=new String();
	rslname=new String();	
	rscono=new String();
	rsid=new String();
	rsd1=new String();
	rsd2=new String();
	rstp=new String();
	rstid=new String();

       	try
	{
	s.rs=s.stmt.executeQuery("select sr.sid,fname,mname,lname,contact,sdate,nsdate,type,tid from student,sr where student.sid="+s.sid+" and sr.sid="+s.sid);
		while(s.rs.next())
		{	
			rsid=s.rs.getString(1);
			rsfname=s.rs.getString(2);
			rsmname=s.rs.getString(3);
			rslname=s.rs.getString(4);
			rscono=s.rs.getString(5);
			rsd1=s.rs.getString(6);
			rsd2=s.rs.getString(7);
			rstp=s.rs.getString(8);	
			rstid=s.rs.getString(9);		
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

    name = new JLabel ("Name:");
  lname = new JLabel ("Last Name:");
    id = new JLabel ("Student ID:");
    cno= new JLabel ("Contact No:");
    type = new JLabel ("Type of Servicing:");
    d1 = new JLabel ("Servicing Date:");
    d2 = new JLabel ("Next Servicing Date:");
    cnt=new JLabel("Servicings Complete");

    nam=new JLabel();
   lnam=new JLabel(); 
   cono=new JLabel();
    id1=new JLabel();
    dt1=new JLabel();
    dt2=new JLabel();
    tp=new JLabel();    
    ctr=new JLabel();
	
nam.setText(rsfname +" "+ rsmname +" " +rslname);
lnam.setText(rslname);
	id1.setText(rsid);
	cono.setText(rscono);
	dt1.setText(rsd1);
	dt2.setText(rsd2);
	tp.setText(rstp);
	ctr.setText(rstid);

	back=new JButton ("<<Back");

    name.setBounds(200,180,160,30);
   id.setBounds(200,140,160,30);
    cno.setBounds(200,220,160,30);
    type.setBounds(200,260,160,30);
    d1.setBounds(200,300,160,30);
    d2.setBounds(200,340,160,30);
    cnt.setBounds(200,380,160,30);

  
    nam.setBounds(320,180,200,30);
    id1.setBounds(320,140,200,30);
    cono.setBounds(320,220,200,30);
    tp.setBounds(320,260,200,30);
    dt1.setBounds(320,300,200,30);
    dt2.setBounds(320,340,200,30);
    ctr.setBounds(320,380,200,30);

   back.setBounds(50,40,140,30);

    background.add (name);
    background.add (cno);
    background.add (id);
    background.add (type);
    background.add (d1);
    background.add (d2);
    background.add (lname);
    background.add (nam);
   // background.add (lnam);
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
