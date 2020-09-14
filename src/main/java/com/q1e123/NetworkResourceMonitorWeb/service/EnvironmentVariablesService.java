package com.q1e123.NetworkResourceMonitorWeb.service;

import com.q1e123.NetworkResourceMonitorWeb.DatabaseConnection;
import com.q1e123.NetworkResourceMonitorWeb.model.EnvironmentVariables;
import com.q1e123.NetworkResourceMonitorWeb.model.Users;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class EnvironmentVariablesService {
    public List<EnvironmentVariables> getEnvironmentVariablesFor(int usageId){
        Connection connection = null;
        List<EnvironmentVariables> environmentVariablesList = new ArrayList<>();
        try{
            connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "SELECT * " +
                        "FROM Environment_Variables " +
                        "WHERE usage_id = " + usageId;
            ResultSet resultSet = ((java.sql.Statement) statement).executeQuery(query);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String variable = resultSet.getString("variable");
                String variableValue = resultSet.getString("variable_value");
                int _usageId = resultSet.getInt("usage_id");
                EnvironmentVariables environmentVariables = new EnvironmentVariables(id, variable, variableValue, _usageId);

                environmentVariablesList.add(environmentVariables);
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
        return environmentVariablesList;
    }
}
