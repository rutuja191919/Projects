import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Student extends JFrame implements ActionListener
{
  	JButton  Stud,edit,logout,achivments;
  	public Student ()
  	{
  		super ("Student Record");
       		JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/stud.jpg")));
				  this.add(background);
    		this.setSize (1366, 786);
		this.setDefaultCloseOperation (EXIT_ON_CLOSE);
		Stud = new JButton ("Registration of Student");
    		edit= new JButton ("Student Records");
		achivments=new JButton("Student Achievements");

    		logout = new JButton ("<<Back");
		Stud.setBounds(240,160,210,39);   
    		edit.setBounds(240,230,210,39);
		achivments.setBounds(240,300,210,39);
    
 		logout.setBounds(50,40,140,30);
		background.add (Stud);
    		background.add (edit);
   		background.add (logout);
		background.add (achivments);
	
   		Stud.addActionListener (this);
    		edit.addActionListener (this);
		achivments.addActionListener (this);
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
		else if(e3.getSource()==achivments)
		{
			new OpenAchiv();
			dispose();
		}
  	}

}
