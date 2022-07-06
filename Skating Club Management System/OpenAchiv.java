import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import pro.*;
import java.text.*;
import java.sql.*;

class OpenAchiv extends JFrame implements ActionListener
{
  	JLabel id,batch;
  	JTextField sid,bid,dt;
//JTextField dt;
  	JButton edit,view,bstud,back;
  	Staticinfo s;
	JTextArea b,tadd,tachiv;


// Date d,nd;

  SimpleDateFormat sdf;
String s11;

  	public OpenAchiv()
  	{
  		super ("Student Achievements");
		s=new Staticinfo();
 		JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/ach.JPG")));
				  this.add(background);
  Font f=new Font("Brodway",Font.BOLD,18) ;  
   		this.setSize (1366,786);
   		this.setDefaultCloseOperation (EXIT_ON_CLOSE);
   		id= new JLabel ("*Student ID:");
   		sid=new JTextField();
		
		batch=new JLabel("Batch ID:");
		bid=new JTextField();
 		b=new JTextArea(30,100);
		JScrollPane scroll=new JScrollPane(b);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(1000,190,200,50); 
		scroll.setSize(200,500);
		background.add(scroll);

	sdf=new SimpleDateFormat("dd/MM/yyyy");    	
	Date d=new Date();
	sdf.format(d);
	Date nd=new Date();
	sdf.format(d);

  	JLabel dtt=new JLabel("Date:");
	//dtt.setFont(f);
	dtt.setBounds(320,140,100,30);
	background.add(dtt);
	 dt=new JTextField();
	//dt.setFont(f);
	s11=sdf.format(d);

	System.out.println("\n******"+s11+"******");
	dt.setText(s11+" ");
	dt.setBounds(390,140,100,30);
	background.add(dt);


		JLabel lachiv=new JLabel("Previous Achievements:");
		lachiv.setBounds(100,185,200,30);		
		background.add(lachiv);

		 tachiv=new JTextArea();
		tachiv.setBounds(220,207,300,100);	
		JScrollPane scroll1=new JScrollPane(tachiv);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll1.setBounds(220,240,300,100); 
		scroll1.setSize(350,120);
		background.add(scroll1);
		//background.add(tachiv);

		JLabel ladd=new JLabel("Current Achievement:");
		ladd.setBounds(100,415,200,30);		
		background.add(ladd);

		 tadd=new JTextArea();
		tadd.setBounds(220,450,300,60);	
		background.add(tadd);

		bstud =new JButton ("Show List");
   		edit =new JButton ("Add");
   		view =new JButton ("View");
   		back=new JButton ("<<Back");

		batch.setBounds(770,140,160,30);
		bid.setBounds(850,140,100,30);
		bstud.setBounds(1000,140,150,33);
    		id.setBounds(100,140,150,30);
    		sid.setBounds(200,140,100,30);
//b.setBounds(950,150,150,500); 

    		background.add (id);
    		background.add (sid);
    		background.add (back);
    		background.add (edit);
    		background.add (view);

	background.add (bid);
	background.add (bstud);
	background.add (batch);
//background.add (b);
     		back.addActionListener(this);
     		edit.addActionListener(this);
     		view.addActionListener(this);
		bstud.addActionListener(this);
		edit.setBounds(330,530,150,30);
		view.setBounds(330,200,150,30);
        	back.setBounds(50,40,160,33);
           	this.setVisible (true);
  	}
  	
	public static void main (String s[])
  	{
  		  new OpenAchiv();
  	}

	
	public int search(int a)

	{

		int i=0;

		try

		{
			PreparedStatement ps;

			ps=s.con.prepareStatement("select * from Student where sid=?");

			ps.setInt(1,a);
			
s.rs=ps.executeQuery();
			while(s.rs.next())
			i=s.rs.getInt(1);
		
}

		catch(Exception e)

		{
			
System.out.println(e);
		
}
		return i;

	}



