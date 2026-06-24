import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        
        return marks;
    }

    public String getGrade() {
        if (marks >= 90)
            return "A";
        else if (marks >= 80)
            return "B";
        else if (marks >= 70)
            return "C";
        else if (marks >= 60)
            return "D";
        else
            return "F";
    }
}

public class StudentGradeTracker {

    public static double calculateAverage(ArrayList<Student> students) {
        int sum = 0;
        for (Student s : students) {
            sum += s.getMarks();
        }
        return (double) sum / students.size();
    }

    public static int findHighest(ArrayList<Student> students) {
        int highest = students.get(0).getMarks();

        for (Student s : students) {
            if (s.getMarks() > highest) {
                highest = s.getMarks();
            }
        }
        return highest;
    }

    public static int findLowest(ArrayList<Student> students) {
        int lowest = students.get(0).getMarks();

        for (Student s : students) {
            if (s.getMarks() < lowest) {
                lowest = s.getMarks();
            }
        }
        return lowest;
    }

    public static void displayReport(ArrayList<Student> students) {
        System.out.println("\n========== STUDENT REPORT ==========");

        for (Student s : students) {
            System.out.println("Name : " + s.getName()
                    + " | Marks : " + s.getMarks()
                    + " | Grade : " + s.getGrade());
        }

        System.out.printf("\nAverage Marks : %.2f\n", calculateAverage(students));
        System.out.println("Highest Marks : " + findHighest(students));
        System.out.println("Lowest Marks  : " + findLowest(students));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nStudent " + i);

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();
            sc.nextLine();

            students.add(new Student(name, marks));
        }

        displayReport(students);

        sc.close();
    }
}