import FTP.*;
import java.io.*;
import java.net.*;
public class FTPServer
{
public static void main(String a[])throws Exception
	{
	ServerSocket ssocket=new ServerSocket(6665);
		while(true)
		{
		new FTPServerThread(ssocket.accept()).start();
		}
	}
}