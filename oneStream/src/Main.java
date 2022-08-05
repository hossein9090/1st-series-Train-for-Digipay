import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class Main {
    public static void main(String[] args) {
        List<String> name = Arrays.asList("a","a","b","b","b","c","c","c","d");

        Map<String, Long> collect = name.stream().sorted()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        LinkedHashMap<String, Long> collect1 = collect.entrySet().stream()
                .sorted((Collections.reverseOrder(Map.Entry.comparingByValue())))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        List<List<String>> lists = collect1.keySet().stream()
                .map(x -> Collections.nCopies(Math.toIntExact(collect.get(x)), x))
                .collect(Collectors.toList());
        System.out.println(lists);
    }
}
