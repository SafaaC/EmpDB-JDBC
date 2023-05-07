package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpDate {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emps", "root", "root");
		
			//Giving Date as an input to DB
			PreparedStatement p = c.prepareStatement("update emp set doj=? where id=?");
			p.setDate(1, Date.valueOf("2023-02-16"));
			p.setInt(2, 1);
			p.execute();
			
	 		c.close();
		}
		catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		System.out.println("DONE");
	}

}
