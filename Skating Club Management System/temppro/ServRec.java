import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ServRec extends JFrame implements ActionListener
{
  	JButton  Stud,edit,logout;
  	public ServRec ()
  	{
  		super ("Servising Record");
       		JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/serv2.jpg")));
				  this.add(background);
    		this.setSize (1366, 786);
		this.setDefaultCloseOperation (EXIT_ON_CLOSE);
		Stud = new JButton ("This Week Servising");
    		edit= new JButton ("Student Records");
    		logout = new JButton ("<<back");
		Stud.setBounds(150,100,210,39);   
    		edit.setBounds(150,170,210,39);    
 		logout.setBounds(840,570,210,39);
		background.add (Stud);
    		background.add (edit);
   		background.add (logout);
   		Stud.addActionListener (this);
    		edit.addActionListener (this);
    		logout.addActionListener (this);

		this.setVisible (true);
	}
  	
	public static void main (String s[])
  	{
    		new ServRec ();
	}
  
	public void actionPerformed (ActionEvent e3)
  	{

		if (e3.getSource () == logout)
      		{
			new ManMain1 ();
			dispose();
		}
		else if(e3.getSource() == Stud)
		{
        		new ThisWeekServ();
			dispose();
		}
		else if(e3.getSource()==edit)
		{
			new OpenServRec();
			dispose();
		}

  	}

}
