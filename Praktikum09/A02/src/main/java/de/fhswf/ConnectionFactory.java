package de.fhswf;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
        public static Connection getConnection() {
            try {
                return DriverManager.getConnection("jdbc:sqlite:fh.sqlite");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public static void close(Connection conn) {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
}
