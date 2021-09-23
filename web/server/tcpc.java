package server;
import java.io.*;
import java.net.*;
public class tcpc 
{
	Socket clientsocket=new Socket(InetAddress.getLocalHost(),80);
	DataOutputStream toserver=new DataOutputStream(clientsocket.getOutputStream());
	//BufferedReader fromserver;
	BufferedReader fromserver=new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
	public tcpc(String s1,BufferedReader infromuser) throws Exception
	{
	//Socket clientsocket=new Socket(InetAddress.getLocalHost(),80);
	String s2;
	//int j=0;
	//DataOutputStream toserver=new DataOutputStream(clientsocket.getOutputStream());
	int j=s1.length();
	String s3=s1.substring(0,j-1);
	s1=s3.concat("0");
	//System.out.println(s1);
	toserver.writeBytes(s1+"\r\n\r\n");
	while((s1=infromuser.readLine()).length()!=0)
		{ continue; }
		//toserver.writeBytes("\r\n");
		//if((s1=infromuser.readLine())!=null)
		//toserver.writeBytes(s1);
	/*while((s1=infromuser.readLine()).length()!=0)
		{
		toserver.writeBytes(s1+"\r\n");
	System.out.println(s1);
		}
	*/
	
	//BufferedReader fromserver;
	//fromserver=new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
	FileOutputStream out1=new FileOutputStream("out.html");
		while((s2=fromserver.readLine()).length()!=0)
			{
			continue;
			}
	 while((s2=fromserver.readLine())!=null)	
		{
			//System.out.println(s2);
			out1.write(s2.getBytes());
			
		}
	clientsocket.close();

	}
	
}