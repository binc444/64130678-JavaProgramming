import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class app_tuDien {
	public static void main(String[] args) {
	Map<String, String> vocab = new HashMap<String, String>();
    vocab.put("Hello", "Xin chào");
    vocab.put("Apple", "Táo");
    vocab.put("Lime", "Quả chanh");
    vocab.put("Lion", "Sư tử");
    vocab.put("Chicken", "Con gà");
    vocab.put("Elephant", "Voi");
    vocab.put("Snake", "Rắn");
    vocab.put("Tiger", "Hổ");
    vocab.put("Pen", "Cây bút");
    vocab.put("Programmer", "Lập trình viên");
    
    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhập từ cần tra: ");
    String key = scanner.nextLine();

    if (vocab.containsKey(key)) {
        System.out.println(vocab.get(key));
    } else {
        System.out.println(" không có trong từ điển!!!");
    	}	
	}
}
