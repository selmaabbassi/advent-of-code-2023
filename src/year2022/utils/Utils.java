package year2022.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Utils {

    /**
     * COPY TO READ FILE FROM PATH
     * @param args
     */
    public static void main(String[] args) {
        Path filePath = Path.of("src/year2022/d1.txt");

        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;

            while ((line = reader.readLine()) != null) {

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
