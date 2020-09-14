package com.q1e123.NetworkResourceMonitorWeb.service;

import com.q1e123.NetworkResourceMonitorWeb.DatabaseConnection;
import com.q1e123.NetworkResourceMonitorWeb.model.CpuUsage;
import com.q1e123.NetworkResourceMonitorWeb.model.EnvironmentVariables;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class CpuUsageService {
    public List<CpuUsage> getCpuUsageFor(int usageId){
        Connection connection = null;
        List<CpuUsage> cpuUsageList = new ArrayList<>();
        try{
            connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "SELECT * " +
                    "FROM Cpu_Usage " +
                    "WHERE usage_id = " + usageId;
            ResultSet resultSet = ((java.sql.Statement) statement).executeQuery(query);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String cpuNamee = resultSet.getString("cpu_name");
                double usage = resultSet.getDouble("cpu_usage");

                CpuUsage cpuUsage = new CpuUsage(id, cpuNamee, usage, usageId);
                cpuUsageList.add(cpuUsage);
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
        return cpuUsageList;
    }
}
