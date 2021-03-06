package com.q1e123.NetworkResourceMonitorWeb.service;

import com.q1e123.NetworkResourceMonitorWeb.DatabaseConnection;
import com.q1e123.NetworkResourceMonitorWeb.model.Systems;
import com.q1e123.NetworkResourceMonitorWeb.model.Users;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {
    public List<Users> getAllUsers(){
        Connection connection = null;
        List<Users> usersList = new ArrayList<>();
        try{
            connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM Users";
            ResultSet resultSet = ((java.sql.Statement) statement).executeQuery(query);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                int userRole = resultSet.getInt("user_role");
                int systemId = resultSet.getInt("system_id");

                Users users = new Users(id, username, userRole, systemId);

                usersList.add(users);
            }

            ((java.sql.Statement) statement).close();
            resultSet.close();
        }catch (SQLException exception){
            exception.printStackTrace();
            java.lang.System.out.println(exception.getMessage());
        }finally {
            try{
                connection.close();
            }catch (SQLException exception){
                exception.printStackTrace();
            }
        }
        return usersList;
    }

    public void insertUser(Users users){
        Connection connection = null;
        try{
            connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "INSERT INTO Users(username, user_role, system_id) " +
                    "VALUES ('" + users.getUsername() + "', " + users.getUserRole() + ", " + users.getSystemId() + ");";
            ((java.sql.Statement) statement).executeUpdate(query);
            ((java.sql.Statement) statement).close();
        }catch (SQLException exception){
            exception.printStackTrace();
            java.lang.System.out.println(exception.getMessage());
        }finally {
            try{
                connection.close();
            }catch (SQLException exception){
                exception.printStackTrace();
            }
        }
    }

    public void updateUser(Users users){
        Connection connection = null;
        try{
            connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "UPDATE Users " +
                    "SET username = '" + users.getUsername() + "' , user_role = " + users.getUserRole() + ", system_id  = " + users.getSystemId() + " "+
                    "WHERE id = " + users.getId() + ";";
            ((java.sql.Statement) statement).executeUpdate(query);
            ((java.sql.Statement) statement).close();
        }catch (SQLException exception){
            exception.printStackTrace();
            java.lang.System.out.println(exception.getMessage());
        }finally {
            try{
                connection.close();
            }catch (SQLException exception){
                exception.printStackTrace();
            }
        }
    }
}
