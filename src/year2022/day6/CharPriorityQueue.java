package year2022.day6;

import java.util.PriorityQueue;

public class CharPriorityQueue<E> extends PriorityQueue<E> {

    Character[] array;

    public CharPriorityQueue(int initialCapacity) {
        super(initialCapacity);
        this.array = (Character[]) toArray();
    }

    public boolean hasDuplicates() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
