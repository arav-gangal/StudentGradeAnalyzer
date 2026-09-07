# Student Grade Analyzer

A Java console application that analyzes a student's marks across multiple subjects and calculates their grades, performance, and credit-weighted CGPA.

## Features

- Accepts a variable number of subjects
- Takes subject names as input
- Takes marks for each subject
- Takes credit values for each subject
- Validates the number of subjects
- Validates marks between 0 and 100
- Validates credit values
- Calculates total marks
- Calculates average marks
- Finds the highest and lowest marks
- Counts passed and failed subjects
- Assigns grades based on marks
- Calculates grade points
- Calculates credit-weighted CGPA
- Provides an overall grade
- Provides an overall performance rating

## Grading System

| Marks | Grade | Grade Point |
|------:|:-----:|------------:|
| > 90  | O     | 10 |
| > 80  | A+    | 9 |
| > 70  | A     | 8 |
| > 60  | B+    | 7 |
| > 50  | B     | 6 |
| > 40  | C     | 5 |
| > 32  | D     | 4 |
| ≤ 32  | F     | 0 |

A mark of 33 or above is considered a passing mark.

## CGPA Calculation

The program calculates CGPA using the credit-weighted grade points of each subject.

**Formula:**

CGPA = Σ(Grade Point × Credits) / Σ(Credits)

For example:

| Subject | Grade Point | Credits |
|---------|------------:|--------:|
| Calculus | 10 | 4 |
| Programming | 9 | 4 |
| Physics | 8 | 3 |

Example calculation:

    CGPA = (10 × 4 + 9 × 4 + 8 × 3) / (4 + 4 + 3)
         = 9.09

## Concepts Demonstrated

- Java methods
- Arrays
- Loops
- Conditional statements
- `Scanner` for user input
- Method parameters and return values
- Input validation
- Type casting
- Basic modular programming
- Credit-weighted calculations

## How to Run

Make sure Java is installed on your system.

Open a terminal in the project directory and compile the program:

    javac StudentGradeAnalyzer.java

Then run it:

    java StudentGradeAnalyzer

## Example

    Enter number of subjects: 3
    Enter name of Subjects:
    1. Calculus
    2. Programming
    3. Physics

    Enter marks:
    Calculus : 92
    Programming : 85
    Physics : 76

    Enter credits:
    Calculus : 4
    Programming : 4
    Physics : 3

    ===== STUDENT GRADE ANALYZER =====


    Calculus:
    Marks: 92
    Grade: O
    Status: Pass
    Grade Point: 10
    Credits: 4

    Programming:
    Marks: 85
    Grade: A+
    Status: Pass
    Grade Point: 9
    Credits: 4

    Physics:
    Marks: 76
    Grade: A
    Status: Pass
    Grade Point: 8
    Credits: 3

    ===== SUMMARY =====

    Total Marks: 253
    Average: 84.33
    Highest Mark: 92
    Lowest Mark: 76
    Number of Subjects Passed: 3
    Number of Subjects Failed: 0
    Overall Grade: A+
    Performance: Very Good
    CGPA: 9.09

## Author

Arav Gangal
