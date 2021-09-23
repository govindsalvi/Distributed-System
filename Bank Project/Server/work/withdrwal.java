package work;
import java.sql.*;
import java.util.Date;
public class withdrwal
{
	public static int check(String ac,String amount) throws Exception
	{
		int x=0;
		String get;
		int balance=0;
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
		int bal=Integer.parseInt(amount);

		String s1="select balance from account where account_no="+acno+"";
		try{

		rs=st.executeQuery(s1);
		
		while(rs.next())
			{
			balance=rs.getInt("balance");
			}
	
		if(balance>bal)
		{
		String s="update account set balance=balance-"+bal+" where account_no="+acno+"";
		try {
		st.executeUpdate(s);
 			}
		catch (Exception e) {return 0;}
		x=1;
		}
		else
		x=2;
		}
		catch(Exception ee) { return 0;}
		con.close();
		return x;
	
	
	}
}

