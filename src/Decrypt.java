public class Decrypt {
    public static char[] decrypt(char[] original, int charPosition) {
        char[] processedText = new char[original.length];

        for (int i = 0; i < original.length; i++) {

            for (int j = 0; j < Running.ALPHABET.length; j++)
                if (Running.ALPHABET[j] == original[i]) {
                    int value = j - charPosition % Running.ALPHABET.length;

                    if (value <0){
                        value += Running.ALPHABET.length;
                    }
                    processedText[i] = Running.ALPHABET[(value) % Running.ALPHABET.length];
                }
        }
        return processedText;
    }
}
