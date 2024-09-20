import java.util.ArrayList;
import java.util.Scanner;

public class ManageStudents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> studentList = new ArrayList<>(); // Danh sách lưu các đối tượng Student
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Hiển thị menu
            System.out.println("\nSTUDENTS MANAGEMENT SYSTEM");
            System.out.println("1. Insert new Student");
            System.out.println("2. View list of Students");
            System.out.println("3. Search Students by Class");
            System.out.println("4. Exit");
            System.out.print("Chọn một tùy chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống sau khi nhập số

            switch (choice) {
                case 1:
                    // Tạo đối tượng Student và nhập thông tin
                    Student student = new Student();
                    System.out.print("Enter student name: ");
                    student.setFullName(scanner.nextLine());
                    System.out.print("Enter date of birth (dd/MM/yyyy): ");
                    student.setDateOfBirth(scanner.nextLine());
                    System.out.print("Enter	hometown: ");
                    student.setNativePlace(scanner.nextLine());
                    System.out.print("Enter class: ");
                    student.setStudentClass(scanner.nextLine());
                    System.out.print("Enter PhoneNo: ");
                    student.setPhoneNo(scanner.nextLine());
                    System.out.print("Enter Mobile ");
                    student.setMobile(scanner.nextInt());

                    // Thêm sinh viên vào danh sách
                    studentList.add(student);
                    break;

                case 2:
                    // Hiển thị danh sách sinh viên
                    for (Student s : studentList) {
                        s.Display();
                        System.out.println("-------------");
                    }
                    break;

                case 3:
                    // Tìm kiếm sinh viên theo lớp
                    System.out.print("Enter class name to search: ");
                    String searchClass = scanner.nextLine();
                    for (Student s : studentList) {
                        if (s.getStudentClass().equalsIgnoreCase(searchClass)) {
                            s.Display();
                            System.out.println("-------------");
                        }
                    }
                    break;

                case 4:
                    // Thoát chương trình
                    System.out.println("Exit.");
                    break;

                default:
                    System.out.println("Invalid selection!.");
            }
        } while (choice != 4);

        scanner.close();
    }

}
