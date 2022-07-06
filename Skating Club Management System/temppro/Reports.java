import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Reports extends JFrame implements ActionListener
{
  	JButton  comp,atnd,fee,back;

  	public Reports()
  	{
  		super ("Reports");

       		JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/comptition.jpg")));

		this.add(background);
    		this.setSize (1366, 786);
		this.setDefaultCloseOperation (EXIT_ON_CLOSE);

		comp = new JButton ("TimeTrial Reports");
    		fee= new JButton ("Fee Reports ");
		atnd= new JButton ("Attendance Reports");
    		back = new JButton ("<<Back");

		comp.setBounds(970,100,210,39);   
    		atnd.setBounds(970,170,210,39);
		fee.setBounds(970,240,210,39);     
 		back.setBounds(980,550,210,39);

		background.add (comp);
    		background.add (atnd);
   		background.add (fee);
		background.add (back);

   		comp.addActionListener (this);
   		atnd.addActionListener (this);
    		fee.addActionListener (this);
    		back.addActionListener (this);


		this.setVisible (true);
	}
  	
	public static void main (String s[])
  	{
    		new Reports();
	}
  
	public void actionPerformed (ActionEvent e3)
  	{

		if (e3.getSource () == back)
      		{
			new ManMain1 ();
			dispose();
		}
		else if(e3.getSource() == comp)
		{
        			new TTReport();
			dispose();
		}
		else if(e3.getSource()==atnd)
		{
			new ATReport();
			dispose();
		}
		else if(e3.getSource()==fee)
		{
		//	new FeeReport();
			dispose();
		}

  	}

}
