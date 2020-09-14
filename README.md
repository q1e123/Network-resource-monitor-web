# Network resource monitor web application
This is the web application for the [Network Resouce Monitor](https://github.com/q1e123/Network-resource-monitor).

# Dependencies
* Spring Boot
* Spring Security
* JDBC
* MySql-connector


# Features
## Login
* Using username and machine_id from desktop app database

## Rest Services
* Get all systems
* Get all users
* Get Usage Data
* Get User List
* Get Cpu Usage
* Get Environment Variables
* Get Network Usage


# Usage
## Init
You need to create a database_secret file where you need to put username and password for Network resource monitor desktop app
database.  
You need to create a application.properties file where you need to put username and password for Spring Database.

## Build
The project comes with gradle files. Use those to build the project.