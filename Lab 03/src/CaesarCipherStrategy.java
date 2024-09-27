public class CaesarCipherStrategy implements IEncryptionStrategy{
    private int shift;

    public CaesarCipherStrategy(int shift) {
        this.shift = shift;
    }



    @Override
    public String encryptData(String data) {
        return shiftText(data, shift);
    }

    @Override
    public String decryptData(String encryptedData) {
        return shiftText(encryptedData, -shift);
    }

    private String shiftText(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + shift + 26) % 26 + base);
            }
            result.append(c);
        }
        return result.toString();
    }

}
