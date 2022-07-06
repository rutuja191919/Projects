import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import pro.*;
import java.util.Date;

import java.text.*;

public class BatchTT extends JFrame implements ActionListener
{
	JLabel sid,name;
	JButton back;
	Staticinfo s;
	Font f;
	Color c; 
	JTextArea a;
	int total=0;
	public BatchTT()
  	{
		super("TimeTrial Report");
		
		JLabel bid=new JLabel();
		String t[]=new String[50];
		String id[]=new String[50];    
		String cnt[]=new String[50];
 	
	 	JLabel background=new JLabel(new ImageIcon(ClassLoader.getSystemResource ("pics/atd.png")));
		this.add(background);
    		this.setSize (1366,786);
		this.add(background);
 		this.setDefaultCloseOperation (EXIT_ON_CLOSE);

		s=new Staticinfo();
		f=new Font("Lucida Fax",Font.BOLD,20) ;  
		Color c=new Color(255,255,255);
       		try
		{
			bid=new JLabel("Batch : ***");
			int bbid=s.sid;
			bid.setText("Batch : "+bbid);
			bid.setBounds(120,60,200,200);
			bid.setForeground(c);
			bid.setFont(f);
			background.add(bid);

			JLabel sid=new JLabel("S.ID");
			sid.setBounds(122,125,200,200);
			sid.setForeground(c);
			sid.setFont(f);
			background.add(sid);

			JLabel tt=new JLabel("Average Time");
			tt.setBounds(40,168,200,200);
			tt.setForeground(c);
			tt.setFont(f);
			background.add(tt);

			a=new JTextArea();
			a.setBounds(200,300,1000,100);
			JScrollPane scroll=new JScrollPane(a);
	
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			scroll.setBounds(200,200,1000,100); 
			scroll.setSize(1000,100);
			background.add(scroll);
			
			back=new JButton("<<Back");
			back.setBounds(50,40,140,30);
			back.addActionListener(this);
			background.add(back);
			
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");    	
Date ddd=new Date();
	sdf.format(ddd);
int month=ddd.getMonth()+1;

			s.rs=s.stmt.executeQuery("select sid from Student where bid="+bbid);
			int i=0;
			while(s.rs.next())
			{
				id[i]=new String();
				id[i]=s.rs.getInt(1)+" ";
				i++;
			}
			int total=i;
			int x,j=0;
			System.out.println("array length="+id.length);
			for(i=0;i<id.length;i++)
			{
				float a=0,avg=0;
				//s.rs=s.stmt.executeQuery("select time from timetrial where sid ="+id[i]);
				if(month < 10)
				{
					PreparedStatement ps=s.con.prepareStatement("select time from timetrial where sid =? and timetrial.date like ?");
					ps.setString(1,id[i]);
					ps.setString(2,"%/0"+month+"/%");
					
s.rs=ps.executeQuery();	
				}
				else
				{
					PreparedStatement ps=s.con.prepareStatement("select time from timetrial where sid =? and timetrial.date like ?");
					ps.setString(1,id[i]);
					ps.setString(2,"%/"+month+"/%");
					
s.rs=ps.executeQuery();	
				}
				j=0;
				while(s.rs.next())
				{
					j++;
					a=a+s.rs.getFloat(1);
				}

				System.out.println("count :id[i],j:  total:"+id[i]+" "+j+" "+a);

				if(j!=0)
					avg=a/j;
					cnt[i]=" ["+j+"]";
					t[i]=" "+avg+" ";
			}

			System.out.println("array length="+id.length);
			a.setText("\n");
			for(x=0;x<total;x++)
			{
				a.append(id[x]+"\t");				
			}
			a.append("\n\n");
			for(x=0;x<total;x++)
			{
				a.append(cnt[x]+"\t");				
			}
			a.append("\n");
			for(x=0;x<total;x++)
			{
				a.append(t[x]+"\t");				
			}
		}
		catch(Exception e )
		{
			System.out.println(e);
			e.printStackTrace();
		}

/*		a.setText("\n");
		for(int j=0;j < total;j++)
		a.append(d[j]+"\t");
		a.append("\n\n");
		for(int j=0;j < total;j++)
		a.append(t[j]+"\t");
*/
		this.setVisible (true);

  	}
  	

	public static void main (String s[])
  	{
   		 new StudTT();
  	}

	  public void actionPerformed (ActionEvent e3)
 	 {
		if(e3.getSource()==back)
		{
			new TTReport();
			dispose();
		}
	}
}
