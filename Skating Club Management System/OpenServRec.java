import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import pro.*;
import java.sql.*;

class OpenServRec extends JFrame implements ActionListener
{
  	JLabel id,batch;
  	JTextField sid,bid;
  	JButton edit,view,bstud,back;
  	Staticinfo s;
	JTextArea b;



  	public OpenServRec ()
  	{
  		super ("Servicing Records");
		s=new Staticinfo();
 		 JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/servising.JPG")));
				  this.add(background);
   		this.setSize (1366,786);
   		this.setDefaultCloseOperation (EXIT_ON_CLOSE);

   		id= new JLabel ("*Student ID:");
   		sid=new JTextField();
		batch=new JLabel("Batch ID:");
		bid=new JTextField();
 		b=new JTextArea(30,100);
		
		Font f=new Font("Lucida Fax",Font.BOLD,20) ;	
		Color c=new Color(255,255,255);

		id.setFont(f);
		id.setForeground(c);
		
		batch.setFont(f);
		batch.setForeground(c);


		JScrollPane scroll=new JScrollPane(b);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(950,190,200,500); 
		scroll.setSize(200,500);
		background.add(scroll);

  		bstud =new JButton ("Show List");
   		edit =new JButton ("Edit");
   		view =new JButton ("View");
   		back=new JButton ("<<Back");

		batch.setBounds(720,140,160,30);
		bid.setBounds(825,140,100,30);
		bstud.setBounds(970,140,150,30);
    		id.setBounds(130,240,160,30);
    		sid.setBounds(270,240,100,30);
//b.setBounds(50,120,200,500); 
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
		edit.setBounds(210,410,140,30);
		view.setBounds(420,410,140,30);
        	back.setBounds(50,40,140,30);
           	this.setVisible (true);
  	}
  	
	public static void main (String s[])
  	{
  		  new OpenServRec();
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
		if(e3.getSource()==back)
		{
			new ServRec();
			dispose();
		}
		else if(e3.getSource()==bstud)
		{	
if(bid.getText().equals(""))
{
JOptionPane.showMessageDialog (null,"Enter Batch ID!","Error",JOptionPane.DEFAULT_OPTION);
			sid.requestFocus ();
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
					  b.append(" "+s.rs.getInt(1)+" - "+s.rs.getString(2)+" "+s.rs.getString(4)+"\n");

				}
			
}

			catch(Exception e)

			{
				
System.out.println(e);
			
}
		}}
		else if(e3.getSource()==view || e3.getSource()==edit)
		{
			if (sid.getText ().equals ("") ) 
			{
			JOptionPane.showMessageDialog (null,"Enter student ID@","Error",JOptionPane.DEFAULT_OPTION);
			sid.requestFocus ();
			}
			i=search(Integer.parseInt(sid.getText ()));
			s.sid=Integer.parseInt(sid.getText ());

			if(e3.getSource()==edit)
			{
				if(i!=0)
				{
				new EditServ();
				dispose();
				}
				else
				{
					JOptionPane.showMessageDialog (null,"Incorrect student ID!","Error",JOptionPane.DEFAULT_OPTION);
					sid.requestFocus ();
	  			}		
			}
			if(e3.getSource()==view)
			{      		
				if(i!=0)
				{
					new ViewServ();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog (null,"Incorrect student ID!","Error",JOptionPane.DEFAULT_OPTION);
					sid.requestFocus ();
			      	}
			}     	
		}
	}
}

