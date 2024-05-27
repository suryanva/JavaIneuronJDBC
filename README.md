# JavaIneuronJDBC
### README: Student Management System

---

#### Overview

The Student Management System is a Java-based console application designed to perform basic CRUD (Create, Read, Update, Delete) operations on a database table. This application uses JDBC (Java Database Connectivity) to interact with a database, enabling users to manage student records efficiently.

---

#### Features

- **Create**: Add new student records to the database.
- **Read**: Display all student records from the database.
- **Update**: Modify existing student records.
- **Delete**: Remove student records from the database.
- **Exit**: Terminate the application.

---

#### Prerequisites

- **Java Development Kit (JDK)**: Ensure you have JDK 8 or later installed.
- **Database**: A running instance of MySQL database server.
- **JDBC Driver**: MySQL Connector/J (JDBC driver for MySQL).

---

#### Database Setup

Create a database and a table to store student records. Here is an example SQL script to set up the `assignment` table:

```sql
CREATE DATABASE ineuron;

USE ineuron;


CREATE TABLE assignment(
student_id INT AUTO_INCREMENT,
student_name VARCHAR(20),
student_gender VARCHAR(2),
student_dob DATE,
 student_doj DATE,
student_dom DATE,
PRIMARY KEY(student_id)

);
```

---


#### Code Overview

```java
public class TestApp {

    public static void main(String[] args) throws SQLException, ParseException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter number corresponding to the Operation: ");
            System.out.println("1. Create");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Update");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> CreateOperation.createTable(scanner);
                case 2 -> DeleteOperation.deleteRow(scanner);
                case 3 -> ReadOperation.readTable();
                case 4 -> UpdateOperation.updateTable(scanner);
                case 5 -> {
                    System.out.println("Exiting the program");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Input. Please try again.");
            }
        }
    }
}
```

---

