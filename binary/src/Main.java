import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

    static Integer enteredNumber = 462;
    static List<Integer> listOfDigits = new ArrayList<>();
    static HashMap<Integer, Integer> digitRepetition = new HashMap<Integer, Integer>();
    static Integer maxDigit =0;

    public static void main(String[] args) {
        convertNumToList(enteredNumber);
        digitRepetition(enteredNumber);
    }

    //converting the entered number to the list of digits
    public static void convertNumToList(Integer number){
        Integer counter = 1;
        while (number > 0) {
            listOfDigits.add(number % 10);
            if (number%10 >maxDigit){
                maxDigit = number%10;
            }
            digitRepetition.put(counter, number % 10);
            number = number / 10;
            counter++;
        }
        Collections.reverse(listOfDigits);
        System.out.println(listOfDigits+" <----list of digits");
    }

    //print the repetition of each digit
    public static void digitRepetition(Integer number){
        Integer numLength = number.toString().length();
        while (maxDigit>0) {
            List<Integer> temp = new ArrayList<>();
            for (int i = numLength; i >0; i--) {
                Integer val = digitRepetition.get(i);
                if (val <=0){
                    temp.add(0);
                }else {
                    temp.add(1);
                }
                digitRepetition.replace(i,val-1);
            }
            System.out.println(temp);
            maxDigit--;
        }
    }
}
