package year2022.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Stack;

public class DayOnePartTwo {

    public static void main(String[] args) {
        Path filePath = Path.of("src/year2022/day1/d1.txt");

        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;
            Stack<Integer> stack = new Stack<>();

            int sumCalories = 0;

            while ((line = reader.readLine()) != null) {
                if (line.equals("")) {
                    stack.push(sumCalories);
                    sumCalories = 0;
                } else {
                    sumCalories += Integer.parseInt(line);
                }
            }

            List<Integer> sorted = stack.stream().sorted().toList();
            List<Integer> three_highest = sorted.subList(sorted.size() - 3, sorted.size());
            Integer score = three_highest.stream().reduce(0, Integer::sum);
            System.out.println(score);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
