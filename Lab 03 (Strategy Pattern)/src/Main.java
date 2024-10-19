import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner= new Scanner(System.in);

        EncryptionService encryptionService= new EncryptionService();

        System.out.println("Enter an Encryption Strategy:");
        System.out.println("1. AES");
        System.out.println("2. DES");
        System.out.println("3. Caesar Cipher");

        int choice= scanner.nextInt();
        scanner.nextLine();

        switch(choice){
            case 1:
                try {
                    encryptionService.setEncryptionStrategy(new AESEncryption());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    encryptionService.setEncryptionStrategy(new DESEncryption());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                System.out.println("Enter the shift value for Caesar Cipher:");
                int shift= scanner.nextInt();
                encryptionService.setEncryptionStrategy(new CaesarCipherStrategy(shift));
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }



        System.out.print("Enter the file path to encrypt: ");
        String inputFilePath = scanner.nextLine();


        String fileContents = new String(Files.readAllBytes(Paths.get(inputFilePath)));


        String encryptedData = encryptionService.encryptData(fileContents);


        Path inputPath = Paths.get(inputFilePath);
        Path parentDir = inputPath.getParent();
        String fileName = inputPath.getFileName().toString();


        Path outputFilePath = parentDir.resolve("encrypted_" + fileName);
        System.out.println("Encrypted file will be saved at: " + outputFilePath.toAbsolutePath());


        Files.write(outputFilePath, encryptedData.getBytes());
        System.out.println("File encrypted successfully: " + outputFilePath);

        String decryptedData = encryptionService.decryptData(encryptedData);
        System.out.println("Decrypted data: \n" + decryptedData);

    }
}