import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Camp extends JFrame implements ActionListener
{
  	JButton  stud,at,logout,tt,camp,report,edit;
  	public Camp()
  	{
  		super ("Camp ");

       		JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/camp.jpg")));
		this.add(background);

    		this.setSize (1366, 786);
		this.setDefaultCloseOperation (EXIT_ON_CLOSE);
		stud = new JButton ("Camp Registration");
    		at= new JButton ("Attendance");
		tt=new JButton("TimeTrial");
		report=new JButton("Report");
		edit=new JButton("Edit Student Record");

    		logout = new JButton ("<<Back");

		stud.setBounds(250,170,210,39);
		edit.setBounds(500,170,210,39);   
    		at.setBounds(250,260,210,39);
		tt.setBounds(500,260,210,39);
		report.setBounds(380,340,210,39);
    
 		logout.setBounds(50,40,140,30);

		background.add (stud);
		background.add (edit);
    		background.add (at);
   		background.add (logout);
		background.add (tt);
		background.add (report);		

   		stud.addActionListener (this);
    		at.addActionListener (this);
		report.addActionListener(this);
		tt.addActionListener (this);
		edit.addActionListener(this);
		logout.addActionListener (this);


		this.setVisible (true);
	}
  	
	public static void main (String s[])
  	{
    		new Camp();
	}
  
	public void actionPerformed (ActionEvent e3)
  	{

		if(e3.getSource () == stud)
		{
			new CampReg();
			dispose();
		}
		if(e3.getSource () == at)
		{
			new CampAtt();
			dispose();
		}
		if(e3.getSource () == tt)
		{
			new CampTT();
			dispose();
		}
		if(e3.getSource () == report)
		{
			new CampReport();
			dispose();
		}
		if(e3.getSource()==logout)
		{
			new ManMain1();
			dispose();
		}
		if(e3.getSource()==edit)
		{
			new CampEdit();
			dispose();
		}
  	}

}
