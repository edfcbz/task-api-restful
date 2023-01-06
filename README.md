# The concept of a RESTFul API for the Food Delivery segment

This project implements the use of a RESTFull API for the Food Delivery segment. This API supports the entities necessary for research and control, such as Customers, Addresses, Restaurants and menu options, search by type of food and origin, order tracking your items and status, in addition to allowing different dishes to be ordered from different restaurants, in just one payment. In this API it is possible for a single or different delivery locations to be selected, also offering a control for the available deliverer by region and time.

## 🚀 Starting

Download the complete project by GitHub option

Search **Implantation** about project setup on development environment.

### 📋 Requisites

* 1 - MySQL Database (SGBD Tool)
* 2 - task-api-restful.zip (Source Code Downloaded from github) 

### 🔧 Development Environment Setup - DATABASE

* 2 - Install and Run the MySQL 
* 3 - Install and Run the MySQL Workbench
* 4 - Run DB_APIREST.sql by MySQL Workbench (This step will create the SCHEMA and will insert basic data into tables) 

### 🔧 Development Environment Setup - DEVELOPMENT

* 5 - Import the project on your IDE (Ex.: Eclipse)
* 6 - Locate, Config and Run the file JOOQConfig.java at path /task-api-restful/src/main/java/br/com/edfcbz/api/app/JOOQConfig.java (Project source)
* 7 - Running java class \src\main\java\br\com\edfcbz\api\Startup.java (Will start an Application Server)

## ⚙️ Testing environment
* 8 - Open browser and type: http://localhost:8080/store (This url will list all store registered in store table.

## ⚙️ Documentation Swagger
* 9 - Open browser and type: http://localhost:/swagger-ui.html (This url will open a page with and example for API use.

## ⚙️ Cache Functionality
* 10 - This RESTFul API has the cache implementation in all findAll() methods of the Control classes. For the implementation, Redis was used, which runs on localhost on port 6379 (default ) for installation and the necessary entries were made in the application.properties file, to inform Spring about the use of REDIS. To identify control classes that use caching functionality, look for the @Cacheable annotation in these classes and their methods.

## 🛠️ Building tools

* Eclipse
* Maven

## 📌 Version

* Tags in https://github.com/task-api-restful

## ✒️ Author

* **Developer** - edfcbz@gmail.com

## 📄 License

* NA
