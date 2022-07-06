import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import pro.*;
import java.util.Date;
import java.text.*;


class CampReg extends JFrame implements ActionListener
{
	static int sno;
  	JLabel intrst,fname,mname,lname,addr,dob,prn,school,cno,cno2,mid,mnth,batch,reg,wekly,mode,sid;
  	JTextField fnam,mnam,lnam,adrs,pno,sname,cono,cono2,mail,tsid;
  	
ButtonGroup batches,mod,exist;
  	JTextField bdt,mnt;
 	JRadioButton regl1,regl2,regl3,regl4,regl5,regl6,mod1,mod2,news,exs;
  	JButton submit,back,view;
  	Connection con = null;
  Statement stmt = null;
  ResultSet rs;

  	Staticinfo s;	
	int rid;
	JCheckBox c1,c2,c3,c4,c5,c6;
	JLabel cfeel;
	JTextField cfeet;
	String rsfname,rsmname,rslname,rscono,rsmid,rsadd,rsdob,rsmnt,rsprn,rsage,rsschool,rscono2;

 	 public CampReg()
  	{
  	  	super ("Camp Registration" );
		JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/c4.jpg")));
		 this.add(background);

    		this.setSize (1366,786);

		s=new Staticinfo();
 		this.setDefaultCloseOperation (EXIT_ON_CLOSE);

		rsfname=new String();
		rsmname=new String();
		rslname=new String();
		rscono=new String();
		rscono2=new String();
		rsmid=new String();
		rsadd=new String();
		rsdob=new String();
		rsschool=new String();

    		sid=new JLabel("Student ID");
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
    		// feeSt= new JLabel ("600/- per month.Have to pay two months fees in Advance.");
		//    mode= new JLabel ("Mode of Payment:");
		cfeel=new JLabel("Total Camp Fee :");
		
    		c1=new JCheckBox("Camp1");
		c2=new JCheckBox("Camp2");
	 	c3=new JCheckBox("Camp3");
	 	c4=new JCheckBox("Camp4");
	 	c5=new JCheckBox("Camp5");
   		c6=new JCheckBox("Camp6");

    		tsid=new JTextField();
		mnam=new JTextField();
    		sname=new JTextField();
    		fnam=new JTextField();
    		lnam=new JTextField();
    		adrs=new JTextField();
    		cono=new JTextField();
    		cono2 = new JTextField();
    		mail=new JTextField();
		cfeet=new JTextField();
    		bdt=new JTextField();
    		

  		regl1=new JRadioButton("(1)1st Beginner's & Semi Advance batch:- 5.30-6.30pm");
  		regl2=new JRadioButton("(2)2nd Beginner's & Semi Advance batch:- 6.30-7.30pm");
  		regl3=new JRadioButton("(3)Advance Professional & Elite batch:- 6.30-8.30pm");
		
		news =new JRadioButton("New Student");
		exs=new JRadioButton("Existing Student");

		Color c=new Color(255,255,255);	  
		sid.setForeground(c);
		fname.setForeground(c);
		mname.setForeground(c);
		lname.setForeground(c);
		addr.setForeground(c);
		dob.setForeground(c);
		school.setForeground(c);
		mid.setForeground(c);
		cno.setForeground(c);
		cno2.setForeground(c);
		cfeel.setForeground(c);
		batch.setForeground(c);

  		batches=new ButtonGroup();

  		batches.add(regl1);

  		batches.add(regl2);

  		batches.add(regl3);

  		batches.add(regl4);

		batches.add(regl5);

		batches.add(regl6);

		exist =new ButtonGroup();
		exist.add(news);
		exist.add(exs);

       
		submit =new JButton (" Submit ");
       		back =new JButton ("<<Back");
		view =new JButton("View Details");


		news.setBounds(150,150,150,30);
		exs.setBounds(570,150,150,30);
		sid.setBounds(340,150,150,30);
		tsid.setBounds(440,150,100,30);
		view.setBounds(740,150,150,30);

    		fname.setBounds(205,210,160,30);
		mname.setBounds(530,210,160,30);
    		lname.setBounds(855,210,160,30);
    		addr.setBounds(205,250,160,30);
    		dob.setBounds(200,300,160,30);
 		school.setBounds(200,340,180,30);
    		sname.setBounds(310,340,180,30);
    		mid.setBounds(630,250,160,30);
    		cno.setBounds(200,380,160,30);
    		cno2.setBounds(600,380,160,30);
	
		c1.setBounds(200,440,100,30);
		c2.setBounds(320,440,100,30);
		c3.setBounds(440,440,100,30);
		c4.setBounds(560,440,100,30);
		c5.setBounds(680,440,100,30);
		c6.setBounds(800,440,100,30);

		cfeel.setBounds(920,440,100,30);
		cfeet.setBounds(1020,440,100,30);
   		batch.setBounds(200,490,160,30);


    		fnam.setBounds(310,210,180,30);
		mnam.setBounds(630,210,180,30);
    		lnam.setBounds(950,210,180,30);
    		adrs.setBounds(310,250,280,37);				
    		bdt.setBounds(310,300,200,30);
    		
    		mail.setBounds(720,250,200,30);
    		cono.setBounds(310,380,200,30);
    		cono2.setBounds(720,380,200,30);

		regl1.setBounds(310,490,360,30);

		regl2.setBounds(310,540,360,30);

		regl3.setBounds(310,590,360,30);
	
  
   		submit.setBounds(590,630,160,33);
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
		background.add(news);
		background.add(exs);
		background.add(sid);
		background.add(tsid);
		background.add(view);
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
		view.addActionListener(this);
		c1.addActionListener(this);
		news.addActionListener(this);

		this.setVisible (true);  
  	}

