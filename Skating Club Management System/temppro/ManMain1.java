import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ManMain1 extends JFrame implements ActionListener
{
  JButton attend,fee,serv, logout,trial,a,b,r;

  public ManMain1 ()
  {
    super ("Admin Main Page");
       	
  JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/man1.png")));
				  this.add(background);
    this.setSize (1366, 786);


    this.setDefaultCloseOperation (EXIT_ON_CLOSE);

    a=new JButton("Admin");
    b=new JButton("Student");
    r=new JButton("Reports");
    attend= new JButton ("Attendance");
    fee = new JButton ("Fee Records");
    serv= new JButton ("Servicing Record");
    trial=new JButton("Today's time trial");
    logout = new JButton ("Logout");

    a.setBounds(230,530,170,30);
    b.setBounds(450,530,170,30);
    fee.setBounds(680,530,170,30);
   r.setBounds(910,530,170,30);
    trial.setBounds(280,590,170,30);
    serv.setBounds(800,590,170,30);
    attend.setBounds(540,590,170,30);

    logout.setBounds(1110,650,170,30);

    background.add (attend);
    background.add (fee);
    background.add (serv);
    background.add (logout);
    background.add (trial);
    background.add (a);
   background.add (b);
    background.add (r);


    a.addActionListener (this);
   
     b.addActionListener (this);
     r.addActionListener (this);
    
    
    attend.addActionListener (this);
    fee.addActionListener (this);
    serv.addActionListener (this);
    logout.addActionListener (this);
   trial.addActionListener (this);

	this.setVisible (true);

  }
  public static void main (String s[])
  {
    new ManMain1 ();

  }
  public void actionPerformed (ActionEvent e3)
  {

	if (e3.getSource ()== a)
      {
	new Admin ();
	dispose();
      }
else if (e3.getSource () == b)
      {
	new Student ();
	dispose();
      }
    else if (e3.getSource () == logout)
      {
	new MainLogin ();
	dispose();
      }
    else if (e3.getSource () == serv)
      {
	new ServRec();
	dispose();
      }
else if (e3.getSource () == fee)
      {
		new OpenFeeRec();
		dispose();
      	}
	else if(e3.getSource () == attend)
	{
		new Attendance();
		dispose();
	}
	else if(e3.getSource () == trial)
	{
		new TimeTrial();
		dispose();
	}
	else if(e3.getSource () == r)
	{
		new Reports();
		dispose();
	}
  }
}
