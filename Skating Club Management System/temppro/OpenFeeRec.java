import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OpenFeeRec extends JFrame implements ActionListener
{
  	JButton  Stud,edit,logout;
  	public OpenFeeRec()
  	{
  		super ("Fee Records of student");
       		JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/fee3.jpg")));
				  this.add(background);
    		this.setSize (1366, 786);
		this.setDefaultCloseOperation (EXIT_ON_CLOSE);
		Stud = new JButton ("PENDING");
    		edit= new JButton ("FEE Records of students");
    		logout = new JButton ("<<back");
		Stud.setBounds(200,100,210,39);   
    		edit.setBounds(200,170,210,39);    
 		logout.setBounds(840,520,210,39);
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
    		new OpenFeeRec ();
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
        		new Pending();
			dispose();
		}
		else if(e3.getSource()==edit)
		{
			new FeeRec();
			dispose();
		}

  	}

}
