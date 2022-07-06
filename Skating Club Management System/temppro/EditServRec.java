import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import pro.*;
import java.sql.*;

import java.util.Date;

class EditServRec extends JFrame implements ActionListener
{
  JLabel id,batch;
  JTextField sid,bid;
  JButton edit,view,bstud,back;
  Staticinfo s;
  JTextArea b;
  Date c,d,nd;

  Connection con=null;
  Statement stmt=null;
  ResultSet rs;
  
  	public EditServRec ()
  	{
  		super ("Servising records");

 		 JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/ser2.jpg")));
		this.add(background);

   		this.setSize (1366,786);
   		this.setDefaultCloseOperation (EXIT_ON_CLOSE);

		d=new Date();
   		id= new JLabel ("*Student Id:");

   		sid=new JTextField();
		batch=new JLabel("Batch Id:");
		bid=new JTextField();

 		b=new JTextArea(30,100);

  		bstud =new JButton ("Show");
   		
   		edit =new JButton ("EDIT");
   		view =new JButton ("VIEW");
   		back=new JButton ("<<BACK");

		batch.setBounds(200,80,160,30);
		bid.setBounds(310,80,200,30);
		bstud.setBounds(540,80,150,30);
    		id.setBounds(200,140,160,30);
    		sid.setBounds(310,140,200,30);
		b.setBounds(540,140,290,490); 
		edit.setBounds(150,450,110,30);
		view.setBounds(280,450,110,30);
        	back.setBounds(205,520,110,30);

    		background.add (id);
    		background.add (sid);
    		background.add (back);
    		background.add (edit);
    		background.add (view);
		background.add (bid);
		background.add (bstud);
		background.add (batch);
		background.add (b);

     		back.addActionListener(this);
     		edit.addActionListener(this);
     		view.addActionListener(this);
		bstud.addActionListener(this);

           	this.setVisible (true);
  	}
  	
	public static void main (String s[])
  	{
  		  new EditServRec();
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



	public int search(int a)

	{

		int i=0;

		try

		{
			PreparedStatement ps;

			ps=con.prepareStatement("select * from servisingRecord,Student where sid=? ");

			ps.setInt(1,s.sid);
			
rs=ps.executeQuery();
			while(rs.next())
			i=rs.getInt(1);
		
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
		
		connect();
		if(e3.getSource()==back)
		{
			new ManMain1();
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
					new SRPopup();
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
		}
	}
}

