package utility;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.regex.Matcher;

public class HashingPassword {
	public static String hashing(final String password) {
		SecureRandom random = new SecureRandom();
	    byte[] salt = new byte[16];
	    random.nextBytes(salt);
	    
	    MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	    md.update(salt);
	    
	    byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
	    
	    String hashedPassword = String.format("%x", new BigInteger(hash));
	    return hashedPassword;
    }
}
