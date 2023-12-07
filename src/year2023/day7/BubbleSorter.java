package year2023.day7;

import java.util.List;

public class BubbleSorter {

    public void sort(List<Hand> list) {
        boolean changed = true;
        int step = 0;

        do {
            changed = false;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                    swap(list, i, i + 1);
                    changed = true;
                }
            }
            step++;
        } while (changed);
    }

    private void swap(List<Hand> list, int i, int k) {
        Hand elementToSwap = list.get(i);
        Hand elementToSwapWith = list.get(k);

        list.set(i, elementToSwapWith);
        list.set(k, elementToSwap);
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}
