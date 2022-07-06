import java.lang.*;
import java.io.*;
import java.net.*;
import SocketDemo.Server; 

public class MyServer
{
	public static void main(String arg[]) throws Exception
	{
		 Server sobj = new Server();
		 
		 System.out.println("Server application is running....");
		 sobj.Communicate();
	}
}