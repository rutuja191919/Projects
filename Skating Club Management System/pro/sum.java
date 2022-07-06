import java.io.*;

import java.util.*;

import java.awt.event.*;

import javax.swing.*;

import java.util.Random;



class SetBa extends JFrame implements ActionListener

{

	int a[]=new int[60];

	int i=0;

	JMenu operation,sort,compute;

	JTextArea ta;

	JMenuItem sum,avg,min,max,med;

	JMenuItem asc,dsc,search,load,save,exit;

	JMenuBar menu;

	JLabel l;


	public void  actionPerformed(ActionEvent e)

	{

		try

		{

			if(e.getSource() == save)

			{


			

			}

			else if(e.getSource() == load)

			{

				Random RandomNo=new Random();

				for(i=0;i<50;i++)

				{

					a[i]=RandomNo.nextInt(100);

					ta.setText(ta.getText() + a[i] + ",");

				}

			}

			 if(e.getSource() == save)

			{

				FileWriter fw=new FileWriter("numbers.txt");

				for(i=0;i<50;i++)

				{

					fw.write(new Integer (a[i]).toString());

					fw.write("\n");

			 	}

			 	fw.close();

			}


		

		if(e.getSource()==asc)
		{
			ta.setText("");
			for(i=0;i<50;i++)
				for(int j=0;j<50;j++)
				{
					if(a[i]<a[j])
					{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
					}
				}
				for(i=0;i<50;i++)
			ta.setText(ta.getText() + a[i] + ",");
		}

	

		if(e.getSource()==sum)
		{
			int sum=0;
			for(i=0;i<50;i++)
				{
					sum=sum+a[i];
				}
				String s="Sum is"+sum;
				JOptionPane.showMessageDialog (this, s);
		}

		if(e.getSource()==max)
		{
			int m=0;
			for(i=0;i<50;i++)
				{
					if(m < a[i])
					m=a[i];
				}
				String s="MAximum number is"+m;
				JOptionPane.showMessageDialog (this, s);
		}

		if(e.getSource()==search)
		{
			JTextField ss=new JTextField();
			String s="Enter number";
			Object o=JOptionPane.showInputDialog(this, s);
			int m=Integer.parseInt((String)o);
			for(i=0;i<50;i++)
				{
					if(m == a[i])
					{
						String sd="number Found!";
						JOptionPane.showMessageDialog (this, sd);
						break;
					}
	
				}
			if(i==50)
			{String sf="number not Found!";
				JOptionPane.showMessageDialog (this, sf);
					}
				
		}

		if(e.getSource()==med)
		{		
			int min=0;
			for(i=0;i<50;i++)
				{
					if(min < a[i])
					min=a[i];
				}
			int max=99999;
			for(i=0;i<50;i++)
				{
					if(max > a[i])
					max=a[i];
				}
			int m=(min-max)/2;
				String s="Minimum number is"+m;
				JOptionPane.showMessageDialog (this, s);
		}
	
		if(e.getSource()==min)
		{
			int m=99999;
			for(i=0;i<50;i++)
				{
					if(m > a[i])
					m=a[i];
				}
				String s="Minimum number is"+m;
				JOptionPane.showMessageDialog (this, s);
		}

		if(e.getSource()==dsc)
		{
			ta.setText("");
			for(i=0;i<50;i++)
				for(int j=0;j<50;j++)
				{
					if(a[i]>a[j])
					{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
					}
				}
				for(i=0;i<50;i++)
			ta.setText(ta.getText() + a[i] + ",");
		}


		int sum=0;
		float avrg;
		if(e.getSource()==avg)
		{

			for(i=0;i<50;i++)
			{
				sum=sum+a[i];

			}
			avrg=(float)sum/50;
			String a="Avg is :"+avrg;
			JOptionPane.showMessageDialog(this,a);

		}

	
		if(e.getSource() == exit)
		{
			System.exit(0);
		}
	}
	catch(Exception ee){
		System.out.println(ee+"***************");
	}
}


public SetBa()
{
try
{
		setLayout(null);
		 menu=new JMenuBar();

		operation=new JMenu("File");
		 compute=new JMenu("compute");
		 sort=new JMenu("Operations");
		load=new JMenuItem("Load");
		 save=new JMenuItem("Save");
		 exit=new JMenuItem("Exit");
		sum=new JMenuItem("Sum");
		min=new JMenuItem("minimum");
		max=new JMenuItem("maximum");
		med=new JMenuItem("median");
		 avg=new JMenuItem("Average");
		asc=new JMenuItem("Ascending");
		 dsc=new JMenuItem("Descending");
		 search=new JMenuItem("Search");


		sort.add(asc);
		sort.add(dsc);
		sort.add(search);
		menu.add(compute);
		menu.add(operation);
		menu.add(sort);
		compute.add(sum);
		compute.add(avg);
		compute.add(min);
		compute.add(max);
		compute.add(med);
		operation.add(load);
		operation.add(save);
		operation.add(exit);
		
		ta=new JTextArea("");
		l=new JLabel("Numbers");
		JScrollPane scroll=new JScrollPane(ta);
		scroll.setBounds(10,100,450,100);
		l.setBounds(20,10,450,100);
		add(scroll);
		add(l);

		load.addActionListener(this);
		save.addActionListener(this);
		asc.addActionListener(this);
		search.addActionListener(this);
		dsc.addActionListener(this);
		sum.addActionListener(this);
		avg.addActionListener(this);
		min.addActionListener(this);
		max.addActionListener(this);
		med.addActionListener(this);
		exit.addActionListener(this);

		setJMenuBar(menu);
		
		setSize(500,300);
		setVisible(true);
}catch(Exception ee){
		System.out.println(ee+"***************");
	}

    }
	public static void main(String args[])
	{
		SetBa obj=new SetBa();
	}

}


