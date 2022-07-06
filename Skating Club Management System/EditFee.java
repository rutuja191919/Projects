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

	String rsfname,rsmname,rslname,rscono,rsid,rsd1,rsd2,rstp;
	rsfname=new String();
	rsmname=new String();
	rslname=new String();
	rscono=new String();
	rsid=new String();
	rsd1=new String();
	rsd2=new String();
	rstp=new String();
	
	try
	{
	s.rs=s.stmt.executeQuery("select fee.sid,fname,mname,lname,contact,todate,fromdate,amount from student,fee where student.sid ="+s.sid+" and fee.sid="+s.sid);
		while(s.rs.next())
		{	
			rsid=s.rs.getString(1);
			rsfname=s.rs.getString(2);
			rsmname=s.rs.getString(3);
			rslname=s.rs.getString(4);
			rscono=s.rs.getString(5);
			rsd1=s.rs.getString(6);
			rsd2=s.rs.getString(7);
			rstp=s.rs.getString(8);
		 }
	}
	catch(Exception e )
	{
		System.out.println(e);
	}

  JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/fee.jpg")));
				  this.add(background);
    this.setSize (1366,786);
    this.setDefaultCloseOperation (EXIT_ON_CLOSE);

    	name = new JLabel ("Name:");
	lname = new JLabel ("Last Name:"); 
   	id = new JLabel ("Student ID:");
    	cno= new JLabel ("Contact No:");
    	amount = new JLabel ("Amount Paid:");
    	d1 = new JLabel ("From Date:");
    	d2 = new JLabel ("To Date:");
 
    	nam=new JLabel ();
  	lnam=new JLabel ();
    	cono=new JLabel ();
    	id1=new JLabel ();
    	dt1=new JTextField ();
    	dt2=new JTextField ();
    	amt=new JTextField ();    
   
	nam.setText(rsfname+" "+rsmname+" "+rslname);
	lnam.setText(rslname);
	id1.setText(rsid);
	cono.setText(rscono);
	dt1.setText(rsd2);
	dt2.setText(rsd1);
	//amt.setText();
	
	back=new JButton ("<<Back");
	update=new JButton ("Pay");

 
   id.setBounds(210,140,160,30);
   name.setBounds(210,180,160,30);
    cno.setBounds(210,220,160,30);
    amount.setBounds(210,260,160,30);
    d1.setBounds(210,300,160,30);
    d2.setBounds(210,340,160,30);

    id1.setBounds(330,140,200,30);
    nam.setBounds(330,180,300,30);
    cono.setBounds(330,220,200,30);
    amt.setBounds(330,260,100,30);
    dt1.setBounds(330,300,100,30);
    dt2.setBounds(330,340,100,30);
   
    update.setBounds(400,440,160,33);
    back.setBounds(50,40,140,30);

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
				
				JOptionPane.showMessageDialog (null,"Record updated successfully","Process Complete",JOptionPane.DEFAULT_OPTION);
			}
		        else
			JOptionPane.showMessageDialog (null,"failed to update","Error",JOptionPane.DEFAULT_OPTION);
		}
	}
}
