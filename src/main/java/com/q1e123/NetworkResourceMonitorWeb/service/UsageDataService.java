package com.q1e123.NetworkResourceMonitorWeb.service;

import com.q1e123.NetworkResourceMonitorWeb.DatabaseConnection;
import com.q1e123.NetworkResourceMonitorWeb.model.UsageData;
import com.q1e123.NetworkResourceMonitorWeb.model.Users;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UsageDataService {
    public UsageData getUsageDataFor(String machineId){
        Connection connection = null;
        UsageData usageData = null;
        try{
            connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "SELECT * " +
                        "FROM Usage_Data " +
                        "WHERE system_id = (SELECT  id FROM Systems WHERE machine_id = '" + machineId + "') " +
                        "ORDER BY usage_timestamp DESC " +
                        "LIMIT 1";
            System.out.println(query);
            ResultSet resultSet = ((java.sql.Statement) statement).executeQuery(query);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int totalRam = resultSet.getInt("total_ram");
                int usedRam = resultSet.getInt("used_ram");
                int freeRam = resultSet.getInt("free_ram");
                double avalabileSpace = resultSet.getDouble("avalabile_space");
                java.sql.Date usageTimestamp = resultSet.getDate("usage_timestamp");
                String username = resultSet.getString("username");
                String operatingSystem = resultSet.getString("operating_system");
                String programListString = resultSet.getString("program_list");
                int system_id = resultSet.getInt("system_id");

                List<String> programList = new ArrayList<String>(Arrays.asList(programListString.split(",")));

                usageData = new UsageData(id, totalRam, usedRam, freeRam, avalabileSpace, usageTimestamp, username,
                                            operatingSystem, programList, system_id);

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
        return usageData;
    }
}
