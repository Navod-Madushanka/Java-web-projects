package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
    public static String encrypt(String source){
        String md5 = "";
        try{
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(source.getBytes(),0, source.length());
            BigInteger bigInteger = new BigInteger(1, digest.digest());
            md5 = bigInteger.toString();
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException();
        }
        return md5;
    }
}
