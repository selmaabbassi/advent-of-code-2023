package year2022.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static year2022.day3.Alphabet.getScoresMap;

public class DayThreePartOne {

    public static void main(String[] args) {
        Path filePath = Path.of("src/year2022/day3/d3.txt");

        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;

            int result = 0;

            while ((line = reader.readLine()) != null) {

                final int mid = line.length() / 2;
                String[] parts = {line.substring(0, mid), line.substring(mid)};

                String commonChar = findCommonChars(parts[0], parts[1]);
                Map<String, Integer> scoresMap = getScoresMap();

                result += scoresMap.get(commonChar);

            }
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String findCommonChars(String str1, String str2) {
        StringBuilder commonChars = new StringBuilder();

        for (char ch : str1.toCharArray()) {
            if (str2.indexOf(ch) != -1 && commonChars.indexOf(String.valueOf(ch)) == -1) {
                commonChars.append(ch);
            }
        }

        return commonChars.toString();
    }
}
