import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import java.io.*;

import java.util.Date;
import pro.*;
import java.text.*;

class Pending extends JFrame implements ActionListener
{
  static int ano=1,rcnt;
  JLabel inf,name,cno,sd,mid,select,sid[],nam[],cono[],mlid[];
  JCheckBox c[];
  JButton submit,sa,back;
  Staticinfo s;
  Date d,nd;

  SimpleDateFormat sdf;


  public Pending ()
  {
    super ("Registration of Admin");
   s=new Staticinfo();
	sdf=new SimpleDateFormat("dd/MM/yyyy");    	
	d=new Date();
	sdf.format(d);
	nd=new Date();
	sdf.format(d);

	c=new JCheckBox[100]; 
	sid=new JLabel[100];
	nam=new JLabel[100]; 
	cono=new JLabel[100];
	mlid=new JLabel[100];
//	da=new JLabel[100];

	JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource   ("pics/fee2.jpg")));
				  this.add(background);
    	this.setSize (1366,786);
	int k=0;
	int y=50;
	//Date temp;
	sdf.format(nd);
	//temp=new Date("30/04/2017");

	try
	{
	s.rs=s.stmt.executeQuery(" select fee.sid,fname,contact,email,lname,todate from fee,student where student.sid=fee.sid and fid=(select max(fid) from fee where fee.sid=student.sid)");
	while(s.rs.next())
	{
	nd=sdf.parse(s.rs.getString(6));
	//System.out.println(sdf.format(d)+"====="+sdf.format(nd)+"=====>"+nd.compareTo(d)+"!!!!");
		if(nd.compareTo(d)<0)
		{
			c[k]=new JCheckBox();
			sid[k]=new JLabel(s.rs.getString(1));
			nam[k]=new JLabel(s.rs.getString(2)+" "+s.rs.getString(5));
			cono[k]=new JLabel(s.rs.getString(3));  
			mlid[k]=new JLabel(s.rs.getString(4));
			//sdf.format(da[k]);
			//da[k]=new JLabel(s.rs.getString(5));

			sid[k].setBounds(200,y,100,30);
			nam[k].setBounds(250,y,100,30);	
			cono[k].setBounds(400,y,100,30);
			mlid[k].setBounds(500,y,200,30);
			//da[k].setBounds(600,y,150,30);
			c[k].setBounds(750,y,50,20);
	
			background.add (sid[k]);
			background.add (nam[k]);
			background.add (cono[k]);
			background.add (mlid[k]);
	//		background.add (da[k]);
			background.add (c[k]);
			y=y+25;
			k++;		
		}
	}
rcnt=k;
}
catch(Exception e)
{
System.out.println(e);
}
    this.setDefaultCloseOperation (EXIT_ON_CLOSE);

    inf=new JLabel("Sid");
    name = new JLabel ("Name:");
    cno= new JLabel ("Contact No:");
    mid = new JLabel ("Mail ID:");
    select=new JLabel("Select");
//	sd=new JLabel("Date");    
    submit =
      new JButton ("SEND MAIL");
back=new JButton ("<<BACK");

sa=new JButton("SELECT ALL");
    name.setBounds(250,20,160,30);
    cno.setBounds(400,20,160,30);
    mid.setBounds(500,20,160,30);
//  sd.setBounds(600,20,160,30);
    inf.setBounds(200,20,200,30);
 select.setBounds(750,20,200,30);

    submit.setBounds(800,550,120,32);
    sa.setBounds(930,550,120,32);
    back.setBounds(800,600,120,32);

    background.add (name);
    background.add (cno);
    background.add (mid);
    background.add (select);
    background.add (inf); 
    background.add (sa);
    background.add (submit);
    background.add (back);
//background.add (sd);

    submit.addActionListener (this);
     back.addActionListener(this);
     sa.addActionListener(this);
	this.setVisible (true);

  }
	 



public static void main (String s[])
{
    new Pending();
}

public void actionPerformed (ActionEvent e3)
{

int i;
	if(e3.getSource()==submit)
	{
	new OpenFeeRec();
	}
	if(e3.getSource()==back)
	{
	new OpenFeeRec();
	dispose();
	}
	if(e3.getSource()==sa)
	{
		for(i=0;i<rcnt;i++)
		{
			c[i].setSelected(true);	
		}		
	}
}
}
