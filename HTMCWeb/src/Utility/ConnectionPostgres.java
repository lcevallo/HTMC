package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPostgres {

	private static Connection conn;

		
	
	public static Connection getConn() {
		return conn;
	}



	public static void setConn(Connection conn) {
		ConnectionPostgres.conn = conn;
	}

	public static Connection Conectar()
	{
	 
		try {
			Class.forName("org.postgresql.Driver");
			String url = MyUtil.getDRIVER_POSTGRES();
			Properties props = new Properties();
			props.setProperty("user", MyUtil.getUSUARIO());
			props.setProperty("password", MyUtil.getCLAVE());
			conn = DriverManager.getConnection(url, props);
			return conn;
		} catch (ClassNotFoundException e) {
					e.printStackTrace();
		}
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}//fin del metodo Conectar
 
	
	
}
