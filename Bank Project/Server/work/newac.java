package work;
import java.sql.*;
import java.util.Date;
public class newac 
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
		
		//ResultSet rs=null;
		Date d=new Date();
		//System.out.println(ac+" "+ba);
		int acno=Integer.parseInt(ac);

		int bal=Integer.parseInt(ba);
		//System.out.println(ac+" "+ba);

		//Date d=new Date();
		String s1="insert into personal values ('"+acno+"','"+na+"','"+ph+"','"+type+"','"+add+"')";
		
		int s;
		int r;
		String s2="insert into account values('"+acno+"','"+bal+"')";
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




