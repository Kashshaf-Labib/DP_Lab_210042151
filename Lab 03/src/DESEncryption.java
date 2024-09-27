import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.security.NoSuchAlgorithmException;

public class DESEncryption implements IEncryptionStrategy{

    private SecretKey secretKey;

    public DESEncryption() throws NoSuchAlgorithmException {
        KeyGenerator keyGen= KeyGenerator.getInstance("DES");
        keyGen.init(56);
        this.secretKey= keyGen.generateKey();
    }

    @Override
    public String encryptData(String data) throws Exception {
        Cipher cipher= Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, this.secretKey);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    @Override
    public String decryptData(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedData = cipher.doFinal(decodedData);
        return new String(decryptedData);
    }
}
