package work;
import java.net.*;
import java.io.*;
public class connection
{
Socket clientsocket;
String host;
DataOutputStream toserver;
BufferedReader fromserver;
public connection(String h) throws Exception
	{
	host=new String(h);
	clientsocket=new Socket(host,6565);
	toserver=new DataOutputStream(clientsocket.getOutputStream());
	fromserver=new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
	}
}


