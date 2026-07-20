import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        GradeManager manager = new GradeManager();
        FileManager fileManager = new FileManager();

        for (Student student : fileManager.loadStudents()) {
            manager.addStudent(student);
        }

        int choice;

        do {

            System.out.println("\n===== Student Grade Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter student name: ");
                    String name = input.nextLine();

                    Student student = new Student(name);

                    System.out.print("Enter first grade: ");
                    int grade1 = input.nextInt();

                    System.out.print("Enter second grade: ");
                    int grade2 = input.nextInt();

                    System.out.print("Enter third grade: ");
                    int grade3 = input.nextInt();

                    input.nextLine(); // Clear the Enter key

                    student.addGrade(grade1);
                    student.addGrade(grade2);
                    student.addGrade(grade3);

                    manager.addStudent(student);

                    System.out.println("Student added successfully!");

                    break;

                case 2:
                    manager.displayAllStudents();
                    break;

                case 3:

                    System.out.print("Enter student name to search: ");
                    String searchName = input.nextLine();

                    manager.searchStudent(searchName);

                    break;

                case 4:

                    fileManager.saveStudents(manager);

                    System.out.println("Goodbye!");

                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        input.close();
    }
}