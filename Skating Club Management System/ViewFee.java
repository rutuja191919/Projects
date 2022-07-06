import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import pro.*;
import java.util.Date;

import java.text.*;

class ViewFee extends JFrame implements ActionListener
{
  JLabel name,lname,cno,id,d1,d2,amount;
  JLabel nam,lnam,cono,id1,dt1,dt2,amt;
JLabel m[],ml[];
Date to,from;
SimpleDateFormat sdf;
	 
  JButton back;

Staticinfo s;
 
  public ViewFee()
  {
    super ("Fee Records Details");

m=new JLabel[12];
ml=new JLabel[12];

	s=new Staticinfo();
	String rsfname,rsmname,rslname,rscono,rsid,rsd1,rsd2,rsamt;
	rsfname=new String();
	rsmname=new String();
	rslname=new String();	
	rscono=new String();
	rsid=new String();
	rsd1=new String();
	rsd2=new String();
	rsamt=new String();
		to=new Date();
		from=new Date();
		
		sdf=new SimpleDateFormat("dd/MM/yyyy");

		sdf.format(to);

        	sdf.format(from);
		
       	try
	{
	s.rs=s.stmt.executeQuery("select fee.sid,fname,mname,lname,contact,todate,fromdate,amount from student,fee where student.sid="+s.sid+" and fee.sid="+s.sid);
		while(s.rs.next())
		{	
			rsid=s.rs.getString(1);
			rsfname=s.rs.getString(2);
			rsmname=s.rs.getString(3);
			rslname=s.rs.getString(4);
			rscono=s.rs.getString(5);
			rsd1=s.rs.getString(6);
			rsd2=s.rs.getString(7);
			rsamt=s.rs.getString(8);		
		 }
	}

	catch(Exception e )
	{
	System.out.println(e);
	}

  JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/viewfee1.png")));
				  this.add(background);
    this.setSize (1366,786);


    this.setDefaultCloseOperation (EXIT_ON_CLOSE);

    name = new JLabel ("Name:");
  lname = new JLabel ("Last Name:");
    id = new JLabel ("Student ID:");
    cno= new JLabel ("Contact No:");
    amount= new JLabel ("Amount:");
    d1 = new JLabel ("To Date:");
    d2 = new JLabel ("From date:");


m[0] = new JLabel ("JAN");
m[1]= new JLabel ("FEB");
m[2]= new JLabel ("MAR");
m[3]= new JLabel ("APR");
m[4]= new JLabel ("MAY");
m[5]= new JLabel ("JUN");
m[6]= new JLabel ("JUL");
m[7]= new JLabel ("AUG");
m[8]= new JLabel ("SEPT");
m[9]= new JLabel ("OCT");
m[10]= new JLabel ("NOV");
m[11]= new JLabel ("DEC");

ml[0]= new JLabel ("***");
ml[1]= new JLabel ("***");
ml[2]= new JLabel ("***");
ml[3] = new JLabel ("***");
ml[4]= new JLabel ("***");
ml[5]= new JLabel ("***");
ml[6]= new JLabel ("***");
ml[7]= new JLabel ("***");
ml[8]= new JLabel ("***");
ml[9]= new JLabel ("***");
ml[10]= new JLabel ("***");
ml[11]= new JLabel ("***");


Date  df,ds;
df=new Date();
sdf.format(df);
ds=new Date();
sdf.format(ds);
String s1,s2;
int i,f,l;
try
{
	s.rs=s.stmt.executeQuery("select fromdate,todate from fee where sid="+s.sid);
	while(s.rs.next())
	{
		s1=s.rs.getString(1);
		s2=s.rs.getString(2);
		df=sdf.parse(s1);
		ds=sdf.parse(s2);
		f=df.getMonth();
		l=ds.getMonth();
		System.out.println(df+":"+f+"----"+ds+":"+l);
		for(i=f;i<l;i++)
		ml[i].setText("Paid");
	}
}
catch(Exception e)
{
e.printStackTrace();
}

    nam=new JLabel();
   lnam=new JLabel(); 
   cono=new JLabel();
    id1=new JLabel();
    dt1=new JLabel();
    dt2=new JLabel();
    amt=new JLabel();    
    
	
	nam.setText(rsfname+" "+rsmname+" "+rslname);
	lnam.setText(rslname);
	id1.setText(rsid);
	cono.setText(rscono);
	dt1.setText(rsd1);
	dt2.setText(rsd2);
	amt.setText(rsamt);

back=new JButton ("<<Back");

    name.setBounds(210,180,160,30);
    id.setBounds(210,140,160,30);
    cno.setBounds(210,220,160,30);
    amount.setBounds(210,260,160,30);
    d1.setBounds(210,340,160,30);
    d2.setBounds(210,300,160,30);
 
    nam.setBounds(330,180,200,30); 
   id1.setBounds(330,140,200,30);
    cono.setBounds(330,220,200,30);
    amt.setBounds(330,260,200,30);
    dt1.setBounds(330,340,200,30);
    dt2.setBounds(330,300,200,30);

m[0].setBounds(153,400,160,30);
m[1].setBounds(253,400,160,30);
m[2].setBounds(353,400,160,30);
m[3].setBounds(453,400,160,30);
m[4].setBounds(553,400,160,30);
m[5].setBounds(653,400,160,30);
m[6].setBounds(153,450,160,30);
m[7].setBounds(253,450,160,30);
m[8].setBounds(353,450,160,30);
m[9].setBounds(453,450,160,30);
m[10].setBounds(553,450,160,30);
m[11].setBounds(653,450,160,30);

ml[0].setBounds(153,420,160,30);
ml[1].setBounds(253,420,160,30);
ml[2].setBounds(353,420,160,30);
ml[3].setBounds(453,420,160,30);
ml[4].setBounds(553,420,160,30);
ml[5].setBounds(653,420,160,30);
ml[6].setBounds(153,470,160,30);
ml[7].setBounds(253,470,160,30);
ml[8].setBounds(353,470,160,30);
ml[9].setBounds(453,470,160,30);
ml[10].setBounds(553,470,160,30);
ml[11].setBounds(653,470,160,30);

       back.setBounds(50,40,140,30);

    background.add (name);
    background.add (cno);
    background.add (id);
    background.add (amount);
    background.add (d1);
    background.add (d2);
   // background.add (lname);
    background.add (nam);
  //  background.add (lnam);
    background.add (cono);
    background.add (id1);
    background.add (amt);
    background.add (dt1);
    background.add (dt2);
  background.add (m[1]);
  background.add (m[2]);
  background.add (m[3]);
  background.add (m[4]);
  background.add (m[5]);
  background.add (m[6]);
  background.add (m[7]);
  background.add (m[8]);
  background.add (m[9]);
  background.add (m[10]);
  background.add (m[11]);
  background.add (m[0]);
 background.add (ml[0]);
  background.add (ml[1]);
  background.add (ml[2]);
  background.add (ml[3]);
  background.add (ml[4]);
  background.add (ml[5]);
  background.add (ml[6]);
  background.add (ml[7]);
  background.add (ml[8]);
  background.add (ml[9]);
  background.add (ml[10]);
  background.add (ml[11]);


    background.add (back);
    back.addActionListener(this);

	this.setVisible (true);

  }
  	public static void main (String s[])
  	{
   		 new ViewFee();

  	}

	  public void actionPerformed (ActionEvent e3)
 	 {

		if(e3.getSource()==back)
		{
			new FeeRec();
			dispose();
		}

	}
}
