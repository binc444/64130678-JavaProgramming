import java.util.Scanner;

public class StudentMark implements IStudentMark{
	// Các thuộc tính của StudentMark
    private static int autoId = 1;
    private String fullName;
    private int id;
    private String studentClass;
    private int semester;
    private float averageMark;
    private int[] subjectMarkList = new int[5]; // Mảng chứa điểm của 5 môn học

    // Constructor mặc định
    public StudentMark() {
        this.id = autoId++; // ID tự động tăng khi khởi tạo
    }

    // Getters và Setters
    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public float getAverageMark() {
        return averageMark;
    }

    // Phương thức thực thi từ giao diện IStudentMark
    @Override
    public void Display() {
        System.out.println("Full Name: " + fullName);
        System.out.println("ID: " + id);
        System.out.println("Class: " + studentClass);
        System.out.println("Semester: " + semester);
        System.out.println("Average Mark: " + averageMark);
    }

    // Phương thức nhập điểm cho các môn học
    public void inputSubjectMarks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter marks for 5 subjects:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Mark subject" + (i + 1) + ": ");
            try {
                subjectMarkList[i] = scanner.nextInt();
                if (subjectMarkList[i] < 0 || subjectMarkList[i] > 10) {
                    throw new IllegalArgumentException("Invalid score, must be between 0 and 10.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                i--; // Cho phép nhập lại nếu có lỗi
            }
        }
    }

    // Phương thức tính toán AverageMark
    public void AveCal() {
        int sum = 0;
        for (int mark : subjectMarkList) {
            sum += mark;
        }
        this.averageMark = sum / 5.0f;
    }
}
