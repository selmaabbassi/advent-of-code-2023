package year2023.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day8 {

    public static void main(String[] args) {
        Path filePath = Path.of("src/year2023/day8/d8-example-part2.txt");
//        Path filePath = Path.of("src/year2023/day8/d8.txt");
        String instructions_example = "RL";
        String instructions_example_2 = "LLR";
        String instructions_example_part2 = "LR";
        String instructions_main = "LLLRRLRRRLLRRLRRLLRLRRLRRRLRRLRRLRRRLRLRRLRLRRLRRLLRRLRLLRRLLLRRRLRRLRLRLRRRLRLLRRLRRRLRRLRRLRRLRLLRLLRRLRRRLRRLRLRRLRRRLRRLLRLLRRLRRRLLRRRLRLRRRLLRLRRLRRLLRRLRRLLLRRRLRLRRRLRRLLRLRRLRLLRRRLRLRLLRLRRRLRLRRRLRRLRLRLLRLRRRLRRLRRRLRRRLRLRRRLRRRLLLLRLRLRRRLLLRLRRRLRRLRLRRLLRLLRRRR";

        String instructions = instructions_example_part2;

        LineParser parser = new LineParser(instructions);
        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;

            while ((line = reader.readLine()) != null) {
                parser.appendNode(line);
            }

//            parser.print();
            Map map = parser.getMap();

//            int steps = map.calculateStepsPart1();
//            System.out.println("ZZZ found after " + steps + " steps");

            int steps2 = map.calculateStepsPart2();
            System.out.println("ZZZ found after " + steps2 + " steps");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
