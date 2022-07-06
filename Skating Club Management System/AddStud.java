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

  JLabel sd,fname,mname,lname,addr,dob,cno,mid,afee,prn,school,batch,cno2,intrst;

  JTextField fnam,mnam,lnam,adrs,bdt,cono,mail,adfee,pno,sname,cono2;

  JCheckBox fun,fit,comp;


  ButtonGroup batches;

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
  
JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/addstu.jpg")));
		 this.add(background);
    this.setSize (1366,786);
    this.setDefaultCloseOperation (EXIT_ON_CLOSE);
   
int sno=ano+1;


    sd = new JLabel ("Student ID: "+sno);

    fname = new JLabel ("*First Name:");
    mname = new JLabel ("*Middle Name:");
    lname=new JLabel("*Last Name :");
    addr = new JLabel ("*Address:");
    dob= new JLabel ("*Date of Birth:");
    cno= new JLabel ("*Contact No:");
    mid = new JLabel ("*Mail ID:");
    afee = new JLabel ("*Admission Fee:");
    prn= new JLabel ("*PRN No:");
    school=new JLabel("*School Name :");
    batch = new JLabel ("*Batches:");
    cno2= new JLabel ("*WhatsApp Contact No:");
    intrst= new JLabel ("*Interest in Skating For:");

    fnam=new JTextField();
    mnam=new JTextField();
    lnam=new JTextField();
    adrs=new JTextField();
    bdt=new JTextField("DD/MM/YYYY");
    cono=new JTextField();

    mail=new JTextField("username@gmail.com");
    adfee=new JTextField();
    pno=new JTextField();
    sname=new JTextField();
    cono2=new JTextField();    

  regl1=new JRadioButton("(B-1) 1st Beginner's & Semi Advance batch:- 5.30-6.30pm");
  regl2=new JRadioButton("(B-2) 2nd Beginner's & Semi Advance batch:- 6.30-7.30pm");
  regl3=new JRadioButton("(B-3) Advance Professional:- 6.30-8.30pm");

  regl4=new JRadioButton("(B-4) 1st Beginner's & Semi Advance weekend batch:- 6.30-7.30pm");

  regl5=new JRadioButton("2nd Beginner's & Semi Advance weekend batch");

  regl6=new JRadioButton("(B-5) Advance Professional weekend batch:- 6.30-8.30pm");
 
 batches=new ButtonGroup();
 batches.add(regl1);
 batches.add(regl2);
 batches.add(regl3); 
batches.add(regl4); 
batches.add(regl5);
 batches.add(regl6);



    fun=new JCheckBox("Fun");
    fit=new JCheckBox("Fitness");
    comp=new JCheckBox("Competition");
 
       submit =new JButton ("Submit");
       back =new JButton ("<<Back");


    sd.setBounds(1120,20,230,100);

    fname.setBounds(190,140,150,30);
    mname.setBounds(490,140,150,30);
    lname.setBounds(830,140,150,30);   
    addr.setBounds(215,187,160,30);
    dob.setBounds(200,267,160,30);
    cno.setBounds(200,227,160,30);

    mid.setBounds(220,307,160,30);
    afee.setBounds(200,387,180,30);
    prn.setBounds(710,347,160,30);
    school.setBounds(200,347,180,30);
    batch.setBounds(200,487,160,30);
    cno2.setBounds(645,227,160,30);
    intrst.setBounds(200,420,160,30);


  
    fnam.setBounds(290,140,170,30);
    mnam.setBounds(600,140,170,30);
    lnam.setBounds(930,140,170,30);
    adrs.setBounds(310,180,340,37);				
    bdt.setBounds(320,267,200,30);
    cono.setBounds(320,227,200,30);
    mail.setBounds(320,307,200,30);
    adfee.setBounds(320,387,140,30);
    pno.setBounds(800,347,100,30);
    sname.setBounds(320,347,220,30);
    
