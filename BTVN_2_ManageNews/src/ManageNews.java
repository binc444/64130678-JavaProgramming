import java.util.ArrayList;
import java.util.Scanner;

public class ManageNews {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<News> newsList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\nNEWS MANAGEMENT SYSTEM");
            System.out.println("1. Insert news");
            System.out.println("2. View list news");
            System.out.println("3. Average rate");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Đọc dòng trống sau khi nhập số

            switch (choice) {
                case 1:
                    // Tạo đối tượng News mới và nhập thông tin
                    News news = new News();
                    System.out.print("Enter Title: ");
                    news.setTitle(scanner.nextLine());
                    System.out.print("Enter Publish Date: ");
                    news.setPublishDate(scanner.nextLine());
                    System.out.print("Enter Author: ");
                    news.setAuthor(scanner.nextLine());
                    System.out.print("Enter Content: ");
                    news.setContent(scanner.nextLine());

                    // Nhập đánh giá từ người dùng
                    news.inputRateList();

                    // Thêm đối tượng vào danh sách
                    newsList.add(news);
                    break;

                case 2:
                    // Hiển thị danh sách tin tức
                    for (News n : newsList) {
                        n.Display();
                    }
                    break;

                case 3:
                    // Tính và hiển thị đánh giá trung bình cho từng tin
                    for (News n : newsList) {
                        n.Calculate(); // Tính AverageRate
                        n.Display(); // Hiển thị tin tức và AverageRate
                    }
                    break;

                case 4:
                    // Thoát chương trình
                    System.out.println("Exit.");
                    break;

                default:
                    System.out.println("Invalid selection!");
            }
        } while (choice != 4);

        scanner.close();
    }

}
