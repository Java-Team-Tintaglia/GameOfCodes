package utils;

public class Utils {
	
	 public static String hidePassword(int length) {
	     if (length < 0) {
	         throw new IllegalArgumentException("Length cannot be negative number!");
         }

         StringBuilder password = new StringBuilder();
         for (int i = 0; i < length; i++) {
             password.append("*");
         }

         return password.toString();
    }
}
