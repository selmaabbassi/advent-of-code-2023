package year2015.day5;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class NiceProcessor2 {

    List<String> input;

    public NiceProcessor2(List<String> input) {
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
        return twoCharsAppearTwice(input)
                && repeatsWithLetterBetween(input);
    }

    private boolean twoCharsAppearTwice(String input) {
        char[] charArray = input.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == charArray[i + 1]) {
                sb.append(charArray[i]);
                sb.append(charArray[i + 1]);

                String s = sb.toString();
                System.out.println(s);
                if (!s.isBlank() && StringUtils.countMatches(input, s) > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean repeatsWithLetterBetween(String input) {
        char[] charArray = input.toCharArray();

        for (int i = 0; i < charArray.length - 2; i++) {
            if (charArray[i] == charArray[i + 2]) {
                return true;
            }
        }
        return false;
    }
}
