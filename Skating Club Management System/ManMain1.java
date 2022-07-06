import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import pro.*;
import java.sql.*;

import java.io.*;

import java.util.Date;
import java.text.*;


class ManMain1 extends JFrame implements ActionListener
{
  JButton attend,fee,serv, logout,trial,a,b,r,backup,clear,camp;

  public ManMain1 ()
  {
    super ("Admin Main Page");
       	
  JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/man1.png")));
				  this.add(background);
    this.setSize (1366, 786);


    this.setDefaultCloseOperation (EXIT_ON_CLOSE);

    backup=new JButton("BackUp");
    a=new JButton("Admin");
    b=new JButton("Student");
    r=new JButton("Reports");
    attend= new JButton ("Attendance");
    fee = new JButton ("Fee Records");
    serv= new JButton ("Servicing Record");
    trial=new JButton("Time Trial");
    logout = new JButton ("Logout",new ImageIcon (ClassLoader.
				  getSystemResource
				  ("pics/exit.png")));
     clear =new JButton("Clear DataBase");
     camp=new JButton("Camp");

clear.setBounds(40,220,160,30);
backup.setBounds(40,160,160,30);
   a.setBounds(230,530,170,30);
    b.setBounds(450,530,170,30);
    fee.setBounds(680,530,170,30);
   r.setBounds(910,530,170,30);
    trial.setBounds(280,590,170,30);
    serv.setBounds(720,590,170,30);
    attend.setBounds(500,590,170,30);
camp.setBounds(940,590,170,30);

    logout.setBounds(50,40,130,30);

 background.add(clear);  
 background.add(backup);
    background.add (attend);
    background.add (fee);
    background.add (serv);
    background.add (logout);
    background.add (trial);
    background.add (a);
   background.add (b);
    background.add (r);
	background.add(camp);
	
clear.addActionListener(this);
backup.addActionListener(this);
    a.addActionListener (this);
   
     b.addActionListener (this);
     r.addActionListener (this);
    
    
    attend.addActionListener (this);
    fee.addActionListener (this);
    serv.addActionListener (this);
    logout.addActionListener (this);
   trial.addActionListener (this);
camp.addActionListener(this);
	this.setVisible (true);

  }
  public static void main (String s[])
  {
    new ManMain1 ();

  }
  public void actionPerformed (ActionEvent e3)
  {
Staticinfo s=new Staticinfo();
	if(e3.getSource ()== clear)
	{
		int ret=0;
		ret=JOptionPane.showConfirmDialog(null,"You are not able to view reports if you clear database !!!Do you want to continue???","Warning",ret);
		if(ret == JOptionPane.YES_OPTION)
		{
			//System.out.println("database cleared!!!");
			try
			{
				int aaa=s.stmt.executeUpdate("delete from attendance");
				int bbb=s.stmt.executeUpdate("delete from timetrial ");
				int ccc=s.stmt.executeUpdate("delete from fee");
				int ddd=s.stmt.executeUpdate("delete from sr");
				if(aaa!=0 && bbb!=0 && ccc!=0 && ddd!=0 )
				{
					JOptionPane.showMessageDialog (null,"Database cleared","Process complete",JOptionPane.DEFAULT_OPTION);
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
				e.printStackTrace();
			}	
		}
		else
		{
			System.out.println("operation cancelled!!");
		}
	}
	else if(e3.getSource ()== backup)
	{	
	try
	{
		int ret=0;
		ret=JOptionPane.showConfirmDialog(null,"Are you sure? ","Warning",ret);
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy");    	
		Date d=new Date();
		sdf.format(d);		
		String fname=sdf.format(d);
		PrintStream fw=new PrintStream(new File("Backup"+fname+".txt"));
		 
		if(fw==null)
		{
			JOptionPane.showMessageDialog (null,"Failed to take Backup","Process Failed",JOptionPane.DEFAULT_OPTION);
		}
		else if(ret == JOptionPane.YES_OPTION)
		{
			s.rs=s.stmt.executeQuery("select * from Admin");
			fw.println("\n");

			fw.println("\n\t-------------------------ADMIN-----------------------------\n");
			fw.println("\n");

			fw.println("\n A.Id\t Name \t Contact  \t Mail \t Uname \t Passward \n");

			fw.println("\n");
			while(s.rs.next())

			{

				fw.println(s.rs.getInt(1)+" \t"+s.rs.getString(2)+"\t"+s.rs.getString(3)+"\t"+s.rs.getString(4)+"\t"+s.rs.getString(5)+"\t"+s.rs.getString(6)+"\n");
			}

			fw.println("\n");



			s.rs=s.stmt.executeQuery("select * from Student");
			fw.println("\n");

			fw.println("\n\t-------------------------STUDENT-----------------------------\n\n");
			fw.println("\n");

			fw.print(" S.ID \t Name \t Address \t DOB \t Contact \t Email  \t AdmFee \t PRN  \t School \t B.ID \t Admdate \t Contact2 \t Interest \n");

			fw.println("\n");

			while(s.rs.next())

			{

				fw.println(s.rs.getInt(1)+" \t"+s.rs.getString(2)+"\t"+s.rs.getString(3)+"\t"+s.rs.getString(4)+"\t"+s.rs.getString(5)+"\t"+s.rs.getString(6)+"\t"+s.rs.getString(7)+"\t"+s.rs.getString(8)+"\t"+s.rs.getString(9)+"\t"+s.rs.getInt(10)+"\t"+s.rs.getString(11)+"\t"+s.rs.getInt(12)+"\t"+s.rs.getString(13)+"\t"+s.rs.getString(14)+"\t"+s.rs.getString(15)+"\n");
			}
		
			fw.println("\n");


			s.rs=s.stmt.executeQuery("select * from achiv");
			fw.println("\n");

			fw.println("\n\t-------------------------STUDENT ACHIEVEMENTS-----------------------------\n\n");
			fw.println("\n");

			fw.println("AchNo \t S.ID \t Date \t Achievement \n");

			fw.println("\n");

			while(s.rs.next())

			{

				fw.println(s.rs.getInt(1)+" \t"+s.rs.getInt(2)+"\t"+s.rs.getString(3)+"\t"+s.rs.getString(4)+"\n");

			//	fw.println("\n");

			}

			fw.println("\n");


			s.rs=s.stmt.executeQuery("select * from fee");
			fw.println("\n");

			fw.println("\n\t-------------------------FEE RECORDS-----------------------------\n\n");
			fw.println("\n");

			 fw.println("F.ID \t S.ID \t PayDate \t Amount \t ToDate \t FromDate \t transcnt \n");

			fw.println("\n");

			while(s.rs.next())

			{

				fw.println(s.rs.getInt(1)+" \t"+s.rs.getInt(2)+"\t"+s.rs.getString(3)+"\t"+s.rs.getInt(4)+"\t"+s.rs.getString(5)+"\t"+s.rs.getString(6)+"\t"+s.rs.getInt(7)+"\n");
//				fw.println("\n");

			}

		fw.println("\n");



			s.rs=s.stmt.executeQuery("select * from sr");
			fw.println("\n");

			fw.println("\n\t-------------------------SERVICING RECORDS-----------------------------\n\n");
			fw.println("\n");

			fw.println(" SR.ID\t S.ID  \t ServDate \t NxtServDate \t Type \t T.ID  \n");
			fw.println("\n");


			while(s.rs.next())

			{

				fw.println(s.rs.getInt(1)+" \t"+s.rs.getInt(2)+"\t"+s.rs.getString(3)+"\t"+s.rs.getString(4)+"\t"+s.rs.getString(5)+"\t"+s.rs.getInt(6)+"\n");
	//			fw.println("\n");

			}

			fw.println("\n");

			
			s.rs=s.stmt.executeQuery("select * from attendance");
			fw.println("\n");

			fw.println("\n\t-------------------------ATTENDANCE RECORDS-----------------------------\n\n");
			fw.println("\n");

			 fw.println("S.ID\t Date  \t Status \n");
			fw.println("\n");


			while(s.rs.next())

			{

				fw.println(s.rs.getInt(1)+" \t"+s.rs.getString(2)+"\t"+s.rs.getString(3)+"\n");
	//			fw.println("\n");

			}

			fw.println("\n");

		
			s.rs=s.stmt.executeQuery("select * from TimeTrial");
			fw.println("\n");

			fw.println("\n\t-------------------------TIMETRIAL RECORDS-----------------------------\n\n");
			fw.println("\n");

			 fw.println("T.No \t S.ID \t Date \t Time  \n");
			fw.println("\n");



			while(s.rs.next())

			{

				fw.println(s.rs.getInt(1)+" \t"+s.rs.getInt(2)+"\t"+s.rs.getString(3)+"\t"+s.rs.getFloat(4)+"\n");
				fw.println("\n");

			}

		JOptionPane.showMessageDialog (null,"Backup file :Backup"+fname+".txt created successfully","Process complete",JOptionPane.DEFAULT_OPTION);
		fw.close();
		}
		else
		{
			System.out.println("operation cancelled!!");
		}
	}
	catch(Exception e)	
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}
	else if (e3.getSource ()== a)
      {
	new Admin ();
	dispose();
      }
else if (e3.getSource () == b)
      {
	new Student ();
	dispose();
      }
    else if (e3.getSource () == logout)
      {
	new MainLogin ();
	dispose();
      }
    else if (e3.getSource () == serv)
      {
	new ServRec();
	dispose();
      }
	else if (e3.getSource () == fee)
      {
		new OpenFeeRec();
		dispose();
      	}
	else if(e3.getSource()==camp)
	{
		new Camp();
		dispose();
	}
	else if(e3.getSource () == attend)
	{
		new Attendance();
		dispose();
	}
	else if(e3.getSource () == trial)
	{
		new TimeTrial();
		dispose();
	}
	else if(e3.getSource () == r)
	{
		new Reports();
		dispose();
	}
  }
}
