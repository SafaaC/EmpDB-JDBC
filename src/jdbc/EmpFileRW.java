package jdbc;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpFileRW {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emps", "root", "root");

			//reading from file 
			
		/*   PreparedStatement preparedStatement = connection.prepareStatement("insert into emp(resume) values(?)"); 
			 FileReader f =new FileReader("C:\\Users\\win10\\Desktop\\text.txt") ;
			 preparedStatement.setClob(1,f);
			 preparedStatement.execute();		*/
			
			
			//Retrieving file from db
			
			PreparedStatement p = connection.prepareStatement("select * from emp where id=1");
			ResultSet r = p.executeQuery();
			while (r.next()) {
				Reader re = r.getCharacterStream(5);// 5 is the column position
				int ch = re.read();
				while (ch != -1) {
					System.out.print((char) ch);
					ch = re.read();
				}
			}

			connection.close();
		} catch (IOException | SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("done");
	}

}
