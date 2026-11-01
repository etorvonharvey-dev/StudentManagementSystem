
import java.util.ArrayList;
import java.util.Scanner;
 
class Student {
    int id;
    String name;
    int age;
    double grade;

    Student(int id, String name, int age, double grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }
}

public class StudentManagementSystem {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Calculate Average Grade");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    calculateAverage();
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);
    }

    static void addStudent() {

        System.out.println("\n--- Add Student ---");

        System.out.print("Enter ID: ");
        int id = input.nextInt();

        if (findStudent(id) != null) {
            System.out.println("Student ID already exists!");
            return;
        }

        input.nextLine();

        System.out.print("Enter Name: ");
        String name = input.nextLine();

        System.out.print("Enter Age: ");
        int age = input.nextInt();

        System.out.print("Enter Grade: ");
        double grade = input.nextDouble();

        Student student = new Student(id, name, age, grade);

        students.add(student);

        System.out.println("Student added successfully!");
    }

    static void displayStudents() {

        System.out.println("\n--- All Students ---");

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            student.display();
            System.out.println("-------------------");
        }
    }

    static void searchStudent() {

        System.out.println("\n--- Search Student ---");

        System.out.print("Enter Student ID: ");
        int id = input.nextInt();

        Student student = findStudent(id);

        if (student != null) {
            System.out.println("Student found!");
            student.display();
        } else {
            System.out.println("Student not found.");
        }
    }

    static void updateStudent() {

        System.out.println("\n--- Update Student ---");

        System.out.print("Enter Student ID: ");
        int id = input.nextInt();

        Student student = findStudent(id);

        if (student != null) {

            input.nextLine();

            System.out.print("Enter New Name: ");
            student.name = input.nextLine();

            System.out.print("Enter New Age: ");
            student.age = input.nextInt();

            System.out.print("Enter New Grade: ");
            student.grade = input.nextDouble();

            System.out.println("Student updated successfully!");

        } else {
            System.out.println("Student not found.");
        }
    }

    static void deleteStudent() {

        System.out.println("\n--- Delete Student ---");

        System.out.print("Enter Student ID: ");
        int id = input.nextInt();

        Student student = findStudent(id);

        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    static void calculateAverage() {

        System.out.println("\n--- Average Grade ---");

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        double total = 0;

        for (Student student : students) {
            total += student.grade;
        }

        double average = total / students.size();

        System.out.printf("Average Grade: %.2f%n", average);
    }

    static Student findStudent(int id) {

        for (Student student : students) {

            if (student.id == id) {
                return student;
            }
        }

        return null;
    }
}
