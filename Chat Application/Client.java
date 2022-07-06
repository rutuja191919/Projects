package SocketDemo;

import java.lang.*;
import java.io.*;
import java.net.*;

public final class Client
{
  private Socket s;
  private BufferedReader brk,br;
  private PrintStream ps;
 
  public Client() throws Exception
  {
       s = new Socket("localhost",1100); 
	   brk = new BufferedReader(new InputStreamReader(System.in));
	   br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	   ps = new PrintStream(s.getOutputStream()); 
  }
  protected void Finalize() throws Exception
  {
	  s.close();
	  brk.close();
	  br.close();
	  ps.close();
  }
 
  public void Communicate() throws Exception
  { 
	  String s1, s2;
	 
	   while(!((s1 = brk.readLine()).equals("exit")))
	   {
		  ps.println(s1);
		  s2 = br.readLine();
		  System.out.println("Server says  : "+s2);
		  System.out.print("Enter message for server : ");    
	   } 
  } 
}