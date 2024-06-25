package databaseeex;

import java.sql.*;

public class ConnectionManager {

    private static String server = "jdbc:mysql://localhost/my_db";
    private static String username = "root";
    private static String password = "";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            connection = logOn();
        }
        return connection;
    }

    private static Connection logOn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Successful connection");
            return DriverManager.getConnection(server, username, password);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            System.out.println("Failed connection: " + e.toString());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.err);
            System.out.println("JDBC, ODBC driver not found");
        }
        return null;
    }

    public void logOff() {
        try {
            connection.close();
            System.out.println("Closed connection");
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
    
    public static void main(String[] args) {
        getConnection();
    }
}
