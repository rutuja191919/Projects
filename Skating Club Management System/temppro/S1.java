import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import pro.*;
import java.sql.*;

class S1 extends JFrame implements ActionListener
{
  	JButton sserv,week,back;
  	Staticinfo s;
  	Connection con = null;
  Statement stmt = null;
  ResultSet rs;

  
  	public S1 ()
  	{
  		super ("Servising records");
 		 JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/attend1.png")));
				  this.add(background);
   		this.setSize (1000,700);
   		this.setDefaultCloseOperation (EXIT_ON_CLOSE);
 
  		sserv =new JButton ("Student Servising Records");
   		week =new JButton("Servising of this week");
		back =new JButton("<<Back");
	 
    		background.add (sserv);
    		background.add (week);
    		background.add (back);

      		back.addActionListener(this);
     		sserv.addActionListener(this);
     		week.addActionListener(this);

      		sserv.setBounds(200,100,200,40);
		week.setBounds(200,200,200,40);
        	back.setBounds(450,400,90,30);

           	this.setVisible (true);
  	}
  	
	public static void main (String s[])
  	{
  		  new S1();
  	}

	public void connect()

	{

		try

		{
		Class.forName("org.postgresql.Driver");
     con=DriverManager.getConnection("jdbc:postgresql://192.168.100.10/tybcs1","tybcs1","");
			 stmt=con.createStatement();

		}

		catch(Exception e)

		{

			System.out.println(e);

		}
	}



	public void actionPerformed (ActionEvent e3)
	{
		/* int i=0;
		
		connect();
		if(e3.getSource()==back)
		{
			new Student();
			dispose();
		}
   
	     	if(e3.getSource()==edit)
		{
			if (sid.getText ().equals ("") ) 
			{
				JOptionPane.showMessageDialog (null,"enter student id","error",
						       JOptionPane.DEFAULT_OPTION);
				sid.requestFocus ();
			}
			else 
			{
			        i=search(Integer.parseInt(sid.getText ()));
				s.sid=Integer.parseInt(sid.getText ());
				if(i!=0)
				{
					new Edit();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog (null,
					       "Incorrect student id!","error",
					       JOptionPane.DEFAULT_OPTION);
					sid.requestFocus ();
	  	    		}
			}
		}
		if(e3.getSource()==view)
		{      		
			if (sid.getText ().equals ("") ) 
			{
				JOptionPane.showMessageDialog (null,"enter student id","error",
						       JOptionPane.DEFAULT_OPTION);
				sid.requestFocus ();
			}
			else 
			{	i=search(Integer.parseInt(sid.getText ()));
				s.sid=Integer.parseInt(sid.getText ());
				if(i!=0)
				{
					new View();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog (null,
					       "Incorrect student id!","error",
					       JOptionPane.DEFAULT_OPTION);
					sid.requestFocus ();
	      			}
	 		}     	
		}
		if(e3.getSource()==delete)
		{      	
			if (sid.getText ().equals ("") ) 
			{
				JOptionPane.showMessageDialog (null,"enter student id","error",
						       JOptionPane.DEFAULT_OPTION);
				sid.requestFocus ();
			}
			else 
			{	i=search(Integer.parseInt(sid.getText ()));
				s.sid=Integer.parseInt(sid.getText ());
				if(i!=0)
				{
					new DelStud();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog (null,
					       "Incorrect student id!","error",
					       JOptionPane.DEFAULT_OPTION);
					sid.requestFocus ();
	      			}
			}
	      	
		}
		if(e3.getSource()==bstud)
		{
			 b.setText(" ");


			try

			{
				PreparedStatement ps;

				ps=con.prepareStatement("select * from Student where bid=?");

				ps.setInt(1,Integer.parseInt(bid.getText()));
				
rs=ps.executeQuery();
				while(rs.next())
				{
					  b.append(" "+rs.getInt(1)+" - "+rs.getString(2)+" "+rs.getString(3)+"\n");

				}
			
}

			catch(Exception e)

			{
				
System.out.println(e);
			
}
		}*/
	}
}

