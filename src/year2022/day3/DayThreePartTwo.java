package year2022.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static year2022.day3.Alphabet.getScoresMap;

public class DayThreePartTwo {

    public static void main(String[] args) {
        Path filePath = Path.of("src/year2022/day3/d3.txt");

        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;
            int result = 0;
            int lineCount = 0;
            List<String> group = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                lineCount++;
                group.add(line);

                if(lineCount == 3) {
                    System.out.println(group);
                    String commonChar = findCommonChars(group.get(0), group.get(1), group.get(2));
                    Map<String, Integer> scoresMap = getScoresMap();
                    System.out.println("commonChar: " + commonChar);
                    result += scoresMap.get(commonChar);

                    group.clear();
                    lineCount = 0;
                }
            }

            System.out.println("Result: " + result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String findCommonChars(String str1, String str2, String str3) {
        String res = "";

        for (char c : str1.toCharArray()) {
            if (str2.contains(String.valueOf(c)) && str3.contains(String.valueOf(c))) {
                res = String.valueOf(c);
            }
        }
        return  res;
    }
}
