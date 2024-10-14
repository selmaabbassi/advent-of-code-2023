package year2015.day4;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Day4 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input = "yzbqklnj";

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(input.getBytes());
        byte[] digest = md5.digest();

        Base64.Encoder encoder = Base64.getEncoder();

    }

    private String toHex(String arg) {
        return String.format("%x", new BigInteger(1, arg.getBytes(/* charset */)));
    }
}
