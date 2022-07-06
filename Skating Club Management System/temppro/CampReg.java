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
  	JLabel fname,lname,addr,dob,prn,school,age,cno,cno2,mid,mnth,intrst,batch,reg,wekly,feeSt,mode,sid;
  	JTextField fnam,lnam,adrs,pno,sname,agefield,cono,cono2,mail,tsid;
  	
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
	String rsfname,rslname,rscono,rsmid,rsadd,rsdob,rsmnt,rsprn,rsage,rsschool;

 	 public CampReg()
  	{
  	  	super ("Camp Registration" );
		JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/c4.jpg")));
		 this.add(background);

    		this.setSize (1366,786);

		s=new Staticinfo();
 		this.setDefaultCloseOperation (EXIT_ON_CLOSE);

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

    		sid=new JLabel("Student id");
    		fname = new JLabel ("First Name:");
    		lname=new JLabel("Last Name");
    		school=new JLabel("School Name :");
    		age=new JLabel("Age:");
    		addr = new JLabel ("*Address:");
    		dob= new JLabel ("Date of Birth");
    		prn= new JLabel ("PRN No:");
    		mid = new JLabel ("Mail Id:");
    		cno= new JLabel ("Contact No:");
    		cno2=new JLabel("Alternate contact");
    		mnth = new JLabel ("Month of Admission:");
    		intrst= new JLabel ("Interest in Skating for:");
    		batch = new JLabel ("Batches:");
    		// feeSt= new JLabel ("600/- per month.Have to pay two months fees in Advance.");
		//    mode= new JLabel ("Mode of Payment:");
		cfeel=new JLabel("Total camp fee :");
		
    		c1=new JCheckBox("Camp1");
		c2=new JCheckBox("Camp2");
	 	c3=new JCheckBox("Camp3");
	 	c4=new JCheckBox("Camp4");
	 	c5=new JCheckBox("Camp5");
   		c6=new JCheckBox("Camp6");

    		tsid=new JTextField();
    		sname=new JTextField();
    		agefield=new JTextField();
    		fnam=new JTextField();
    		lnam=new JTextField();
    		adrs=new JTextField();
    		pno=new JTextField();
    		cono=new JTextField();
    		cono2 = new JTextField();
    		mail=new JTextField();
		cfeet=new JTextField();
    	
    		bdt=new JTextField();
    		mnt=new JTextField();

  		regl1=new JRadioButton("(1)1st beginner's & Semi Advance batch:- 5.30-6.30pm");
  		regl2=new JRadioButton("(2)2nd beginner's & Semi Advance batch:- 6.30-7.30pm");
  		regl3=new JRadioButton("(3)Advance Professional & Elite batch:- 6.30-8.30pm");
		news =new JRadioButton("New Student");
		exs=new JRadioButton("Student alrady exist");


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
       		back =new JButton ("Back", new ImageIcon (ClassLoader. getSystemResource ("pics/back.png")));
		view =new JButton("View Details");


		news.setBounds(150,20,150,30);
		exs.setBounds(320,20,150,30);
		sid.setBounds(500,20,150,30);
		tsid.setBounds(600,20,100,30);
		view.setBounds(750,20,150,30);
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
    		cno2.setBounds(600,300,160,30);
		mnth.setBounds(200,340,180,30);
		c1.setBounds(200,380,100,30);
		c2.setBounds(320,380,100,30);
		c3.setBounds(440,380,100,30);
		c4.setBounds(560,380,100,30);
		c5.setBounds(680,380,100,30);
		c6.setBounds(800,380,100,30);
		cfeel.setBounds(920,380,100,30);
		cfeet.setBounds(1020,380,100,30);
   		batch.setBounds(200,440,160,30);
		//    feeSt.setBounds(200,550,400,30);
		//    mode.setBounds(200,590,180,30);

    		fnam.setBounds(310,60,200,30);
    		lnam.setBounds(310,100,200,30);
    		adrs.setBounds(310,140,200,30);				
    		bdt.setBounds(310,180,200,30);
    		pno.setBounds(310,220,200,30);
    		mail.setBounds(310,260,200,30);
    		cono.setBounds(310,300,200,30);
    		cono2.setBounds(800,300,200,30);
		mnt.setBounds(340,340,140,30);
		regl1.setBounds(310,440,360,30);

		regl2.setBounds(310,480,360,30);

		regl3.setBounds(310,520,360,30);
		//mod1.setBounds(330,590,90,30);
		//mod2.setBounds(430,590,90,30);
    		setbval(rid);
  
   		submit.setBounds(810,625,120,32);
    		back.setBounds(960,625,120,32);

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
		//background.add (feeSt);
		//background.add (mode);

    		background.add (lnam);
    		background.add (fnam);
    		background.add (adrs);
    		background.add (pno);
    		background.add (cono);
    		background.add (mail);
    		background.add (bdt);
    		background.add (mnt);
		//background.add (mod1);

		//background.add (mod2);

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
				JOptionPane.showMessageDialog (null,"alrady registered"," for updation edit the record!",JOptionPane.DEFAULT_OPTION);
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
			ps.setString(3,lnam.getText());	
			ps.setString(4,adrs.getText());
			ps.setString(5,bdt.getText());
			ps.setString(6,cono.getText());
			ps.setString(7,mail.getText());
			ps.setInt(9,Integer.parseInt(pno.getText()));
			ps.setInt(10,Integer.parseInt(agefield.getText()));
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
				
			ps.setString(8,""+d.getMonth()+1+"");
			
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
				
				JOptionPane.showMessageDialog (null,"ERROR! Fail to Update","Process Complete",JOptionPane.DEFAULT_OPTION);
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
				
				JOptionPane.showMessageDialog (null,"ERROR! Fail to Update","Process Complete",JOptionPane.DEFAULT_OPTION);
			}	    

		}
		else
		{
			System.out.println("\n problem occured");
		}
	}
	else if(e3.getSource()==view)
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
				rslname=s.rs.getString(3);
				rscono=s.rs.getString(6);
				rsdob=s.rs.getString(5);
				rsmid=s.rs.getString(7);
				rsadd=s.rs.getString(4);
				rsmnt=s.rs.getString(8);
				rsprn=s.rs.getString(9);
				rsage=s.rs.getString(10);
				rsschool=s.rs.getString(11);
				rid=s.rs.getInt(12);
				}
			 }
		}
		catch(Exception e )
		{
			System.out.println(e);
			e.printStackTrace();
		}

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
	setbval(rid);
	}

	else if(e3.getSource()==back)
	{
		new Camp();
		dispose();
	}
	else if(e3.getSource()==news)
	{
	int ano=0;
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
