
package org.tz.pos.Lagerverwaltung;

import java.sql.*;


public class MySql {
	
	

	public static void sqlAbfrage(String statement) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/warehouse", "root", "");
			
			java.sql.Statement myStatement = con.createStatement();
			
			ResultSet myResultSet = myStatement.executeQuery(statement);
					
			while (myResultSet.next()) {
			
			System.out.println(myResultSet.getString(1)+"\t"+ myResultSet.getString(2));
			
			}
			
			
		}catch (SQLException | ClassNotFoundException ex ) {
			System.out.println("SQLException: " + ex.getMessage());
			
			
		}
	}

public static void main(String[] args) {
	sqlAbfrage("Select * from artikel");
}


}
	

	
	
	
	
