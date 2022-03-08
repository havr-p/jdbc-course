import java.sql.*;

public class JDBCTest {
	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//get a connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student" , "student");
			System.out.println("Database connection succesful");
			//create a statement
			stmt = conn.createStatement();
			//execute SQL query
			rs = stmt.executeQuery("select * from employees");
			//process the result set
			while (rs.next()) {
				System.out.println(rs.getString("last_name") + ", " + rs.getString("first_name"));				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

}
