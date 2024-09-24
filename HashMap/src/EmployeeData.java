
public class EmployeeData {
	public EmployeeData(String nm) {
        name = nm;
        salary = 5600;
    }

    public String toString() {
        return "[name=" + name + ", salary=" + salary + "]";
    }

    private String name;
    private float salary;

    
}
