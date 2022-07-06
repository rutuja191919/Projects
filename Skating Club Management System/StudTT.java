import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import pro.*;
import java.util.Date;

import java.text.*;

public class StudTT extends JFrame implements ActionListener
{
	JLabel sid,name;
	JButton back;
	Staticinfo s;
	Font f;
	Color c; 
	JTextArea a;
	int total=0;
int month;

	  public StudTT()
	  {
		super("Student TimeTrial Report");
		String d[]=new String[31];
		String t[]=new String[31];
    
  JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/atd.png")));
				  this.add(background);
    this.setSize (1366,786);

SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");    	
Date ddd=new Date();
	sdf.format(ddd);
month=ddd.getMonth()+1;

System.out.println("month : "+month);	

this.add(background);
 this.setDefaultCloseOperation (EXIT_ON_CLOSE);

	s=new Staticinfo();
f=new Font("Lucida Fax",Font.BOLD,20) ;  
Color c=new Color(255,255,255);


       	try
	{
	name=new JLabel("*****");
		name.setFont(f);	
		name.setBounds(100,100,300,100);
		background.add(name);
		name.setForeground(c);

	sid=new JLabel("*****");
		sid.setBounds(400,100,100,100);
		background.add(sid);
		sid.setFont(f);	
		sid.setForeground(c);

JLabel date=new JLabel("Date :");
JLabel time=new JLabel("Time :");
date.setBounds(20,170,80,100);
time.setBounds(20,210,80,100);
date.setForeground(c);
date.setFont(f);
time.setFont(f);
time.setForeground(c);
background.add(date);
background.add(time);

s.rs=s.stmt.executeQuery("select fname,lname from Student where sid="+s.sid);
while(s.rs.next())
name.setText("Name :"+s.rs.getString(1)+" "+s.rs.getString(2));
sid.setText("S.ID :"+s.sid);
		a=new JTextArea();
		a.setBounds(100,200,1000,100);
			JScrollPane scroll=new JScrollPane(a);
	
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			scroll.setBounds(100,200,1000,100); 
			scroll.setSize(1000,100);
			background.add(scroll);

//		background.add(a);
		back=new JButton("<<Back");
		back.setBounds(50,40,140,30);
		background.add(back);
		if(month < 10)
		{
			//s.rs=s.stmt.executeQuery("select date,time from TimeTrial where sid="+s.sid+" and date like '%/0"+month+"/%' ");
			PreparedStatement ps=s.con.prepareStatement("select date, time  from timetrial where sid=? and date like ?");
			ps.setInt(1,s.sid);
			ps.setString(2,"%/0"+month+"/%");
			
s.rs=ps.executeQuery();	
		}
		else
		{
			//s.rs=s.stmt.executeQuery("select date,time from TimeTrial where sid="+s.sid+"and date like '%/"+month+"/%' ");
			PreparedStatement ps=s.con.prepareStatement("select date, time  from timetrial where sid=? and date like ?");
			ps.setInt(1,s.sid);
			ps.setString(2,"%/"+month+"/%");
			
s.rs=ps.executeQuery();	
		}
	int i=0;
		while(s.rs.next())
		{
		d[i]=new String(s.rs.getString(1));
		t[i]=new String(" "+s.rs.getDouble(2));
		i++;
		}
		total=i;
	}

	catch(Exception e )
	{
	System.out.println(e);
	e.printStackTrace();
	}

a.setText("\n");
for(int j=0;j < total;j++)
a.append(d[j]+"\t");
a.append("\n\n");
for(int j=0;j < total;j++)
a.append(t[j]+"\t");
    back.addActionListener(this);

	this.setVisible (true);

  }
  	public static void main (String s[])
  	{
   		 new StudTT();
  	}

	  public void actionPerformed (ActionEvent e3)
 	 {

		if(e3.getSource()==back)
		{
			new TTReport();
			dispose();
		}

	}
}
