import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import java.io.*;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import pro.*;
import java.text.*;

class ThisWeekServ extends JFrame implements ActionListener
{
  static int ano=1,rcnt=0;
  JLabel inf,name,cno,sd,mid,select,sid[],nam[],cono[],mlid[],da[];
  JCheckBox c[];
  JButton submit,sa,back;
  Staticinfo s;
  Date d,d7,nd;
	SimpleDateFormat sdf;

Calendar cal;
Color cc;

  public ThisWeekServ ()
  {
    super ("This Week Servising");
   s=new Staticinfo();
cc=new Color(255,0,0);
sdf=new SimpleDateFormat("dd/MM/yyyy");    	
d=new Date();
cal=Calendar.getInstance();
cal.add(Calendar.DATE,7);
//String temp=sdf.parse(cal.getTime());
System.out.println("aaaaaaaaa"+cal.getTime()+"sss");
d7=addDays(d,7);
sdf.format(d);
nd=new Date();
sdf.format(d);

c=new JCheckBox[100]; 
sid=new JLabel[100];
nam=new JLabel[100]; 
cono=new JLabel[100];
mlid=new JLabel[100];
da=new JLabel[100];
JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource   ("pics/serv3.jpg")));
				  this.add(background);
this.setSize (1366,786);
int k=0;
int y=50;
//Date temp;
//sdf.format(temp);
//temp=new Date("30/04/2017");

try
{

	s.rs=s.stmt.executeQuery("select sr.sid,fname,contact,email,nsdate,lname from sr,student where student.sid=sr.sid and tid=(select max(tid) from sr where sr.sid=student.sid)");
	while(s.rs.next())
	{
	nd=sdf.parse(s.rs.getString(5));
	System.out.println(sdf.format(d7)+"====="+sdf.format(nd)+"=====>"+nd.compareTo(d)+"!!!!");
		if(nd.compareTo(d7)<0)
		{
			c[k]=new JCheckBox();
			c[k].setForeground(cc);
			sid[k]=new JLabel(s.rs.getString(1));
			sid[k].setForeground(cc);
			nam[k]=new JLabel(s.rs.getString(2)+" "+s.rs.getString(6));
			nam[k].setForeground(cc);
			cono[k]=new JLabel(s.rs.getString(3));
			cono[k].setForeground(cc);  
			mlid[k]=new JLabel(s.rs.getString(4));
			mlid[k].setForeground(cc);
			//sdf.format(da[k]);
			da[k]=new JLabel(s.rs.getString(5));
			da[k].setForeground(cc);

			sid[k].setBounds(200,y,100,30);
			nam[k].setBounds(250,y,100,30);	
			cono[k].setBounds(400,y,100,30);
			mlid[k].setBounds(500,y,200,30);
			da[k].setBounds(700,y,100,30);
			c[k].setBounds(800,y,50,20);
	
			background.add (sid[k]);
			background.add (nam[k]);
			background.add (cono[k]);
			background.add (mlid[k]);
			background.add (da[k]);
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
inf.setForeground(cc);
    name = new JLabel ("Name:");
name.setForeground(cc);    
     cno= new JLabel ("Contact No:");
cno.setForeground(cc);
    mid = new JLabel ("Mail ID:");
mid.setForeground(cc);
    select=new JLabel("Select");
select.setForeground(cc);
	sd=new JLabel("Date");
sd.setForeground(cc);    
    
submit =new JButton ("SEND MAIL");
back=new JButton ("<<BACK");

sa=new JButton("SELECT ALL");
    name.setBounds(250,20,160,30);
    cno.setBounds(400,20,160,30);
    mid.setBounds(500,20,160,30);
  sd.setBounds(700,20,160,30);
    inf.setBounds(200,20,200,30);
 select.setBounds(800,20,200,30);

    submit.setBounds(890,550,120,32);
    sa.setBounds(1050,550,120,32);
    back.setBounds(890,600,120,32);

    background.add (name);
    background.add (cno);
    background.add (mid);
    background.add (select);
    background.add (inf); 
    background.add (sa);
    background.add (submit);
    background.add (back);
    background.add (sd);

    submit.addActionListener (this);
     back.addActionListener(this);
     sa.addActionListener(this);

	this.setVisible (true);

}
	 


public static Date addDays(Date d,int days)
{
	GregorianCalendar cal= new GregorianCalendar();
	cal.setTime(d);
	cal.add(Calendar.DATE,days);
	return cal.getTime();
}

public static void main (String s[])
{
    new ThisWeekServ();
}

public void actionPerformed (ActionEvent e3)
{

int i;
	if(e3.getSource()==submit)
	{
		
	}
	if(e3.getSource()==back)
	{
	new ServRec();
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
