import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class HolidayPopup extends JFrame implements ActionListener
{
  
  private JLabel hday,bno,rson;
  private JButton email, msg;
  

  public HolidayPopup()
  {
    super ("Holiday Reminder");

	
   	JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/hday.jpg")));
  	this.add(background);

	//this.setLayout(new FlowLayout());
      this.setSize (600, 400);


    this.setDefaultCloseOperation (EXIT_ON_CLOSE);

      hday = new JLabel ("Today is Hoilday for");
  
      rson = new JLabel ("Reason:");
   
      bno = new JLabel ("Batch No:");
    
      email=
      new JButton ("Email");
      msg =
      new JButton ("Message");

     hday.setBounds (80, 40, 230, 45);
     bno.setBounds (80, 90, 230, 45);
     rson.setBounds (80, 140, 230, 45);
     email.setBounds(50,200, 160, 35);
     msg.setBounds (240,200, 160, 35);


    background.add (hday);
    background.add (bno);
    background.add (rson);
    background.add (email);
    background.add (msg);
  

    email.addActionListener (this);
    msg.addActionListener (this);

    this.setVisible (true);

  }
  public static void main (String s[])
  {
    new HolidayPopup ();
  }

  public void actionPerformed (ActionEvent e)
  {
    
  }
}
