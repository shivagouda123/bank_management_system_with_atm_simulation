# 🏦 Bank Management System with ATM Simulation – Java + MySQL (Swing & AWT)

This project is a **Java-based Bank Management System** that integrates a user-friendly **Graphical User Interface (GUI)** using **Swing** and **AWT**, and utilizes **MySQL** as the backend database. The system replicates the core features of real-world banking operations and also simulates an **ATM interface** with essential transactional options. 

## 🚀 Project Overview

The Bank Management System is designed to offer a complete banking experience, allowing users to **sign up**, **log in**, and **perform transactions** similar to those conducted in physical banks and ATMs. This project emphasizes user authentication, secure transaction handling, and efficient data management through a robust backend.

### ✨ Key Features

#### 🔐 User Authentication
- **Signup Page**: New users can register by entering personal details.
- **Login Page**: Registered users can securely log in using card number and PIN.

#### 🏧 ATM Simulation Interface
After successful login, users access an ATM-like interface with the following options:
- **Cash Deposit**: Deposit a specific amount to their bank account.
- **Cash Withdrawal**: Withdraw a specific amount (with minimum balance check).
- **Fast Cash**: Withdraw preset amounts instantly (e.g., ₹100, ₹500, ₹1000).
- **Mini Statement**: View a summary of recent transactions.
- **Balance Enquiry**: Check current account balance.
- **PIN Change**: Securely update the account PIN.

---

## 🛠️ Technologies Used

- **Java** (Core + OOP Concepts)
- **Swing & AWT** (for GUI)
- **MySQL** (Database)
- **JDBC** (Java Database Connectivity)

---

## 🗃️ Database Structure

The application uses the following MySQL tables:

### 🔹  `signup`
Stores user registration details.
sql
CREATE TABLE signup (
  form_no VARCHAR(20) PRIMARY KEY,
  name VARCHAR(100),
  dob DATE,
  gender VARCHAR(10),
  email VARCHAR(100),
  address VARCHAR(200),
  city VARCHAR(100),
  state VARCHAR(100),
  pincode VARCHAR(10)
);
### 🔹  login

Stores card number and associated PIN for login.

sql
Copy
Edit
CREATE TABLE login (
  card_number VARCHAR(16) PRIMARY KEY,
  pin VARCHAR(6),
  form_no VARCHAR(20),
  FOREIGN KEY (form_no) REFERENCES signup(form_no)
);

### 🔹 bank
Stores ATM transactions (debit/credit).

sql
Copy
Edit
CREATE TABLE bank (
  id INT AUTO_INCREMENT PRIMARY KEY,
  card_number VARCHAR(16),
  date DATETIME,
  type VARCHAR(10), -- 'Deposit' or 'Withdraw'
  amount DECIMAL(10, 2),
  FOREIGN KEY (card_number) REFERENCES login(card_number)
);


## 🧰 Technologies Used

- **Java** – Core logic and backend processing
- **Swing & AWT** – GUI design and user interaction
- **MySQL** – Database for storing user credentials and transaction data
- **JDBC** – For connecting Java application with MySQL database

---

## 📌 Key Learnings

- Implementing real-world banking logic using Java.
- GUI design using Swing and AWT for enhanced user experience.
- JDBC integration with MySQL for persistent data storage.
- Exception handling, user validations, and secure PIN management.
- Simulation of practical ATM functionalities in a controlled desktop environment.

---

## 🧑‍💻 Author

Developed as part of an academic/internship project by [Your Name].
