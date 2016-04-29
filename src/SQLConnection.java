import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
	
	private static SQLConnection sqlConnection = null;
	private static String database = "Persona.sql";
	private static String us = "root";
	private static String pass = "";
	private static String url = "jdbc:mysql://localhost:3306/"+database;
	private static Connection connection = null;
	
	private SQLConnection(){
		try{
			Class.forName("com.mysql.jdbc.Connection");
			connection = (Connection)DriverManager.getConnection(url, us , pass);
		}
		catch(SQLException e){
			System.out.println("Cannot connect to the DB "+url);
		}
		catch (ClassNotFoundException e){
			System.out.println(e);
		}		
	}
	
	public static SQLConnection getInstance(){
		if(connection == null)
			sqlConnection = new SQLConnection();
		else
			System.out.println("Connection to DB "+url+" is already running");
		return sqlConnection;
					
	}
	public String getState(){
		String state="Close";
		if (connection !=null)
			state="Stablished";
		return state;
	}
	public void closeConnection(){
		if(connection!=null)
			try{
				connection.close();
				System.out.println("Connection has been closed.");
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		else
			System.out.println("DB connection was not established");
	}

}
