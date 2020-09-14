package com.q1e123.NetworkResourceMonitorWeb.service;

import com.q1e123.NetworkResourceMonitorWeb.DatabaseConnection;
import com.q1e123.NetworkResourceMonitorWeb.model.CpuUsage;
import com.q1e123.NetworkResourceMonitorWeb.model.UserList;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserListService {
    public List<UserList> getUserListFor(int usageId){
        Connection connection = null;
        List<UserList> userListList = new ArrayList<>();
        try{
            connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "SELECT * " +
                    "FROM User_List " +
                    "WHERE usage_id = " + usageId;
            ResultSet resultSet = ((java.sql.Statement) statement).executeQuery(query);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                java.sql.Date lastLogin = resultSet.getDate("last_login");

                UserList userList = new UserList(id, username, lastLogin, usageId);
                userListList.add(userList);
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
        return userListList;
    }
}
