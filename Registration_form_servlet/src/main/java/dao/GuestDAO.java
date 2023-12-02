
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import model.Guest;

public class GuestDAO {

	private static final String INSERT_QUERY = "INSERT INTO guests (first_name,last_name,email,password) VALUES (?,?,?,?)";


public boolean insertGuest(Guest guest) throws ClassNotFoundException{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/conference","root","password");
		
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
				
		preparedStatement.setString(1, guest.getFirst_name());
		preparedStatement.setString(2, guest.getLast_name());
		preparedStatement.setString(3, guest.getEmail());
		preparedStatement.setString(4, guest.getPassword());
		
		System.out.println("preparedStatement"+" "+preparedStatement);
		
		int rowAffected = preparedStatement.executeUpdate();
		return rowAffected > 0;
	}catch(Exception e) {
		e.printStackTrace();
		return false;
	}
	
}
}
