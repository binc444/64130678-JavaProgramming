import java.util.Scanner;

public class ManagePhoneBook {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nPHONEBOOK MANAGEMENT SYSTEM");
            System.out.println("1. Insert Phone");
            System.out.println("2. Remove Phone");
            System.out.println("3. Update Phone");
            System.out.println("4. Search Phone");
            System.out.println("5. Sort");
            System.out.println("6. Show All");
            System.out.println("7. Exit");
            System.out.print("Chọn một tùy chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Đọc dòng trống

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String phone = scanner.nextLine();
                    phoneBook.insertPhone(name, phone);
                    break;
                case 2:
                    System.out.print("Nhập tên để xóa: ");
                    name = scanner.nextLine();
                    phoneBook.removePhone(name);
                    break;
                case 3:
                    System.out.print("Nhập tên để cập nhật: ");
                    name = scanner.nextLine();
                    System.out.print("Nhập số điện thoại mới: ");
                    String newPhone = scanner.nextLine();
                    phoneBook.updatePhone(name, newPhone);
                    break;
                case 4:
                    System.out.print("Nhập tên để tìm kiếm: ");
                    name = scanner.nextLine();
                    phoneBook.searchPhone(name);
                    break;
                case 5:
                    phoneBook.sort();
                    break;
                case 6:
                    phoneBook.showAll();
                    break;
                case 7:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 7);

        scanner.close();
    }
}

