package org.example.db;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    private static final String URL = "jdbc:postgresql://localhost:5432/car_shop";
    private static final String USER = "admin";
    private static final String PASSWORD = "passwordP";
    //private static final String URL = "jdbc:postgresql://localhost:5432/car_shop";
//    private static final String USER = "user";
//    private static final String PASSWORD = "password";
    public Connection connection;
    public Statement statement;

    public DataBase() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("SQL  " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            Database database =
                    DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
            Liquibase liquibase =
                    new Liquibase("db/changelog/changelog.xml", new ClassLoaderResourceAccessor(), database);
            liquibase.update();
            System.out.println("Migration is completed successfully");
        } catch (LiquibaseException e) {
            System.out.println("SQL Exception in migration " + e.getMessage());
            e.printStackTrace();
        }
    }
}

