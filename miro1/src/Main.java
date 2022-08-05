import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static int checkpoint =0;
    static int counter = 2;
    static ArrayList<Integer> results = new ArrayList<Integer>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number : ");
        Integer enterNumber = scanner.nextInt();

        findPrimeNumBeforeEnterNum(enterNumber);
    }

    // check that entered number is prime or not
    public static void primeNumber(int number) {
        if (number == 0 || number == 1) {
            System.out.println(number + "عدد وارد شده اول نیست");
        } else {

            while (counter <= number/2) {
                if (number % counter == 0) {
                    System.out.println(number + "عدد وارد شده اول نیست");
                    checkpoint = 1;
                    break;
                }
                counter++;
            }
            if (checkpoint == 0) {
                System.out.println(number + "عدد اول است");
                results.add(number);
            }
        }
    }


    //find the count of PrimeNumber before entered number
    public static void findPrimeNumBeforeEnterNum(Integer myNumber){
        for (int i = 2; i < myNumber; i++) {
            primeNumber(i);
            checkpoint =0;
            counter = 2;
        }
        System.out.println(results);
        System.out.println("Number of prime number befor your entered number is :"+results.size());
    }
}

