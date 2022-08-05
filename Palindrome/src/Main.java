import java.util.Objects;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Number : ");
        int enteredNumber = scanner.nextInt();
        boolean result = checkPalindrome(enteredNumber);
        if (result ){
            System.out.println("its a palindrome number");
        }else {
            System.out.println("no no its not a palindrome");
        }
    }

    //check the entered number is palindrome or not
    public static boolean checkPalindrome (int number){
        String num = String.valueOf(number);
        char character ;
        String empty ="";
        for (int i=num.length()-1;i>=0;i--){
            character  =num.charAt(i);
            empty = empty + character ;
        }
        if (Objects.equals(empty, num))
            return true;
        else
            return false;
    }

}
