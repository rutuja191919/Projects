import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import java.io.*;

import java.util.Date;
import pro.*;
import java.text.*;

class TimeTrial extends JFrame implements ActionListener
{
  static int ano=1;
	int rcnt=0;
  JLabel inf,dtt,batch,name,select;
  JTextField bid,dt;
  JTextArea a;
  JButton save,submit,sa,back;
  Staticinfo s;
  Date d,nd;

  SimpleDateFormat sdf;
  JLabel background;
  JTextField c[]=null;
 JLabel sid[];
  Font f;

  public TimeTrial()
  {
     super ("Todays time trial");
    this.setBackground(Color.RED); 
     f=new Font("Brodway",Font.BOLD,18) ;  
	s=new Staticinfo();
	sdf=new SimpleDateFormat("dd/MM/yyyy");    	
	d=new Date();
	sdf.format(d);
	nd=new Date();
	sdf.format(d);
//	this.setBackground(Color.BLUE);
//background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/aa.jpeg")));

//	this.add(background);
	this.setSize (1366,786);
	this.setDefaultCloseOperation (EXIT_ON_CLOSE);

	batch=new JLabel("Batch Id:");
	batch.setFont(f);
	bid=new JTextField();
	bid.setFont(f);
	dtt=new JLabel("Date:");
	dtt.setFont(f);
	dt=new JTextField();
	dt.setFont(f);
	String s1=sdf.format(d);
	dt.setText(s1);
	inf=new JLabel("Sid");
	inf.setFont(f);
	name = new JLabel ("Name:");
	name.setFont(f);
	select=new JLabel("Time");
	select.setFont(f);	
	save=new JButton("Save"); 
	save.setFont(f);  
	submit =new JButton ("List of Students");
	submit.setFont(f);
	back=new JButton ("<<Back");
	back.setFont(f);	        
a=new JTextArea(30,70);
//	sa=new JButton("Submit");

    	name.setBounds(300,50,160,30);
    	inf.setBounds(200,50,200,30);
	dtt.setBounds(650,10,120,30);
	dt.setBounds(710,10,120,30);
 	select.setBounds(500,50,200,30);

	batch.setBounds(100,10,120,30);
	bid.setBounds(200,10,120,30);

    	submit.setBounds(350,10,160,30);
	save.setBounds(900,550,120,32);
    	back.setBounds(900,600,120,32);
	a.setBounds(200,100,200,500);
  	
JLabel ba=new JLabel("");
   	this.add (select);
    	this.add (inf); 
//    	this.add (sa);
	this.add (a);
    	this.add (submit);
    	this.add (back);
	this.add (batch);
	this.add (bid);
	this.add (name);
	this.add (ba);
	this.add(save);
	this.add(dtt);
	this.add(dt);
this.add(new JLabel(" " ));
	
	save.addActionListener(this);
	submit.addActionListener (this);
     	back.addActionListener(this);
   //  	sa.addActionListener(this);

	this.setVisible (true);
}
	 



public static void main (String s[])
{
    new TimeTrial();
}


int update()
{
int mtid=1;
int i=0;
try{
	s.rs=s.stmt.executeQuery("select max(tno) from timetrial");
	while(s.rs.next())
	mtid=s.rs.getInt(1);
	mtid++;
	while(i<rcnt)
	{
		
PreparedStatement ps;

		ps=s.con.prepareStatement("Insert into timetrial values(?,?,?,?)");

		ps.setInt(1,mtid);
		ps.setInt(2,Integer.parseInt(sid[i].getText()));
		ps.setString(3,dt.getText());
		ps.setString(4,c[i].getText())
;
		
int k=ps.executeUpdate();
		mtid++;
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
JLabel nam[];


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
					       "Records of time trial for batch"+bid.getText()+"saved successfully","submition fail",
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
			c=null;
			c=new JTextField[100]; 
			sid=new JLabel[100];
			nam=new JLabel[100]; 
			a.setText(" ");
			Font f1=new Font("Brodway",Font.BOLD,12) ;  
			s.rs=s.stmt.executeQuery("select sid,fname,contact,email,email,lname from student where student.bid="+bid.getText());
		while(s.rs.next())
		{	//nd=s.rs.getDate(5);
			//if(nd <= temp)
			{
				c[k]=new JTextField();
				sid[k]=new JLabel(s.rs.getString(1));
				sid[k].setFont(f1);
				nam[k]=new JLabel(s.rs.getString(2)+" "+s.rs.getString(6));
				nam[k].setFont(f1);
				//sdf.format(da[k]);
				//sid[k].setBounds(200,y,100,30);
				//nam[k].setBounds(300,y,100,30);	
				c[k].setBounds(500,y,30,20);
				System.out.println(""+nam[k]+"");
				a.append("\n"+sid[k].getText()+"\t"+nam[k].getText());
				this.add(c[k]);
				y=y+18;
				k++;		
			}
		}
		System.out.println("rcnt==="+k);
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

}
}
