import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class S3 extends JFrame implements ActionListener
{
  
  private JLabel serv,name,sid,d1,d2,cno,type,nam,sno,dt1,dt2,cno1,tp1;
  private JButton back;
  

  public S3()
  {
 super ("Servising Record");
try
{
   	
   	JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/sc1.png")));
  	this.add(background);

        this.setSize (600, 400);

        this.setDefaultCloseOperation (EXIT_ON_CLOSE);

      serv = new JLabel ("Sevising of Skates!!!");
	serv.setForeground(Color.BLUE);

        name = new JLabel ("Name:");
	name.setForeground(Color.BLUE); 

        nam= new JLabel ();
	name.setForeground(Color.RED); 

        sid= new JLabel ("Student Id:");
	sid.setForeground(Color.BLUE); 
    
  	type = new JLabel ("Type of Servising:");
	type.setForeground(Color.BLUE);
   
      cno = new JLabel ("Contact No:");
cno.setForeground(Color.BLUE);   

serv.setBounds (80, 40, 230, 45);
name.setBounds (80, 80, 230, 45);
type.setBounds (80, 120, 230, 45);
cno.setBounds (80, 160, 230, 45); 

  background.add (serv);
    background.add (name);
    background.add (type);
    background.add (cno);

}

      email=
      new JButton ("Email");
    
     
back=new JButton("back",new ImageIcon (ClassLoader.
				  getSystemResource ("pics/t4.jpg")));     
     email.setBounds(50,320, 160, 35);
     
     back.setBounds(250,320,150,35);
  
    background.add (email);
  
    background.add (back);

    email.addActionListener (this);
   
 back.addActionListener(this);

    this.setVisible (true);
}
catch(Exception en)
{
 System.out.println (en);
}

  }


  public static void main (String s[])
  {
    new SRPopup ();
  }

  public void actionPerformed (ActionEvent es)
  {

     if (es.getSource () == back)
      {
	dispose ();
	//new ManMain1();
	
      }
  }
}
