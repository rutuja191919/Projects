import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class BdayPopup extends JFrame implements ActionListener
{
  
  private JLabel name,cno,date;
  private JButton email, msg;
  

  public BdayPopup()
  {
    super ("Birthday Reminder");

	
   	JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/bday1.png")));
  	this.add(background);

	//this.setLayout(new FlowLayout());
      this.setSize (600, 400);


    this.setDefaultCloseOperation (EXIT_ON_CLOSE);

      name = new JLabel ("Name:");
  
      date = new JLabel ("Date:");
   
      cno = new JLabel ("Contact No:");
    
      email=
      new JButton ("Email");
      msg =
      new JButton ("Message");

     name.setBounds (80, 40, 230, 45);
     date.setBounds (80, 90, 230, 45);
     cno.setBounds (80, 140, 230, 45);
     email.setBounds(50,200, 160, 35);
     msg.setBounds (240,200, 160, 35);


    background.add (name);
    background.add (date);
    background.add (cno);
    background.add (email);
    background.add (msg);
  

    email.addActionListener (this);
    msg.addActionListener (this);

    this.setVisible (true);

  }
  public static void main (String s[])
  {
    new BdayPopup ();
  }

  public void actionPerformed (ActionEvent e)
  {
    
  }
}
