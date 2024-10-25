import java.sql.*;

public class JdbcCrudExample {

    // Database connection details
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Modify with your DB URL
    static final String USER = "vikram"; // Replace with your DB username
    static final String PASS = "system"; // Replace with your DB password
    static final String QUERY_SELECT = "SELECT * FROM EMPLOYEES";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // 1. Register the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 2. Open a connection
            System.out.println("Connecting to the database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 3. Execute a query to create a statement object
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            // 4. Perform CRUD operations

            // Create - Insert a new record
            String sqlInsert = "INSERT INTO EMPLOYEES (ID, NAME, SALARY) VALUES (1, 'John Doe', 30000)";
            stmt.executeUpdate(sqlInsert);
            System.out.println("Record inserted!");

            // Read - Select and display data from the table
            System.out.println("Reading data from EMPLOYEES table...");
            ResultSet rs = stmt.executeQuery(QUERY_SELECT);
            while (rs.next()) {
                // Retrieve data by column name
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                double salary = rs.getDouble("SALARY");

                // Display values
                System.out.print("ID: " + id);
                System.out.print(", Name: " + name);
                System.out.println(", Salary: " + salary);
            }

            // Update - Update an existing record
            String sqlUpdate = "UPDATE EMPLOYEES SET SALARY = 35000 WHERE ID = 1";
            stmt.executeUpdate(sqlUpdate);
            System.out.println("Record updated!");

            // Delete - Delete a record
            String sqlDelete = "DELETE FROM EMPLOYEES WHERE ID = 1";
            stmt.executeUpdate(sqlDelete);
            System.out.println("Record deleted!");

            // 5. Clean-up the environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // Finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        System.out.println("Goodbye!");
    }
}

// import java.sql.*;

// public class JdbcExample {
// public static void main(String[] args) {
// try {
// // Load the Oracle JDBC driver
// Class.forName("oracle.jdbc.OracleDriver");

// // Create a connection to the Oracle database
// Connection conn =
// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
// "username",
// "password");

// // Your CRUD operations here

// // Close the connection
// conn.close();
// } catch (Exception e) {
// e.printStackTrace();
// }
// }
// }
