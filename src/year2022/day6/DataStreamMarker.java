package year2022.day6;

import java.util.PriorityQueue;

public class DataStreamMarker {

    public DataStreamMarker() {
    }

    /**
     * example: mjqjpqmgbljsphdztnvjfqwrcgsmlb
     * step 1: put each 4 chars in queue, check if duplicate
     * if true count marker
     * if false continue
     *
     * remove first element in queue "m"
     * add 5th element to queue "p"
     * redo step 1
     * @param line
     */
    private void test(String line) {
        CharPriorityQueue<Character> queue = new CharPriorityQueue<>(4);

        char[] charArray = line.toCharArray();
        for (int i = 0; i < 4; i++) {
            queue.add(charArray[i]);
        }

        if(queue.hasDuplicates()) {

        } else {

        }
    }
}
