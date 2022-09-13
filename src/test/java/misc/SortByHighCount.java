package misc;

import lombok.var;
import java.util.*;

public class SortByHighCount {

    private static Map<String, Integer> countCharacterOccurences(String value) {
        System.out.println("\noriginal input string: " + value);
        final Map<String, Integer> counts = new HashMap<>();

        for (char c : value.toCharArray()) {
            if (counts.containsKey(String.valueOf(c))) {
                Integer current = counts.get(String.valueOf(c));
                counts.put(String.valueOf(c), current + 1);
            }
            else {
                counts.put(String.valueOf(c), 1);
            }
        }

        System.out.println("\nunsorted hashmap counts:");
        for (var entry : counts.entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue());
        return counts;
    }

    private static Map<String, Integer> sortHashMap(Map<String, Integer> unsortedMap) {
        SortedSet<Map.Entry<String, Integer>> sorted = new TreeSet<>((e1, e2) -> {
            int res = e1.getValue().compareTo(e2.getValue());
            if (res == 0)
                return e1.getKey().compareTo(e2.getKey());
            return res * -1;
        });

        sorted.addAll(unsortedMap.entrySet());

        Map<String, Integer> sortedLinkedHashMap = new LinkedHashMap<>();
        for (var entry : sorted) sortedLinkedHashMap.put(entry.getKey(), entry.getValue());

        System.out.println("\nsorted linked hashmap counts:");
        for (var entry : sortedLinkedHashMap.entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue());

        return sortedLinkedHashMap;
    }

    private static void printCountedCharacters(Map<String, Integer> value) {
        String output = "";
        for (var entry : sortHashMap(value).entrySet()) {
            for (int i = 0; i < Integer.valueOf(entry.getValue()); i++)
                output += entry.getKey();
        }
        System.out.println("\nresults: " + output);
    }


    public static void main(String[] args) {
        String input = "javabbbbbbcc";  // should return “bbbbbaaccjv";
        printCountedCharacters( countCharacterOccurences(input) );
    }
}