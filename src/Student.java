import java.util.ArrayList;

public class Student {

    private String name;
    private ArrayList<Integer> grades;

    public Student(String name) {
        this.name = name;
        grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(int grade) {

        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        } else {
            System.out.println("Invalid grade. Grade must be between 0 and 100.");
        }
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public double calculateAverage() {

        if (grades.isEmpty()) {
            return 0;
        }

        int total = 0;

        for (int grade : grades) {
            total += grade;
        }

        return (double) total / grades.size();
    }

    public void displayGrades() {
        System.out.println("Grades: " + grades);
        System.out.printf("Average: %.2f%n", calculateAverage());
    }
}

