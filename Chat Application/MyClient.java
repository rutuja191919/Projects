import java.lang.*;
import java.io.*;
import java.net.*;
import SocketDemo.Client; 

public class MyClient
{
	public static void main(String arg[]) throws Exception
	{
		 Client cobj = new Client();
		 
		 cobj.Communicate();
	}
}