	void setbval(int a)

	{

		if(a==7) regl1.setSelected(true);

		else if(a==8) regl2.setSelected(true);

		else if(a==9) regl3.setSelected(true);

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

	boolean campmemb(int sid)
	{
		try
		{
		s.rs=s.stmt.executeQuery("select sid from Camp");
				while(s.rs.next())
				{
					if(s.rs.getInt(1)==sid)
					return false;
				}
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public int insertCamp()
	{
		int j=0,i=0,k=0,ano=0,fee=0,temp;

		try

		{
			if(campmemb(s.sid)==true)
			{
				s.rs=s.stmt.executeQuery("select max(sno) from Camp");
				while(s.rs.next())
				{ano=Integer.parseInt(s.rs.getString(1));
				}
				ano++;
				
PreparedStatement ps=s.con.prepareStatement("Insert into camp values(?,?,?,?,?,?,?,?,?)");
		
				ps.setInt(1,ano);
				ps.setInt(2,s.sid);
			
				temp=getbval();
				if(c1.isSelected()==true)
					ps.setInt(3,10+getbval());
				else
				ps.setInt(3,0);	
				if(c2.isSelected()==true)
					ps.setInt(4,20+getbval());
				else
					ps.setInt(4,0);
				if(c3.isSelected()==true)
					ps.setInt(5,30+getbval());
				else
					ps.setInt(5,0);
				if(c4.isSelected()==true)
					ps.setInt(6,40+getbval());
				else
					ps.setInt(6,0);
				if(c5.isSelected()==true)
					ps.setInt(7,50+getbval());
				else
					ps.setInt(7,0);
				if(c6.isSelected()==true)	
					ps.setInt(8,60+getbval());
				else
					ps.setInt(8,0);
				if(cfeet.getText()!=" ")
				ps.setInt(9,Integer.parseInt(cfeet.getText()));
				
i=ps.executeUpdate();
			}
			else
			{
				JOptionPane.showMessageDialog (null,"For Updation, Edit it!"," Already Exist",JOptionPane.DEFAULT_OPTION);
			}

		}	

		catch(Exception e)

		{
				
System.out.println(e);
				e.printStackTrace();
	
	}
	if (i==1)
	return 1;
	else
	return 0;
 			
	}

	public int insertStud()

	{


	int j=0,i=0,k=0,ano=2;

		try

		{
			s.rs=s.stmt.executeQuery("select max(sid) from Student");
			while(s.rs.next())
			{ano=Integer.parseInt(s.rs.getString(1));
			}
			ano++;
			s.sid=ano;
			//
PreparedStatement ps;



			 ps=s.con.prepareStatement("Insert into Student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
			ps.setInt(1,ano);
			ps.setString(2,fnam.getText());
			ps.setString(3,mnam.getText());
			ps.setString(4,lnam.getText());	
			ps.setString(5,adrs.getText());
			ps.setString(6,bdt.getText());
			ps.setString(7,cono.getText());
			ps.setString(8,mail.getText());
			ps.setString(11,sname.getText());
			ps.setInt(12,getbval()+10);

			ps.setString(14,cono2.getText());

			SimpleDateFormat sdf=new SimpleDateFormat();
			Date d=new Date();

			String ss=sdf.format(d);
	
			ps.setString(13,(String)ss);
			Date nd=new Date(d.getTime()+60*(24*60*60*1000));
			String ds=sdf.format(nd);
			System.out.println(ds+"aaaaaaa"+d.getTime());
				
		
			
i=ps.executeUpdate();
	
		
}

		catch(Exception e)

		{
				
System.out.println(e);
				e.printStackTrace();
	
	}
	if(i==1)
		return 1;
	else
	 	return 0;



	}



  	public static void main (String s[])
  	{
  		  new CampReg();
	}
	
	public void actionPerformed (ActionEvent e3)
	{
	int i,j,cfee=0;
	if(c1.isSelected() && getbval()!=0)
		{
			if(getbval()<=8)
					cfee=cfee+700;
				else
					cfee=cfee+1400;
		cfeet.setText(cfee+"");
		}
	if(e3.getSource()==submit)
	{
		if(news.isSelected()==true)
		{
			
			i=insertStud();
			j=insertCamp();
			if(i==1 && j==1)

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
		else if(exs.isSelected()==true)
		{
			j=insertCamp();
			if(j==1)

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
			System.out.println("\n problem occured");
		}
	}
	else if(e3.getSource()==view)
	{
		if(tsid.getText().equals(""))
			{
				
				JOptionPane.showMessageDialog (null,"Enter Student ID!","Error",JOptionPane.DEFAULT_OPTION);
			}
		else
		{
		s.sid=Integer.parseInt(tsid.getText());
		try
		{
			System.out.println("*******"+s.sid);
			s.rs=s.stmt.executeQuery("select * from Student");
			while(s.rs.next())
			{	
			if(s.sid==s.rs.getInt(1) )
				{
				sno=s.rs.getInt(1);
				rsfname=s.rs.getString(2);
				rsmname=s.rs.getString(3);
				rslname=s.rs.getString(4);
				rsadd=s.rs.getString(5);
				rsdob=s.rs.getString(6);
				rscono=s.rs.getString(7);
				rsmid=s.rs.getString(8);
				rsschool=s.rs.getString(11);
				rid=s.rs.getInt(12);
				//rsdt=s.rs.getString(13);
				rscono2=s.rs.getString(14);
				
				}
			 }
		}
		catch(Exception e )
		{
			System.out.println(e);
			e.printStackTrace();
		}

	fnam.setText(rsfname);
	mnam.setText(rsmname);
	lnam.setText(rslname);
	adrs.setText(rsadd);
	cono2.setText(rscono2);
	sname.setText(rsschool);
	cono.setText(rscono);
	mail.setText(rsmid);
	bdt.setText(rsdob);
	//dt.setText(rsdt);
	setbval(rid);
	}
	}
	else if(e3.getSource()==back)
	{
		new Camp();
		dispose();
	}
	else if(e3.getSource()==news)
	{
	int ano=0; 
fnam.setText(" ");mnam.setText(" ");lnam.setText(" ");adrs.setText(" ");sname.setText(" ");cono.setText(" ");cono2.setText(" ");mail.setText(" ");bdt.setText(" ");
		try
			{
				s.rs=s.stmt.executeQuery("select max(sid) from Student");
				while(s.rs.next())
				{ano=Integer.parseInt(s.rs.getString(1));
				}
				ano++;
				tsid.setText(ano+"");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}

  	}
}

		

