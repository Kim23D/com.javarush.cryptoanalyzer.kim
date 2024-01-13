import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Running {
    protected static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й','к', 'л', 'м',
            'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я',
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'Й','К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У',
            'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я',
            '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', '{', '}', '[', ']', '(', ')'};

    private static char[] workChar;
    private static ArrayList<Character> arrayBruteForce = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите режим программы: \n1. Зашифровать текст\n2. Расшифровать текст \n3. Взлом brute force");
        int choise = scanner.nextInt();
        System.out.println("Укажите путь к файлу:");
        System.out.println("Укажите путь к файлу для сохранения данных:");
        try (Scanner scan = new Scanner(System.in);
             BufferedReader bufferedReader = new BufferedReader(new FileReader(scan.nextLine()));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(scan.nextLine()))) {

            if (choise == 1 || choise == 2) {
                System.out.println("Введите ключ:");
                int key = scanner.nextInt();
                while (bufferedReader.ready()) {
                    String str = bufferedReader.readLine();
                    workChar = str.toCharArray();

                    if (choise == 1) {
                        char[] encrypt = Encrypt.encrypt(workChar, key);
                        for (char c : encrypt) {
                            bufferedWriter.write(c);
                        }
                        bufferedWriter.write("\n");
                    } else if (choise == 2) {
                        char[] decrypt = Decrypt.decrypt(workChar, key);
                        for (char c : decrypt) {
                            bufferedWriter.write(c);
                        }
                        bufferedWriter.write("\n");
                    }
                }
            } else if (choise == 3) {
                while (bufferedReader.ready()) {
                    String str = bufferedReader.readLine();
                    workChar = str.toCharArray();

                    for (char c : workChar) {
                        arrayBruteForce.add(c);
                    }
                }
                char[] aa = new char[arrayBruteForce.size()];
                for (int i = 0; i < arrayBruteForce.size(); i++) {
                    aa[i] = arrayBruteForce.get(i);
                    for (int j = 0; j < ALPHABET.length; j++) {
                        bufferedWriter.write("Взломанный текст: ");
                        for (char c : Decrypt.decrypt(aa, i)) {
                            bufferedWriter.write(c);
                        }
                        bufferedWriter.write("\" - Номер ключа: " + i);
                        bufferedWriter.write("\n");
                        bufferedWriter.write("\n");
                    }
                }
                for (int i = 0; i < ALPHABET.length; i++) {
                    bufferedWriter.write("Взломанный текст: ");
                    for (char c : Decrypt.decrypt(aa, i)) {
                        bufferedWriter.write(c);
                    }
                    bufferedWriter.write("\" - Номер ключа: " + i);
                    bufferedWriter.write("\n");
                    bufferedWriter.write("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
