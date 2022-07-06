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
  JButton submit,sa,back,compose;
  Staticinfo s;
  Date d,d7,nd;
	SimpleDateFormat sdf;

Calendar cal;
Color cc;
Font f;
  public ThisWeekServ ()
  {
    super ("This Week Servicing");
   s=new Staticinfo();
cc=new Color(0,0,250);
f=new Font("Lucida Fax",Font.BOLD,20) ;  
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
JLabel background=new JLabel();
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
	//		c[k].setFont(f);
	//		c[k].setForeground(cc);
			sid[k]=new JLabel(s.rs.getString(1));
	//		sid[k].setFont(f);
	//		sid[k].setForeground(cc);
			nam[k]=new JLabel(s.rs.getString(2)+" "+s.rs.getString(6));
	//		nam[k].setFont(f);
	//		nam[k].setForeground(cc);
			cono[k]=new JLabel(s.rs.getString(3));
	//		cono[k].setFont(f);
	//		cono[k].setForeground(cc);  
			mlid[k]=new JLabel(s.rs.getString(4));
	//		mlid[k].setFont(f);
	//		mlid[k].setForeground(cc);
			//sdf.format(da[k]);
			da[k]=new JLabel(s.rs.getString(5));
	//		da[k].setFont(f);
//			da[k].setForeground(cc);

			sid[k].setBounds(80,y,100,30);
			nam[k].setBounds(130,y,300,30);	
			cono[k].setBounds(240,y,200,30);
			mlid[k].setBounds(400,y,300,30);
			da[k].setBounds(700,y,150,30);
			c[k].setBounds(800,y+2,50,20);
	
			background.add (sid[k]);
			background.add (nam[k]);
			background.add (cono[k]);
			background.add (mlid[k]);
			background.add (da[k]);
			background.add (c[k]);
			y=y+20;
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

    inf=new JLabel("S.ID");
inf.setFont(f);
inf.setForeground(cc);
    name = new JLabel ("Name:");
name.setFont(f);
name.setForeground(cc);    
     cno= new JLabel ("Contact No:");
cno.setFont(f);
cno.setForeground(cc);
    mid = new JLabel ("Mail ID:");
mid.setFont(f);
mid.setForeground(cc);
    select=new JLabel("Select");
select.setFont(f);
select.setForeground(cc);
	sd=new JLabel("Date");
sd.setFont(f);
sd.setForeground(cc);    
    
submit =new JButton ("Send Mail");
back=new JButton ("<<Back");
compose=new JButton("Compose Mail");


sa=new JButton("Select All");
 name.setBounds(130,20,160,30);
 cno.setBounds(240,20,160,30);

  mid.setBounds(400,20,160,30);
  sd.setBounds(700,20,160,30);
    inf.setBounds(80,20,200,30);
 select.setBounds(800,20,200,30);

    submit.setBounds(1000,130,150,32);
compose.setBounds(1000,80,150,32);
    sa.setBounds(1000,30,150,32);
    back.setBounds(1000,600,150,32);

background.add(compose);
    background.add (name);
    background.add (cno);
    background.add (mid);
    background.add (select);
    background.add (inf); 
    background.add (sa);
    background.add (submit);
    background.add (back);
    background.add (sd);

compose.addActionListener(this);
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

int i,cnt=0;
	if(e3.getSource()==submit)
	{
		if(s.mailflag==1)
		{
			System.out.println("***sub="+s.substr+"\n mail:"+s.mailstr);
			for(i=0;i<rcnt;i++)
			{
				if(c[i].isSelected()==true)
				{
					s.sendEmail(mlid[i].getText());
					cnt++;
				}
			}
			s.mailflag=0;
			JOptionPane.showMessageDialog (null,
					       cnt+" Mails has been send succesfully","Process Complete",
					       JOptionPane.DEFAULT_OPTION);
		}	
		else
		{
			new CmposMail();
		}	
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
	if(e3.getSource()==compose)
	{
		new CmposMail();
	}
}
}
