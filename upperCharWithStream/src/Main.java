import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String input = "a1cbD2";
        // Output: ["a1b2","a1B2","A1b2","A1B2"];

        Set<String> result = new HashSet<>();
        result.add(input);

        input.chars().mapToObj(c -> (char) c)
                .filter(Character::isLetter)
                .forEach(c -> result.addAll(
                        result.stream().map(str -> {
                            if (!str.equals(input.toUpperCase())) {
                                return str.replaceFirst(c.toString(), c.toString().toUpperCase());
                            }
                            return str;
                        }).collect(Collectors.toSet()))
                );
        System.out.println("all modes uppercase characters");
        System.out.println(result);
    }
}
