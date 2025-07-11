package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/pos"; // Change DB URL
    private static final String USER = "user_name"; // Change DB username
    private static final String PASSWORD = "password"; // Change DB password

    /**
     * Establishes a connection to the database.
     * @return Connection object
     * @throws SQLException if a database access error occurs
     */
    public  static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

