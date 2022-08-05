import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) {
        Map<Integer,Map<Integer,List<String>>> result = new HashMap<>();

        String[] enteredNames = new String[]{
                "Amir", "Hatef", "Mehran", "Mojtaba", "Mohammad",
                "Ali", "Davood", "Reza", "Mohsen"};
        Map<Integer, List<String>> countCharNameMap = Stream.of(enteredNames)
                .collect(groupingBy(String::length));
        System.out.println(countCharNameMap);
        countCharNameMap.forEach((Integer, String)-> System.out.println("number of "+Integer + " character " + countCharNameMap.get(Integer).size()));
    }
}

