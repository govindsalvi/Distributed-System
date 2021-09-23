import java.sql.*;
public class xyz
{
public static void main(String a[])
   {
        try
	{

		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("Jdbc:Odbc:bank","","");
		Statement stmt=con.createStatement();		


		
		String sq="select * from user";


		ResultSet rs=stmt.executeQuery(sq);
		


		while(rs.next())
		{
			String ac=rs.getString("username");
			System.out.println(ac);
		}


	}
	catch(Exception e)
	{

	}
   }
}