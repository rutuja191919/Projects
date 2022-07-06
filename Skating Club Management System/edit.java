import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import pro.*;

class Edit extends JFrame implements ActionListener
{
	static int sno;

 JLabel fname,mname,lname,addr,dob,prn,cno,mid,fee,batch,dt,cno2,mnth,intrst,school;
  JTextField fnam,mnam,lnam,adrs,bdt,pno,cono,mail,sname,afee,bt,ad,cono2;

  
ButtonGroup batches,mod;
  
 JRadioButton regl1,regl2,regl3,regl4,regl5,regl6,mod1,mod2;
  JButton submit,back;
  Connection con = null;
  Statement stmt = null;
  ResultSet rs;

  Staticinfo s;
int rid;

  public Edit ()
  {
    super ("Edit Student Record" );
       	
  JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/abc.jpg")));
				  this.add(background);
    this.setSize (1366,786);


    this.setDefaultCloseOperation (EXIT_ON_CLOSE);

String rsfname,rsmname,rslname,rscono,rsmid,rsadd,rsdob,rsmnt,rsprn,rsage,rsschool,rsafee,rsbid,rscono2,rsdt;

rsfname=new String();
rsmname=new String();
rslname=new String();
rscono=new String();
rsmid=new String();
rsadd=new String();
rsdob=new String();
rsprn=new String();
rsschool=new String();
rsafee=new String();
rsbid=new String();
rscono2=new String();
rsdt=new String();

connect();
try
{
System.out.println("*******"+s.sid);
		rs=stmt.executeQuery("select * from Student");
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
			rsmid=rs.getString(8);
			rsafee=rs.getString(9);
			rsprn=rs.getString(10);
			rsschool=rs.getString(11);
			rsbid=rs.getString(12);
			rsdt=rs.getString(13);
			rscono2=rs.getString(14);		
			}
		 }
}
catch(Exception e )
{
System.out.println(e);
}

    fname = new JLabel ("First Name:"); 
    mname = new JLabel ("Middle Name:"); 
    lname = new JLabel ("Last Name:"); 
    addr = new JLabel ("Address:");
    dob= new JLabel ("Date of Birth:");
    cno= new JLabel ("Contact No:");
    mid = new JLabel ("Mail ID:");
    fee = new JLabel ("Admission Fee:");
    prn= new JLabel ("PRN No:");
    school=new JLabel("School Name :");
    batch=new JLabel("Batches:");
    dt = new JLabel ("Admission Date:");
    cno2= new JLabel ("WhatsApp Contact No:");

    fnam=new JTextField();
	mnam=new JTextField();
	lnam=new JTextField();
    adrs=new JTextField();
    bdt=new JTextField();
    cono=new JTextField();
    mail=new JTextField();
    afee=new JTextField();
    pno=new JTextField();
    sname=new JTextField();
    bt=new JTextField();
    ad=new JTextField();
    cono2=new JTextField();

fnam.setText(rsfname);
mnam.setText(rsmname);
lnam.setText(rslname);
adrs.setText(rsadd);
bdt.setText(rsdob);
cono.setText(rscono);
mail.setText(rsmid);
afee.setText(rsafee);
pno.setText(rsprn);
sname.setText(rsschool);
bt.setText(rsbid);
ad.setText(rsdt);
cono2.setText(rscono2);

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

 //   mod1=new JRadioButton("Cheque");

 //   mod2=new JRadioButton("Cash");
//
   mod=new ButtonGroup();
//   mod.add(mod1);
//   mod.add(mod2);

       submit =new JButton ("Update");
       back =new JButton ("<<Back");


    fname.setBounds(190,140,150,30);
    mname.setBounds(490,140,150,30);
    lname.setBounds(830,140,150,30);   
    addr.setBounds(215,187,160,30);
    dob.setBounds(200,267,160,30);
    cno.setBounds(200,227,160,30);

    mid.setBounds(220,307,160,30);
    fee.setBounds(200,387,180,30);
    prn.setBounds(710,347,160,30);
    school.setBounds(200,347,180,30);
    batch.setBounds(200,437,160,30);
    cno2.setBounds(645,227,160,30);
  
    fnam.setBounds(290,140,170,30);
    mnam.setBounds(600,140,170,30);
    lnam.setBounds(930,140,170,30);
    adrs.setBounds(310,180,340,37);				
    bdt.setBounds(320,267,200,30);
    cono.setBounds(320,227,200,30);
    mail.setBounds(320,307,200,30);
    afee.setBounds(320,387,140,30);
    pno.setBounds(800,347,100,30);
    sname.setBounds(320,347,220,30);
    
cono2.setBounds(800,227,200,30);

   back.setBounds(50,40,140,30);

	regl1.setBounds(320,440,360,30);	
regl2.setBounds(320,480,385,30);
	
	regl3.setBounds(320,520,385,30);
	regl4.setBounds(720,440,402,30);

	regl5.setBounds(720,450,399,30);
	regl6.setBounds(720,480,399,30);


    background.add (batch);
    background.add (fname);
background.add (mname);
background.add (lname);
    background.add (addr);
    background.add (dob);
    background.add (mid);
    background.add (cno);
    background.add (cno2);
    background.add (school);
    background.add (prn);
    background.add (dt);
    background.add (fee);
    background.add (bt);
    background.add (fnam);
background.add (mnam);
background.add (lnam);
    background.add (adrs);
    background.add (bdt);
    background.add (mail);
    background.add (cono);
    background.add (cono2);
    background.add (sname);
    background.add (pno);
    background.add (ad);
    background.add (afee);



//	mod1.setBounds(330,590,90,30);
//mod2.setBounds(430,590,90,30);
    setbval(rid);
  
   submit.setBounds(610,590,160,33);
    back.setBounds(50,40,140,30);

    background.add (regl1);
    background.add (regl2);
    background.add (regl3);

 background.add (regl4);
    //background.add (regl5);
    background.add (regl6);

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

else if(a==4) regl4.setSelected(true);

else if(a==5) regl5.setSelected(true);

else if(a==6) regl6.setSelected(true);

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


public int update()

{

int i=0;

try

	{
		
		
PreparedStatement ps;

		ps=con.prepareStatement("Update Student set fname=?,mname=?,lname=?,address=?,dob=?,contact=?,email=?,admfee=?,prn=?,school=?,bid=?,date=?,contact2=? where sid=?");

		
		ps.setString(1,fnam.getText());
		ps.setString(2,fnam.getText());
		ps.setString(3,lnam.getText());
		ps.setString(4,adrs.getText());
		ps.setString(5,bdt.getText());
		ps.setString(6,cono.getText());
		ps.setString(7,mail.getText());
		ps.setString(8,afee.getText());
		ps.setInt(9,Integer.parseInt(pno.getText()))
;
		ps.setString(10,sname.getText());

		ps.setInt(11,getbval());
		ps.setString(12,ad.getText());
		ps.setString(13,cono2.getText());
		ps.setInt(14,s.sid);
		
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
    new Edit();

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
			}
			else
			{
				
				JOptionPane.showMessageDialog (null,"ERROR! Failed to Update","Process Failed",JOptionPane.DEFAULT_OPTION);
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
new EditRec();
dispose();
}

  }
}
