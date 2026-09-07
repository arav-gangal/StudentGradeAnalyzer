import java.util.*;

public class StudentGradeAnalyzer { 

    // Grade and performance methods

    static String getGrade(double mark) {
        if (mark > 90) {
            return "O";
        } else if (mark > 80) {
            return "A+";
        } else if (mark > 70) {
            return "A";
        } else if (mark > 60) {
            return "B+";
        } else if (mark > 50) {
            return "B";
        } else if (mark > 40) {
            return "C";
        } else if (mark > 32) {
            return "D";
        } else {
            return "F";
        }
    }

    static int getGradePoint(double mark) {
        if (mark > 90) {
            return 10;
        } else if (mark > 80) {
            return 9;
        } else if (mark > 70) {
            return 8;
        } else if (mark > 60) {
            return 7;
        } else if (mark > 50) {
            return 6;
        } else if (mark > 40) {
            return 5;
        } else if (mark > 32) {
            return 4;
        } else {
            return 0;
        }
    }

    static boolean isPassing(int mark) {
        return mark >= 33;
    }

    static void printResult(int mark) {
        String grade = getGrade(mark);
        boolean status = isPassing(mark);
        System.out.println("Marks: " + mark);
        System.out.println("Grade: " + grade);
        if (status) {
            System.out.println("Status: Pass");
        } else {
            System.out.println("Status: Fail");
        }
    }

    static String getPerformance(double average) {
        if (average >= 90) {
            return "Excellent";
        } else if (average >= 80) {
            return "Very Good";
        } else if (average >= 70) {
            return "Good";
        } else if (average >= 60) {
            return "Satisfactory";
        } else {
            return "Needs Improvement";
        }
    }


    // Calculation methods

    static int findHighest(int[] marks) {
        int highestNum = marks[0];
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] > highestNum) {
                highestNum = marks[i];
            }
        }
        return highestNum;
    }

    static int findLowest(int[] marks) {
        int lowestNum = marks[0];
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < lowestNum) {
                lowestNum = marks[i];
            }
        }
        return lowestNum;
    }

    static int calculateTotal(int[] marks) {
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        return sum;
    }

    static int countPassing(int[] marks) {
        int count = 0;
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] >= 33) {
                count++;
            }
        }
        return count;
    }

    static double calculateAverage(int[] marks) {
        int total = calculateTotal(marks);
        return total / (double) marks.length;
    }

    static double calculateCGPA(int[] marks, int[] credits) {
        int totalCredits = 0;
        int weightedGradePoints = 0;

        for (int i = 0; i < marks.length; i++) {
            int gradePoint = getGradePoint(marks[i]);
            weightedGradePoints += gradePoint * credits[i];
            totalCredits += credits[i];
        }

        return weightedGradePoints / (double) totalCredits;
    }


    // Input methods

    static int getNumberOfSubjects(Scanner input) {
        System.out.print("\nEnter number of subjects: ");
        int numSubjects = input.nextInt();

        while (numSubjects <= 0) {
            System.out.print("Enter a valid number of subjects: ");
            numSubjects = input.nextInt();
        }
        return numSubjects;
    }

    static String[] inputSubjectNames(Scanner input, int numSubjects) {
        String[] subjectNames = new String[numSubjects];
        System.out.println("Enter name of Subjects: ");

        input.nextLine();

        for (int i = 0; i < subjectNames.length; i++) {
            System.out.print((i + 1) + ". ");
            subjectNames[i] = input.nextLine();
        }
        return subjectNames;
    }

    static int[] inputMarks(Scanner input, String[] subjectNames) {
        int[] marks = new int[subjectNames.length];
        System.out.println("Enter marks: ");

        for (int i = 0; i < marks.length; i++) {
            System.out.print(subjectNames[i] + " : ");
            marks[i] = input.nextInt();

            while (marks[i] < 0 || marks[i] > 100) {
                System.out.print("Invalid mark. Enter a mark between 0 and 100: ");
                marks[i] = input.nextInt();
            }
        }
        return marks;
    }

    static int[] inputCredits(Scanner input, String[] subjectNames) {
        int[] credits = new int[subjectNames.length];
        System.out.println("Enter credits: ");

        for (int i = 0; i < credits.length; i++) {
            System.out.print(subjectNames[i] + " : ");
            credits[i] = input.nextInt();

            while (credits[i] <= 0) {
                System.out.print("Invalid credit value. Enter a positive number: ");
                credits[i] = input.nextInt();
            }
        }
        return credits;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numSubjects = getNumberOfSubjects(input);
        String[] subjectNames = inputSubjectNames(input, numSubjects);
        int[] marks = inputMarks(input, subjectNames);
        int[] credits = inputCredits(input, subjectNames);

        int total = calculateTotal(marks);
        double average = calculateAverage(marks);
        int highestMark = findHighest(marks);
        int lowestMark = findLowest(marks);
        int subPassed = countPassing(marks);
        int subFailed = numSubjects - subPassed;
        String overallGrade = getGrade(average);
        String performance = getPerformance(average);
        double cgpa = calculateCGPA(marks, credits);

        System.out.println("\n===== STUDENT GRADE ANALYZER =====");

        for (int i = 0; i < marks.length; i++) {
            System.out.println("\n" + subjectNames[i] + ":");
            printResult(marks[i]);
            System.out.println("Grade Point: " + getGradePoint(marks[i]));
            System.out.println("Credits: " + credits[i]);
        }

        System.out.println("\n===== SUMMARY =====");

        System.out.println("\nTotal Marks: " + total);
        System.out.printf("Average: %.2f%n", average);
        System.out.println("Highest Mark: " + highestMark);
        System.out.println("Lowest Mark: " + lowestMark);
        System.out.println("Number of Subjects Passed: " + subPassed);
        System.out.println("Number of Subjects Failed: " + subFailed);
        System.out.println("Overall Grade: " + overallGrade);
        System.out.println("Performance: " + performance);
        System.out.printf("CGPA: %.2f%n", cgpa);

    }
}
