import java.io.*;
import java.net.*;
import java.util.*;
public class FTPClient
{
public static void main(String args[])throws Exception
	{
	String s1="";
	String s2="";
	String s="";
	Socket client=null;
	BufferedReader fromuser=null;
	DataOutputStream toserver=null;
	DataInputStream input=null;
	DataOutputStream toserver1=null;
	DataInputStream input1=null;
	//BufferedReader fromserver=null;
	client=new Socket(args[0],6665);
	fromuser=new BufferedReader(new InputStreamReader(System.in));
	toserver1=new DataOutputStream(client.getOutputStream());
	input1=new DataInputStream(client.getInputStream());
	//fromserver=new BufferedReader(new InputStreamReader(client.getInputStream()));
	System.out.print("Enter username ");
	s1=fromuser.readLine();
	System.out.print("Enter Password ");
	s2=fromuser.readLine();
	toserver1.writeBytes(s1+"\n");
	toserver1.writeBytes(s2+"\n");
	int x=Integer.parseInt(input1.readLine());
		if(x==0)
		{
		System.out.println("Wrong UserName or Password");
		System.exit(0);
		}	
		else
		{ 
			System.out.println("Welcome "+s1);
			System.out.println("For getting a file from remote host use command GET Filename\nFor putting a file at remote host use command PUT Filename\nFor Exit use Bye");
			boolean listen=true;
			while(listen)
			{ 
			toserver=new DataOutputStream(client.getOutputStream());
			input=new DataInputStream(client.getInputStream());
			System.out.print(s1+":>");
			String command=fromuser.readLine();
				if(command.equals("bye"))
					System.exit(0);
				StringTokenizer cmd=new StringTokenizer(command);
					String first=cmd.nextToken();
					String filename=cmd.nextToken();
					if(first.equals("get"))
					{
						//System.out.println("get");
						toserver.writeBytes("get"+"\n");
						toserver.writeBytes(filename+"\n");
							try{	
							    String size=input.readLine();
								int c=Integer.parseInt(size);
								//System.out.println(c);
								FileOutputStream fout=new FileOutputStream(filename);
								byte b[]=new byte[c];
								input.read(b);
								System.out.println(c+" Bytes are Successfully read");
								fout.write(b,0,c);
										/*
										while((c=fromserver.read())!=-1)
										{
										if(s.equals("EOF")) break;
										System.out.println(s);
										}
										*/
								fout.close();
								}
							catch(Exception eeeee)
							{
							System.out.println("Exception occures");
							}
					}
					else if(first.equals("put"))
					{
					toserver.writeBytes("put"+"\n");
					toserver.writeBytes(filename+"\n");
					//FileInputStream fin;
					String line="";
					//System.out.print(numOfBytes);
							try
							{
							int c;
							FileInputStream fileread=new FileInputStream(filename);
							File file=new File(filename);
							int numOfBytes=(int)file.length();
							String no=String.valueOf(numOfBytes);
							toserver.writeBytes(no+"\n");
							byte[] fileinBytes=new byte[numOfBytes];
							fileread.read(fileinBytes);
														//System.out.print(fileinBytes);
							toserver.write(fileinBytes,0,numOfBytes);
							System.out.println(fileinBytes);
							System.out.println(input.readLine()+" Bytes are Successfully written to server");
														/*while((c=fileread.read())!=-1)
														{
														toserver.write((char)c);
														}
														*/
							fileread.close();
							}
							catch(Exception eee)
							{
							System.out.println("file opening error");
							}
					}
					else
						System.out.println("This is Not any Recognize Command");
				//input.close();
				//toserver.close();	
			}
				input1.close();
				toserver1.close();
				fromuser.close();
		}
	}
}