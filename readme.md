Java OOP Fundamentals 

- project structure 
- working with objects 
- creating methods on the fly 
- reading i/p and giving o/p 

- Java Memory Mgmt 
  - local and instance variables 
  - Heap and Stack 
  - Encapsulation 

- Inheritance 
  - abstract class 
  - interfacing 
  - polymorphism 
  - constructor
  - static <?>

- Exception Handling 

- Collections Framework 
  - List: ArrayList, Vector, LinkedList 
     Key Points:  
     - ArrayList is fastest class. 
     - LinkedList used nodes and links all elements hence updation, sorting etc.. are expensive. 
     - ArrayList doesnot support multithreading, hence we must use Vector if we are going to create multiple threads.  
  
  - Map:  HashMap, Hashtable, LinkedHashMap
    Key Points: 
    - HashMap is fastest of all  Map classes. 
    - Hashtable supports multi-threading 
    - LinkedHashMap used Linked structure hence it is slower for few operations like delete, edit etc. 
  
- Set:  TreeSet, HashSet 
    Key Points: 
   - TreeSet is by default sorted. so if you save model objects in it, you must implement Comparable interface. 
  
  - Comparable and Comparator 

- Set up the DB 
 - JDBC api
 - CRUD 

- Java Streams and Lambda Expressions 

- Unit Testing using JUnit Framework 
 
- DB Programming 
	- Single table queries : group by, having clauses 
	- DB design - EER 
	- Multi table Queries 
		- Manual Mapping 
		- Joins 
		- Nested Queries 
	
- JPA/Hibernate Framework 

-  Persistence API 
- Hibernate ORM : Object Relational Model 
	- Configuring Hibernate Project
	- creating entity classes (1:M / M:1)
	- Using EntityManager methods 

- Spring Framework
	- Set Up the project
	- REST API 
	- Security Config 