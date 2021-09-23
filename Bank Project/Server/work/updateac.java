package work;
import java.sql.*;
import java.util.Date;
public class updateac 
{
	public static int check(String ac,String na,String ph,String type,String ba,String add) throws Exception
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
		
		
		//Date d=new Date();
		
		int acno=Integer.parseInt(ac);

		int bal=Integer.parseInt(ba);
		

		//System.out.println(ba+"");		
		//System.out.println(acno+" "+bal);
		String s1="update  personal set name='"+na+"',phone='"+ph+"',ac_type='"+type+"',address='"+add+"' where account_no="+acno+"";
		
		int s;
		int r;
		String s2="update account set balance="+bal+" where account_no="+acno+"";
		try {
		st.executeUpdate(s2);
		st.executeUpdate(s1);  
 			}
		catch (Exception e) {return 0;}
		con.close();
			x=1;
		return x;
	
	
	}
}

