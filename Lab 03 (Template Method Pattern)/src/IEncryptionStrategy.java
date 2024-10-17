public interface IEncryptionStrategy {

    String encryptData(String data) throws Exception;

    String decryptData(String encryptedData) throws Exception;
}
