package year2023.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day3Part1 {
        public static void main(String[] args) {
                Path filePath = Path.of("src/year2023/day3/d3.txt");

                LinkedSchematics schematics = new LinkedSchematics();

                try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
                        String line;

                        while ((line = reader.readLine()) != null) {
                                schematics.append(line);
                        }

                        schematics.linkSchematicNodes();
                        schematics.print();

                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

}
