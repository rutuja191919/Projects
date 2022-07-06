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
  		super ("Student Record");
 		 JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/patins.jpg")));
				  this.add(background);
   		this.setSize (1366,786);
   		this.setDefaultCloseOperation (EXIT_ON_CLOSE);
   		id= new JLabel ("*Student ID:");
   		sid=new JTextField();
		batch=new JLabel("Batch ID:");
		bid=new JTextField();

	Font f=new Font("Lucida Fax",Font.BOLD,20) ;
	Color c1=new Color(0,102,0);
		id.setFont(f);	  
		id.setForeground(c1);
  		batch.setFont(f);	  
		batch.setForeground(c1);

 		b=new JTextArea();
		JScrollPane scroll=new JScrollPane(b);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(940,190,190,60); 
		scroll.setSize(200,500);
		background.add(scroll);

//b.setBounds(950,150,200,30); 
//background.add (b);

  		bstud =new JButton ("Show List");
   		delete =new JButton ("Delete");
   		edit =new JButton ("Edit");
   		view =new JButton ("View");
   		back=new JButton ("<<Back");

		batch.setBounds(695,150,160,30);
		bid.setBounds(800,150,100,30);
		bstud.setBounds(955,150,150,30);
    		id.setBounds(170,250,160,30);
    		sid.setBounds(320,250,100,30);

    		
	background.add (id);
    		background.add (sid);
    		background.add (delete);
    		background.add (back);
    		background.add (edit);
    		background.add (view);
background.add (bid);
background.add (bstud);
background.add (batch);

     		delete.addActionListener (this);
     		back.addActionListener(this);
     		edit.addActionListener(this);
     		view.addActionListener(this);
bstud.addActionListener(this);
      		delete.setBounds(450,530,120,33);
		edit.setBounds(150,530,120,33);
		view.setBounds(300,530,120,33);
        	back.setBounds(50,40,140,30);
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


			else if(e3.getSource()==edit)
			{
				
			s.sid=Integer.parseInt(sid.getText());
			i=search(Integer.parseInt(sid.getText()));
		
				if (sid.getText().equals ("") ) 
				{
				JOptionPane.showMessageDialog (null,"Enter Student ID!","Error",JOptionPane.DEFAULT_OPTION);
				sid.requestFocus ();
				}
				
			
				else if(i!=0)
				{
				new Edit();
				dispose();
				}
				else
				{
					JOptionPane.showMessageDialog (null,"Incorrect Student ID!","Error",JOptionPane.DEFAULT_OPTION);
					sid.requestFocus ();
	  			}		
			}
			
		else if(e3.getSource()==view)
			{      	
				s.sid=Integer.parseInt(sid.getText());
				i=search(Integer.parseInt(sid.getText()));
		

			if (sid.getText().equals ("") ) 
				{
				JOptionPane.showMessageDialog (null,"Enter Student ID!","Error",JOptionPane.DEFAULT_OPTION);
				sid.requestFocus ();
				}
	
		

				else if(i!=0)
				{
					new View();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog (null,"Incorrect student ID!","Error",JOptionPane.DEFAULT_OPTION);
					sid.requestFocus ();
			      	}
			}
			
			else if(e3.getSource()==delete)
			{  
			s.sid=Integer.parseInt(sid.getText());    
			i=search(Integer.parseInt(sid.getText()));
		
	
				if (sid.getText().equals ("") ) 
				{
				JOptionPane.showMessageDialog (null,"Enter Student ID!","Error",JOptionPane.DEFAULT_OPTION);
				sid.requestFocus ();
				}
			
		


				else if(i!=0)
				{
					new DelStud();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog (null,"Incorrect student ID!","Error",JOptionPane.DEFAULT_OPTION);
					sid.requestFocus ();
	      			}
			
	      	
			}     	
		
		
		if(e3.getSource()==bstud)
		{
			
		if(bid.getText().equals(""))
		{
			JOptionPane.showMessageDialog (null,"Enter Batch ID!","Error",JOptionPane.DEFAULT_OPTION);
					bid.requestFocus ();
		}
		else
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
					  b.append(" "+rs.getInt(1)+" - "+rs.getString(2)+" "+rs.getString(4)+"\n");

				}
			
}

			catch(Exception e)

			{
				
System.out.println(e);
			
}
		}

		}
	}
}

