import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import pro.*;

class CampEdit extends JFrame implements ActionListener
{
	static int sno;
  JLabel fname,mname,lname,addr,dob,prn,school,cno,cno2,mid,mnth,intrst,batch,reg,wekly,feeSt,mode,lbatch;
  JLabel fnam,lnam,mnam,adrs,pno,sname,cono,cono2,mail,bdt,mnt;
JCheckBox c1,c2,c3,c4,c5,c6;
JLabel cfeel;
	JTextField cfeet;
  
ButtonGroup batches,mod;
  JTextField tbatch;
 JRadioButton regl1,regl2,regl3,mod1,mod2;
  JButton submit,back,view;
  Connection con = null;
  Statement stmt = null;
  ResultSet rs;

  Staticinfo s;
int rid;
  public CampEdit ()
  {
    super ("Edit Student Record" );
       	
  JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/addstu.jpg")));
				  this.add(background);
    this.setSize (1366,786);


    this.setDefaultCloseOperation (EXIT_ON_CLOSE);

lbatch=new JLabel("Student ID:");
lbatch.setBounds(220,150,100,30);
background.add(lbatch);
tbatch=new JTextField();
tbatch.setBounds(300,150,100,30);
background.add(tbatch);
view=new JButton("View");
view.setBounds(440,150,100,30);
view.addActionListener(this);
background.add(view);

  fname = new JLabel ("First Name:");
		mname = new JLabel ("Middle Name:");
    		lname=new JLabel("Last Name:");
    		school=new JLabel("School Name :");
    		addr = new JLabel ("Address:");
    		dob= new JLabel ("Date of Birth");
    		mid = new JLabel ("Mail ID:");
    		cno= new JLabel ("Contact No:");
    		cno2=new JLabel("WhatsApp Contact:");
    		intrst= new JLabel ("Interest in Skating for:");
    		batch = new JLabel ("Batches:");
		cfeel=new JLabel("Total Camp Fee :");


		
    
    sname=new JLabel();
    fnam=new JLabel();
    mnam=new JLabel();
    lnam=new JLabel();
    adrs=new JLabel();
    pno=new JLabel();
    cono=new JLabel();
    mail=new JLabel();
    bdt=new JLabel();
  cono2=new JLabel();
  cfeet=new JTextField();

		Color c=new Color(0,0,255);	  
		//sid.setForeground(c);
		fnam.setForeground(c);
		mnam.setForeground(c);
		lnam.setForeground(c);
		adrs.setForeground(c);
		bdt.setForeground(c);
		sname.setForeground(c);
		mail.setForeground(c);
		cono.setForeground(c);
		cono2.setForeground(c);

    		c1=new JCheckBox("Camp1");
		c2=new JCheckBox("Camp2");
	 	c3=new JCheckBox("Camp3");
	 	c4=new JCheckBox("Camp4");
	 	c5=new JCheckBox("Camp5");
   		c6=new JCheckBox("Camp6");

 regl1=new JRadioButton("(1)1st Beginner's & Semi Advance batch:- 5.30-6.30pm");
  		regl2=new JRadioButton("(2)2nd Beginner's & Semi Advance batch:- 6.30-7.30pm");
  		regl3=new JRadioButton("(3)Advance Professional & Elite batch:- 6.30-8.30pm");

  batches=new ButtonGroup();
  batches.add(regl1);
  batches.add(regl2);
  batches.add(regl3);



       submit =new JButton ("Update");
       back =new JButton ("<<Back");

    		fname.setBounds(200,210,160,30);
		mname.setBounds(520,210,160,30);
    		lname.setBounds(845,210,160,30);
    		addr.setBounds(205,250,160,30);
    		dob.setBounds(200,300,160,30);
 		school.setBounds(630,300,180,30);
    		sname.setBounds(720,300,180,30);
    		mid.setBounds(630,250,160,30);
    		cno.setBounds(200,340,160,30);
    		cno2.setBounds(630,340,160,30);
	
		c1.setBounds(200,400,100,30);
		c2.setBounds(320,400,100,30);
		c3.setBounds(440,400,100,30);
		c4.setBounds(560,400,100,30);
		c5.setBounds(680,400,100,30);
		c6.setBounds(800,400,100,30);

		cfeel.setBounds(920,400,100,30);
		cfeet.setBounds(1020,400,100,30);
   		batch.setBounds(200,460,160,30);


    		fnam.setBounds(300,210,180,30);
		mnam.setBounds(620,210,180,30);
    		lnam.setBounds(940,210,180,30);
    		adrs.setBounds(310,250,280,37);				
    		bdt.setBounds(310,300,200,30);
    		
    		mail.setBounds(710,250,200,30);
    		cono.setBounds(310,340,200,30);
    		cono2.setBounds(750,340,200,30);

		regl1.setBounds(310,450,360,30);

		regl2.setBounds(310,500,360,30);

		regl3.setBounds(310,550,360,30);

  
  
   submit.setBounds(590,600,160,33);
    back.setBounds(50,40,140,30);
	background.add(c1);
		background.add(c2);
		background.add(c3);
		background.add(c4);
		background.add(c5);
		background.add(c6);
		background.add(cfeel);
		background.add(cfeet);
		background.add(cno2);
		background.add(cono2);
	
  		background.add (school);
    		background.add (sname);
    	
    		background.add (lname);
    		background.add (fname);
    		background.add (addr);
    		background.add (dob);
    		background.add (cno);
		background.add (cno2);
    		background.add (mid);
    		//background.add (intrst);
    		background.add (batch);

    		background.add (lnam);
    		background.add (fnam);
    		background.add (adrs);
    		background.add (mname);
    		background.add (cono);
		background.add (cono2);
    		background.add (mail);
    		background.add (bdt);
    		background.add (mnam);

    		background.add (regl1);

		background.add (regl2);
		
background.add (regl3);


    background.add (submit);
    background.add(back);

    submit.addActionListener (this);
    back.addActionListener(this);


	this.setVisible (true);
  
  }

void setbval(int a)

{

if(a==1) regl1.setSelected(true);

else if(a==2) regl2.setSelected(true);

else if(a==3) regl3.setSelected(true);

}


int getbval()

{

if(regl1.isSelected())

return 1;

if(regl2.isSelected())

return 2;

if(regl3.isSelected())

return 3;

else

return 0;

}

public int update()

{

int i=0;

try

	{
		
		
PreparedStatement ps;

		ps=con.prepareStatement("Update Camp set c1=?,c2=?,c3=?,c4=?,c5=?,c6=?,fee=? where sid=?");

			if(c1.isSelected()==true)
				ps.setInt(1,10+getbval());
			else
				ps.setInt(1,0);
			if(c2.isSelected()==true)
				ps.setInt(2,20+getbval());
			else
				ps.setInt(2,0);
			if(c3.isSelected()==true)
				ps.setInt(3,30+getbval());
			else
				ps.setInt(3,0);
			if(c4.isSelected()==true)
				ps.setInt(4,40+getbval());
			else
				ps.setInt(4,0);
			if(c5.isSelected()==true)
				ps.setInt(5,50+getbval());
			else
				ps.setInt(5,0);
			if(c6.isSelected()==true)
				ps.setInt(6,60+getbval());
			else
				ps.setInt(6,0);
		ps.setInt(7,Integer.parseInt(cfeet.getText()))
;
		ps.setInt(8,s.sid);
		
i=ps.executeUpdate();
	
}

catch(Exception e)

	{
		
System.out.println(e);
	
}
return i;

}



