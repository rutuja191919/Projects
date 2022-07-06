package SocketDemo;

import java.lang.*;
import java.io.*;
import java.net.*;

public final class Server
{
  private ServerSocket ss;
  private Socket s;
  private BufferedReader brk,br;
  private PrintStream ps;
 
  public Server() throws Exception
  {
	   ss = new ServerSocket(1100);
       s = ss.accept(); 
	   brk = new BufferedReader(new InputStreamReader(System.in));
	   br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	   ps = new PrintStream(s.getOutputStream()); 
  }
  protected void Finalize() throws Exception
  {
	  ss.close();
	  s.close();
	  brk.close();
	  br.close();
	  ps.close();
  }
 
  public void Communicate() throws Exception
  {
	  String s1, s2;
	 
	   while((s1 = br.readLine())!= null)
	   {
		  System.out.println("Client Says : "+s1);
		  System.out.print("Enter the message for client : ");
		  s2 = brk.readLine();
		  ps.println(s2);
	   }
	 
  } 
}