public class Encrypt {
    public static char[] encrypt(char[] original, int charPosition) {
        char[] processedText = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < Running.ALPHABET.length; j++)
                if (Running.ALPHABET[j] == original[i]) {
                    processedText[i] = Running.ALPHABET[(j + charPosition) % Running.ALPHABET.length];
                }
        }
        return processedText;
    }
}
