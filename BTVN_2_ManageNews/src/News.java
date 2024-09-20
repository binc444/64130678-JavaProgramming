import java.util.Scanner;

public class News implements INews{
	// Khai báo các thuộc tính
    private int ID;
    private String Title;
    private String PublishDate;
    private String Author;
    private String Content;
    private float AverageRate;
    private int[] RateList = new int[3]; // Mảng 3 phần tử để lưu đánh giá
    
    public News() {
    	
    }

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getPublishDate() {
		return PublishDate;
	}

	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public int[] getRateList() {
		return RateList;
	}

	public void setRateList(int[] rateList) {
		RateList = rateList;
	}

	public float getAverageRate() {
		return AverageRate;
	}

	@Override
    public void Display() {
        System.out.println("Title: " + Title);
        System.out.println("Publish Date: " + PublishDate);
        System.out.println("Author: " + Author);
        System.out.println("Content: " + Content);
        System.out.println("Average Rate: " + AverageRate);
    }
    
	// Phương thức Calculate để tính AverageRate từ RateList
    public void Calculate() {
        int sum = 0;
        for (int rate : RateList) {
            sum += rate;
        }
        AverageRate = sum / 3.0f;
    }
    
 // Phương thức nhập đánh giá từ người dùng
    public void inputRateList() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập 3 đánh giá (Rate từ 1 đến 5):");
        for (int i = 0; i < 3; i++) {
            System.out.print("Đánh giá " + (i + 1) + ": ");
            RateList[i] = scanner.nextInt();
        }
    }
    
}
