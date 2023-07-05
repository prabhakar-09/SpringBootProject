# SpringBootProject

1. Configurations:
   -> Starting from configurations, here no specific configurations are needed for the DB connectivity.
   -> Easy going walkthrough, here you don't need to connect to any DB as it performs all the CRUD operations using the inbuilt ArrayLists.(Note: Your changes are           lost every time you restart the server or system).
   -> Dependencies :
     1. org.springframework.boot (Version: 3.1.0)
     2. Java (Version: 17)
     3. spring-boot-starter-web (Web starter dependency)
     4. jackson-dataformat-xml (Version: 2.15.2) for content negotiation.
     5. spring-boot-maven-plugin (Maven = Build Tool)
      
  2. Project Walkthrough
     1. com.myspringproject.springbootproject (Package)
        -> This package contains a 'SpringBootProjectApplication' class which is responsible for bootstrapping the spring boot application. Annotated with         
           '@SpringBootApplication'.
        
     2. com.myspringproject.springbootproject.config (Package)
        -> Contains a class 'WebConfig' which overrides 'WebMvcConfigurationSupport' (Inbuilt spring class for *content negotiation*). This returns the content in 
            the requested data format (XML || JSON).
        
     3. com.myspringproject.springbootproject.controller (Package)
        -> This package has 3 controller classes:
          1. 'EmployeeController' important controller class which connects to all the layers and fully functions with all the CRUD operations. It has the API                     version 'v1' which is API versioning.
          2. 'EmployeeV2Controller' the sole purpose of this class is to explain the API versioning. (More info in the comments of the class file).
          3. 'HomeController' explains all the basic properties like Req Mapping, Get Mapping, Path Params, Path Variables etc. Run on a browser with the port                     number.
             
      4. com.myspringproject.springbootproject.errors (Package)
         -> This package contains two classes that are responsible for handling the custom errors/exceptions.
          1. 'EmployeeNotFoundException' which extends the generic class 'RuntimeException' throws exceptions.
          2. 'RestResponseEntityExceptionHandler' extends 'ResponseEntityExceptionHandler' custom messages for more clarity on the errors to the users.
             
      5. com.myspringproject.springbootproject.model (Package)
         -> This package has 3 classes:
          1. 'Employee' This basically is a POJO here we create different fields to get and set the values. (Refer class file for more info)
          2. 'ErrorMessage' custom error message POJO which is linked to the previous package in the .erros package.
          3. 'User' basic POJO for simple operations linked to the HomeController class.
             
      8. com.myspringproject.springbootproject.service (Package)
         -> This package is considered the service layer and is linked to the EmployeeController it has one interface and one class.
         1. 'EmployeeService' defines all the interface methods which are to be implemented in the 'Impl' class.
         2. 'EmployeeServiceImpl' here goes the business logic and implementation of all the methods defined in the service layer (Refer to class file for more                  info).
