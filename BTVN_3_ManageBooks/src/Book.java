import java.util.Scanner;

public class Book implements IBook {	
    private int id;
    private String name;
    private String publishDate;
    private String author;
    private String language;
    private float averagePrice;
    private int[] priceList = new int[5]; // Mảng chứa 5 giá trị
    private static int autoId = 1; // ID tự động tăng dần
    
    public Book() {
        this.id = autoId++;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public float getAveragePrice() {
		return averagePrice;
	}

	public int[] getPriceList() {
		return priceList;
	}

	public void setPriceList(int[] priceList) {
		this.priceList = priceList;
	}

	public static int getAutoId() {
		return autoId;
	}

	public static void setAutoId(int autoId) {
		Book.autoId = autoId;
	}
    
	// Phương thức thực thi từ giao diện IBook
    @Override
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Publish Date: " + publishDate);
        System.out.println("Author: " + author);
        System.out.println("Language: " + language);
        System.out.println("Average Price: " + averagePrice);
    }

    // Phương thức nhập danh sách giá (PriceList)
    public void inputPriceList() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 5 book prices:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Price " + (i + 1) + ": ");
            priceList[i] = scanner.nextInt();
        }
    }

    // Phương thức tính toán AveragePrice
    public void calculateAveragePrice() {
        int sum = 0;
        for (int price : priceList) {
            sum += price;
        }
        this.averagePrice = sum / 5.0f;
    }
}
