package year2015.day2;

import java.util.Arrays;

public class Present {

    private final int length;
    private final int width;
    private final int height;

    private int smallestSide;
    private int requiredWrappingPaper;

    private int smallestPerimeter;
    private int requiredRibbon;

    public Present(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;

        //part 1
        setSmallestSide();
        setRequiredWrappingPaper();

        //part 2
        setSmallestPerimeter();
        setRequiredRibbon();
    }

    public int getRequiredWrappingPaper() {
        return requiredWrappingPaper;
    }

    public int getRequiredRibbon() {
        return requiredRibbon;
    }

    private void setSmallestSide() {
        int[] values = {length, width, height};

        Arrays.sort(values);
        this.smallestSide = values[0] * values[1];
    }

    private void setRequiredWrappingPaper() {
        this.requiredWrappingPaper =
                (2 * length * width) +
                        (2 * width * height) +
                        (2 * height * length) +
                        smallestSide;
    }

    public void setSmallestPerimeter() {
        int[] values = {length, width, height};

        Arrays.sort(values);
        this.smallestPerimeter = values[0] + values[0] + values[1] + values[1];
    }

    public void setRequiredRibbon() {
        int volume = length * width * height;
        this.requiredRibbon = smallestPerimeter + volume;
    }

    public void print() {
        System.out.println(length + "x" + width + "x" + height
                + ", smallest side: " + smallestSide
                + ", required wrapping paper: " + requiredWrappingPaper);
    }
}
