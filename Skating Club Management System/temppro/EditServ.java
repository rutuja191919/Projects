import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import pro.*;
import java.text.*;
import java.util.*;
import java.util.Date;

class EditServ extends JFrame implements ActionListener
{
  JLabel name,lname,cno,id,d1,d2,type,nam,lnam,cono,id1;
  JTextField dt1,dt2,tp;
  JButton back,update;
  Staticinfo s;
Font f;
Date d;
SimpleDateFormat sdf;

  public EditServ()
  {
    super ("Servising Details");
	s=new Staticinfo();
sdf=new SimpleDateFormat("dd/mm/yyyyy");
d=new Date();
f=new Font("Cosmic SANS MS",Font.BOLD,18);
Color c=new Color(255,0,0);
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
	s.rs=s.stmt.executeQuery("select sr.sid,fname,lname,contact,sdate,nsdate,type from student,sr where student.sid="+s.sid+" and 		sr.sid="+s.sid);
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

  JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/serv.jpg")));
				  this.add(background);
    this.setSize (1366,786);
    this.setDefaultCloseOperation (EXIT_ON_CLOSE);

    	name = new JLabel ("First Name:");
	lname = new JLabel ("last Name:"); 
   	id = new JLabel ("Student Id:");
    	cno= new JLabel ("Contact No:");
    	type = new JLabel ("Type of Servising:");
    	d1 = new JLabel ("Servising Date:");
    	d2 = new JLabel ("Next Servising Date:");
 
	name.setFont(f);
	name.setForeground(c);
	lname.setFont(f);
	lname.setForeground(c);
id.setFont(f);
	id.setForeground(c);
cno.setFont(f);
	cno.setForeground(c);
type.setFont(f);
	type.setForeground(c);
d1.setFont(f);
	d1.setForeground(c);
d2.setFont(f);
	d2.setForeground(c);

Color c1=new Color(0,0,255);

    	nam=new JLabel ();
nam.setFont(f);
	nam.setForeground(c1);
  	
lnam=new JLabel ();
lnam.setFont(f);
	lnam.setForeground(c1);
   
 	cono=new JLabel ();
cono.setFont(f);
	cono.setForeground(c1);

    	id1=new JLabel ();
id1.setFont(f);
	id1.setForeground(c1);
    	dt1=new JTextField ();
    	dt2=new JTextField ();
    	tp=new JTextField ();    
   
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
	update=new JButton ("Update");

    name.setBounds(200,100,180,30);
lname.setBounds(200,140,180,30);
    id.setBounds(200,180,180,30);
    cno.setBounds(200,220,180,30);
    type.setBounds(200,260,180,30);
    d1.setBounds(200,300,180,30);
    d2.setBounds(200,340,200,30);
  

    nam.setBounds(450,100,200,30);
lnam.setBounds(450,140,200,30);
    id1.setBounds(450,180,200,30);
    cono.setBounds(450,220,200,30);
    tp.setBounds(450,260,200,30);
    dt1.setBounds(450,300,200,30);
    dt2.setBounds(450,340,200,30);
   
    update.setBounds(560,490,120,32);
    back.setBounds(700,490,120,32);

    background.add (name);
    background.add (lname);
    background.add (lnam);
    background.add (cno);
    background.add (id);
    background.add (type);
    background.add (d1);
    background.add (d2);
  
    background.add (nam);
    background.add (cono);
    background.add (id1);
    background.add (tp);
    background.add (dt1);
    background.add (dt2);

    background.add (back);
    back.addActionListener(this);

    background.add (update);
    update.addActionListener(this);

    this.setVisible (true);
  }

  	public static void main (String s[])
  	{
   		 new EditServ();
  	}


public int update()

{

int i=0,srid=0,tid=0;

try

	{
		s.rs=s.stmt.executeQuery("select max(srid) from sr");
		while(s.rs.next())
		srid=s.rs.getInt(1);
		srid++;

		s.rs=s.stmt.executeQuery("select max(tid) from sr where sid="+s.sid+"");
		while(s.rs.next())
		tid=s.rs.getInt(1);
		tid++;		
			
		String sd=sdf.format(d);
		
PreparedStatement ps;

		ps=s.con.prepareStatement("insert into sr values(?,?,?,?,?,?)");
	
		ps.setInt(1,srid);
		ps.setString(3,dt1.getText());
		ps.setString(4,dt2.getText())
;
		ps.setInt(2,s.sid);
		ps.setString(5,tp.getText());
		ps.setInt(6,tid);
		
i=ps.executeUpdate();
	
}

catch(Exception e)

	{
		
System.out.println(e);
		e.printStackTrace();
	
}
return i;

}



	 public void actionPerformed (ActionEvent e3)
 	 {
int i;
		if(e3.getSource()==back)
		{
			new OpenServRec();
			dispose();
		}
		else if(e3.getSource()==update)
		{
		i=update();
			if(i==1)

			{
				
				JOptionPane.showMessageDialog (null,"record updated sucessfully","process complete",JOptionPane.DEFAULT_OPTION);
			}
		        else
			JOptionPane.showMessageDialog (null,"fail to updated","process complete",JOptionPane.DEFAULT_OPTION);
		}
	}
}
