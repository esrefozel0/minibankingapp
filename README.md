# Mini Banking App
This project provides the backend APIs for a mini banking application.

The project is developed using Java and Spring Boot. You can download the project files and open them in a Java IDE. Before running the project, you should create a PostgreSQL database and configure your database connection details in the application.properties file.

You can start the PostgreSQL database using Docker with the following command:
# Running Container

1. `./gradlew clean build`
2. Run: `docker-compose up`
3. Create container just first : `docker run -d --name postgres1 -p 5455:5432 -e POSTGRES_PASSWORD=postgres postgres`
4. Exec container : `docker start postgres`
5. Run app : `./gradlew bootRun`

## ACCOUNT APIs

##### Create Account

**Endpoint:** `/api/accounts`

**Method:** POST

**Description:** This endpoint creates an account for the authenticated user.

### Search Accounts

**Endpoint:** `/api/accounts`

**Method:** GET

**Description:** This endpoint searches accounts for the authenticated user.

### Update Account

**Endpoint:** `/api/accounts/{id}`

**Method:** PUT

**Description:** This endpoint updates an account for the authenticated user.

### Delete Account

**Endpoint:** `/api/accounts/{id}`

**Method:** DELETE

**Description:** This endpoint deletes an account for the authenticated user.

### Retrieve Account Details

**Endpoint:** `/api/accounts/{id}`

**Method:** GET

**Description:** This endpoint retrieves details of a specific account for the authenticated user.

## AUTH APIs

### Login

**Endpoint:** `/api/users/login`

**Method:** POST

**Description:** This endpoint allows users to log in with their username and password.

### Register

**Endpoint:** `/api/users/register`

**Method:** POST

**Description:** This endpoint allows users to register with their username, password, and email.

## TRANSACTION APIs

### Transfer Money

**Endpoint:** `/api/transactions/transfer`

**Method:** POST

**Description:** This endpoint allows authenticated users to transfer money from one account to another.

### Retrieve History

**Endpoint:** `/api/transactions/account/{accountId}`

**Method:** GET

**Description:** This endpoint allows authenticated users to retrieve the transaction history of a specific account.
