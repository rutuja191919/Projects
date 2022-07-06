import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import java.io.*;

import java.util.Date;
import pro.*;
import java.text.*;

class TTReport extends JFrame implements ActionListener
{
public JButton b,stud,oa,back;
public JTextField bid,sid;
public JLabel H,lb,ls,ht,bt,st,oat,loa;
public Staticinfo s;
Font f;
Color c;
	public TTReport()
	{
		super ("TimeTrial Reports");
	       	JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/achiv.jpg")));
				  this.add(background);
    		this.setSize (1366, 786);
		this.setDefaultCloseOperation (EXIT_ON_CLOSE);
		this.add(background);
		f=new Font("Lucida Fax",Font.BOLD,20) ;  
		s=new Staticinfo();		
		back=new JButton("<<BACK");
		b=new JButton("Batch Average");
		stud=new JButton("Student Average");
		oa=new JButton("Overall Average");
		back.setBounds(1000,550,150,30);
  		b.setBounds(500,100,200,30);
		stud.setBounds(500,150,200,30);
		oa.setBounds(500,200,200,30);
		b.addActionListener (this);
		oa.addActionListener (this);
		stud.addActionListener (this);
		back.addActionListener (this);
		background.add(b);
		background.add(oa);
		background.add(stud);
		background.add(back);

		Color c=new Color(255,0,0);
		Color c1=new Color(0,0,255);
		H=new JLabel("Congratulations!!!  Fastest Timetrial :");
		H.setFont(f);	  
		H.setForeground(c1);
		lb=new JLabel("Enter Batch-id:");
		lb.setFont(f);	
		lb.setForeground(c);
		ls=new JLabel("Enter Student-id:");
		ls.setFont(f);
		ls.setForeground(c);
		loa=new JLabel("Overall Average:");
		loa.setFont(f);
		loa.setForeground(c);
		ht=new JLabel("***");
		ht.setFont(f);
		ht.setForeground(c1);
		bt=new JLabel("***");
		bt.setFont(f);
		bt.setForeground(c);
		st=new JLabel("***");
		st.setFont(f);
		st.setForeground(c);
		oat=new JLabel("***");
		oat.setFont(f);
		oat.setForeground(c);
		H.setBounds(100,270,500,30);
		lb.setBounds(100,100,200,30);
		ls.setBounds(100,150,200,30);
		oat.setBounds(320,200,100,30);
		loa.setBounds(100,200,200,30);
		ht.setBounds(510,270,500,30);
		bt.setBounds(420,100,100,30);
		st.setBounds(420,150,100,30);
		background.add(H);
		background.add(lb);
		background.add(ls);
		background.add(oat);
		background.add(loa);
		background.add(ht);
		background.add(bt);
		background.add(st);
try
{

		s.rs=s.stmt.executeQuery("select min(time) from timetrial");
		while(s.rs.next())
		ht.setText(" "+s.rs.getFloat(1));
		s.rs=s.stmt.executeQuery("select sid,fname,lname,bid from student where sid=(select sid from timetrial where time=(select min(time) from timetrial)) ");
		while(s.rs.next())
		ht.setText(ht.getText()+" name: "+s.rs.getString(2)+" "+s.rs.getString(3)+" batch: "+s.rs.getInt(4));
}
catch(Exception e)
{
e.printStackTrace();
}
		
		bid=new JTextField();
		sid=new JTextField();
		bid.setBounds(320,100,100,30);
		background.add(bid);
		sid.setBounds(320,150,100,30);
		background.add(sid);

		this.setVisible (true);
	}
	
	public static void main(String args[])
	{
		new TTReport();
	}

	public void actionPerformed(ActionEvent e)
	{int i;
	Float a=0.0f,avg=0.0f;
	try
	   {	if(e.getSource()==back)
		{
		dispose();
		new Reports();
		}
		if(e.getSource()==b)
		{i=0;
			s.rs=s.stmt.executeQuery("select time from timetrial where sid in(select sid from student where bid="+bid.getText()+")");
			while(s.rs.next())
			{
			i++;
			a=a+s.rs.getFloat(1);
			}
			if(i!=0)
			avg=a/i;
			bt.setText(""+avg);		
		}
		else if(e.getSource()==stud)
		{i=0;
			s.rs=s.stmt.executeQuery("select time from timetrial where sid ="+sid.getText( ));
			while(s.rs.next())
			{
			i++;
			a=a+s.rs.getFloat(1);
			}
			if(i!=0)
			avg=a/i;
			st.setText(""+avg);	
		}
		else if(e.getSource()==oa)
		{i=0;
			s.rs=s.stmt.executeQuery("select time from timetrial ");
			while(s.rs.next())
			{
			i++;
			a=a+s.rs.getFloat(1);
			}
			if(i!=0)
			avg=a/i;
			oat.setText(""+avg);	
		}
	   }
	   catch(Exception ex)
	   {
		ex.printStackTrace();
	   }	
	}
}