import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    public void saveStudents(GradeManager manager) {

        try {

            FileWriter writer = new FileWriter("students.txt");

            writer.write("Student Grade Management System\n\n");

            for (Student student : manager.getStudents()) {

                writer.write("Student Name: " + student.getName() + "\n");
                writer.write("Grades: " + student.getGrades() + "\n");
                writer.write("\n");
            }

            writer.close();

            System.out.println("Data saved successfully.");

        } catch (IOException e) {

            System.out.println("Error saving data.");

        }
    }

    public ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader("students.txt"));

            String line;
            Student currentStudent = null;

            while ((line = reader.readLine()) != null) {

                if (line.startsWith("Student Name: ")) {

                    String name = line.substring(14);

                    currentStudent = new Student(name);
                    students.add(currentStudent);

                } else if (line.startsWith("Grades: ")) {

                    String gradesText = line.substring(8);

                    gradesText = gradesText.replace("[", "")
                            .replace("]", "");

                    String[] grades = gradesText.split(",");

                    for (String grade : grades) {

                        if (!grade.trim().isEmpty()) {
                            currentStudent.addGrade(Integer.parseInt(grade.trim()));
                        }
                    }
                }
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("No saved data found.");

        }

        return students;
    }
}