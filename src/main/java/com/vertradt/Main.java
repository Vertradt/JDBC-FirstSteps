package com.vertradt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class Main {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/postgres";


   static final String USER = "postgres";
    static final String PASS = "pawel";

    public static void main(String[] args) {
// Lączenie, insert i select do bazy
//        String url = "jdbc:postgresql://localhost/postgres";
//        Properties props = new Properties();
//        props.setProperty("user", "postgres");
//        props.setProperty("password", "pawel");
//
//
//        Connection conn = DriverManager.getConnection(url, props);
//        Statement statement = conn.createStatement();
//
//        String insertQuery = "INSERT INTO tabelka VALUES (10)";
//        statement.executeUpdate(insertQuery);
//
//
//        ResultSet rs = statement.executeQuery("SELECT id FROM tabelka");
//        rs.next();
//        System.out.println(rs.getInt("id"));
//        rs.next();
//        System.out.println(rs.getInt("id"));
//
//        tworzenie nowej tabeli
        Main main = new Main();

        try {
            main.probowałemToZrobicJakosLadnieAleNieWyszło();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());

            System.exit(0);
        }

    }

    private static final String POSTGRES_URL = "jdbc:postgresql://localhost/postgres";

    private static final String LOGIN = "postgres";

    private static final String PASSWORD = "pawel";

    String query = "Create Table Tabelka_Numer_500(name varchar)";

    private final Properties props = getUserDbCredentials();


    private void probowałemToZrobicJakosLadnieAleNieWyszło() throws SQLException {
        Connection connection = connectionEstablishing();
        Statement statement = createDbStatement(connection);
        statement.executeUpdate(query);
        connection.close();
    }

    private Properties getUserDbCredentials() {
        Properties props = new Properties();// nie znalazłem na razie nic by to co poniżej zawszeć w one-linerze

        props.setProperty("user", LOGIN);
        props.setProperty("password", PASSWORD);
        return props;
    }

    private Connection connectionEstablishing() throws SQLException {

        return DriverManager.getConnection(POSTGRES_URL,
                props);
    }


    private Statement createDbStatement(Connection c) throws SQLException {
        return c.createStatement();
    }


}