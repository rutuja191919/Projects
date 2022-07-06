import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import pro.*;
import java.sql.*;


class EditRec extends JFrame implements ActionListener
{
  	JLabel id,batch;
  	JTextField sid,bid;
  	JButton edit,view,bstud,delete,back;
  	Staticinfo s;
	 JTextArea b;


  	Connection con = null;
  Statement stmt = null;
  ResultSet rs;

  
  	public EditRec ()
  	{
  		super ("Student records");
 		 JLabel background=new JLabel();
				  this.add(background);
   		this.setSize (1366,786);
   		this.setDefaultCloseOperation (EXIT_ON_CLOSE);
   		id= new JLabel ("*student id:");
   		sid=new JTextField();
		batch=new JLabel("enter batch id:");
		bid=new JTextField();
 b=new JTextArea(30,100);
  		bstud =new JButton ("VIEW Students");
   		delete =new JButton ("DELETE");
   		edit =new JButton ("EDIT");
   		view =new JButton ("VIEW");
   		back=new JButton ("<<BACK");

		batch.setBounds(850,70,160,30);
		bid.setBounds(940,70,200,30);
		bstud.setBounds(940,105,150,30);
    		id.setBounds(200,100,160,30);
    		sid.setBounds(310,100,200,30);
b.setBounds(950,150,200,500); 
    		
	background.add (id);
    		background.add (sid);
    		background.add (delete);
    		background.add (back);
    		background.add (edit);
    		background.add (view);
background.add (bid);
background.add (bstud);
background.add (batch);
background.add (b);
     		delete.addActionListener (this);
     		back.addActionListener(this);
     		edit.addActionListener(this);
     		view.addActionListener(this);
bstud.addActionListener(this);
      		delete.setBounds(350,550,90,30);
		edit.setBounds(150,550,90,30);
		view.setBounds(250,550,90,30);
        	back.setBounds(150,590,90,30);
           	this.setVisible (true);
  	}
  	
	public static void main (String s[])
  	{
  		  new EditRec();
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

			ps=con.prepareStatement("select * from Student where sid=?");

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
		}
	}
}

