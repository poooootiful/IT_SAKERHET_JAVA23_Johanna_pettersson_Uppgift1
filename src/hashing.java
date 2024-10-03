import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;


public class hashing {

    //Metod for hash generating
    public static String generateHash(String data,byte[] salt, String algorithm) throws NoSuchAlgorithmException {
        //make instence of MessageDigest for the algoritm
        MessageDigest digest = MessageDigest.getInstance(algorithm);

        //Add salt
        digest.update(salt);
        //feed data to hash function
        byte[] hashBytes = digest.digest(data.getBytes());

        //Convert bytes to a readable hex
        return Base64.getEncoder().encodeToString(hashBytes);
    }
    public static byte[] generateSalt() throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16]; // Salt is 16 bytes
        random.nextBytes(salt);
        return salt;
    }
}