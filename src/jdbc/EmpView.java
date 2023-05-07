package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpView {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emps", "root", "root");
		
			
			// we can use any statement while using view

			CallableStatement cs=c.prepareCall("select * from idandname ");
			ResultSet r= cs.executeQuery();
			while(r.next()) {
				System.out.println(r.getInt(1));
				System.out.println(r.getString(2));
				System.out.println("----------------");
			
			}
			/*
			PreparedStatement p=c.prepareStatement("select * from febemp ");
			ResultSet r= p.executeQuery();
			while(r.next()) {
				System.out.println(r.getInt(1));
				System.out.println(r.getString(2));
				System.out.println(r.getDate(3));
				System.out.println("----------------");
			
			}*/
			/*PreparedStatement p=c.prepareStatement("select * from namestartingwiths ");
			ResultSet r= p.executeQuery();
			while(r.next()) {
				System.out.println(r.getInt(1));
				System.out.println(r.getString(2));
				System.out.println(r.getDate(3));
				System.out.println("----------------");
			
			}*/
	 		c.close();
		}
		catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		System.out.println("DONE");
	}
}
