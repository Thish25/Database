package Test.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Database 
{
	
	public void databaseConnection() throws ClassNotFoundException {
		
		String dbClass = "com.mysql.jdbc.Driver";
		Class.forName(dbClass);
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "xyz");
			Statement statement = connection.createStatement();
			String query = "SELECT `current_dept_emp`.`emp_no`, `current_dept_emp`.`dept_no`, `employees`.birth_date, `employees`.`first_name` FROM current_dept_emp\n" + 
					"JOIN `employees` ON current_dept_emp.`emp_no`= employees.`emp_no` AND `current_dept_emp`.`emp_no`<10010\n" + 
					"ORDER BY `employees`.`first_name`";
			ResultSet rs = statement.executeQuery(query);	
			
			while (rs.next()) {
				System.out.print("Current Employee No: "+ rs.getString(1) + "   Current dept No: " + rs.getString(2) + "   Employees Birthdate: "+ rs.getString(3) + "   Employees FirstName: " + rs.getString(4));
				System.out.println();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Database con = new Database();
        try {
			con.databaseConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
    }
}
