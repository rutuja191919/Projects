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
  static int ano=1;
int rcnt=0;
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
//background=new JLabel(new ImageIcon(ClassLoader.getSystemResource   ("pics/attend1.png")));

//	this.add(background);
	this.setSize (1366,786);
	this.setDefaultCloseOperation (EXIT_ON_CLOSE);

	batch=new JLabel("Batch ID:");
	bid=new JTextField();
	dtt=new JLabel("Date:");
	dt=new JTextField();
String ss=sdf.format(d);
dt.setText(ss);	
inf=new JLabel("S.ID");
	name = new JLabel ("Name");
	select=new JLabel("Select");   
	submit =new JButton ("Show List");
        save =new JButton ("Save");
	back=new JButton ("<<Back");
        a=new JTextArea(30,70);
	sa=new JButton("Select All");
    	name.setBounds(300,50,160,30);
    	inf.setBounds(200,50,200,30);
 	select.setBounds(600,50,200,30);

	batch.setBounds(220,10,120,30);
	bid.setBounds(330,10,120,30);
	dtt.setBounds(680,10,120,30);
	dt.setBounds(760,10,120,30);
    	submit.setBounds(475,10,150,30);
	save.setBounds(1030,570,120,30);
    	sa.setBounds(880,570,120,30);
    	back.setBounds(30,30,130,30);
	a.setBounds(200,70,360,600);
  	
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
int y=85;
String nam[];

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
					       "Attendance of batch "+bid.getText()+" saved successfully","Submission Successful",
					       JOptionPane.DEFAULT_OPTION);
		bid.requestFocus ();
	}
}

if(e3.getSource()==submit)
{
	if (bid.getText().equals ("") ) 
				{
				JOptionPane.showMessageDialog (null,"Enter Batch ID!","Error",JOptionPane.DEFAULT_OPTION);
						bid.requestFocus ();
				}

else
{				
int z=0;
while(z<rcnt)
c[z++].setVisible(false);
	
	c=null;
		sid=null;
		nam=null;	
		k=0;
		//rcnt=0;
		try
		{
		c=new JCheckBox[100]; 
		sid=new String[100];
		nam=new String[100]; 

		a.setText(" ");
		s.rs=s.stmt.executeQuery("select sid,fname,contact,email,lname from student where bid="+bid.getText());
		while(s.rs.next())
		{
			{
				c[k]=new JCheckBox();
				sid[k]=new String(s.rs.getString(1));
				nam[k]=new String(s.rs.getString(2)+" "+s.rs.getString(5));
				c[k].setBounds(600,y,30,20);
				System.out.println(""+nam[k]+"");
				a.append("\n"+sid[k]+"\t"+nam[k]);
				this.add(c[k]);
				y=y+15;
				k++;		
			}
		}
		this.add(new JLabel(""));
		rcnt=k;	
		this.setVisible (true);
	}
	catch(Exception e)
	{
		System.out.println(e);
	}		
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
