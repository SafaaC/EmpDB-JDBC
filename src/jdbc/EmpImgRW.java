package jdbc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpImgRW {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emps", "root", "root");
			
			// inserting image into the database
			
		
		/*	PreparedStatement p = c.prepareStatement("insert into emp (image) values (?)");
			FileInputStream f = new FileInputStream("C:\\Users\\win10\\Desktop\\img.jpeg");
			p.setBlob(1, f);
			p.execute();           */
			
			
			//retrieving image from database
			
			PreparedStatement p = c.prepareStatement("select * from emp where id=2");
			ResultSet r= p.executeQuery();
			while(r.next()) {
				Blob b=r.getBlob(4);
				byte[] by=b.getBytes(1, (int)b.length());
				FileOutputStream f=new FileOutputStream("C:\\Users\\win10\\Desktop\\jdbc\\hi");
				f.write(by);
				f.close();	
			}
			
	 		c.close();
		} catch (IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println("DONE");
	}

}
