package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpCallableStatement {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emps", "root", "root");
			/*CallableStatement cs=c.prepareCall("call getalldata()");
			ResultSet r= cs.executeQuery();
			while(r.next()) {
				System.out.println(r.getInt(1));
				System.out.println(r.getString(2));
				System.out.println(r.getDate(3));
				System.out.println("----------------");
			}
			*/
			
			/*CallableStatement cs=c.prepareCall("call getbyid(2)");
			ResultSet r= cs.executeQuery();
			while(r.next()) {
				System.out.println(r.getInt(1));
				System.out.println(r.getString(2));
				System.out.println(r.getDate(3));
				System.out.println("----------------");
			}*/
			
			/*CallableStatement cs=c.prepareCall("call getbyname('safaa')");
			ResultSet r= cs.executeQuery();
			while(r.next()) {
				System.out.println(r.getInt(1));
				System.out.println(r.getString(2));
				System.out.println(r.getDate(3));
				System.out.println("----------------");
			}*/
			
			CallableStatement cs=c.prepareCall("call getbynameanddoj('sheenu','2023-03-25')");
			ResultSet r= cs.executeQuery();
			while(r.next()) {
				System.out.println(r.getInt(1));
				System.out.println(r.getString(2));
				System.out.println(r.getDate(3));
				System.out.println("----------------");
			}
	 		c.close();
		}
		catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		System.out.println("DONE");
	}

}
