
import java.io.*;
import java.net.*;
class tcpclient {
	public static void main(String[] args) throws Exception {
	String s1;
	String modi;
	BufferedReader infromuser;
	infromuser=new BufferedReader(new InputStreamReader(System.in));
	Socket clientsocket=new Socket(InetAddress.getLocalHost(),80);
	DataOutputStream toserver=new DataOutputStream(clientsocket.getOutputStream());

	//BufferedReader fromserver;
	//fromserver=new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
	//s1=infromuser.readLine();
         DataInputStream fromserver=new DataInputStream(clientsocket.getInputStream());
	s1="GET /my/arrays.php HTTP/1.0\r\n\r\n";
	toserver.writeBytes(s1);
	 while(true)
	{
	modi=fromserver.readLine();
	if(modi.equals("</html>"))
	break;
	System.out.println(modi);
	}
	System.out.println(modi);
	clientsocket.close();
}

}
