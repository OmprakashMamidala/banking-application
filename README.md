# BANKING-APPLICATION
simple version of Banking App with basic functionalities: creating a bank account, fetching account details, and making a deposit/withdrawal.
Project: Maven Project 
Language: Java 
Packaging: Jar 
Java version: 17
Dependencies: Spring Web, Spring Data JPA, MySQL Driver
DataBase:MY SQL

Run and Test Application
Navigate to the main application class (with @SpringBootApplication annotation) and run it as a Java application.

1. Create a new bank account: 
HTTP Method: POST 

URL: http://localhost:8080/api/accounts 
![image](https://github.com/OmprakashMamidala/banking-application/assets/150418876/6f72b19d-61a1-4bc8-a268-7e56957b6122)

2. Fetch the details of a specific account: 
HTTP Method: GET 

URL: http://localhost:8080/api/accounts/{id} (Replace {id} with the actual ID of the account you want to fetch.)
![image](https://github.com/OmprakashMamidala/banking-application/assets/150418876/a1c26cba-a9a8-4aaa-82e9-d3e184ecc3ed)


3. Deposit money into an account: 
HTTP Method: POST 
URL: http://localhost:8080/api/accounts/{id}/deposit (Replace {id} with the actual ID of the account you want to deposit money into.) 
![image](https://github.com/OmprakashMamidala/banking-application/assets/150418876/fe4410c1-d7c8-4eda-afa7-ec0ca9178cf2)

4. Withdraw money from an account: 
HTTP Method: POST 

URL: http://localhost:8080/api/accounts/{id}/withdraw (Replace {id} with the actual ID of the account you want to withdraw money from.) 
![image](https://github.com/OmprakashMamidala/banking-application/assets/150418876/b73a3b44-191e-40ac-bb42-01770999f7ef)
