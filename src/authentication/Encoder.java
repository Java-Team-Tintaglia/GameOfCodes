package authentication;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Encoder {
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final String DEFAULT_KEY = "key phrase used for XOR-ing";
    private static String cryptedPassword;
    private static String decoded;
    private static BASE64Encoder enc = new BASE64Encoder();
    private static BASE64Decoder dec = new BASE64Decoder();

    public static String cryptingPassword(String password) {
        password = xorMessage(password, DEFAULT_KEY);
        cryptedPassword = base64encode(password);
        return cryptedPassword;

    }

    public static String decryptPassword(String encryptedpassword) {
        encryptedpassword = base64decode(encryptedpassword);
        decoded = xorMessage(encryptedpassword, DEFAULT_KEY);
        return decoded;
    }
    
    private static String base64encode(String text) {
        try {
            return enc.encode(text.getBytes(DEFAULT_ENCODING));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    private static String base64decode(String text) {
        try {
            return new String(dec.decodeBuffer(text), DEFAULT_ENCODING);
        } catch (IOException e) {
            return null;
        }
    }

    private static String xorMessage(String message, String key) {
        try {
            if (message == null || key == null) return null;

            char[] keyArray = key.toCharArray();
            char[] messageArray = message.toCharArray();

            int messageLength = messageArray.length;
            int keylength = keyArray.length;
            char[] newMessage = new char[messageLength];

            for (int index = 0; index < messageLength; index++) {
                newMessage[index] = (char) (messageArray[index] ^ keyArray[index % keylength]);
            }

            return new String(newMessage);
        } catch (Exception e) {
            return null;
        }
    }
}
