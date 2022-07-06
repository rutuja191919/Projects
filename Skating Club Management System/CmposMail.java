import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import pro.*;

class CmposMail extends JFrame implements ActionListener
{
JLabel subject,compose;
JTextArea sub,c;
JButton OK;
Staticinfo s;

	CmposMail()
	{
		setSize(500,500);
		setLayout(null);
		s=new Staticinfo();
		subject =new JLabel("Subject: ");
		sub=new JTextArea();
		compose =new JLabel("Compose Email:");
		c=new JTextArea();
		OK=new JButton("OK");

		subject.setBounds(50,20,300,30);
		sub.setBounds(50,70,300,30);
		compose.setBounds(50,120,300,30);
		c.setBounds(50,170,300,200);
		OK.setBounds(350,420,100,30);
		
		OK.addActionListener(this);
						
		add(subject);
		add(sub);
		add(compose);
		add(c);
		add(OK);
		
		setVisible(true);
	}

	public static void main(String args[])
	{
		new CmposMail();
	}

	public void  actionPerformed(ActionEvent e)
	{
		if(e.getSource()==OK)
		{
			s.mailflag=1;
			if(sub.getText().equals(" ")!=true)
				s.substr=sub.getText();
			if(c.getText().equals(" ")!=true)
				s.mailstr=c.getText();
			dispose();
		}
	}

}