package com.q1e123.NetworkResourceMonitorWeb.service;

import com.q1e123.NetworkResourceMonitorWeb.DatabaseConnection;
import com.q1e123.NetworkResourceMonitorWeb.model.Systems;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class SystemService {
    public List<Systems> getAllSystems(){
            Connection connection = null;
            List<Systems> systems = new ArrayList<>();
            try{
                connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();

                String query = "SELECT * FROM Systems";
                ResultSet resultSet = ((java.sql.Statement) statement).executeQuery(query);

                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    int systemStatus = resultSet.getInt("system_status");
                    String machineId = resultSet.getString("machine_id");

                    Systems system = new Systems(id, systemStatus, machineId);

                    systems.add(system);
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
            return  systems;
    }

    public void insertSystems(Systems systems){
        Connection connection = null;
        try{
            connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "INSERT INTO Systems(machine_id, system_status) " +
                        "VALUES ('" + systems.getMachineId() + "', 0);";
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

    public void updateSystem(Systems systems){
        Connection connection = null;
        try{
            connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "UPDATE Systems " +
                    "SET machine_id = '" + systems.getMachineId() + "' " +
                    "WHERE id = " + systems.getId() + ";";
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

    public Systems getSystemFor(String username){
        Connection connection = null;
        Systems system = null;
        try{
            connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "SELECT * " +
                        "FROM Systems " +
                        "INNER JOIN Users ON Users.system_id = Systems.id " +
                        "WHERE Users.username = '" + username + "' ;";
            ResultSet resultSet = ((java.sql.Statement) statement).executeQuery(query);
            resultSet.next();
            int id = resultSet.getInt("id");
            int systemStatus = resultSet.getInt("system_status");
            String machineId = resultSet.getString("machine_id");

            system = new Systems(id, systemStatus, machineId);
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
        return system;
    }

    public List<Systems> getActiveSystems(){
        Connection connection = null;
        List<Systems> systems = new ArrayList<>();
        try{
            connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM Systems WHERE system_status = 1;";
            ResultSet resultSet = ((java.sql.Statement) statement).executeQuery(query);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int systemStatus = resultSet.getInt("system_status");
                String machineId = resultSet.getString("machine_id");

                Systems system = new Systems(id, systemStatus, machineId);

                systems.add(system);
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
        return  systems;
    }

    public Systems getSystemWith(String machineId){
        Connection connection = null;
        Systems systems = null;
        try{
            connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "SELECT * " +
                        "FROM Systems " +
                        "WHERE machine_id = '"+ machineId +"';";
            ResultSet resultSet = ((java.sql.Statement) statement).executeQuery(query);
            resultSet.next();
            int id = resultSet.getInt("id");
            int systemStatus = resultSet.getInt("system_status");

            systems = new Systems(id, systemStatus, machineId);

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
        return systems;
    }

}