  public static void main (String s[])
  {
    new CampEdit();

  }

public void connect()

{

try

	{
		Class.forName("com.mysql.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
		 stmt=con.createStatement();

	}

catch(Exception e)

	{

		System.out.println(e);

	}


}


  public void actionPerformed (ActionEvent e3)
  {
if(e3.getSource()==submit)
{int i;
	if(e3.getSource()==submit)
	{
	     
			i=update();
			if(i==1)

			{
				
				JOptionPane.showMessageDialog (null,"Record Updated Successfully","Process Complete",JOptionPane.DEFAULT_OPTION);
				new Camp();
				dispose();
			}
			else
			{
				
				JOptionPane.showMessageDialog (null,"ERROR! Fail to Update","Submission Fail",JOptionPane.DEFAULT_OPTION);
			}
		
	 
		    
	}
 else 
	      {
			JOptionPane.showMessageDialog (null,
					       "Record Updated","Process Complete",
					       JOptionPane.DEFAULT_OPTION);
		
	      }


}
else if(e3.getSource()==back)
{
new Camp();
dispose();
}
else if(e3.getSource()==view)
{
		if(tbatch.getText().equals(""))
			{
				
				JOptionPane.showMessageDialog (null,"Enter Student ID!","Error",JOptionPane.DEFAULT_OPTION);
			}
else
{
String rsfname,rsmname,rslname,rscono,rscono2,rsmid,rsadd,rsdob,rsmnt,rsprn,rsschool;
rsfname=new String();
rsmname=new String();
rslname=new String();
rscono=new String();
rsmid=new String();
rsadd=new String();
rsdob=new String();
rscono2=new String();
rsschool=new String();

connect();
try
{
s.sid=Integer.parseInt(tbatch.getText());
System.out.println("*******"+s.sid);
		rs=stmt.executeQuery("select sid,fname,mname,lname,address,dob,contact,contact2,email,school,bid from Student");
		while(rs.next())
		{	
			if(s.sid==rs.getInt(1) )
			{
			sno=rs.getInt(1);
			rsfname=rs.getString(2);
			rsmname=rs.getString(3);
			rslname=rs.getString(4);
			rsadd=rs.getString(5);
			rsdob=rs.getString(6);
			rscono=rs.getString(7);
			rscono2=rs.getString(8);
			rsmid=rs.getString(9);
			rsschool=rs.getString(10);
			rid=rs.getInt(11);
			}
		 }
		

fnam.setText(rsfname);
mnam.setText(rsmname);
lnam.setText(rslname);
adrs.setText(rsadd);
sname.setText(rsschool);
cono.setText(rscono);
cono2.setText(rscono2);
mail.setText(rsmid);
bdt.setText(rsdob);


int cc1=0,cc2=0,cc3=0,cc4=0,cc5=0,cc6=0,ccf=0;

rs=stmt.executeQuery("select sid,c1,c2,c3,c4,c5,c6,fee from camp");
		while(rs.next())
		{	
			if(s.sid==rs.getInt(1) )
			{
			cc1=rs.getInt(2);
			cc2=rs.getInt(3);
			cc3=rs.getInt(4);
			cc4=rs.getInt(5);
			cc5=rs.getInt(6);
			cc6=rs.getInt(7);
			ccf=rs.getInt(8);
			}
		 }
rid=cc1%10;
  setbval(rid);
if(cc1!=0)
c1.setSelected(true);
if(cc2!=0)
c2.setSelected(true);
if(cc3!=0)
c3.setSelected(true);
if(cc4!=0)
c4.setSelected(true);
if(cc5!=0)
c5.setSelected(true);
if(cc6!=0)
c6.setSelected(true);

cfeet.setText(ccf+"");
}
catch(Exception e )
{
System.out.println(e);
}

}
  }
}
}