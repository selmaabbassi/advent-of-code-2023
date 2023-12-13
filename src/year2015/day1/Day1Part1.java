package year2015.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1Part1 {

    public static void main(String[] args) {
        Path filePath = Path.of("src/year2015/day1/d1.txt");

        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;

            while ((line = reader.readLine()) != null) {
                Pattern start = Pattern.compile("[(]");
                Pattern end = Pattern.compile("[)]");

                Matcher startMatcher = start.matcher(line);
                Matcher endMatcher = end.matcher(line);

                int countStart = 0;
                int countEnd = 0;

                while (startMatcher.find()) {
                    countStart++;
                }

                while (endMatcher.find()) {
                    countEnd++;
                }

                int level = countStart - countEnd;
                System.out.println("Santa is at level " + level + "!");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
