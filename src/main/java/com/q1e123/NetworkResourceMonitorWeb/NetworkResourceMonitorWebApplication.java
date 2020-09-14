package com.q1e123.NetworkResourceMonitorWeb;

import com.q1e123.NetworkResourceMonitorWeb.model.DatabaseConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NetworkResourceMonitorWebApplication {

	public static void main(String[] args) {
		DatabaseConnection.init();
		SpringApplication.run(NetworkResourceMonitorWebApplication.class, args);
	}

}
