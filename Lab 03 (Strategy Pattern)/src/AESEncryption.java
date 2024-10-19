import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Cipher;

public class AESEncryption implements IEncryptionStrategy{

    private SecretKey secretKey;

    public AESEncryption() throws NoSuchAlgorithmException {
        KeyGenerator keyGen= KeyGenerator.getInstance("AES");
        keyGen.init(128);
        this.secretKey = keyGen.generateKey();
    }

    @Override
    public String encryptData(String data) throws Exception {
        Cipher cipher= Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, this.secretKey);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    @Override
    public String decryptData(String encryptedData) throws Exception {
        Cipher cipher= Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, this.secretKey);
        byte[] decodeData=Base64.getDecoder().decode(encryptedData);
        byte[] decryptedData = cipher.doFinal(decodeData);
        return new String(decryptedData);
    }
}
