package utils;

public class Utils {
	
	 public static String hidePassword(int length) {
	        StringBuilder password = new StringBuilder();
	        for (int i = 0; i < length; i++) {
	            password.append("*");
	        }
	        return password.toString();
	    }
}
