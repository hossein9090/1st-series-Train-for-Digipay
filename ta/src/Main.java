import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    static Scanner numScanner = new Scanner(System.in);
    static Scanner strScanner = new Scanner(System.in);
    static List<String> test = new ArrayList<>();
//    static List<String> test = Arrays.asList("a","a","a","b","b","c","c","c","c");


    public static void main(String[] args) {
        System.out.println("enter length of list you want : ");
        Integer listSize = numScanner.nextInt();
        for (int i=0;i<listSize;i++){
            System.out.println("enter char : ");
            String temp = strScanner.nextLine();
            test.add(temp);
        }
        Map<String, Long> collect = test.
                stream().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }
}
