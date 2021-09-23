import work.*;
import java.io.*;
import java.sql.*;
import java.net.*;
public class s
{
	public static void main(String a[]) throws  Exception
	{
	String user,pass,get,send;
	ServerSocket ssocket=new ServerSocket(6565);
		while(true)
		{
		Socket csocket=ssocket.accept();
		BufferedReader fromclient=new BufferedReader(new InputStreamReader(csocket.getInputStream()));
		DataOutputStream toclient=new DataOutputStream(csocket.getOutputStream());
		int n=Integer.parseInt(fromclient.readLine());
		switch(n)
		{
		case 1: 	//login check
			{
			user=fromclient.readLine();
			pass=fromclient.readLine();
			int x=logincheck.check(user,pass);
			send=String.valueOf(x)+"\n";
			toclient.writeBytes(send);
			} break;
		case 2: 	//delete
			{
			String ac=fromclient.readLine();
			int x=delete.check(ac);
			send=String.valueOf(x)+"\n";
			toclient.writeBytes(send);
			} break;
		
		case 3: 			// new account
			{
			String acno=fromclient.readLine();
			String na=fromclient.readLine();
			String ph=fromclient.readLine();
			String type=fromclient.readLine();
			String ba=fromclient.readLine();
			String add=fromclient.readLine();
			int x=newac.check(acno,na,ph,type,ba,add);
			send=String.valueOf(x)+"\n";
			toclient.writeBytes(send);
			} break;
		case 4: 			// get account number
			{
			int x=acno.getacno();
			//System.out.print(x);
			send=String.valueOf(x)+"\n";
			toclient.writeBytes(send);
			} break;
		case 5:				// search account
			{
			String accno,name,ph,type,ba,add;

			String acno=fromclient.readLine();
			searchac ac=new searchac(acno);
			accno=ac.getac();
			name=ac.getnam();
			ph=ac.getph();
			type=ac.gettype();
			ba=ac.getba();
			add=ac.getadd();
			if(accno==null)
				{
				//System.out.println("null");
				connection c=new connection("10.10.10.1");
				c.toserver.writeBytes("5"+"\n");
				c.toserver.writeBytes(acno+"\n");
				accno=c.fromserver.readLine();
				name=c.fromserver.readLine();
				ph=c.fromserver.readLine();
				type=c.fromserver.readLine();
				ba=c.fromserver.readLine();
				add=c.fromserver.readLine();
				int x=newac.check(accno,name,ph,type,ba,add);	
				}
			toclient.writeBytes(accno+"\n");
			toclient.writeBytes(name+"\n");
			toclient.writeBytes(ph+"\n");
			toclient.writeBytes(type+"\n");
			toclient.writeBytes(ba+"\n");
			toclient.writeBytes(add+"\n");
			} break;
		case 6: 			//update
			{
			String acno=fromclient.readLine();
			String na=fromclient.readLine();
			String ph=fromclient.readLine();
			String type=fromclient.readLine();
			String ba=fromclient.readLine();
			String add=fromclient.readLine();
			
			int x=updateac.check(acno,na,ph,type,ba,add);
			send=String.valueOf(x)+"\n";
			//System.out.println(send);
			toclient.writeBytes(send);
			} break;
		case 7:				// balance inquiry
			{
			String acno=fromclient.readLine();
			searchac ac=new searchac(acno);
			toclient.writeBytes(ac.getac()+"\n");
			toclient.writeBytes(ac.getnam()+"\n");
			toclient.writeBytes(ac.getba()+"\n");
			} break;

		case 10:				// search name account
			{
			String acno=fromclient.readLine();
			//System.out.print(acno);
			searchac ac=new searchac(acno);
			toclient.writeBytes(ac.getac()+"\n");
			toclient.writeBytes(ac.getnam()+"\n");

			} break;
		case 11:				// Deposit
			{
			String acno=fromclient.readLine();
			String money=fromclient.readLine();
			int x=deposit.check(acno,money);
			send=String.valueOf(x)+"\n";
			toclient.writeBytes(send);

			} break;		
		case 12:				// Withdrwal
			{
			String acno=fromclient.readLine();
			String money=fromclient.readLine();
			//System.out.print(acno+money);

			int x=withdrwal.check(acno,money);
			send=String.valueOf(x)+"\n";
			toclient.writeBytes(send);

			} break;
		}		
		}
	}
}