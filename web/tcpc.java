import java.net.*;
import java.io.*;
public class tcpc {

public static void main(String[] args) throws Exception
{
	String s1,s2;
	String modi;
	BufferedReader infromuser;
	infromuser=new BufferedReader(new InputStreamReader(System.in));
	Socket clientsocket=new Socket("localhost",9999);

	DataOutputStream toserver;
	toserver=new DataOutputStream(clientsocket.getOutputStream());

	BufferedReader fromserver;
	fromserver=new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));


	while(true){
	System.out.println("enter two numders");
	s1=infromuser.readLine();
	s2=infromuser.readLine();
	if(s1.equals("bye")) break;
	toserver.writeBytes(s1+"\n");
	toserver.writeBytes(s2+"\n");
	modi=fromserver.readLine();
	System.out.println(modi);
	}
	clientsocket.close();
	}

}