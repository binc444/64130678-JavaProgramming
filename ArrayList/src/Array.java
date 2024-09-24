import java.util.ArrayList;

public class Array {

	public static void main(String[] args) {
		// Tạo một ArrayList
        ArrayList<String> list = new ArrayList<>();

        //add() để thêm phần tử
        list.add("Ô 1");
        list.add("Ô 2");
        list.add("Ô 3");
        System.out.println("Danh sách sau khi thêm phần tử: " + list);

        //size() để trả về kích thước của danh sách
        System.out.println("Số phần tử trong danh sách: " + list.size());

        //contains() để kiểm tra một phần tử có trong danh sách hay không
        System.out.println("Kiểm tra có Ô 1 trong mảng không " + list.contains("Ô 1"));

        //ensureCapacity() để đảm bảo kích thước tối thiểu của danh sách
        list.ensureCapacity(10); // Đảm bảo danh sách có thể chứa ít nhất 10 phần tử

        //clear() để xóa tất cả các phần tử trong danh sách
        list.clear();
        System.out.println("Danh sách sau khi clear(): " + list);

        //trimToSize() để cắt kích thước danh sách
        list.trimToSize();

	}

}
