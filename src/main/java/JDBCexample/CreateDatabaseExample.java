package JDBCexample;

import java.sql.*;

public class CreateDatabaseExample {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "MXJGH1999";
        String databaseName = "harexiluo";

        Connection connection = null;
        Statement statement = null;

        try {
            // 建立与数据库的连接
            connection = DriverManager.getConnection(url, username, password);

            // 创建数据库
            statement = connection.createStatement();
            String createDatabaseSQL = "CREATE DATABASE " + databaseName;
            statement.executeUpdate(createDatabaseSQL);
            System.out.println("Database created successfully.");

            // 切换到新创建的数据库
            String useDatabaseSQL = "USE " + databaseName;
            statement.execute(useDatabaseSQL);

            // 创建表
            String createTableSQL = "CREATE TABLE users (id INT PRIMARY KEY, name VARCHAR(50), age INT)";
            statement.executeUpdate(createTableSQL);
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}



