package year2015.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day1Part2 {

    public static void main(String[] args) {
        Path filePath = Path.of("src/year2015/day1/d1.txt");

        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;

            while ((line = reader.readLine()) != null) {

                char[] charArray = line.toCharArray();
                List<Integer> integers = new ArrayList<>();

                for (char c : charArray) {
                    if (c == '(') {
                        integers.add(1);
                    } else {
                        integers.add(-1);
                    }
                }

                int sum = 0;
                for (int i = 0; i < integers.size(); i++) {
                    if (sum == -1) {
                        System.out.println("Character at position " + i + " gets Santa to the basement!");
                        return;
                    }
                    sum += integers.get(i);
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
