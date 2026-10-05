# Test Case Management System

## 📌 Project Overview

The **Test Case Management System** is a Core Java console-based application designed to manage software testing test cases.

It allows users to create, view, search, execute, and delete test cases while tracking test priority, execution status, actual results, execution notes, and execution time.

This project was developed to demonstrate practical **Core Java and Object-Oriented Programming concepts** through a real-world software testing use case.

---

## 🚀 Features

- Add new test cases
- View all test cases
- Search test case by ID
- Search test cases by module
- Define test steps and expected results
- Set test priority
- Execute test cases manually
- Record PASS, FAIL, or BLOCKED results
- Store actual results and execution notes
- Track test creation and execution time
- Delete test cases
- Generate test execution summary
- Validate user input
- Handle invalid test case IDs using custom exceptions

---

## 🛠️ Technologies Used

- Java
- Core Java
- Maven
- IntelliJ IDEA / Visual Studio Code
- Git
- GitHub

---

## 🧠 Core Java Concepts Used

### Object-Oriented Programming

- Classes and Objects
- Encapsulation
- Constructors
- Getters and Setters
- Method implementation

### Java Features

- ArrayList
- List
- Enum
- Switch statements
- Loops
- Methods
- Exception Handling
- Custom Exceptions
- Java `LocalDateTime`
- Input validation

---

## 📂 Project Structure

```text
test-case-management-system
│
├── pom.xml
├── README.md
├── .gitignore
│
├── .mvn
│   ├── jvm.config
│   └── maven.config
│
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── dharshu
    │               └── testcasemanagement
    │                   │
    │                   ├── Main.java
    │                   │
    │                   ├── model
    │                   │   ├── TestCase.java
    │                   │   ├── TestPriority.java
    │                   │   └── TestStatus.java
    │                   │
    │                   ├── service
    │                   │   └── TestCaseService.java
    │                   │
    │                   ├── exception
    │                   │   └── TestCaseNotFoundException.java
    │                   │
    │                   └── util
    │                       └── InputValidator.java
    │
    └── test
        └── java
```

---

## ⚙️ How the Application Works

The application follows a simple flow:

```text
User
  ↓
Main.java
  ↓
TestCaseService
  ↓
TestCase Objects
  ↓
ArrayList
```

### Test Case Creation

A test case contains:

- Test Case ID
- Title
- Module
- Description
- Test Steps
- Expected Result
- Priority
- Status
- Actual Result
- Execution Notes
- Created Time
- Executed Time

### Test Execution

A tester selects a test case and chooses:

```text
PASS
FAIL
BLOCKED
```

The system then stores:

- Execution status
- Actual result
- Execution notes
- Execution timestamp

---

## 📋 Sample Test Case

### TC001 – Verify Login with Valid Credentials

**Module:** Login

**Test Steps:**

```text
1. Open login page
2. Enter valid username
3. Enter valid password
4. Click Login
```

**Expected Result:**

```text
User should be logged in successfully.
```

**Priority:** HIGH

**Status:** PASS

**Actual Result:**

```text
Login page displayed successfully.
```

**Execution Notes:**

```text
Valid username and password accepted.
```

---

## 🧪 Test Scenarios

| Test Case ID | Test Scenario | Expected Result |
|---|---|---|
| TC001 | Add valid test case | Test case should be added successfully |
| TC002 | View all test cases | All available test cases should be displayed |
| TC003 | Search existing test case ID | Correct test case should be displayed |
| TC004 | Search invalid test case ID | Appropriate error message should be displayed |
| TC005 | Search by module | Matching test cases should be displayed |
| TC006 | Execute test case with PASS | Status should become PASS |
| TC007 | Execute test case with FAIL | Status should become FAIL |
| TC008 | Execute test case with BLOCKED | Status should become BLOCKED |
| TC009 | Delete existing test case | Test case should be removed |
| TC010 | Delete invalid test case ID | Appropriate error message should be displayed |
| TC011 | Enter invalid numeric input | Validation message should be displayed |
| TC012 | Enter empty test case title | User should be asked to enter a valid value |
| TC013 | View execution summary | Correct PASS/FAIL/BLOCKED counts should be displayed |

---

## ▶️ How to Run the Project

### Prerequisites

- JDK 21 or compatible Java version
- Maven
- Visual Studio Code or IntelliJ IDEA

### Run using Maven

Open the terminal inside the project folder and run:

```bash
mvn clean compile
```

Then run the `Main.java` class.

### Run in Visual Studio Code

1. Open the project folder.
2. Open `Main.java`.
3. Right-click inside the file.
4. Select **Run Java**.
5. Use the console menu to interact with the application.

---

## 🖥️ Sample Console Output

```text
==========================================
      TEST CASE MANAGEMENT SYSTEM
==========================================

========== MAIN MENU ==========
1. Add Test Case
2. View All Test Cases
3. Search Test Case by ID
4. Search Test Cases by Module
5. Execute Test Case
6. Delete Test Case
7. View Test Summary
8. Exit
===============================
Enter your choice:
```

---

## 📊 Test Execution Summary

The application provides a summary of test execution results:

```text
========== TEST SUMMARY ==========
Total Test Cases : 3
Passed           : 1
Failed           : 1
Blocked          : 0
Not Executed     : 1
==================================
```

---

## ⚠️ Current Limitation

The current version uses an `ArrayList` for data storage.

Therefore, test case data is stored only in memory and will be lost when the application is closed.

This version was intentionally developed using Core Java to focus on programming fundamentals and object-oriented design.

---

## 🔮 Future Enhancements

- MySQL database integration using JDBC
- Persistent test case storage
- User login and role-based access
- Test execution history
- Defect management
- Report generation
- CSV/PDF report export
- Selenium integration for automated test execution
- TestNG integration

---

## 🎯 Learning Outcomes

Through this project, I practiced:

- Designing a Java application using OOP principles
- Using collections to manage application data
- Implementing enums for controlled values
- Creating and handling custom exceptions
- Validating console input
- Working with Java date and time APIs
- Separating business logic from user interaction
- Using Git and GitHub for source-code management

---

## 👩‍💻 Author

**Dharshini R**

B.Tech – Artificial Intelligence and Machine Learning

GitHub: [dharshini-dharsh](https://github.com/dharshini-dharsh)
