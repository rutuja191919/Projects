import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import pro.*;

class Edit extends JFrame implements ActionListener
{
	static int sno;
  JLabel fname,lname,addr,dob,prn,school,age,cno,mid,mnth,intrst,batch,reg,wekly,feeSt,mode;
  JTextField fnam,lnam,adrs,pno,sname,agefield,cono,mail;
  
ButtonGroup batches,mod;
  JTextField bdt,mnt;
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
       	
  JLabel background=new JLabel();
				  this.add(background);
    this.setSize (1366,786);


    this.setDefaultCloseOperation (EXIT_ON_CLOSE);

String rsfname,rslname,rscono,rsmid,rsadd,rsdob,rsmnt,rsprn,rsage,rsschool;
rsfname=new String();
rslname=new String();
rscono=new String();
rsmid=new String();
rsadd=new String();
rsdob=new String();
rsmnt=new String();
rsprn=new String();
rsage=new String();
rsschool=new String();

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
			rslname=rs.getString(3);
			rscono=rs.getString(6);
			rsdob=rs.getString(5);
			rsmid=rs.getString(7);
			rsadd=rs.getString(4);
			rsmnt=rs.getString(8);
			rsprn=rs.getString(9);
			rsage=rs.getString(10);
			rsschool=rs.getString(11);
			rid=rs.getInt(12);
			}
		 }
}
catch(Exception e )
{
System.out.println(e);
}
    fname = new JLabel ("First Name:");
    lname=new JLabel("Last Name");
  school=new JLabel("School Name :");
    age=new JLabel("Age:");
    addr = new JLabel ("*Address:");
    dob= new JLabel ("Date of Birth");
    prn= new JLabel ("PRN No:");
    mid = new JLabel ("Mail Id:");
    cno= new JLabel ("Contact No:");
    mnth = new JLabel ("Month of Admission:");
    intrst= new JLabel ("Interest in Skating for:");
    batch = new JLabel ("Batches:");
   // feeSt= new JLabel ("600/- per month.Have to pay two months fees in Advance.");
    mode= new JLabel ("Mode of Payment:");

    sname=new JTextField();
    agefield=new JTextField();
    fnam=new JTextField();
    lnam=new JTextField();
    adrs=new JTextField();
    pno=new JTextField();
    cono=new JTextField();
    mail=new JTextField();
    
    bdt=new JTextField();
    mnt=new JTextField();

fnam.setText(rsfname);
lnam.setText(rslname);
adrs.setText(rsadd);
pno.setText(rsprn);
sname.setText(rsschool);
agefield.setText(rsage);
cono.setText(rscono);
mail.setText(rsmid);
bdt.setText(rsdob);
mnt.setText(rsmnt);

  regl1=new JRadioButton("1st beginner's & Semi Advance batch:- 5.30-6.30pm");
  regl2=new JRadioButton("2nd beginner's & Semi Advance batch:- 6.30-7.30pm");
  regl3=new JRadioButton("Advance Professional & Elite batch:- 6.30-8.30pm");
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

       submit =new JButton ("Update");
       back =new JButton ("Back", new ImageIcon (ClassLoader. getSystemResource ("pics/back.png")));

    fname.setBounds(200,60,160,30);
    lname.setBounds(200,100,160,30);
    addr.setBounds(200,140,160,30);
    dob.setBounds(200,180,160,30);
 school.setBounds(600,60,180,30);
    sname.setBounds(800,60,180,30);
    age.setBounds(600,100,180,30);
    agefield.setBounds(800,100,180,30);
    prn.setBounds(200,220,160,30);
    mid.setBounds(200,260,160,30);
    cno.setBounds(200,300,160,30);
    mnth.setBounds(200,340,180,30);

   batch.setBounds(200,440,160,30);
//    feeSt.setBounds(200,550,400,30);
    mode.setBounds(200,590,180,30);

    fnam.setBounds(310,60,200,30);
    lnam.setBounds(310,100,200,30);
    adrs.setBounds(310,140,200,30);				
    bdt.setBounds(310,180,200,30);
    pno.setBounds(310,220,200,30);
    mail.setBounds(310,260,200,30);
    cono.setBounds(310,300,200,30);
    mnt.setBounds(340,340,140,30);
	regl1.setBounds(310,440,360,30);

	regl2.setBounds(310,480,360,30);

	regl3.setBounds(310,520,360,30);
regl4.setBounds(710,440,360,30);

	regl5.setBounds(710,480,360,30);

	regl6.setBounds(710,520,360,30);


	mod1.setBounds(330,590,90,30);
	mod2.setBounds(430,590,90,30);

setbval(rid);

  submit.setBounds(810,625,120,32);
    back.setBounds(960,625,120,32);

  background.add (school);
    background.add (sname);
    background.add (age);
    background.add (agefield);
    background.add (lname);
    background.add (fname);
    background.add (addr);
    background.add (dob);
    background.add (prn);
    background.add (cno);
    background.add (mid);
    background.add (mnth);
    background.add (intrst);
    background.add (batch);
//    background.add (feeSt);
    background.add (mode);

    background.add (lnam);
    background.add (fnam);
    background.add (adrs);
    background.add (pno);
    background.add (cono);
    background.add (mail);
    background.add (bdt);
    background.add (mnt);
    background.add (mod1);
    background.add (mod2);
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

		ps=con.prepareStatement("Update Student set fname=?,lname=?,address=?,contact=?,email=?,month=?,prn=?,age=?,school=?,dob=?,bid=? where sid=?");

		
		ps.setString(1,fnam.getText());
		ps.setString(2,lnam.getText());
		ps.setString(3,adrs.getText());
		ps.setInt(8,Integer.parseInt(agefield.getText()));
		ps.setString(5,mail.getText());
		ps.setInt(7,Integer.parseInt(pno.getText()))
;
		ps.setString(6,mnt.getText());
		ps.setString(4,(cono.getText()));
		ps.setString(9,sname.getText());

		ps.setString(10,bdt.getText());
		ps.setInt(11,getbval());

		ps.setInt(12,s.sid);
		
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
				
				JOptionPane.showMessageDialog (null,"ERROR! Fail to Update","Process Complete",JOptionPane.DEFAULT_OPTION);
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
