import java.util.ArrayList;
import java.util.Scanner;

public class ManageStudentMarks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<StudentMark> studentMarkList = new ArrayList<>(); // Danh sách lưu các đối tượng StudentMark
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Hiển thị menu
            System.out.println("\nMARKS MANAGEMENT SYSTEM");
            System.out.println("1. Insert new Student");
            System.out.println("2. View list of Students");
            System.out.println("3. Average Mark");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống sau khi nhập số

            switch (choice) {
                case 1:
                    // Tạo đối tượng StudentMark và nhập thông tin
                    StudentMark student = new StudentMark();
                    System.out.print("Enter student name: ");
                    student.setFullName(scanner.nextLine());
                    System.out.print("Class: ");
                    student.setStudentClass(scanner.nextLine());
                    System.out.print("Semester: ");
                    student.setSemester(scanner.nextInt());

                    // Nhập điểm cho các môn học
                    student.inputSubjectMarks();

                    // Thêm sinh viên vào danh sách
                    studentMarkList.add(student);
                    break;

                case 2:
                    // Hiển thị danh sách sinh viên
                    for (StudentMark s : studentMarkList) {
                        s.Display();
                        System.out.println("-------------");
                    }
                    break;

                case 3:
                    // Tính và hiển thị điểm trung bình cho từng sinh viên
                    for (StudentMark s : studentMarkList) {
                        s.AveCal();  
                        s.Display(); 
                        System.out.println("-------------");
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
