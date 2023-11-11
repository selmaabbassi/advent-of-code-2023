package year2022.day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Alphabet {

    public static Map<String, Integer> getScoresMap() {
        HashMap<String, Integer> scoresMap = new HashMap<>();
        List<String> alphabetList = getAlphabetList();

        for (int i = 0; i < alphabetList.size(); i++) {
            scoresMap.put(alphabetList.get(i), i + 1);
        }

        return scoresMap;
    }

    private static List<String> getAlphabetList() {
        List<String> alphabetList = new ArrayList<>();

        for (char letter = 'a'; letter <= 'z'; letter++) {
            alphabetList.add(String.valueOf(letter));
        }

        for (char letter = 'A'; letter <= 'Z'; letter++) {
            alphabetList.add(String.valueOf(letter));
        }

        return alphabetList;
    }
}
