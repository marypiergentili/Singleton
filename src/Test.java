
public class Test {
	
	public static void main (String[] arg){
		
		//creating an instance of the FakeConnection class		
		FakeConnection fakeConnect= FakeConnection.getInstance();
		
		//getting the state on the connection
		String connectionState = fakeConnect.getState();
		System.out.println("The DB is "+connectionState);
		
		//creating an other instance of the FakeConnection class
		FakeConnection fakeConnect2 = FakeConnection.getInstance();
		
		//closing the connection created 
		fakeConnect.closeConnection();
		System.out.println("Connection's state is "+fakeConnect.getState());
		
		//creating now the second instance of the FakeConnection class
		fakeConnect2 = FakeConnection.getInstance();
		System.out.println("New connection is now "+fakeConnect2.getState());
		
		//trying to connect to the real DB
		SQLConnection sqlConnection= SQLConnection.getInstance();
		//getting the state of the connection
		System.out.println("The DB connection is "+sqlConnection.getState());
		//trying to close the connection if it was established
		sqlConnection.closeConnection();
		
	}

}
