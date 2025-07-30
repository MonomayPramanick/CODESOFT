import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        StudentManagement sms = new StudentManagement();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Edit Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter roll number: ");
                    String roll = sc.nextLine();
                    System.out.print("Enter grade: ");
                    String grade = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    sms.addStudent(new Student(name, roll, grade, email));
                    break;
                case 2:
                    System.out.print("Enter roll number to remove: ");
                    sms.removeStudent(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Enter roll number to edit: ");
                    String rollToEdit = sc.nextLine();
                    System.out.print("Enter new grade: ");
                    String newGrade = sc.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = sc.nextLine();
                    sms.editStudent(rollToEdit, newGrade, newEmail);
                    break;
                case 4:
                    System.out.print("Enter roll number to search: ");
                    Student s = sms.searchStudent(sc.nextLine());
                    if (s != null) {
                        System.out.println("Student Found: " + s);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    sms.displayAllStudents();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            } while (choice != 6);

        sc.close();
    }
}
