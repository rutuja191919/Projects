import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import pro.*;
import java.util.Date;

import java.text.*;

class StudAtt extends JFrame implements ActionListener
{
	JLabel sid,name,m[],ml[];
	JButton back;
	Staticinfo s;
	Font f;
	Color c; 
  public StudAtt()
  {
    super ("Attendance Report");
  JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/atd.png")));
				  this.add(background);
    this.setSize (1366,786);

this.add(background);
    this.setDefaultCloseOperation (EXIT_ON_CLOSE);


	m=new JLabel[30];
	ml=new JLabel[50];

	s=new Staticinfo();
f=new Font("Lucida Fax",Font.BOLD,20) ;  
Color c=new Color(255,255,255);

	String rsfname,rslname,date,rsid;
	name=new JLabel("*****");
		name.setFont(f);	
		name.setForeground(c);
	sid=new JLabel("*****");
		sid.setFont(f);	
		sid.setForeground(c);
       	try
	{
		back=new JButton("<<BACK");
		back.setBounds(850,630,100,30);
		background.add(back);
		s.rs=s.stmt.executeQuery("select sid,fname,lname from student where student.sid="+s.sid);
		while(s.rs.next())
		{
			name.setText("Name  :  "+s.rs.getString(2)+" "+s.rs.getString(3));
			sid.setText(" Id :"+s.rs.getInt(1));
		}
		name.setBounds(150,50,500,30);
		sid.setBounds(500,50,100,30);
		background.add(name);
		background.add(sid );
		s.rs=s.stmt.executeQuery("select date,status from student,attendance where student.sid="+s.sid+" and student.sid=attendance.sid");
		int i=0, y=100;		
		while(s.rs.next())
		{	
			m[i]=new JLabel(s.rs.getString(1));
				m[i].setFont(f);	
				m[i].setForeground(c);
			if(s.rs.getString(2).equals("p"))
			{
			ml[i]=new JLabel("Present");
				ml[i].setFont(f);	
				ml[i].setForeground(c);
			}
			else
			{
			ml[i]=new JLabel("Absent");
				ml[i].setFont(f);	
				ml[i].setForeground(c);
			}
			m[i].setBounds(100,y,190,30);
			ml[i].setBounds(300,y,100,30);
			background.add(m[i]);
			background.add(ml[i]);
			i++;
			y=y+30;
		 }
	}

	catch(Exception e )
	{
	System.out.println(e);
	}


    back.addActionListener(this);

	this.setVisible (true);

  }
  	public static void main (String s[])
  	{
   		 new StudAtt();
  	}

	  public void actionPerformed (ActionEvent e3)
 	 {

		if(e3.getSource()==back)
		{
			new ATReport();
			dispose();
		}

	}
}
