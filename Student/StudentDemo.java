import java.util.Scanner;

class Student {
    private String usn;
    private String name;

    public void accept(Scanner scanner) {
        System.out.print("Enter USN: ");
        usn = scanner.nextLine();
        System.out.print("Enter name: ");
        name = scanner.nextLine();
    }

    public void display() {
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many students? ");
        int count = Integer.parseInt(scanner.nextLine());
        Student[] students = new Student[count];

        for (int i = 0; i < students.length; i++) {
            System.out.println("\nStudent " + (i + 1));
            students[i] = new Student();
            students[i].accept(scanner);
        }

        System.out.println("\nStudent details");
        for (Student student : students) {
            student.display();
            System.out.println();
        }
    }
}
