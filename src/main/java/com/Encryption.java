package com;
import java.security.SecureRandom;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
	 static SecureRandom random = new SecureRandom();

	public static String generateSalt() {
		 byte bytes[]= new byte[20];
		 random.nextBytes(bytes);
		 return random.toString();
	}
	 /*Computes the hash of the given string salted.
     * @param unhashed -> the string to hash
     * @param salt -> the salt to use
     * @return -> the hash of the given string salted and uppercase.
     * @throws -> NoSuchAlgorithmException
	  */
	public static String getHashMD5(String unhashed, String salt) {
        // Hash the password.
        final String toHash = salt + unhashed + salt;
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            return "00000000000000000000000000000000";
        }
        messageDigest.update(toHash.getBytes(), 0, toHash.length());
        String hashed = new BigInteger(1, messageDigest.digest()).toString(16);
        if (hashed.length() < 32) {
            hashed = "0" + hashed;
        }
        return hashed;
    }
}
