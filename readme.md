VIT Bhopal Academic Resource Navigator
A robust Java-based desktop application designed to help students at VIT Bhopal manage their academic records, track course progress, and calculate their Grade Point Average (GPA) using the university's specific grading system.

📌 Problem Statement
As students at VIT Bhopal, we manage a diverse range of courses (University Core, Programme Core, Electives) each with different credit weights. Manually tracking these across semesters and calculating an accurate CGPA according to the S-F grading scale can be error-prone and tedious.

The VIT Bhopal Academic Resource Navigator solves this by providing a centralized, persistent Graphical User Interface (GUI) where students can log their grades and instantly view their academic standing.

✨ Key Features
Intuitive GUI: Built with Java Swing for a clean, user-friendly experience.

Data Persistence: Uses Java Serialization to save your course list to a local file (student_data.dat). Your data remains safe even after closing the application.

Automated GPA Calculation: Implements the official VIT Bhopal credit-weighted formula.

Real-time Table Updates: Dynamically add courses and see them reflected in a structured table format immediately.

Error Handling: Built-in validation to ensure credits are entered as numerical values and grades follow the standard S, A, B, C, D, E, F format.

🛠️ Tech Stack & Concepts
Language: Java (JDK 8+)

GUI Framework: Java Swing (javax.swing)

Design Patterns: Object-Oriented Programming (Encapsulation, Inheritance-ready structures).

Data Structures: * ArrayList: For dynamic storage of course objects.

HashMap: For constant-time lookup of grade-to-point mappings.

I/O Operations: ObjectOutputStream and ObjectInputStream for binary data persistence.
📂 Project Structure

   VITNavigator/
   │
   ├── Course.java          # Model class representing a subject (Name, Credits, Grade)
   ├── GPACalculator.java   # Logic class for grade point mapping and math formulas
   ├── FileManager.java     # Utility class for saving/loading data to student_data.dat
   ├── VITNavigatorGUI.java # Main class containing the GUI and Event Handlers
   └── README.md            # Project documentation

🚀 Setup and Installation
Prerequisites
Ensure you have Java Development Kit (JDK) installed (Version 8 or higher).

A terminal or Command Prompt.

Steps to Run
Clone/Download this repository to your local machine.

Open your terminal and navigate to the project folder:

Bash
cd path/to/VITNavigator
Compile all Java files:

Bash
javac *.java
Run the application:

Bash
java VITNavigatorGUI
📖 How to Use
Add Course: Enter the name of your subject, the number of credits (e.g., 2, 3, or 4), and select your grade from the dropdown.

View List: The table in the center will automatically update with your new entry.

Calculate GPA: Click the "Calculate GPA" button at the bottom to see your semester performance.

Save: Click "Save & Exit" to ensure your data is written to the disk for your next session.
## 📸 Screenshots

| Main Dashboard | GPA Calculation |
| :--- | :--- |
| ![Dashboard](https://i.postimg.cc/3xgwyXz3/Screenshot_2026_03_28_010123.png) | ![GPA Result](https://i.postimg.cc/ydN6rwx3/Screenshot_2026_03_28_010919.png) |
💡 Learning Outcomes
Through this project, I deepened my understanding of:

Event-Driven Programming: Managing user actions like button clicks in a GUI environment.

Separation of Concerns: Organizing code into Models, Logic, and UI components to make it maintainable.

File Handling: Implementing robust data persistence using serialization.