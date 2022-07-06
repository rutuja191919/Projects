import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Admin extends JFrame implements ActionListener
{
  JButton Admin,logout,editAdmin;
  public Admin ()
  {
    super ("Admin Main Page");
       	
  JLabel background=new JLabel();
this.add(background);
    this.setSize (1366, 786);


    this.setDefaultCloseOperation (EXIT_ON_CLOSE);

    Admin = new JButton ("New Registration of Admin");
    editAdmin=new JButton("Admin Records");
    logout = new JButton ("<<Back");

    Admin.setBounds(200,200,200,40);
    editAdmin.setBounds(200,280,200,40);
   
    logout.setBounds(900,520,210,39);

    background.add (Admin);
    background.add (editAdmin);
    background.add (logout);
    
    Admin.addActionListener (this);
    logout.addActionListener (this);
    editAdmin.addActionListener (this);
    
	this.setVisible (true);

  }
  public static void main (String s[])
  {
    new Admin ();
  }

  public void actionPerformed (ActionEvent e3)
  {
	if (e3.getSource () == logout)
      {
	new ManMain1();
	dispose();
      }
	else if(e3.getSource()==Admin)
	{
	new AddAdmin();
	dispose();
	}
	else if(e3.getSource()==editAdmin)
	{
	new DAdmin();
	dispose();
	}
  }
}
