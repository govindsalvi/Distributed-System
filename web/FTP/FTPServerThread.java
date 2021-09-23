package FTP;
import java.net.*;
import java.io.*;
import java.util.*;
public class FTPServerThread extends Thread
{
	Socket s=null;
	DataOutputStream toclient=null;
	DataInputStream input=null;
	DataOutputStream toclient1=null;
	DataInputStream input1=null;
	public FTPServerThread(Socket socket)
	{
	this.s=socket;
	}
	public void run()
	{
	while(true)
	{
		try
		{
		//BufferedReader fromclient=new BufferedReader(new InputStreamReader(s.getInputStream()));
		toclient=new DataOutputStream(s.getOutputStream());
		input=new DataInputStream(s.getInputStream());
		toclient1=new DataOutputStream(s.getOutputStream());
		input1=new DataInputStream(s.getInputStream());
		String username="",password="";
		username=input.readLine();
		password=input.readLine();
		int xx=FTPLoginCheck.LoginCheck(username,password);
		String x=String.valueOf(xx);
		toclient.writeBytes(x+"\n");
		String first=input.readLine();
		String filename=input.readLine();
		//System.out.println(filename);
		String line;
					if(first.equals("get"))
						{
						try{
						System.out.println("i am in get");
						FileInputStream fileread=new FileInputStream(filename);
						File file=new File(filename);
						System.out.println(filename);
						int c=(int)file.length();
						String size=String.valueOf(c);
						toclient.writeBytes(size+"\n");
						byte b[]=new byte[c];
						fileread.read(b);
						System.out.println(b);
						toclient.write(b,0,c);
										/*
										while((line=fileread.readLine())!=null)
										{
										toclient.writeBytes(line+"\n");
										}
										toclient.writeBytes("EOF"+"\n");
										*/
						//fileread.close();
						}
						catch(Exception exp)
							{}
						}
						else if(first.equals("put"))
						{
							
							try
							{
							//System.out.println("i am in put");
							FileOutputStream fout=new FileOutputStream(filename);
							String size=input1.readLine();
							int c=Integer.parseInt(size);
							
							//System.out.println(filename+c);
							byte b[]=new byte[c];
							//input.read(b,0,c);
							  int r=input1.read(b);
							  String r1=String.valueOf(r);
							 System.out.println("put"+b);
							  fout.write(b,0,c);
							  toclient1.writeBytes(r1+"\n");
								/*while((c=fromclient.read())!=-1)
								{
								fout.write((char)c);
								}
								fout.write((char)-1);
								*/
								//fout.close();
							}
							catch(Exception e)
							{
							System.out.println("error");
							}
							
						}
		//input.close();
		//toclient.close();
		}
		catch(Exception e)
		{}
		
	}
	}
}