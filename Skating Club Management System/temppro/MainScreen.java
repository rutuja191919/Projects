import javax.swing.*;
import java.awt.image.*;
import java.awt.event.*;
import java.awt.*;

public class MainScreen extends JFrame implements ActionListener
{
  JLabel filelab,lab1,lab2;
  Font f;
  JButton btnClose, btnLogin;
  Dimension screen = Toolkit.getDefaultToolkit ().getScreenSize ();
  
	public MainScreen ()
  {
  	super ("Welcome");
    this.setSize (1366, 768);
    this.setDefaultCloseOperation (EXIT_ON_CLOSE);
    this.setResizable (true);
    this.setLayout(new FlowLayout());
    filelab = new JLabel ("WELCOME TO");
    lab1=new JLabel("DSK SCHOOL FAST AND FURIOUS");
   lab2=new JLabel("SKATING ACADAMY!!!");
    
	btnClose = new JButton ("",new ImageIcon (ClassLoader.
				  getSystemResource ("pics/logout.png")));
    btnLogin= new JButton ("",new ImageIcon (ClassLoader.
				  getSystemResource ("pics/login.png")));
    filelab.setBounds (390, 40, 820, 55);
lab1.setBounds (378, 90, 820, 55);
lab2.setBounds (378, 140, 820, 55);

    f=new Font("ITALIC",0,30);
    filelab.setFont(f);
    filelab.setForeground(Color.BLUE);
     lab1.setFont(f);
    lab1.setForeground(Color.RED);
  lab2.setFont(f);
    lab2.setForeground(Color.BLUE);

    btnLogin.setBounds (70, 380 , 180, 50);
    btnClose.setBounds (70, 460, 180, 50);

   	JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/p11.png")));
  	this.add(background);
    background.add (btnLogin);
    background.add (btnClose);

    btnLogin.addActionListener (this);
    btnClose.addActionListener (this);
	this.setVisible (true);

  	}
  public static void main (String s[])
  {
    new MainScreen ();
  }
  public void actionPerformed (ActionEvent e2)
  {

    if (e2.getSource () == btnLogin)
      {
	new MainLogin ();
	dispose ();
      }
    else if (e2.getSource () == btnClose)
      {
	System.exit (0);
      }
  }
}
