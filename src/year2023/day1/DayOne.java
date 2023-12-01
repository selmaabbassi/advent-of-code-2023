package year2023.day1;

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
                                String intValue = line.replaceAll("[^0-9]", "");
                                System.out.println("whole string " + intValue);
                                char[] charArray = intValue.toCharArray();


                                String firstAndLast = "" + charArray[0] + charArray[charArray.length - 1];


                                System.out.println("first and last " + firstAndLast);
                                sum += Integer.parseInt(firstAndLast);
                        }

                        System.out.println("SUM: " + sum);

                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
}
