package BankAccountApp;

public class GenerateRandomSequence {
    public static String generateNumberSequence(int length) {
        long random;
        String randomSequenceString = "";
        for (int i = 0; i < length; i++) {
            random = (long) Math.floor((Math.random() * 10));
            randomSequenceString += random;
        }
        char[] randomSequenceStringAsChars = randomSequenceString.toCharArray();
        char[] randomSequenceReturnAsChars = new char[length];
        for (int i = (randomSequenceStringAsChars.length - 1), j = length - 1; i >= 0; i--, j--) {
            randomSequenceReturnAsChars[j] = randomSequenceStringAsChars[i];
        }
        if (length > randomSequenceStringAsChars.length) {
            for (int i = 0; i < length; i++) {
                if (randomSequenceReturnAsChars[i] == '\u0000') {
                    randomSequenceReturnAsChars[i] = '0';
                }
            }
        }
        return String.valueOf(randomSequenceReturnAsChars);
    }
}
