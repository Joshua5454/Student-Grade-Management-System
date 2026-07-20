import java.util.ArrayList;

public class GradeManager {

    private ArrayList<Student> students;

    public GradeManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println();
            System.out.println("Student Name: " + student.getName());
            student.displayGrades();
        }
    }

    public void searchStudent(String name) {

        for (Student student : students) {

            if (student.getName().equalsIgnoreCase(name)) {

                System.out.println();
                System.out.println("Student Name: " + student.getName());
                student.displayGrades();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

}