import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import pro.*;
import java.util.Date;

import java.text.*;

class BatchAtt extends JFrame implements ActionListener
{
	JLabel bid,m[],present[],absent[],lp,la;
	JButton back;
	Staticinfo s;
	Font f;
	Color c;
	
  public BatchAtt()
  {
  super ("Attendance Report");
  JLabel background=new JLabel();
				  this.add(background);
    this.setSize (1366,786);

this.add(background);
    this.setDefaultCloseOperation (EXIT_ON_CLOSE);


	m=new JLabel[30];
	present =new JLabel[20];
	absent =new JLabel[20];
	
	s=new Staticinfo();
f=new Font("Lucida Fax",Font.BOLD,18) ;  
Color c=new Color(255,250,250);
	bid=new JLabel("batch :"+s.bid);
		bid.setFont(f);	
		bid.setForeground(c);
		bid.setBounds(100,50,100,30);
		background.add(bid );
	back=new JButton("<<BACK");
		back.setBounds(950,630,100,30);
		background.add(back);

	try
	{	
		int j=0,i=0, y=130,x=130,cnt=0;

		s.rs=s.stmt.executeQuery("Select Distinct Date from Attendance;");
		while(s.rs.next())
		{	
			m[i]=new JLabel(s.rs.getString(1));
				m[i].setFont(f);	
				m[i].setForeground(c);
				m[i].setBounds(100,y,150,30);
				background.add(m[i]);
			y=y+50;
			cnt++;
			i++;
		}

		lp=new JLabel("Total : Present   |");
		lp.setFont(f);	
		lp.setForeground(c);
		lp.setBounds(230,100,170,30);
		background.add(lp );

		la=new JLabel("Absent");
		la.setFont(f);	
		la.setForeground(c);
		la.setBounds(400,100,100,30);
		background.add(la );
y=130;
String temp;
for(i=0;i<cnt;i++)
{
	int p=0,a=0;	
	
System.out.println("date=:"+m[i].getText()+"i==="+i+"batch:"+s.bid);

		s.rs=s.stmt.executeQuery("select status from attendance where date='"+ m[i].getText() +"' and sid in(select sid from Student where bid="+s.bid+")");	
	
		while(s.rs.next())
			
		{	
		temp=s.rs.getString(1);
		if(temp.equals("p"))
			p++;
		else
			a++;
		}
	
System.out.println(" p==="+p+"a==="+a);
		present[i]=new JLabel(" "+p);
		present[i].setFont(f);	
		present[i].setForeground(c);
		present[i].setBounds(300,y,100,30);
		background.add(present[i] );

		absent[i]=new JLabel(" "+a);
		absent[i].setFont(f);	
		absent[i].setForeground(c);
		absent[i].setBounds(400,y,100,30);
		background.add(absent[i] );

y=y+50;

}

	}
catch(Exception e )
{
System.out.println(e);
e.printStackTrace();
}


    back.addActionListener(this);

	this.setVisible (true);

  }
  	public static void main (String s[])
  	{
   		 new BatchAtt();
  	}

	  public void actionPerformed (ActionEvent e3)
 	 {

		if(e3.getSource()==back)
		{
			new ATReport();
			dispose();
		}

	}
}
