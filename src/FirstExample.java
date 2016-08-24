import java.sql.*;

/**
 * Created by youngz on 16-8-20.
 */
public class FirstExample {
    //jdbc driver name and database URL;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/EMP";
    //Database credentials
    static final String USER = "root";
    static final String PASS = "yz9406";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STET 2:Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //3:Open a connectioin
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //4:Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id,first,last,age FROM Employess";
            ResultSet rs = stmt.executeQuery(sql);

            //5:Extract data from result set;
            while (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
            //6:Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {

            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
