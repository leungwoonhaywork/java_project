package week3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTest {
    public static void main(String[] args) {
        ConnectionManager.getConnection();
        ConnectionManager.closeConnection();
    }
}
