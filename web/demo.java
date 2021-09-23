import java.io.*;
import java.net.*;
public class demo 
{
	public static void main(String a[]) throws Exception
	{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String s="GET /index.php HTTP/1.0\r\n\r\n";
	tcpc tcp=new tcpc(s,br);
	tcp.getfile();

	} 
}
