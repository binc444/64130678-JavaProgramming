package Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CommonUtils {
	 public static String encodePass(String password) {
	        try {
	            // Mã hóa mật khẩu với MD5
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            byte[] hashInBytes = md.digest(password.getBytes());

	            // Chuyển đổi byte[] thành chuỗi hex
	            StringBuilder sb = new StringBuilder();
	            for (byte b : hashInBytes) {
	                sb.append(String.format("%02x", b));
	            }
	            return sb.toString(); // Trả về mật khẩu đã mã hóa
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException("Error encoding password", e);
	        }
	    }
}
