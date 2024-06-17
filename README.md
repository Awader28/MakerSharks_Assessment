# Required Steps to Run the Application and CURLS

### 1. Register a User
```bash
curl -X POST http://localhost:8080/api/users/register -H "Content-Type: application/json" -d '{
  "username": "Roshan_Mathew",
  "email": "rmrf@example.com",
  "password": "password123"
}'
```
### 2. Retrieve All Users
```bash
curl -X GET http://localhost:8080/api/users
```
### 3. Retrieve User by ID
Replace `{id}` with the actual ID of the user you want to fetch.
```bash
curl -X GET http://localhost:8080/api/users/{id}
```
### 4. Retrieve User by Username
Replace `{username}` with the actual username of the user you want to fetch.
```bash
curl -X GET http://localhost:8080/api/users/username/{username}
```

### 5. Update a User
Replace `{id}` with the actual ID of the user you want to update. 
```bash
curl -X PUT http://localhost:8080/api/users/{id} -H "Content-Type: application/json" -d '{
  "username": "krnmutha",
  "email": "karan@example.com",
  "password": "updatedPassword"
}'
```
### 6. Delete a User
Replace `{id}` with the actual ID of the user you want to delete.
```bash
curl -X DELETE http://localhost:8080/api/users/{id}
```
### 7. MySQL Schema
```mysql
use test_db;
create table registration(
	user_id int primary key not null auto_increment, 
    username varchar(245),
    email_id varchar(245),
    password varchar(234)
);
```
### 8. Build and Run the Application
You can build and run the application using Maven:
```bash
mvn clean install
java -jar target/MakerSharksTest-0.0.1-SNAPSHOT.jar
```
Alternatively, you can run it directly from your IDE by running the main class YourProjectApplication.
