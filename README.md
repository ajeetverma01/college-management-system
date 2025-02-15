# 🎓 College Management System

## 📌 Overview
The **College Management System** is a Java-based desktop application developed using **Java Swing** and **SQL**. It is designed to streamline and automate various administrative tasks within an educational institution, providing a **user-friendly** interface for managing students, faculty, courses, and more.

## 🚀 Features
- 🔐 **User Management**: Secure login with role-based access for administrators, faculty, and students.
- 🏫 **Student Records**: Manage student details, enrollment, attendance, and grades.
- 📚 **Course Management**: Simplified course creation, scheduling, and assignments.
- 👩‍🏫 **Faculty Management**: Maintain faculty details, schedules, and performance records.
- 🗄️ **Database Integration**: SQL-backed data storage for efficient management.
- 🖥️ **User-Friendly Interface**: Intuitive Java Swing-based GUI for easy navigation.

## 🛠 Tech Stack
- 🎨 **Frontend**: Java Swing for UI design.
- ⚙️ **Backend**: Java for business logic.
- 🗃 **Database**: MySQL for data management.

## 💻 Installation and Setup
Follow the steps below to set up and run the project on your local system:

### ✅ Prerequisites
Ensure you have the following installed on your system:
- [☕ Java JDK (8 or later)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [🐬 MySQL Server](https://dev.mysql.com/downloads/installer/)
- [🔌 MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)
- [🖥 An IDE like IntelliJ IDEA or Eclipse](https://www.jetbrains.com/idea/download/)

### ⚡ Steps to Run the Project
1. **📥 Clone the Repository**
   ```sh
   git clone https://github.com/ajeetverma01/college-management-system.git
   cd college-management-system
   ```
2. **🛢 Set Up the Database**
   - Open MySQL and create a new database.
   - Execute the SQL queries provided in the `queries.sql` file to set up the required tables and data.

3. **⚙ Configure the Database Connection**
   - Locate the database connection code inside the project (`connection.java`).
   - Update the database URL, username, and password as per your MySQL setup:
   ```java
   String url = "jdbc:mysql://localhost:3306/collegemanagementsystem";
   String user = "root";
   String password = "";
   ```

4. **▶ Run the Project**
   - Open the project in your IDE.
   - Compile and run the main Java file (`Main.java`).
   - Log in with the appropriate user credentials.

## 📞 Contact
For any queries, feel free to reach out:
- **GitHub**: [Ajeet Verma](https://github.com/yourusername)
- 📧 **Email**: av401402@gmail.com
