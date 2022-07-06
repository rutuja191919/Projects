import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;

import java.util.Date;

import java.io.*;

import java.text.*;
import pro.*;

class AddStud extends JFrame implements ActionListener
{
static int ano=0;
  JLabel fname,lname,addr,dob,prn,cno,cno2,mid,mnth,intrst,batch,reg,age,school,wekly,feeSt,mode;
  JTextField fnam,lnam,adrs,pno,agefield,sname,cono,cono2,mail;
  JCheckBox fun,fit,comp;

  ButtonGroup batches,mod;
  JTextField bdt,mnt;
  JRadioButton regl1,regl2,regl3,regl4,regl5,regl6,mod1,mod2;
  JButton submit,back;
Staticinfo s;
Validation v;
Font f;
Color c;
	Date d,nd;
	SimpleDateFormat sdf;

  public AddStud ()
  {
    super ("Registration of Student");
	s=new Staticinfo();       	
		f=new Font("Lucida Fax",Font.BOLD,20) ;  
		Color c=new Color(255,0,0);
  JLabel background=new JLabel();
				  this.add(background);
    this.setSize (1366,786);
    this.setDefaultCloseOperation (EXIT_ON_CLOSE);
    fname = new JLabel ("*First Name:");
//fname.setFont(f);
//fname.setForeground(c);
    lname=new JLabel("*Last Name :");
//lname.setFont(f);
//lname.setForeground(c);
    school=new JLabel("*School Name :");
//school.setFont(f);
//school.setForeground(c);    
age=new JLabel("Age:");
//age.setFont(f);
//age.setForeground(c);
    addr = new JLabel ("*Address:");
//addr.setFont(f);
//addr.setForeground(c);
    dob= new JLabel ("*Date of Birth");
//dob.setFont(f);
//dob.setForeground(c);
    prn= new JLabel ("*PRN No:");
//prn.setFont(f);
//prn.setForeground(c);
    mid = new JLabel ("*Mail ID:");
//mid.setFont(f);
//mid.setForeground(c);
    cno= new JLabel ("*Contact No:");
//cno.setFont(f);
//cno.setForeground(c);

    cno2= new JLabel ("Alternate Contact No:");
//cno2.setFont(f);
//cno2.setForeground(c);
    mnth = new JLabel ("*Admission Fee:");
//mnth.setFont(f);
//mnth.setForeground(c);
    intrst= new JLabel ("Interest in Skating For:");
//intrst.setFont(f);
//intrst.setForeground(c);
    batch = new JLabel ("*Batches:");
//batch.setFont(f);
//batch.setForeground(c);
    feeSt= new JLabel ("600/- per month. Have to pay two months fees in Advance.");
//feeSt.setFont(f);
//feeSt.setForeground(c);
    mode= new JLabel ("*Mode of Payment:");
//mode.setFont(f);
//mode.setForeground(c);

    fnam=new JTextField();
    lnam=new JTextField();
    adrs=new JTextField();
    pno=new JTextField();
    cono=new JTextField();

    cono2=new JTextField();
    mail=new JTextField();
    sname=new JTextField();
    agefield=new JTextField();

    fun=new JCheckBox("Fun");
    fit=new JCheckBox("Fitness");
    comp=new JCheckBox("Compitition");

    bdt=new JTextField("DD/MM/YYYY");
    mnt=new JTextField();

  regl1=new JRadioButton("1st beginner's & Semi Advance batch:- 5.30-6.30pm");
  regl2=new JRadioButton("2nd beginner's & Semi Advance batch:- 6.30-7.30pm");
  regl3=new JRadioButton("Advance Professional:- 6.30-8.30pm");

  regl4=new JRadioButton("1st beginner's weekend batch");

  regl5=new JRadioButton("2nd beginner's weekend batch");

  regl6=new JRadioButton("Advance Professional weekend batch");
  batches=new ButtonGroup();
  batches.add(regl1);
  batches.add(regl2);
  batches.add(regl3);
batches.add(regl4);
batches.add(regl5);
batches.add(regl6);

    mod1=new JRadioButton("Cheque");
    mod2=new JRadioButton("Cash");
   mod=new ButtonGroup();
   mod.add(mod1);
   mod.add(mod2);

       submit =new JButton ("SUBMIT");
       back =new JButton ("back", new ImageIcon (ClassLoader. getSystemResource ("pics/back.png")));

    fname.setBounds(200,60,160,30);
    lname.setBounds(200,100,160,30);
    
    school.setBounds(600,220,180,30);
    sname.setBounds(800,220,180,30);
 
    age.setBounds(600,180,180,30);
    agefield.setBounds(800,180,180,30);

    addr.setBounds(200,140,160,30);
    dob.setBounds(200,180,160,30);
    prn.setBounds(200,220,160,30);
    mid.setBounds(200,260,160,30);
    cno.setBounds(200,300,160,30);
    cno2.setBounds(600,300,160,30);
    mnth.setBounds(200,340,180,30);
    intrst.setBounds(200,376,160,30);
   batch.setBounds(200,440,160,30);
    feeSt.setBounds(200,550,400,30);
//    mode.setBounds(200,590,180,30);

    fnam.setBounds(310,60,200,30);
    lnam.setBounds(310,100,200,30);
    adrs.setBounds(310,140,200,30);				
    bdt.setBounds(310,180,200,30);
    pno.setBounds(310,220,200,30);
    mail.setBounds(310,260,200,30);
    cono.setBounds(310,300,200,30);
    cono2.setBounds(800,300,200,30);
    mnt.setBounds(340,340,140,30);
    fun.setBounds(540,400,200,30);
    fit.setBounds(770,400,200,30);
    comp.setBounds(310,400,200,30);

	d=new Date();

		sdf=new SimpleDateFormat("dd/MM/yyyy");

	sdf.format(d);

	regl1.setBounds(310,440,360,30);

	regl2.setBounds(310,480,360,30);
	regl3.setBounds(310,520,360,30);
	regl4.setBounds(710,440,360,30);
	regl5.setBounds(710,480,360,30);
	regl6.setBounds(710,520,360,30);

	mod1.setBounds(330,590,90,30);
	mod2.setBounds(430,590,90,30);

  submit.setBounds(810,625,120,32);
    back.setBounds(960,625,120,32);

    background.add (lname);
    background.add (fname);
    background.add (addr);
    background.add (dob);
    background.add (prn);
    background.add (cno);
    background.add (cno2);
    background.add (mid);
    background.add (mnth);
    background.add (intrst);
    background.add (batch);
//    background.add (feeSt);
//    background.add (mode);

    background.add (school);
    background.add (sname);
    background.add (age);
    background.add (agefield);

    background.add (lnam);
    background.add (fnam);
    background.add (adrs);
    background.add (pno);
    background.add (cono);
    background.add (cono2);
    background.add (mail);
    background.add (fun);
    background.add (fit);
    background.add (comp);
    background.add (bdt);
    background.add (mnt);
//    background.add (mod1);
 
//   background.add (mod2);
 
   background.add (regl1);
    background.add (regl2);
    background.add (regl3);
   background.add (regl4);
    background.add (regl5);
    background.add (regl6);

    background.add (submit);
    background.add(back);

    submit.addActionListener (this);
    back.addActionListener(this);

	this.setVisible (true);


  }
  public static void main (String s[])
  {
    new AddStud();

  }


int getbval()

{

if(regl1.isSelected())

return 1;

if(regl2.isSelected())

return 2;

if(regl3.isSelected())

return 3;

if(regl4.isSelected())

return 4;

if(regl5.isSelected())

return 5;

if(regl6.isSelected())

return 6;

else

return 0;

}


public int insert()

{

int j=0,i=0,k=0;

try

	{
		s.rs=s.stmt.executeQuery("select max(sid) from Student");
		while(s.rs.next())
		{ano=Integer.parseInt(s.rs.getString(1));ano++; }
		
PreparedStatement ps;


		ps=s.con.prepareStatement("Insert into Student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		ps.setInt(1,ano);
		ps.setString(2,fnam.getText());
		ps.setString(3,lnam.getText());	
		ps.setString(4,adrs.getText());
		ps.setString(5,bdt.getText());
		ps.setString(6,cono.getText());
		ps.setString(7,mail.getText());
		ps.setInt(9,Integer.parseInt(pno.getText()));
		ps.setInt(10,Integer.parseInt(agefield.getText()));
		ps.setString(11,sname.getText());
		ps.setInt(12,getbval());

		ps.setString(14,cono2.getText());

		String ss=sdf.format(d);
	
		ps.setString(13,(String)ss);
		nd=new Date(d.getTime()+60*(24*60*60*1000));
		String ds=sdf.format(nd);
	System.out.println(ds+"aaaaaaa"+d.getTime());
				
		ps.setString(8,""+d.getMonth()+1+"");
		
i=ps.executeUpdate();

		int fid=0;
		s.rs=s.stmt.executeQuery("select max(fid) from fee");
		if(s.rs != null)
		{
		while(s.rs.next())
		   fid=s.rs.getInt(1);
		}
		fid++;

		ps=s.con.prepareStatement("Insert into fee values(?,?,?,?,?,?,?)");
		ps.setInt(1,fid);
		ps.setInt(2,ano);
		ps.setString(3,ss);
		ps.setString(4,mnt.getText())
;
		ps.setString(5,ss);
		ps.setString(6,ds);
		ps.setString(7,"1");	
		
k=ps.executeUpdate();

	
}

catch(Exception e)

	{
		
System.out.println(e);
		e.printStackTrace();
	
}
if(i==1 && k==1)
return 1;
else
 return 0;

}

	



  public void actionPerformed (ActionEvent e3)
  {


int i=0;
v=new Validation( );

try
{
	
	if(e3.getSource()==submit)
	{
 
		if (fnam.getText ().equals ("")  || adrs.getText ().equals ("") || pno.getText ().equals ("") || 			cono.getText ().equals ("")  || mail.getText ().equals ("") ) 
	     {
		
			JOptionPane.showMessageDialog (null,
					       "All entrys with * are must","submition fail",
					       JOptionPane.DEFAULT_OPTION);
		fname.requestFocus ();
	      }

	   else 
	      {		
		if(v.validname(fnam.getText())==1 && v.validname(lnam.getText())==1 && v.validage(agefield.getText())==1 && v.validphone(cono.getText())==1 && v.validphone(cono2.getText())==1 && v.validemail(mail.getText())==1)          
			
			{ i=insert();  }
			if(i==1)

			{
				
				JOptionPane.showMessageDialog (null,"Submitted sucessfully","process complete",JOptionPane.DEFAULT_OPTION);
			}
	      }
	


	}
	else if(e3.getSource()==back)
	{
	new Student();
	dispose();
	}
}
catch(Exception e)
{
System.out.println(e);
 }
  }
}
