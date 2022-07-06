import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import pro.*;
import java.util.*;
import java.util.Date;
import java.text.*;

class EditFee extends JFrame implements ActionListener
{
  JLabel name,lname,cno,id,d1,d2,amount,nam,lnam,cono,id1;
  JTextField dt1,dt2,amt;
  JButton back,update;
  Staticinfo s;
  Date d;
  SimpleDateFormat sdf;
  

  public EditFee()
  {
    super ("Fee Details");
	d=new Date();
	s=new Staticinfo();
	sdf=new SimpleDateFormat("dd/MM/yyyy");	
	String rsfname,rslname,rscono,rsid,rsd1,rsd2,rstp;
	rsfname=new String();
	rslname=new String();
	rscono=new String();
	rsid=new String();
	rsd1=new String();
	rsd2=new String();
	rstp=new String();
	
	try
	{
	s.rs=s.stmt.executeQuery("select fee.sid,fname,lname,contact,todate,fromdate,amount from student,fee where student.sid ="+s.sid+" and fee.sid="+s.sid);
		while(s.rs.next())
		{	
			rsid=s.rs.getString(1);
			rsfname=s.rs.getString(2);
			rslname=s.rs.getString(3);
			rscono=s.rs.getString(4);
			rsd1=s.rs.getString(5);
			rsd2=s.rs.getString(6);
			rstp=s.rs.getString(7);
		 }
	}
	catch(Exception e )
	{
		System.out.println(e);
	}

  JLabel background=new JLabel();
				  this.add(background);
    this.setSize (1366,786);
    this.setDefaultCloseOperation (EXIT_ON_CLOSE);

    	name = new JLabel ("First Name:");
	lname = new JLabel ("last Name:"); 
   	id = new JLabel ("Student Id:");
    	cno= new JLabel ("Contact No:");
    	amount = new JLabel ("Amount payed:");
    	d1 = new JLabel ("From Date:");
    	d2 = new JLabel ("To Date:");
 
    	nam=new JLabel ();
  	lnam=new JLabel ();
    	cono=new JLabel ();
    	id1=new JLabel ();
    	dt1=new JTextField ();
    	dt2=new JTextField ();
    	amt=new JTextField ();    
   
	nam.setText(rsfname);
	lnam.setText(rslname);
	id1.setText(rsid);
	cono.setText(rscono);
	dt1.setText(rsd1);
	dt2.setText(rsd2);
	amt.setText(rstp);
	
	back=new JButton ("Back",
		   new ImageIcon (ClassLoader.
				  getSystemResource ("pics/back.png")));
	update=new JButton ("Update");

    name.setBounds(200,100,160,30);
lname.setBounds(200,140,160,30);
    id.setBounds(200,180,160,30);
    cno.setBounds(200,220,160,30);
    amount.setBounds(200,260,160,30);
    d1.setBounds(200,300,160,30);
    d2.setBounds(200,340,160,30);
  

    nam.setBounds(320,100,200,30);
lnam.setBounds(320,140,200,30);
    id1.setBounds(320,180,200,30);
    cono.setBounds(320,220,200,30);
    amt.setBounds(320,260,200,30);
    dt1.setBounds(320,300,200,30);
    dt2.setBounds(320,340,200,30);
   
    update.setBounds(460,490,120,32);
    back.setBounds(600,490,120,32);

    background.add (name);
    background.add (lname);
    background.add (lnam);
    background.add (cno);
    background.add (id);
    background.add (amount);
    background.add (d1);
    background.add (d2);
  
    background.add (nam);
    background.add (cono);
    background.add (id1);
    background.add (amt);
    background.add (dt1);
    background.add (dt2);

    background.add (back);
    back.addActionListener(this);

    background.add (update);
    update.addActionListener(this);

    this.setVisible (true);
  }

  	public static void main (String s[])
  	{
   		 new EditFee();
  	}


public int update()

{

int i=0,fid=0,tid=0;

try

	{
		s.rs=s.stmt.executeQuery("select max(fid) from fee");
		while(s.rs.next())
		fid=s.rs.getInt(1);
		fid++;

		s.rs=s.stmt.executeQuery("select max(transcnt) from fee where sid="+s.sid+"");
		while(s.rs.next())
		tid=s.rs.getInt(1);
		tid++;		
			String sd=sdf.format(d);
		
PreparedStatement ps;

		ps=s.con.prepareStatement("insert into fee values(?,?,?,?,?,?,?)");

		ps.setInt(1,fid);
		ps.setInt(2,s.sid);
		ps.setString(3,sd);
		ps.setString(4,amt.getText());
		ps.setString(5,dt1.getText())
;
		ps.setString(6,dt2.getText());
		ps.setInt(7,tid);
		
i=ps.executeUpdate();

	
}

catch(Exception e)

	{
		
System.out.println(e);
		e.printStackTrace();
	
}
return i;

}



	 public void actionPerformed (ActionEvent e3)
 	 {
int i;
		if(e3.getSource()==back)
		{
			new FeeRec();
			dispose();
		}
		else if(e3.getSource()==update)
		{
		i=update();
			if(i==1)

			{
				
				JOptionPane.showMessageDialog (null,"record updated sucessfully","process complete",JOptionPane.DEFAULT_OPTION);
			}
		        else
			JOptionPane.showMessageDialog (null,"fail to updated","process complete",JOptionPane.DEFAULT_OPTION);
		}
	}
}
