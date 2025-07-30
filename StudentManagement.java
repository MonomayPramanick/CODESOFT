import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
    
    private List<Student> students = new ArrayList<>();
    private final String FILE_NAME = "students.txt";

    public StudentManagement() {
        loadStudentsFromFile();
    }

    public void addStudent(Student student) {
        if (student.getName().isEmpty() || student.getRollNumber().isEmpty()) {
            System.out.println("Name and Roll Number are required.");
            return;
        }
        students.add(student);
        saveStudentsToFile();
        System.out.println("Student added successfully.");
    }
    public void removeStudent(String rollNumber) {
        Student s = searchStudent(rollNumber);
        if (s != null) {
            students.remove(s);
            saveStudentsToFile();
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }
    public Student searchStudent(String rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber().equalsIgnoreCase(rollNumber)) {
                return s;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    public void editStudent(String rollNumber, String newGrade, String newEmail) {
        Student s = searchStudent(rollNumber);
        if (s != null) {
            s.setGrade(newGrade);
            s.setEmail(newEmail);
            saveStudentsToFile();
            System.out.println("Student updated.");
        } else {
            System.out.println("Student not found.");
        }
    }
    private void loadStudentsFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    Student s = new Student(data[0], data[1], data[2], data[3]);
                    students.add(s);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
    private void saveStudentsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                bw.write(s.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

}
