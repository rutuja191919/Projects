package pro;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Validation
{
	public int  validage(String s)
	{
		for (int j = 0; j < s.length (); j++)

		    {

		      if (Character.isDigit (s.charAt (j)) == false)
			{

			JOptionPane.showMessageDialog (null,"Age can not contain Characters","Invalid Age",JOptionPane.DEFAULT_OPTION);
			return 0;
			}

		    }
	return 1;
	}

	public int validname(String name)
	{
	

 for (int i = 0; i < name.length (); i++)

		    {

		      if (Character.isDigit (name.charAt (i)))

			{

			JOptionPane.showMessageDialog (null,"Name cannot contain digits..","Invalid Name",JOptionPane.DEFAULT_OPTION);
			 return 0;
			 // throw new InvalidName ("Name cannot contain digits..");

			}

		    }
		return 1;
	}


	public int validphone(String s)
	{
	for (int j = 0; j < s.length (); j++)

		    {

		      if (Character.isDigit (s.charAt (j)) == false)

			{

			JOptionPane.showMessageDialog (null,"Phone number cannot contain characters.","Invalid Phone Number", JOptionPane.DEFAULT_OPTION);
				return 0;
			//  throw new InvalidAgeF ("Phone number cannot contain characters");

			}

		    }
		if(s.length()!=10)
		{
			JOptionPane.showMessageDialog (null,"Phone Number should be of 10 digits","Invalid Phone Number",JOptionPane.DEFAULT_OPTION);
		return 0;
		}
	return 1;
	}

	public int validemail(String mail)
	{
	int cnt=0;
	for (int i = 0; i < mail.length (); i++)

		    {

		      if (mail.charAt (i)=='@' || mail.charAt(i)=='.')

			{

			cnt++;		
			
			}

		    }
		if(cnt!=2)
		{
		JOptionPane.showMessageDialog (null,"Email address should be alid","Invalid Mail ID",JOptionPane.DEFAULT_OPTION);
			return 0;



		}
	return 1;
	}	
}