import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import pro.*;

class DAdmin extends JFrame implements ActionListener
{
  JLabel un,pwd;
  JTextField uname;
JPasswordField pswd;
  JButton edit,view,delete,back;
  Staticinfo s;
  
  public DAdmin()
  {
    super ("Admin Records");
       	
  JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/achiv.jpg")));
				  this.add(background);
    this.setSize (1366,786);


    this.setDefaultCloseOperation (EXIT_ON_CLOSE);

    un= new JLabel ("Admin UserName:");
    uname=new JTextField();
	pwd= new JLabel ("Admin Password:");
    pswd=new JPasswordField();
    delete =new JButton ("Delete");
    edit =new JButton ("Edit");
    view =new JButton ("View");

	back=new JButton ("<<Back");

    un.setBounds(220,180,160,30);
    uname.setBounds(330,180,200,30);
    pwd.setBounds(220,230,160,30);
    pswd.setBounds(330,230,200,30);
  
  	delete.setBounds(640,350,130,33);
	edit.setBounds(280,350,130,33);
	view.setBounds(460,350,130,33);
    back.setBounds(50,40,160,33);

    background.add (un);
    background.add (uname);
    background.add (pwd);
    background.add (pswd);

    background.add (delete);
    background.add (back);
    background.add (edit);
    background.add (view);

    delete.addActionListener (this);
    back.addActionListener(this);
   edit.addActionListener(this);
   view.addActionListener(this);
    
	this.setVisible (true);

  }
  public static void main (String s[])
  {
    new DAdmin();
  }
  public void actionPerformed (ActionEvent e3)
  {
	s=new Staticinfo();
	if(e3.getSource()==delete)
	{
	   if (uname.getText ().equals ("") && pswd.getText ().equals ("")) 
	        {
		JOptionPane.showMessageDialog (null,
					       "Enter Details ","Error",
					       JOptionPane.DEFAULT_OPTION);
		uname.requestFocus ();
		}
		else if(pswd.getText ().equals (""))
		{
				JOptionPane.showMessageDialog (null,
					       "Enter password ","Error",
					       JOptionPane.DEFAULT_OPTION);
						pswd.requestFocus ();
		}

		   else if (uname.getText ().equals ("")) 
	        {
		JOptionPane.showMessageDialog (null,
					       "Enter UserName ","Error",
					       JOptionPane.DEFAULT_OPTION);
		uname.requestFocus ();
	      }

	    else 
	      {
			s.adminuname=uname.getText ();
			s.adminPsw=pswd.getText ();
			new DelAdmin();
			dispose();
	      }
	}
if(e3.getSource()==edit)
	{
	if (uname.getText ().equals ("") && pswd.getText ().equals ("") ) 
	     {
		JOptionPane.showMessageDialog (null,
					       "Enter Details ","Error",
					       JOptionPane.DEFAULT_OPTION);
		uname.requestFocus ();
		}
		else if(pswd.getText ().equals (""))
			{
				JOptionPane.showMessageDialog (null,
					       "Enter Password ","Error",
					       JOptionPane.DEFAULT_OPTION);
						pswd.requestFocus ();
			}
		else if (uname.getText ().equals ("")) 
	     {
		JOptionPane.showMessageDialog (null,
					       "Enter UserName ","Error",
					       JOptionPane.DEFAULT_OPTION);
		uname.requestFocus ();

	      }

	    else 
	      {
			s.adminuname=uname.getText ();
			s.adminPsw=pswd.getText ();
			new EditAdmin();
			dispose();
	      }
	}
if(e3.getSource()==view)
	{
	if (uname.getText ().equals ("") && pswd.getText ().equals ("") ) 
	     {
		JOptionPane.showMessageDialog (null,
					       "Enter Username ","Error",
					       JOptionPane.DEFAULT_OPTION);
		uname.requestFocus ();
	}
			else if(pswd.getText ().equals (""))
			{
				JOptionPane.showMessageDialog (null,
					       "Enter Password ","Error",
					       JOptionPane.DEFAULT_OPTION);
						pswd.requestFocus ();
			}

	else if (uname.getText ().equals ("") ) 
	     {
		JOptionPane.showMessageDialog (null,
					       "Enter Username ","Error",
					       JOptionPane.DEFAULT_OPTION);
		uname.requestFocus ();
	      }

	    else 
	      {
			s.adminuname=uname.getText ();
			s.adminPsw=pswd.getText ();
			new ViewAdmin();
			dispose();
	      }
	}
	if(e3.getSource()==back)
	{
	new Admin();
	dispose();
	}
	

}
}
