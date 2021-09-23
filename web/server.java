import server.*;
import java.io.*;
import java.net.*;
import java.util.*;
class server {
public static void main(String[] args) throws Exception {
String s1="";
String filename;	
String modi;
ServerSocket ssocket=new ServerSocket(6666);

	//BufferedReader infromuser;
	//DataOutputStream fromserver;
	while(true)
	{
	BufferedReader infromuser;
	DataOutputStream fromserver;
	Socket connectionsocket=ssocket.accept();
	infromuser=new BufferedReader(new InputStreamReader(connectionsocket.getInputStream()));
	fromserver=new DataOutputStream(connectionsocket.getOutputStream());
        s1=infromuser.readLine();
	StringTokenizer tokeniz=new StringTokenizer(s1);
		String getorpost=tokeniz.nextToken();
	
		if(getorpost.equals("GET")||getorpost.equals("POST"))
			{
			filename=tokeniz.nextToken();
				if(filename.startsWith("/")==true)
				{
				filename=filename.substring(1);
				}
					File file;
					int numOfBytes;
					FileInputStream infile;
						try
							{
								file=new File(filename);
								numOfBytes=(int)file.length();
								infile=new FileInputStream(filename);
							}
							catch(Exception e)
							{	
								//System.out.print("Exception");
								//try
								//{
								tcpc tcp=new tcpc(s1,infromuser);
								filename="out.html";
								file=new File(filename);
								numOfBytes=(int)file.length();
								infile=new FileInputStream(filename);
								//}
								/*catch(Exception ee)
								{
								
								//tcpc tcp=new tcpc(s1,infromuser);
								filename="error.html";
								file=new File("error.html");
								numOfBytes=(int)file.length();
								infile=new FileInputStream(filename);
								}
							*/
							}
								byte[] fileinBytes=new byte[numOfBytes];
								infile.read(fileinBytes);
								fromserver.writeBytes("HTTP/1.0 200 ok\r\n");
								String type;
								type=mime.getmime(filename);
								fromserver.writeBytes("Content-Type:"+type+"\r\n");
								fromserver.writeBytes("\r\n");
								fromserver.write(fileinBytes,0,numOfBytes);
						}
		else
			System.out.println("Bad");connectionsocket.close();
	}
         // connectionsocket.close();

}

}
