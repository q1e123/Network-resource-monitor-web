# Network resource monitor web application
This is the web application for the [Network Resouce Monitor](https://github.com/q1e123/Network-resource-monitor).

## Technologies
* Java
* Spring Boot
* Spring Security
* JDBC
* MySql-connector
* Thymeleaf
* jQuery

## Features
### Login
* Using username and machine_id from desktop app database

### Rest services
* Get all systems
* Get all users
* Get Usage Data
* Get User List
* Get Cpu Usage
* Get Environment Variables
* Get Network Usage

### System management
* Add new system
* Modify current systems
* See what systems are on/off 

### User management
* Add new user
* Modify current users 

### My machine
* Real time tracking of:
    * Operating System
    * Current user
    * Avalabile space
    * RAM (total, used, avalabile)
    * Cpu usage (per core)
    * Network usage (per interface)
    * IPv4 / interface
    * Last login for every user
    * Environment variables
* Check if a software is installed

## Usage
### Init
You need to create a database_secret and a  application.properties  file where you need to put username and password for Network resource monitor desktop app
database.  

Templates for the files are provided in their locations.

### Build
The project comes with gradle files. Use those to build the project.