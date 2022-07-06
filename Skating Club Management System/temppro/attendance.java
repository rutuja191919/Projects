import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import java.io.*;

import java.util.Date;
import pro.*;
import java.text.*;


class Attendance extends JFrame implements ActionListener
{
  static int ano=1,rcnt=0;
  JLabel inf,batch,name,select,dtt;
  JTextField bid,dt;
  JTextArea a;
  JButton submit,save,sa,back;
  Staticinfo s;
  Date d,nd;

  SimpleDateFormat sdf;
//JLabel background;
JCheckBox c[]=null;
String sid[]=null;

  public Attendance ()
  {
    super ("Attendance");
   this.setBackground(Color.RED);
   	s=new Staticinfo();
	sdf=new SimpleDateFormat("dd/MM/yyyy");    	
	d=new Date();
	sdf.format(d);
	nd=new Date();
	sdf.format(d);
	//this.setBackground(Color.BLUE);
//background=new JLabel();

//	this.add(background);
	this.setSize (1366,786);
	this.setDefaultCloseOperation (EXIT_ON_CLOSE);

	batch=new JLabel("Batch Id:");
	bid=new JTextField();
	dtt=new JLabel("Date:");
	dt=new JTextField();
String ss=sdf.format(d);
dt.setText(ss);	
inf=new JLabel("Sid");
	name = new JLabel ("Name:");
	select=new JLabel("Select");   
	submit =new JButton ("MarkAttendance ");
        save =new JButton ("SAVE");
	back=new JButton ("<<BACK");
        a=new JTextArea(30,70);
	sa=new JButton("SELECT ALL");
    	name.setBounds(300,50,160,30);
    	inf.setBounds(200,50,200,30);
 	select.setBounds(600,50,200,30);

	batch.setBounds(100,10,120,30);
	bid.setBounds(200,10,120,30);
	dtt.setBounds(350,10,120,30);
	dt.setBounds(410,10,120,30);
    	submit.setBounds(700,10,160,30);
	save.setBounds(890,570,120,30);
    	sa.setBounds(1020,570,120,30);
    	back.setBounds(970,610,120,30);
	a.setBounds(200,100,360,500);
  	
	JLabel ba=new JLabel("");
   	add (select);
    	add (inf); 
    	add (sa);
	add (a);
    	add (submit);
	add(save);
    	add (back);
	add (batch);
	add (bid);
	add(dtt);
	add(dt);
	add (name);
	add (ba);

	submit.addActionListener (this);
     	back.addActionListener(this);
     	sa.addActionListener(this);
	save.addActionListener(this);
	
	this.setVisible (true);
}
	 



public static void main (String s[])
{
    new Attendance();
}

int update()
{
int i=0;
try{
	while(i<rcnt)
	{
		
PreparedStatement ps;

		ps=s.con.prepareStatement("Insert into Attendance values(?,?,?)");

		ps.setInt(1,Integer.parseInt(sid[i]));
		ps.setString(2,dt.getText());
		if(c[i].isSelected())
		ps.setString(3,"p")
;
		else
		ps.setString(3,"a")
;
		
int k=ps.executeUpdate();
		i++;
	
}

    }

catch(Exception e)

	{	
		
System.out.println(e);
	}
return i;
}

public void actionPerformed (ActionEvent e3)
{

int i=0;
int k=0;
int y=115;
String nam[];

if(e3.getSource()==save)
{
	if(update()==0)
	{
			JOptionPane.showMessageDialog (null,
					       "Error!!!","submition fail",
					       JOptionPane.DEFAULT_OPTION);
		bid.requestFocus ();
	}
	else
	{
			JOptionPane.showMessageDialog (null,
					       "Attendance of batch"+bid.getText()+"saved successfully","submition fail",
					       JOptionPane.DEFAULT_OPTION);
		bid.requestFocus ();
	}
}

if(e3.getSource()==submit)
{
while(i<rcnt)
c[i++].setVisible(false);
		c=null;
		sid=null;
		nam=null;	
		k=0;
		try
		{

		c=new JCheckBox[100]; 
		sid=new String[100];
		nam=new String[100]; 

		a.setText(" ");
		s.rs=s.stmt.executeQuery("select sr.sid,fname,contact,email,nsdate,lname from sr,student where student.sid=sr.sid and 		student.bid="+bid.getText());
		while(s.rs.next())
		{
			//nd=s.rs.getDate(5);
			//if(nd <= temp)
			{
				c[k]=new JCheckBox();
				sid[k]=new String(s.rs.getString(1));
				nam[k]=new String(s.rs.getString(2)+" "+s.rs.getString(6));
				c[k].setBounds(600,y,30,20);
				System.out.println(""+nam[k]+"");
				a.append("\n"+sid[k]+"\t"+nam[k]);
				this.add(c[k]);
				y=y+15;
				k++;		
			}
		}
		add(new JLabel(""));
		rcnt=k;	
		this.setVisible (true);
	}
	catch(Exception e)
	{
		System.out.println(e);
	}		
	}
	if(e3.getSource()==back)
	{
		new ManMain1();
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
