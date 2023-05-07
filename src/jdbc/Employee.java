package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Employee {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","root");
			Statement statement =connection.createStatement();
			//statement.execute("insert into employee values(20,'hayat',65000,'9886614410','hydrabad')");
			//statement.execute("delete from employee where id=1");
			
			System.out.printf("%10s%10s%20s%20s%15s","id","Name","Salary","Phone no","Location");
			System.out.println();
			System.out.println("---------------------------------------------------");
			ResultSet r=statement.executeQuery("select * from employee limit 1,4");
			while(r.next()) {
				System.out.printf("%10s%10s%20s%20s%15s",r.getInt(1),r.getString(2),r.getInt(3),r.getString(4),r.getString(5));
				System.out.println();
				/*System.out.println(r.getInt(1));
				System.out.println(r.getString(2));
				System.out.println(r.getInt(3));
				System.out.println(r.getString(4));
				System.out.println(r.getString(5));
				System.out.println("---------");*/
			}
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
