import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import pro.*;
import java.util.Date;

import java.text.*;

class StudAtt extends JFrame implements ActionListener
{
	JLabel sid,name;
	String m[],ml[];
	JButton back;
	Staticinfo s;
	Font f;
	Color c; 

  	public StudAtt()
  	{
  		super ("Attendance Report");
  		JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/atd.png")));
				  this.add(background);
    		this.setSize (1366,786);
		this.add(background);
    		this.setDefaultCloseOperation (EXIT_ON_CLOSE);

		m=new String[30];
		ml=new String[50];

		s=new Staticinfo();
		f=new Font("Lucida Fax",Font.BOLD,20) ;  
		Color c=new Color(255,255,255);

		String rsfname,rslname,date,rsid;
		name=new JLabel("*****");
		name.setFont(f);	
		name.setForeground(c);
		sid=new JLabel("*****");
		sid.setFont(f);	
		sid.setForeground(c);

       		try
		{
			back=new JButton("<<Back");
			back.setBounds(50,40,140,30);
			background.add(back);
			s.rs=s.stmt.executeQuery("select sid,fname,lname from student where student.sid="+s.sid);
			while(s.rs.next())
			{
				name.setText("Name  :  "+s.rs.getString(2)+" "+s.rs.getString(3));
				sid.setText(" S.ID :"+s.rs.getInt(1));
			}
			name.setBounds(150,150,500,30);
			sid.setBounds(500,150,100,30);
			background.add(name);
			background.add(sid );

			
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");    	
Date ddd=new Date();
	sdf.format(ddd);
int month=ddd.getMonth()+1;
			
			//s.rs=s.stmt.executeQuery("select attendance.date,status from student,attendance where student.sid="+s.sid+" and student.sid=attendance.sid");
			if(month < 10)
			{
				PreparedStatement ps=s.con.prepareStatement("select attendance.date, status  from student,attendance where student.sid=? and student.sid=attendance.sid and attendance.date like ?");

				ps.setInt(1,s.sid);
				ps.setString(2,"%/0"+month+"/%");
				
s.rs=ps.executeQuery();	
			}
			else
			{
				PreparedStatement ps=s.con.prepareStatement("select attendance.date, status  from student,attendance where student.sid=? and student.sid=attendance.sid and attendance.date like ?");
				ps.setInt(1,s.sid);
				ps.setString(2,"%/"+month+"/%");
				
s.rs=ps.executeQuery();	
			}
			int i=0, y=100;		
			while(s.rs.next())
			{	
				m[i]=new String(s.rs.getString(1));
				//m[i].setFont(f);	
				//m[i].setForeground(c);
				if(s.rs.getString(2).equals("p"))
				{
					ml[i]=new String("Present");
				//	ml[i].setFont(f);	
				//	ml[i].setForeground(c);
				}
				else
				{
					ml[i]=new String("Absent");
					//ml[i].setFont(f);	
					//ml[i].setForeground(c);
				}
				//m[i].setBounds(100,y,190,30);
				//ml[i].setBounds(300,y,100,30);
				//background.add(m[i]);
				//background.add(ml[i]);
				i++;
				y=y+30;
			 }
			int total=i;
		 	JTextArea ta=new JTextArea();
			ta.setBounds(200,230,1000,100);
			JScrollPane scroll=new JScrollPane(ta);
	
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			scroll.setBounds(200,230,1000,100); 
			scroll.setSize(1000,100);
			background.add(scroll);
			
			JLabel dd=new JLabel("Date-");
			dd.setBounds(100,200,100,100);
			dd.setFont(f);	
			dd.setForeground(c);
			background.add(dd);

			ta.setText("\n");
			for(i=0;i<total;i++)
			{
				ta.append("\t"+m[i]);		
			}
			ta.append("\n\n");
			for(i=0;i<total;i++)
			{
				ta.append("\t"+ml[i]);		
			}
		}
		catch(Exception e )
		{
			System.out.println(e);
		}


   		 back.addActionListener(this);
		this.setVisible (true);
  	}

  	public static void main (String s[])
  	{
   		 new StudAtt();
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
