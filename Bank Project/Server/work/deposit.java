package work;
import java.sql.*;
import java.util.Date;
public class deposit 
{
	public static int check(String ac,String amount) throws Exception
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
		
		
		int acno=Integer.parseInt(ac);

		int bal=Integer.parseInt(amount);
		


		String s="update account set balance=balance+"+bal+" where account_no="+acno+"";
		try {
		st.executeUpdate(s);
 			}
		catch (Exception e) {return 0;}
		con.close();
			x=1;
		return x;
	
	
	}
}

