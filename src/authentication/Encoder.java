package authentication;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Encoder {
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static String cryptedPassword;
    private static String decoded;
    static BASE64Encoder enc = new BASE64Encoder();
    static BASE64Decoder dec = new BASE64Decoder();

    public static String cryptingPassword(String password) {
        String key = "key phrase used for XOR-ing";
        password = xorMessage(password, key);

        cryptedPassword = base64encode(password);
        return cryptedPassword;

    }

    public static String decryptPassword(String encryptedpassword) {
        String key = "key phrase used for XOR-ing";
        encryptedpassword = base64decode(encryptedpassword);
        decoded = xorMessage(encryptedpassword, key);
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

            char[] keys = key.toCharArray();
            char[] mesg = message.toCharArray();

            int ml = mesg.length;
            int kl = keys.length;
            char[] newmsg = new char[ml];

            for (int i = 0; i < ml; i++) {
                newmsg[i] = (char) (mesg[i] ^ keys[i % kl]);
            }

            return new String(newmsg);
        } catch (Exception e) {
            return null;
        }
    }
}
