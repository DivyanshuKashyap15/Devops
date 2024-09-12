import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Caesar Cipher Encryption and Decryption Tool");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        System.out.print("Choose an option (1/2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            System.out.print("Enter the plaintext: ");
            String plaintext = scanner.nextLine();

            System.out.print("Enter the encryption key (a number): ");
            int key = scanner.nextInt();

            String encryptedText = encrypt(plaintext, key);
            System.out.println("Encrypted Text: " + encryptedText);
        } else if (choice == 2) {
            System.out.print("Enter the ciphertext: ");
            String ciphertext = scanner.nextLine();

            System.out.print("Enter the decryption key (a number): ");
            int key = scanner.nextInt();

            String decryptedText = decrypt(ciphertext, key);
            System.out.println("Decrypted Text: " + decryptedText);
        } else {
            System.out.println("Invalid choice. Please choose 1 or 2.");
        }

        scanner.close();
    }

    public static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                result.append((char) ((c - base + key) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, int key) {
        return encrypt(text, 26 - key); // Decryption is the same as encryption with the complementary key.
}
}