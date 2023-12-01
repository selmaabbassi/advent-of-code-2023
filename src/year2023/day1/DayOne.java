package year2023.day1;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class DayOne {

    /**
     * Day 1:
     * Extract first and last int values from a string
     *
     * @param args
     */
    public static void main(String[] args) {
        Path filePath = Path.of("src/year2023/day1/d1.txt");

        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;
            int sum = 0;

            while ((line = reader.readLine()) != null) {
                System.out.println("Original line : " + line);
                line = replaceAlphabeticalNumbers(line);
                System.out.println("Replaced alpha numbers : " + line);
                String intValue = line.replace("[^0-9]", "");

                System.out.println("Replaced chars : " + intValue);

                char[] charArray = intValue.toCharArray();
                String firstAndLast;

                firstAndLast = "" + charArray[0] + charArray[charArray.length - 1];
                System.out.println("First and last : " + firstAndLast);

                int i = Integer.parseInt(firstAndLast);
                sum += i;
                System.out.println("Accumulating sum : " + sum);
                System.out.println("");
            }

            System.out.println("SUM: " + sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private static String replaceAlphabeticalNumbers(String line) {
//        String replaced = "";
////        String[] searchList = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
////        String[] replacementList = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
////        String result = StringUtils.replaceEach(line, searchList, replacementList);
////        System.out.println("Replaced line : " + result);
//
//        replaced = line.replace("one", "1");
//        replaced = replaced.replace("two", "2");
//        replaced = replaced.replace("three", "3");
//        replaced = replaced.replace("four", "4");
//        replaced = replaced.replace("five", "5");
//        replaced = replaced.replace("six", "6");
//        replaced = replaced.replace("seven", "7");
//        replaced = replaced.replace("eight", "8");
//        replaced = replaced.replace("nine", "9");
//
//        return replaced;
//    }

    private static String replaceAlphabeticalNumbers(String input){
        String[] validNumbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i=0; i< validNumbers.length; i++){
            input = input.replace(validNumbers[i], mixValue(validNumbers[i], i+1));
        }

        return input;
    }

    private static String mixValue(String str, int n){
        StringBuilder sb = new StringBuilder(str);

        sb.insert((int)sb.length()/2, n);
        return sb.toString();
    }
}
