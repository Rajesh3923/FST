import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseApp {
    // JDBC URL, username, and password of MySQL server
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";     // replace with your MySQL username
    static final String PASSWORD = "root"; // replace with your MySQL password

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // 1. Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Open a connection
            System.out.println("Connecting to MySQL server...");
            conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            stmt = conn.createStatement();

            // 3. Create the 'cse' database
            String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS cse2";
            stmt.executeUpdate(createDatabaseSQL);
            System.out.println("Database 'cse2' created successfully.");

            // 4. Connect to the 'cse2' database
            conn = DriverManager.getConnection(JDBC_URL + "cse2", USER, PASSWORD);
            stmt = conn.createStatement();

            // 5. Create the 'student' table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS student ("
                    + "rno INT PRIMARY KEY, "
                    + "name VARCHAR(50), "
                    + "age INT, "
                    + "department VARCHAR(50)"
                    + ")";
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'student' created successfully.");

            // 6. Insert sample records into the 'student' table
            String insertDataSQL = "INSERT INTO student (rno,name, age, department) VALUES "
                    + "(1,'Alice', 20, 'Computer Science'), "
                    + "(2,'Bob', 22, 'Information Technology'), "
                    + "(3,'Charlie', 21, 'Electronics')";
            int rowsInserted = stmt.executeUpdate(insertDataSQL);
            System.out.println(rowsInserted + " records inserted into the 'student' table.");

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // 7. Close resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
