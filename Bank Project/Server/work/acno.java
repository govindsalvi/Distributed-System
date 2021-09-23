package work;
import java.awt.*;	
import javax.swing.*;
import java.sql.*;
public class acno 
{
	public static int getacno() throws Exception
	{
		String get;
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
		catch (Exception e)
		{
			System.out.println("Error makeing connection");
		}
		Connection con=DriverManager.getConnection("Jdbc:Odbc:bank");
		Statement st=con.createStatement();

		ResultSet rs=null;
		int x=0;
		String s="select max(account_no) as maxac from account";
		rs=st.executeQuery(s);
		while(rs.next())
		{
		x=rs.getInt("maxac");
		}		
		return x+1;	
	}
}





