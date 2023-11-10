package year2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Stack;

public class DayOnePartOne {
    public static void main(String[] args) {
        Path filePath = Path.of("src/year2022/d1.txt");

        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;
            Stack<Integer> stack = new Stack<>();

            int sumCalories = 0;

            while ((line = reader.readLine()) != null) {
                if (line.equals("")) {
                    if (stack.isEmpty()) {
                        stack.push(sumCalories);
                    } else if (sumCalories > stack.peek()) {
                        stack.pop();
                        stack.push(sumCalories);
                    }
                    sumCalories = 0;
                } else {
                    sumCalories += Integer.parseInt(line);
                }
            }

            System.out.println("Highest calorie count: " + stack.peek());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}