cono2.setBounds(800,227,200,30);
  
    fun.setBounds(550,447,180,30);
    fit.setBounds(780,447,180,30);
    comp.setBounds(320,447,180,30);



	d=new Date();

	sdf=new SimpleDateFormat("dd/MM/yyyy");

	sdf.format(d);


	regl1.setBounds(320,487,360,30);	
regl2.setBounds(320,527,385,30);
	
	regl3.setBounds(320,567,385,30);
	regl4.setBounds(720,487,402,30);

	regl5.setBounds(720,496,399,30);
	regl6.setBounds(720,527,399,30);



    submit.setBounds(600,640,160,32);
    back.setBounds(50,40,140,30);


   // background.add (sd);

    background.add (fname);
    background.add (mname);
    background.add (lname);
    background.add (addr);
    background.add (dob);
    background.add (cno);
    background.add (mid);
    background.add (afee);
    background.add (prn);
    background.add (school);
    
background.add (cno2);
    background.add (intrst);
    background.add (batch);

    
    background.add (fnam);
    background.add (mnam);
    background.add (lnam);
    background.add (adrs);
    background.add (bdt);
    background.add (cono);
    background.add (mail);
    background.add (adfee);
    background.add (pno);
    background.add (sname);
    
background.add (cono2);
   
    background.add (fun);
    background.add (fit);
    background.add (comp);

 
   background.add (regl1);
    background.add (regl2);
   
   background.add (regl3);
    background.add (regl4);

// background.add (regl5);
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

String getcval()

{

String ans=" ";

if(fun.isSelected())

ans+=" Fun ";


if(fit.isSelected())

ans+=" Fitness ";


if(comp.isSelected())

ans+=" Competition ";


return ans;

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


		ps=s.con.prepareStatement("Insert into Student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		ps.setInt(1,ano);
		ps.setString(2,fnam.getText());
		ps.setString(3,mnam.getText());
		ps.setString(4,lnam.getText());	
		ps.setString(5,adrs.getText());
		ps.setString(6,bdt.getText());
		ps.setString(7,cono.getText());
		ps.setString(8,mail.getText());
		ps.setString(9,adfee.getText());
		ps.setInt(10,Integer.parseInt(pno.getText()));
		ps.setString(11,sname.getText());
		ps.setInt(12,getbval());


			String ss=sdf.format(d);
	
		ps.setString(13,(String)ss);

		ps.setString(14,cono2.getText());

		ps.setString(15,getcval());
		
		nd=new Date(d.getTime()+60*(24*60*60*1000));
		String ds=sdf.format(nd);

	System.out.println(ds+"aaaaaaa"+d.getTime());
				
		
		
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
		ps.setString(4,"jan")
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
 
		if (fnam.getText ().equals ("")  ||mnam.getText ().equals ("") ||lnam.getText ().equals ("") ||cono2.getText ().equals ("")||pno.getText ().equals ("")|| bdt.getText ().equals ("") || adrs.getText ().equals ("")  || cono.getText ().equals ("")  || mail.getText ().equals ("") ) 
	     {
		if(getbval()==0)
			JOptionPane.showMessageDialog (null,
					       "All entries with * are must","Submission Fail",
					       JOptionPane.DEFAULT_OPTION);
		fname.requestFocus ();
	      }

	   else 
	      {	
	
		if(v.validname(fnam.getText())==1 && v.validname(lnam.getText())==1  && v.validphone(cono.getText())==1 && v.validphone(cono2.getText())==1&& v.validemail(mail.getText())==1)          
			
			{   
				i=insert();        
			
  			 
			 }
			if(i==1)

			{
				
				JOptionPane.showMessageDialog (null,"Submitted Successfully","Process Complete",JOptionPane.DEFAULT_OPTION);
			}
			else
			{
				
				JOptionPane.showMessageDialog (null,"Submission failed","ERROR!!!",JOptionPane.DEFAULT_OPTION);
			}

			new Student();
			dispose();


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
