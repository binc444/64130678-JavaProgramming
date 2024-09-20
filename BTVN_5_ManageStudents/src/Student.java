
public class Student implements IStudent{
	private static int autoId = 1; 
    private int id;
    private String fullName;
    private String dateOfBirth;
    private String nativePlace;
    private String studentClass;
    private String phoneNo;
    private int mobile;

    // Constructor mặc định
    public Student() {
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    // Phương thức thực thi từ giao diện IStudent
    @Override
    public void Display() {
        System.out.println("Full Name: " + fullName);
        System.out.println("ID: " + id);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Native Place: " + nativePlace);
        System.out.println("Class: " + studentClass);
        System.out.println("Phone No: " + phoneNo);
        System.out.println("Mobile: " + mobile);
    }
}
