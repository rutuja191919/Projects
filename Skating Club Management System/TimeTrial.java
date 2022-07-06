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
     super ("Today's Time Trial");
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

	batch=new JLabel("Batch ID:");
//	batch.setFont(f);
	bid=new JTextField();
//	bid.setFont(f);
	dtt=new JLabel("Date:");
//	dtt.setFont(f);
	dt=new JTextField();
//	dt.setFont(f);
	String s1=sdf.format(d);
	dt.setText(s1);
	inf=new JLabel("S.ID");
//	inf.setFont(f);
	name = new JLabel ("Name:");
//	name.setFont(f);
	select=new JLabel("Time");
//	select.setFont(f);	
	save=new JButton("Save"); 
//	save.setFont(f);  
	submit =new JButton ("Show List");
//	submit.setFont(f);
	back=new JButton ("<<Back");
//	back.setFont(f);	        
a=new JTextArea(30,70);
//	sa=new JButton("Submit");

    	name.setBounds(300,60,160,30);
    	inf.setBounds(200,60,200,30);
	dtt.setBounds(690,10,120,30);
	dt.setBounds(740,10,110,30);
 	select.setBounds(500,60,200,30);

	batch.setBounds(250,10,100,30);
	bid.setBounds(350,10,80,30);

    	submit.setBounds(460,10,140,30);
	save.setBounds(900,550,120,32);
    	back.setBounds(40,20,130,30);
	a.setBounds(190,80,220,600);
  	
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
	System.out.println("update ___"+mtid);
	while(i < rcnt)
	{
		if(c[i].getText()!=" " && c[i].getText()!=null)
		{
		System.out.println("update ___"+mtid);
			try
			{
				
PreparedStatement ps;

				ps=s.con.prepareStatement("Insert into timetrial values(?,?,?,?)");

				ps.setInt(1,mtid);
				ps.setInt(2,Integer.parseInt(sid[i].getText()));
				ps.setString(3,dt.getText());
				System.out.println("time:"+c[i].getText());
				ps.setString(4,c[i].getText())
;
				
int k=ps.executeUpdate();
				mtid++;
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else
		{
			System.out.println(i+"student is absent");
		}
		i++;
	
}

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

int i=0;
int k=0;
int y=85;
JLabel nam[];


if(e3.getSource()==save)
{
	if(update()==0)
	{
			JOptionPane.showMessageDialog (null,
					       "Error!!!","Submission Fail",
					       JOptionPane.DEFAULT_OPTION);
		bid.requestFocus ();
	}
	else
	{
			JOptionPane.showMessageDialog (null,
					       "Records of time trial for batch "+bid.getText() +" saved successfully","Submission Successful",
					       JOptionPane.DEFAULT_OPTION);
		bid.requestFocus ();
	}
}

if(e3.getSource()==submit)
{
	if(bid.getText().equals(""))
		{
			JOptionPane.showMessageDialog (null,"Enter Batch ID!","Error",JOptionPane.DEFAULT_OPTION);
					bid.requestFocus ();
		}
else
{
while(i<rcnt)
c[i++].setVisible(false);
	
		c=null;
		sid=null;
		nam=null;	
		k=0;
		y=93;
		try
		{
			c=null;
			c=new JTextField[100]; 
			sid=new JLabel[100];
			nam=new JLabel[100]; 
			a.setText(" ");
			Font f1=new Font("Brodway",Font.BOLD,12) ;  
			s.rs=s.stmt.executeQuery("select sid,fname,lname from student where student.bid="+bid.getText());
		while(s.rs.next())
		{	//nd=s.rs.getDate(5);
			//if(nd <= temp)
			{
				c[k]=new JTextField();	
				c[k].setBounds(500,y,33,18);
				sid[k]=new JLabel(s.rs.getString(1));
				a.append("\n    "+s.rs.getString(1)+"\t"+s.rs.getString(2)+" "+s.rs.getString(3));
				this.add(c[k]);
				y=y+16;
				k++;		
			}
		}
		System.out.println("rcnt==="+k);
		
		this.add(new JLabel(""));
		rcnt=k;	
		this.setVisible (true);
	}
	catch(Exception e)
	{
		System.out.println(e);
	}}		
	}
	if(e3.getSource()==back)
	{
		new ManMain1();
		dispose();
	}

}
}
