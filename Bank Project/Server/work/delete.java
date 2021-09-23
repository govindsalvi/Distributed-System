package work;
import java.awt.*;	
import javax.swing.*;
import java.sql.*;
public class delete 
{
	public static int check(String ac) throws Exception
	{
		int x=0;
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
		
		int acno=Integer.parseInt(ac);
		String s=" delete from account where account_no="+acno+"";
		String s1="delete from personal where account_no="+acno+"";
		try{
		st.executeUpdate(s);
		st.executeUpdate(s1);
		}
		catch (Exception ee)	{ return 0;}
		
		return 1;
	
	
	}
}




