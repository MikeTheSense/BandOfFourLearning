package learnpatterns.Strategy;

import java.util.HashMap;
import java.util.Map;

public class CalculationNumberOfOccurensMapImplementation implements CalculationNumberOfOccurens {
    public Map<Integer,Integer> calculate(int[] array)
    {
        Map<Integer,Integer> map= new HashMap<>();
        for (int i : array)
        {
            if (map.containsKey(i)) map.put(i,map.get(i)+1);
            else map.put(i,1);
        }
        return map;
    }
}
