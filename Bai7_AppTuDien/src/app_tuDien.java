import java.util.HashMap;
import java.util.Map;

public class app_tuDien {
	public static void main(String[] args) {
	Map<String, String> vocab = new HashMap<String, String>();
    vocab.put("Hello", "Xin chào");
    vocab.put("Apple", "Táo");
    System.out.println(vocab.get("Hello"));
}
	}
