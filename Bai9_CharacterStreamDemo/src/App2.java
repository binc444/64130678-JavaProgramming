import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App2 {
	public static void main(String[] args) throws IOException
	{
	FileReader fr = new FileReader("songque.txt");
	BufferedReader bufferedReader = new BufferedReader(fr);

	String dong1 = bufferedReader.readLine();

	System.out.println(dong1);
	}
}
