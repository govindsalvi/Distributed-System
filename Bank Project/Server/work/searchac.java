package work;
import java.sql.*;
public class searchac 
{
	String acn,nam,ph,type,add,ba;
	
	
	public searchac(String ac) throws Exception
	{
		
		
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
		ResultSet rs1=null;
		int accc=Integer.parseInt(ac);
		String s="select * from personal where account_no="+accc+"";
		rs=st.executeQuery(s);
		if(rs==null)
		System.out.println("not");
			while(rs.next())
			{
			acn=String.valueOf(rs.getInt("account_no"));
			nam=rs.getString("name");
			ph=rs.getString("phone");
			type=rs.getString("ac_type");
			add=rs.getString("address");

			}
		String s1="select balance from account where account_no="+accc+"";
		
		rs1=st.executeQuery(s1);
			while(rs1.next())
			{
			ba=String.valueOf(rs1.getInt("balance"));	
			}
		
		//rs.close();
		//rs1.close();
	}
		public  String getac()
		{
		return acn;
		}
		public  String getnam()
		{
		return nam;
		}
		public  String getph()
		{
		return ph;
		}
		public  String gettype()
		{
		return type;
		}
		public  String getadd()
		{
		return add;
		}
		public  String getba()
		{
		return ba;
		}
}





