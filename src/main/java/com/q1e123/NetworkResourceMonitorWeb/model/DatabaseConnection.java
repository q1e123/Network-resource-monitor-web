package com.q1e123.NetworkResourceMonitorWeb.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class DatabaseConnection {

    static private String user;
    static private String password;

    static public void init(){
        List<String> lines = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("database-secret"));
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        DatabaseConnection.user = lines.get(0);
        DatabaseConnection.password = lines.get(1);
    }

    static public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/Siemens?serverTimezone=UTC", user, password);
    }
}
