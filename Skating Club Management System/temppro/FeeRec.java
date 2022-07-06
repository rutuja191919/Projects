import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import pro.*;
import java.sql.*;

class FeeRec extends JFrame implements ActionListener
{
  	JLabel id,batch;
  	JTextField sid,bid;
  	JButton edit,view,bstud,back;
  	Staticinfo s;
	 JTextArea b;



  	public FeeRec ()
  	{
  		super ("fee records");
		s=new Staticinfo();
 		 JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/fee2.jpg")));
				  this.add(background);
   		this.setSize (1366,786);
   		this.setDefaultCloseOperation (EXIT_ON_CLOSE);
   		id= new JLabel ("*student id:");
   		sid=new JTextField();
		batch=new JLabel("enter batch id:");
		bid=new JTextField();
 b=new JTextArea(30,100);
  		bstud =new JButton ("VIEW Students");
   		edit =new JButton ("DEPOSIT FEE");
   		view =new JButton ("VIEW");
   		back=new JButton ("<<BACK");

		batch.setBounds(800,70,160,30);
		bid.setBounds(910,70,200,30);
		bstud.setBounds(910,100,150,30);
    		id.setBounds(200,100,150,30);
    		sid.setBounds(310,100,200,30);
b.setBounds(950,150,150,500); 
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
		edit.setBounds(150,450,150,30);
		view.setBounds(350,450,150,30);
        	back.setBounds(150,490,150,30);
           	this.setVisible (true);
  	}
  	
	public static void main (String s[])
  	{
  		  new FeeRec();
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
			new OpenFeeRec();
			dispose();
		}
		else if(e3.getSource()==bstud)
		{	 b.setText(" ");

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
		else if(e3.getSource()==view || e3.getSource()==edit)
		{
			if (sid.getText ().equals ("") ) 
			{
			JOptionPane.showMessageDialog (null,"enter student id","error",JOptionPane.DEFAULT_OPTION);
			sid.requestFocus ();
			}
			i=search(Integer.parseInt(sid.getText ()));
			s.sid=Integer.parseInt(sid.getText ());

			if(e3.getSource()==edit)
			{
				if(i!=0)
				{
				new EditFee();
				dispose();
				}
				else
				{
					JOptionPane.showMessageDialog (null,"Incorrect student 					id!","error",JOptionPane.DEFAULT_OPTION);
					sid.requestFocus ();
	  			}		
			}
			if(e3.getSource()==view)
			{      		
				if(i!=0)
				{
					new ViewFee();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog (null,"Incorrect student 					id!","error",JOptionPane.DEFAULT_OPTION);
					sid.requestFocus ();
			      	}
			}     	
		}
	}
}

