
public class FakeConnection {
	
	private static FakeConnection connection = null;
	
	protected FakeConnection (){
		
	}
	
	public static FakeConnection getInstance(){
		if(connection == null)
			connection= new FakeConnection();
		else
			System.out.println("Connection has already been stablished");
		return connection;
	}
	public String getState (){
		String state = "Connected";
		if (connection == null)
			state = "Not connected";
		return state;
	}
	public void closeConnection(){
		if (connection != null)
			connection = null;
	}
	

}
