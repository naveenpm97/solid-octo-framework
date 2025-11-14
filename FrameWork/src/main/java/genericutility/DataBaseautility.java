package genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseautility {
	Connection con;
	public void getDBConnection(String url, String username, String password) throws SQLException {
		try {
			Driver dr=new Driver();
			DriverManager.registerDriver(dr);
			con=DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			
		}
	}
	
	public void getDBConnection() {
		try {
			Driver dr=new Driver();
			DriverManager.registerDriver(dr);
			con=DriverManager.getConnection("url", "username", "password");//hard code the data in argument
		}catch(Exception e) {
			
		}
	}
	
	public void closeDBConnection() {
		try {
			con.close();
		}catch(Exception e) {
			
		}
	}
	
	public ResultSet executeSelectQuery(String Query) {
		ResultSet result=null;
		try {
			Statement stat=con.createStatement();
			result = stat.executeQuery(Query);
			
		}catch(Exception e){
			
		}
		return result;
	}
	
	public int executeNonSelectQuery(String query) {
		int result=0;
		try {
			Statement stat = con.createStatement();
			result=stat.executeUpdate(query);
		}catch(Exception e) {
			
		}
		return result;
	}

}
