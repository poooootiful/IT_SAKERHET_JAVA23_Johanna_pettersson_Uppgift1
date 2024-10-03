import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class hashing {

    //Metod for hash generating
    public static String generateHash(String data, String algorithm) throws NoSuchAlgorithmException {
        //make instence of MessageDigest for the algoritm
        MessageDigest digest = MessageDigest.getInstance(algorithm);

        // Mata in datan till hash-funktionen
        byte[] hashBytes = digest.digest(data.getBytes());

        // Konvertera bytes till en läsbar form (Base64 eller hexadecimal)
        return bytesToHex(hashBytes); // Alternativt: Base64.getEncoder().encodeToString(hashBytes);
    }

    // Metod för att konvertera bytes till en hex-sträng
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}