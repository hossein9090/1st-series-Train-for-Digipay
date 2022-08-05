import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(16);
        numbers.add(17);
        numbers.add(6);
        numbers.add(2);
        numbers.add(5);
        numbers.add(3);
        numbers.remove(0);
        Integer length = numbers.size();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            result.add(numbers.stream().max(Integer::compare).get());
            numbers.remove(0);
        }
        result.add(-1);
        System.out.println(result);
    }

}

