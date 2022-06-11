package org.example.balancedwordscounter;


public class BalancedWordsCounter {

    public Integer count(String input) {
        if (input == null) throw new RuntimeException("Wrong string argument!");
        int n = input.length();
        int resultCounter = 0;

        checkStringCorrectness(input, n);

        for (int i = 0; i < n; i++) {
            for (int j = i; j <= n; j++) {
                if ((j < n && checkCondition(input.substring(i, j))) || (j == n && checkCondition(input.substring(i)))) {
                    resultCounter += 1;
                }
            }
        }
        return resultCounter;
    }

    private void checkStringCorrectness(String input, int n) {
        for (int d = 0; d < n; d++) {
            if (input.charAt(d) < 65 || input.charAt(d) > 122) {
                throw new RuntimeException("Wrong string argument!");
            }
        }
    }

    private boolean checkCondition(String inputSubstring) {
        int m = inputSubstring.length();
        if (m == 0) return false;
        int[] charCounter = new int[58];

        for (int a = 0; a < m; a++) {
            charCounter[inputSubstring.charAt(a) - 65] += 1;
        }
        int valueToCheck = charCounter[inputSubstring.charAt(0) - 65];

        for (int i : charCounter) {
            if (i != valueToCheck && i != 0) {
                return false;
            }
        }
        return true;
    }
}
