import java.util.ArrayList;
import java.util.Scanner;

public class ManageBooks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Book> bookList = new ArrayList<>(); // Danh sách để lưu các đối tượng Book
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nBOOKS MANAGEMENT SYSTEM");
            System.out.println("1. Insert new book");
            System.out.println("2. View list of books");
            System.out.println("3. Average Price");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống sau khi nhập số

            switch (choice) {
                case 1:
                    // Tạo một đối tượng Book mới và nhập thông tin
                    Book book = new Book();
                    System.out.print("Enter the name of the book: ");
                    book.setName(scanner.nextLine());
                    System.out.print("Enter publication date: ");
                    book.setPublishDate(scanner.nextLine());
                    System.out.print("Enter author: ");
                    book.setAuthor(scanner.nextLine());
                    System.out.print("Enter language: ");
                    book.setLanguage(scanner.nextLine());

                    // Nhập danh sách giá
                    book.inputPriceList();

                    // Thêm sách vào danh sách
                    bookList.add(book);
                    break;

                case 2:
                    // Hiển thị danh sách sách
                    for (Book b : bookList) {
                        b.display();
                        System.out.println("-------------");
                    }
                    break;

                case 3:
                    // Tính và hiển thị giá trung bình cho từng cuốn sách
                    for (Book b : bookList) {
                        b.calculateAveragePrice(); // Tính giá trung bình
                        b.display(); // Hiển thị thông tin sách
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
