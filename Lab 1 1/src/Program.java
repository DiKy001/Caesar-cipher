import java.util.Scanner;

public class Program {

    static Scanner in = new Scanner(System.in);

    // Caesar cipher
    static String encrypt(String s, int k) {
        String encrypted = "";
        for (int i = 0; i < s.length(); i++) {
            encrypted = encrypted.concat(String.valueOf(encryptChar(s.charAt(i), k)));
        }
        return encrypted;
    }

    static char encryptChar(char c, int k) {
        c = Character.toLowerCase(c);
        if (c == 'ё') {
            c = 'e';
        }
        if (c == ' ')
            return ' ';
        int alphabet = c > 'z' ? 'я' - 'а' + 1: 'z' - 'a' + 1;
        int startedLetter = c > 'z' ? 'а': 'a';
        return (char)(startedLetter + (c - startedLetter + k) % alphabet);
    }

    static String decrypt(String s, int k) {
        String decrypted = "";
        for (int i = 0; i < s.length(); i++) {
            decrypted = decrypted.concat(String.valueOf(decryptChar(s.charAt(i), k)));
        }
        return decrypted;
    }

    static char decryptChar(char c, int k) {

        c = Character.toLowerCase(c);
        if (c == ' ')
            return ' ';
        int alphabet = c > 'z' ? 'я' - 'а' + 1: 'z' - 'a' + 1;
        int startLetter = c > 'z' ? 'а': 'a';
        return (char)(startLetter + (c - startLetter + alphabet - k) % alphabet);
    }

    public static void main(String[] args) {
        System.out.println("Enter the string you want to encrypt and encrypt key");
        System.out.println("Encrypted string:\n" + encrypt(in.nextLine(), in.nextInt()));
        in.nextLine();
        System.out.println("Enter the string you want to decrypt and decrypt key");
        System.out.println("Decrypted string:\n" + decrypt(in.nextLine(), in.nextInt()));

    }
}
