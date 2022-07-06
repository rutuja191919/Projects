import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import pro.*;

class DelStud extends JFrame implements ActionListener
{
		static int sno;
 JLabel fname,lname,addr,dob,prn,cno,mid,mnth,intrst,school,age,batch,reg,wekly,feeSt,mode;
  JLabel fnam,lnam,adrs,pno,cono,mail,sname,agefield;
  JCheckBox fun,fit,comp;

  ButtonGroup batches,mod;
  JLabel bdt,mnt;
  JRadioButton regl1,regl2,regl3,mod1,mod2;
  JButton submit,back;
  Connection con = null;
  Statement stmt = null;
  ResultSet rs;

  Staticinfo s;

  public DelStud()
  {
    super ("Delete Student's Record:");
       	
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
			}
		 }
}
catch(Exception e )
{
System.out.println(e);
}

      school=new JLabel("School Name :");
    age=new JLabel("Age:");
    fname = new JLabel ("First Name:");
    lname=new JLabel("Last Name");
    addr = new JLabel ("Address:");
    dob= new JLabel ("Date of Birth");
    prn= new JLabel ("PRN No:");
    mid = new JLabel ("Mail Id:");
    cno= new JLabel ("Contact No:");
    mnth = new JLabel ("Month of Admission:");
 
  sname=new JLabel();
    agefield=new JLabel();
    fnam=new JLabel();
    lnam=new JLabel();
    adrs=new JLabel();
    pno=new JLabel();
    cono=new JLabel();
    mail=new JLabel();


    bdt=new JLabel();
    mnt=new JLabel();
  
       back =new JButton ("back", new ImageIcon (ClassLoader. getSystemResource ("pics/back.png")));
	submit=new JButton("DELETE");
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

     school.setBounds(600,60,180,30);
    sname.setBounds(800,60,180,30);
    age.setBounds(600,100,180,30);
    agefield.setBounds(800,100,180,30);
    fname.setBounds(200,60,160,30);
    lname.setBounds(200,100,160,30);
    addr.setBounds(200,140,160,30);
    dob.setBounds(200,180,160,30);
    prn.setBounds(200,220,160,30);
    mid.setBounds(200,260,160,30);
    cno.setBounds(200,300,160,30);
    mnth.setBounds(200,340,180,30);
  
    fnam.setBounds(310,60,200,30);
    lnam.setBounds(310,100,200,30);
    adrs.setBounds(310,140,200,30);				
    bdt.setBounds(310,180,200,30);
    pno.setBounds(310,220,200,30);
    mail.setBounds(310,260,200,30);
    cono.setBounds(310,300,200,30);
    mnt.setBounds(340,340,140,30);
   back.setBounds(960,590,120,32);
submit.setBounds(960,550,120,32);
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
    background.add (lnam);
    background.add (fnam);
    background.add (adrs);
    background.add (pno);
    background.add (cono);
    background.add (mail);
    background.add (bdt);
    background.add (mnt);
    background.add(back);
  background.add(submit);
    back.addActionListener(this);
    submit.addActionListener(this);

	this.setVisible (true);
}

public int delete()

{

int i=0;

try

	{
		
PreparedStatement ps;

		ps=con.prepareStatement("delete from Student where sid=?");

		ps.setInt(1,s.sid);
		
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
    new DelStud();
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
	{
	int i;
			i=delete();
			if(i!=0)

			{
				
			JOptionPane.showMessageDialog (null,"Record Deleted Successfully","Process 			Complete",JOptionPane.DEFAULT_OPTION);
			}
			else
			{
				
				JOptionPane.showMessageDialog (null,"ERROR! Fail to Delete ","Process 			Complete",JOptionPane.DEFAULT_OPTION);
			}
	}
	else if(e3.getSource()==back)
	{
		new EditRec();
		dispose();
	}

  }
}
