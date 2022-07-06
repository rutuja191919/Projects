import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import java.io.*;

import java.util.Date;
import pro.*;
import java.text.*;

class ATReport extends JFrame implements ActionListener
{
public JButton b,stud,back;
public JTextField bid,sid;
public JLabel w,name[],batch[],lb,ls;
public Staticinfo s;
Font f;
Color c;
	public ATReport()
	{
		super ("Attendance Reports");
	       	JLabel background=new JLabel();
    		this.setSize (1366, 786);
		this.setDefaultCloseOperation (EXIT_ON_CLOSE);
		this.add(background);

		f=new Font("Lucida Fax",Font.BOLD,20) ;  
		s=new Staticinfo();		

		back=new JButton("<<Back");
		b=new JButton("Batch Attendance");
		stud=new JButton("Student Attendance");
		back.setBounds(1000,600,150,30);
  		b.setBounds(500,100,200,30);
		stud.setBounds(500,150,200,30);
		
		b.addActionListener (this);
		stud.addActionListener (this);
		back.addActionListener (this);
		background.add(b);
		background.add(stud);
		background.add(back);

		Color c=new Color(0,0,255);
		Color c1=new Color(255,0,0);
		w=new JLabel("Students with 100% attendance");
		w.setFont(f);	
		w.setForeground(c1);

		lb=new JLabel("Batch Id:");
		lb.setFont(f);	
		lb.setForeground(c);
		ls=new JLabel("Student Id:");
		ls.setFont(f);
		ls.setForeground(c);
		
		lb.setBounds(100,100,200,30);
		ls.setBounds(100,150,200,30);
		w.setBounds(150,250,500,30);

		background.add(lb);
		background.add(ls);
		background.add(w);
try
{
Color c2=new Color(255,200,200);
Color c3=new Color(255,0,0);
name=new JLabel[20];
batch=new JLabel[20];
int i=0,y=280;
		s.rs=s.stmt.executeQuery("select sid,fname,lname,bid from student where sid in(select sid from attendance where sid not in (select sid from attendance where status='a' ))");
		while(s.rs.next())	
		{
			name[i]=new JLabel("name :  "+s.rs.getString(2)+" "+s.rs.getString(3));
			name[i].setFont(f);
			name[i].setForeground(c2);
			batch[i]=new JLabel("batch :  "+s.rs.getString(4));
			batch[i].setFont(f);
			batch[i].setForeground(c2);
			name[i].setBounds(270,y,270,30);
			batch[i].setBounds(150,y,250,30);
			background.add(name[i]);
			background.add(batch[i]);
			y=y+40;
			i++;
			if(y>=640)
			break;
		}
		
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
		new ATReport();
	}

	public void actionPerformed(ActionEvent e)
	{int i=0;
	try
	   {	if(e.getSource()==back)
		{
		dispose();
		new Reports();
		}
		if(e.getSource()==b)
		{
			if (bid.getText ().equals ("") ) 
			{
				JOptionPane.showMessageDialog (null,"enter batch id","error",
						       JOptionPane.DEFAULT_OPTION);
				bid.requestFocus ();
			}
			else 
			{
			      i=Integer.parseInt(bid.getText ());
				s.bid=Integer.parseInt(bid.getText ());
				if(i>0 && i<7)
				{
					new BatchAtt();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog (null,
					       "Incorrect batch id!","error",
					       JOptionPane.DEFAULT_OPTION);
					sid.requestFocus ();
	  	    		}
			}
				
		}
		else if(e.getSource()==stud)
		{
			if (sid.getText ().equals ("") ) 
			{
				JOptionPane.showMessageDialog (null,"enter student id","error",
						       JOptionPane.DEFAULT_OPTION);
				sid.requestFocus ();
			}
			else 
			{
				s.sid=Integer.parseInt(sid.getText ());
			        i=search(Integer.parseInt(sid.getText ()));
				if(i!=0)
				{
					new StudAtt();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog (null,
					       "Incorrect student id!","error",
					       JOptionPane.DEFAULT_OPTION);
					sid.requestFocus ();
	  	    		}
			}	
		}
		
	   }
	   catch(Exception ex)
	   {
		ex.printStackTrace();
	   }	
	}

	public int search(int a)

	{

		int i=0;

		try

		{
			PreparedStatement ps;

			ps=s.con.prepareStatement("select * from Student where sid=?");

			ps.setInt(1,s.sid);
			
s.rs=ps.executeQuery();
			while(s.rs.next())
			i=s.rs.getInt(1);
		
}

		catch(Exception e)

		{
			
System.out.println(e);
		
}
		return i;

	}


}