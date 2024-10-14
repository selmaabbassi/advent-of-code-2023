package year2015.day5;

import java.util.List;

public class NiceProcessor {

    List<String> input;

    public NiceProcessor(List<String> input) {
        this.input = input;
    }

    public int numberOfNiceStrings() {
        int count = 0;

        for (String line : input) {
            if (isNice(line))
                count++;
        }

        return count;
    }

    private boolean isNice(String input) {
        return containsThreeVowels(input)
                && appearsTwiceInARow(input)
                && !containSpecialStrings(input);
    }

    private boolean containsThreeVowels(String input) {
        char[] charArray = input.toCharArray();
        int vowelCount = 0;

        for (char c : charArray) {
            if (isAVowel(c))
                vowelCount++;
        }

        return vowelCount >= 3;
    }

    private boolean isAVowel(char c) {
        c = Character.toUpperCase(c);
        return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    private boolean appearsTwiceInARow(String input) {
        char[] charArray = input.toCharArray();

        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == charArray[i + 1])
                return true;
        }
        return false;
    }

    private boolean containSpecialStrings(String input) {
        List<String> substrings = List.of("ab", "cd", "pq", "xy");

        for (String substring : substrings) {
            if (input.contains(substring))
                return true;
        }
        return false;
    }
}
