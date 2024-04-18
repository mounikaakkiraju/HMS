package GenericUtility;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class DatabaseUtility
{
	
		Connection con = null;
		
		public void connectToDB() throws SQLException
		{
			OracleDriver driver = new OracleDriver();
			DriverManager.registerDriver(driver);
			
			con = DriverManager.getConnection(IpathConstant.DBurl,IpathConstant.DBusername,IpathConstant.DBpassword);
		}
		
		public void executeAndGetData(String query,int colNo,String expData) throws SQLException
		{
			Statement st = con.createStatement();
			
			ResultSet res = st.executeQuery(query);
			
			boolean flag=false;
			
			while(res.next())
			{
				String actual=res.getString(colNo);
				
				if(actual.contains(expData))
				{
					flag=true;
					break;
				}
			}
			if(flag==true)
			{
				System.out.println("--data is verified--");
			}
			else
			{
				System.out.println("--data is not present--");
			}
		}
		
		public void closeDB() throws SQLException
		{
			con.close();
		}
	

}
