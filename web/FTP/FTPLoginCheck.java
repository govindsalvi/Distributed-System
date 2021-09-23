package FTP;
import java.sql.*;
import java.net.*;
import java.io.*;
public class FTPLoginCheck
{
	public static int LoginCheck(String u,String p)throws Exception
		{
		int x=0;
		String get;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
		catch (Exception e)
		{
			System.out.println("Error makeing connection");
		}
		Connection con=DriverManager.getConnection("Jdbc:Odbc:bank");
		Statement st=con.createStatement();
		ResultSet rs=null;
		String s="select * from user";
		rs=st.executeQuery(s);
		while(rs.next())
		{
		String	user1=rs.getString("username");
		String	pass1=rs.getString("password");
		if(u.equals(user1)&&p.equals(pass1))
				{ x=1; break; }
		}
		return x;
		}
}
