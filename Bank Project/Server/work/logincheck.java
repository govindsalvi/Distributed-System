package work;
import java.awt.*;	
import javax.swing.*;
import java.sql.*;
public class logincheck 
{
	public static int check(String u,String p) throws Exception
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




