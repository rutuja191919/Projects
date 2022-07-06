import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Student extends JFrame implements ActionListener
{
  	JButton  Stud,edit,logout;
  	public Student ()
  	{
  		super ("Students Record");
       		JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/stud.jpg")));
				  this.add(background);
    		this.setSize (1366, 786);
		this.setDefaultCloseOperation (EXIT_ON_CLOSE);
		Stud = new JButton ("NEW Registration of Student");
    		edit= new JButton ("Student Records");
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
    		new Student ();
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
        		new AddStud();
			dispose();
		}
		else if(e3.getSource()==edit)
		{
			new EditRec();
			dispose();
		}

  	}

}
