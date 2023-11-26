package year2022.day4;

public class Pair implements Comparable<Pair>{

    Elf elf1;
    Elf elf2;

    public Pair(String line) {
        createElvesFromFile(line);
    }

    public boolean fullyOverlaps() {
        return (elf1.firstValue <= elf2.firstValue && elf1.secondValue >= elf2.secondValue) || (elf2.firstValue <= elf1.firstValue && elf2.secondValue >= elf1.secondValue);
    }

    public boolean anyOverlaps() {
        return elf1.rangeList.stream().anyMatch(e -> elf2.rangeList.contains(e));
    }

    private void createElvesFromFile(String line) {
        String[] split = line.split(",");
        this.elf1 = new Elf(split[0]);
        this.elf2 = new Elf(split[1]);
    }

    @Override
    public int compareTo(Pair otherPair) {
        return 0;
    }
}