	public void actionPerformed (ActionEvent e3)
	{
		int i=0;
		try
		{
			if(e3.getSource()==back)
			{
				new Student();
				dispose();
			}
			else if(e3.getSource()==bstud)
			{	
				if(bid.getText().equals(""))	
				{
				JOptionPane.showMessageDialog (null,"Enter Batch ID","Error",JOptionPane.DEFAULT_OPTION);
					bid.requestFocus ();
				}
			     else   
			     {
				b.setText(" ");

				try

				{
					PreparedStatement ps;

					ps=s.con.prepareStatement("select * from Student where bid=?");

					ps.setInt(1,Integer.parseInt(bid.getText()));
					
s.rs=ps.executeQuery();
					while(s.rs.next())
					{
						  b.append(" "+s.rs.getInt(1)+" - "+s.rs.getString(2)+" "+s.rs.getString(3)+"\n");

					}
				
}

				catch(Exception e)

				{
					
System.out.println(e);
				
}
	                      }
	                 }
		
			else if(e3.getSource()==view || e3.getSource()==edit)
			{
				s.sid=Integer.parseInt(sid.getText());
				if (sid.getText ().equals ("") ) 
				{
					JOptionPane.showMessageDialog (null,"Enter student ID","Error",JOptionPane.DEFAULT_OPTION);
					sid.requestFocus ();
				}
				i=search(Integer.parseInt(sid.getText ()));
				s.sid=Integer.parseInt(sid.getText ());
	
				if(e3.getSource()==edit)
				{
				        if (sid.getText().equals (" ") ) 
					{
					JOptionPane.showMessageDialog (null,"Enter student ID","Error",JOptionPane.DEFAULT_OPTION);
					sid.requestFocus ();
					}

					if(tadd.getText().equals("") )
						{
			
					JOptionPane.showMessageDialog (null,"Enter Achievement to add","Error",JOptionPane.DEFAULT_OPTION);
					tadd.requestFocus ();
						}
					else
					{

					int ano=0;
					if(i!=0)
					{
						
						
						{
							s.rs=s.stmt.executeQuery("select max(achno) from achiv");
							while(s.rs.next())
								ano=s.rs.getInt(1);
							ano++;
							/*int cnt=s.stmt.executeUpdate("insert into achiv values("+ano+","+s.sid+","+dt.getText()+",'"+tadd.getText()+"')");*/
								
PreparedStatement ps;

								ps=s.con.prepareStatement("Insert into achiv values(?,?,?,?)");

								ps.setInt(1,ano);
								ps.setInt(2,s.sid);
								ps.setString(3,dt.getText());
								ps.setString(4,tadd.getText())
;
		
						int cnt=ps.executeUpdate();
							if(cnt==1)
								JOptionPane.showMessageDialog (null,"Updated successfully " ,"Success",JOptionPane.DEFAULT_OPTION);
							else
								JOptionPane.showMessageDialog (null,"Failed to update","Error",JOptionPane.DEFAULT_OPTION);
					}	}
					
					else
					{
						JOptionPane.showMessageDialog (null,"Incorrect student ID!","Error",JOptionPane.DEFAULT_OPTION);
						sid.requestFocus ();
	  				}		
				}
			}
				if(e3.getSource()==view)
				{      	
					if(sid.getText().equals(" ") )
						{
			
					JOptionPane.showMessageDialog (null,"Enter Student Id to View ","Error",JOptionPane.DEFAULT_OPTION);
					sid.requestFocus ();
						}
					else
					{	
					if(i!=0)
					{
						//new ViewAchiv();//check sid
						//dispose();+
						s.rs=s.stmt.executeQuery("select fname,lname from student where sid="+s.sid);
						while(s.rs.next())
						{
						tachiv.setText("Name :"+s.rs.getString(1)+" "+s.rs.getString(2)+"\n\n");
						}

						s.rs=s.stmt.executeQuery("select achivment from achiv where sid="+s.sid);
						int ii=1;
						while(s.rs.next())
						{
							String aaa=s.rs.getString(1);
							tachiv.append(ii+" "+aaa);
							tachiv.append("\n");
							ii++;
						}
					}
					else
					{
						JOptionPane.showMessageDialog (null,"Incorrect student ID!","Error",JOptionPane.DEFAULT_OPTION);
						tachiv.setText(" ");
						sid.requestFocus ();
				      	}
					}					
				}
			   }     	
			}
		
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
}

