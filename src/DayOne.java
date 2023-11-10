import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DayOne {
    public static void main(String[] args) {
        Path filePath = Path.of("src/d1.txt");

        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;

            while ((line = reader.readLine()) != null) {
                List<Integer> calories = new ArrayList<>();

                if (line.equals("")) {
                    System.out.println("Newline found in the line: " + line);
                } else {
                    calories.add(Integer.valueOf(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int sumCalories(List<Integer> calories) {
        return calories.stream().reduce(0, Integer::sum);
    }
}