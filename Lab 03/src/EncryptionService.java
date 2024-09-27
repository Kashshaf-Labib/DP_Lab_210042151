public class EncryptionService {

    private IEncryptionStrategy strategy;

    public String encryptData(String data) throws Exception {
        if(strategy==null)
        {
            throw new IllegalStateException("Strategy not implemented");
        }
        return strategy.encryptData(data);
    }

    public String decryptData(String encryptedData) throws Exception {
        if(strategy==null)
        {
            throw new IllegalStateException("Strategy not implemented");
        }
        return strategy.decryptData(encryptedData);
    }

    public IEncryptionStrategy getStrategy() {
        return strategy;
    }

    public void setEncryptionStrategy(IEncryptionStrategy strategy) {
        this.strategy = strategy;
    }
}
