package db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Database {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        }
        InputStream inputStream = Database.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            String url = "jdbc:postgresql://localhost/" + properties.getProperty("database");
            Class.forName(properties.getProperty("driver"));
            connection = DriverManager.getConnection(url, properties.getProperty("user"), properties.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}
