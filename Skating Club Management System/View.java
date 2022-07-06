import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import pro.*;

class View extends JFrame implements ActionListener
{
	static int sno;

 JLabel fname,lname,addr,dob,prn,cno,mid,fee,batch,dt,cno2,mnth,intrst,school;
  JLabel fnam,lnam,adrs,bdt,pno,cono,mail,sname,afee,bt,ad,cono2;

  JButton back;

  Connection con = null;
  Statement stmt = null;
  ResultSet rs;

  Staticinfo s;

  public View()
  {
    super ("Student's Details");
       	
  JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/addstu.jpg")));
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


    fname = new JLabel ("Name:"); 
    addr = new JLabel ("Address:");
    dob= new JLabel ("Date of Birth:");
    cno= new JLabel ("Contact No:");
    mid = new JLabel ("Mail ID:");
    fee = new JLabel ("Admission Fee:");
    prn= new JLabel ("PRN No:");
    school=new JLabel("School Name :");
    batch=new JLabel("Batch:");
    dt = new JLabel ("Admission Date:");
    cno2= new JLabel ("WhatsApp Contact No:");


    fnam=new JLabel();
    adrs=new JLabel();
    bdt=new JLabel();
    cono=new JLabel();
    mail=new JLabel();
    afee=new JLabel();
    pno=new JLabel();
    sname=new JLabel();
    bt=new JLabel();
    ad=new JLabel();
    cono2=new JLabel();

       back =new JButton ("<<Back");

fnam.setText(rsfname+" "+rsmname+" "+rslname);
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

    batch.setBounds(200,140,160,30);
    fname.setBounds(200,180,160,30);
    addr.setBounds(200,220,160,30);
    dob.setBounds(200,260,160,30);
    mid.setBounds(200,300,160,30);
    cno.setBounds(200,340,160,30);
    cno2.setBounds(200,380,160,30);
    school.setBounds(200,420,160,30);
    prn.setBounds(200,460,160,30);
    dt.setBounds(200,500,160,30);
    fee.setBounds(200,540,160,30);
  
    bt.setBounds(310,140,200,30);
    fnam.setBounds(310,180,250,30);
    adrs.setBounds(310,220,400,30);				
    bdt.setBounds(310,260,200,30);
    mail.setBounds(310,300,200,30);
    cono.setBounds(310,340,200,30);
    cono2.setBounds(330,380,200,30);
    sname.setBounds(310,420,200,30);
    pno.setBounds(310,460,200,30);
    ad.setBounds(310,500,200,30);
    afee.setBounds(310,540,200,30);

   back.setBounds(50,40,140,30);

    background.add (batch);
    background.add (fname);
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
    background.add (adrs);
    background.add (bdt);
    background.add (mail);
    background.add (cono);
    background.add (cono2);
    background.add (sname);
    background.add (pno);
    background.add (ad);
    background.add (afee);
    background.add(back);

    back.addActionListener(this);

	this.setVisible (true);


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


  public static void main (String s[])
  {
    new View();

  }
  public void actionPerformed (ActionEvent e3)
  {
if(e3.getSource()==back)
{
new EditRec();
dispose();
}

  }
}
