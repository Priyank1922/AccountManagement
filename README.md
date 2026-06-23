# Account Management System

A Spring Boot-based REST API for managing bank accounts and performing secure money transfers. The project demonstrates the implementation of ACID properties using Spring's `@Transactional` annotation to ensure reliable and consistent database transactions.

## Features

- Create Account
- View Account Details
- Update Account 
- Delete Account
- View All Accounts
- Deposit Money
- Withdraw Money
- Transfer Money Between Accounts
- Transaction Rollback Support
- ACID Property Demonstration using `@Transactional`

## Account Entity

The Account entity contains the following attributes:

| Field   | Type    |
|---------|---------|
| id      | Long    |
| name    | String  |
| accno   | String  |
| balance | Double  |

## Technology Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST API

## Project Structure

The project follows a layered architecture:

- **Controller Layer** – Handles API requests and responses
- **Service Layer** – Contains business logic and transaction management
- **Repository Layer** – Handles database operations using JPA
- **Entity Layer** – Represents database tables

## Money Transfer Functionality

The application supports secure money transfers between accounts using Spring's `@Transactional` annotation.



### Transfer Process

1. Validate sender account.
2. Validate receiver account.
3. Check sufficient balance.
4. Deduct amount from sender account.
5. Credit amount to receiver account.
6. Commit transaction.

If any step fails, the entire transaction is rolled back automatically, ensuring that no partial updates occur in the database.



## ACID Properties Demonstrated

### Atomicity
Ensures that a transaction is completed entirely or not executed at all.

### Consistency
Maintains valid database states before and after transactions.

### Isolation
Prevents concurrent transactions from interfering with each other.

### Durability
Ensures committed transactions remain permanently stored in the database.

## Example

### Before Transfer

Sender Balance: ₹10,000

Receiver Balance: ₹5,000

Transfer Amount: ₹2,000

### After Successful Transfer

Sender Balance: ₹8,000

Receiver Balance: ₹7,000

### If Transaction Fails

Sender Balance: ₹10,000

Receiver Balance: ₹5,000

The database remains unchanged because the transaction is rolled back automatically.

## Learning Outcomes

- Spring Boot Development
- REST API Design
- Spring Data JPA
- Database Transaction Management
- ACID Properties
- Exception Handling


## Author

**Priyank Mehta**

Java Developer | Spring Boot Developer
