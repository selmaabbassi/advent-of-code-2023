package year2023.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Day3Part2 {
        public static void main(String[] args) {
                Path filePath = Path.of("src/year2023/day3/d3-example.txt");

                LinkedSchematics schematics = new LinkedSchematics();

                try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
                        String line;

                        while ((line = reader.readLine()) != null) {
                                schematics.append(line);
                        }

                        schematics.linkSchematicNodes();

                        List<Integer> gearParts = schematics.findGearParts();

                        System.out.println(Arrays.toString(gearParts.toArray()));


                        System.out.println("Sum of all parts : ");

                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

}
