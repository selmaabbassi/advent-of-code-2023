package year2022.day4;

public class Pair {

    Elf elf1;
    Elf elf2;

    public Pair(String line) {
        createElvesFromFile(line);
    }

    public boolean fullyOverlaps() {
        System.out.println("Elf1 range: " + elf1.range);
        System.out.println("Elf2 range: " + elf2.range);


//        System.out.println("elf 1 contains elf 2: " + elf1.range.contains(elf2.range));
//        System.out.println("elf 2 contains elf 1: " + elf2.range.contains(elf1.range));
        boolean overlaps = elf1.range.contains(elf2.range) || elf2.range.contains(elf1.range);
        System.out.println("Overlaps: " + overlaps);

        return overlaps;
    }

    private void createElvesFromFile(String line) {
        String[] split = line.split(",");
        this.elf1 = new Elf(split[0]);
        this.elf2 = new Elf(split[1]);
    }
}
