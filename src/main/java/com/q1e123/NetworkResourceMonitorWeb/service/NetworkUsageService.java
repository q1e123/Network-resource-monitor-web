package com.q1e123.NetworkResourceMonitorWeb.service;

import com.q1e123.NetworkResourceMonitorWeb.DatabaseConnection;
import com.q1e123.NetworkResourceMonitorWeb.model.CpuUsage;
import com.q1e123.NetworkResourceMonitorWeb.model.NetworkUsage;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class NetworkUsageService {
    public List<NetworkUsage> getNetworkUsageFor(int usageId){
        Connection connection = null;
        List<NetworkUsage> networkUsageList = new ArrayList<>();
        try{
            connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            String query = "SELECT * " +
                    "FROM Network_Usage " +
                    "WHERE usage_id = " + usageId;
            ResultSet resultSet = ((java.sql.Statement) statement).executeQuery(query);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String interfaceName = resultSet.getString("interface_name");
                double rx = resultSet.getDouble("rx");
                double tx = resultSet.getDouble("tx");
                String ipv4 = resultSet.getString("ipv4");

                NetworkUsage networkUsage = new NetworkUsage(id, interfaceName, rx, tx, ipv4, usageId);
                networkUsageList.add(networkUsage);
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
        return networkUsageList;
    }
}
