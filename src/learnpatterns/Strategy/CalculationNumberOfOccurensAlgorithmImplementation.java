package learnpatterns.Strategy;

import java.util.*;
import java.util.stream.Collectors;

public class CalculationNumberOfOccurensAlgorithmImplementation implements CalculationNumberOfOccurens {
    public Map<Integer, Integer> calculate(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arraycopied = Arrays.copyOf(array, array.length);
        Arrays.sort(arraycopied);
        int k = 1;
        for (int i = 1; i < array.length; i++) {
            if (arraycopied[i - 1] == arraycopied[i]) {
                k++;
            } else {
                map.put(arraycopied[i - 1], k);
                k = 1;
            }
        }
        return map;
    }
}
