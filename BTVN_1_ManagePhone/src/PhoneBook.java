import java.util.ArrayList;
import java.util.Collections;

public class PhoneBook {
    // Sử dụng ArrayList để lưu thông tin người dùng với số điện thoại
    private ArrayList<String> phoneList;

    public PhoneBook() {
        phoneList = new ArrayList<>();
    }

    // Thêm số điện thoại cho người dùng mới hoặc thêm số cho người dùng hiện tại
    public void insertPhone(String name, String phone) {
        for (int i = 0; i < phoneList.size(); i++) {
            if (phoneList.get(i).startsWith(name + ":")) {
                // Kiểm tra xem số điện thoại có tồn tại chưa
                if (!phoneList.get(i).contains(phone)) {
                    phoneList.set(i, phoneList.get(i) + " : " + phone);
                }
                return;
            }
        }
        // Nếu tên không tồn tại, thêm người dùng mới
        phoneList.add(name + ": " + phone);
    }

    // Xóa người dùng khỏi danh sách
    public void removePhone(String name) {
        phoneList.removeIf(entry -> entry.startsWith(name + ":"));
    }

    // Cập nhật số điện thoại cho người dùng
    public void updatePhone(String name, String newPhone) {
        for (int i = 0; i < phoneList.size(); i++) {
            if (phoneList.get(i).startsWith(name + ":")) {
                phoneList.set(i, name + ": " + newPhone);
                return;
            }
        }
        System.out.println("Can't find that person " + name);
    }

    // Tìm kiếm số điện thoại theo tên người dùng
    public void searchPhone(String name) {
        for (String entry : phoneList) {
            if (entry.startsWith(name + ":")) {
                System.out.println(entry);
                return;
            }
        }
        System.out.println("Can't find that person " + name);
    }

    // Sắp xếp danh bạ theo tên người dùng
    public void sort() {
        Collections.sort(phoneList);
        System.out.println("PhoneBook are sorted");
    }

    // Hiển thị toàn bộ danh bạ
    public void showAll() {
        for (String entry : phoneList) {
            System.out.println(entry);
        }
    }
}
