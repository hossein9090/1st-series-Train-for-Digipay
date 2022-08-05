import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Integer> firstList = new ArrayList<>();
    static ArrayList<Integer> secondList = new ArrayList<>();


    public static void main(String[] args) {

        System.out.println("enter length of first list : ");
        takeNum(firstList);
        System.out.println("first list is : "+firstList);
        System.out.println("enter length of second list : ");
        takeNum(secondList);
        System.out.println("second list is : "+secondList);
        System.out.println("reverse of first list is : "+reverseList(firstList));
        System.out.println("reverse of second list is : "+reverseList(secondList));
        int firstNum = makeNumber(firstList);
        int secondNum = makeNumber(secondList);
        System.out.println(firstNum);
        System.out.println(secondNum);
        Integer sum = firstNum+secondNum;
        System.out.println(sum);
        System.out.println("final result is : "+makeList(sum));
    }

    private static void takeNum(ArrayList<Integer> secondList) {
        Integer secondListLength = scanner.nextInt();
        int j=0;
        while (j<secondListLength){
            System.out.println("enter a number");
            int enterNumber = scanner.nextInt();
            secondList.add(j,enterNumber);
            j++;
        }
    }

    public static List<Integer> reverseList(List<Integer> list){
        ArrayList<Integer> newNumlist = new ArrayList<>();
        int counter =0;
        for (int i=list.size()-1;i>=0;i--){
            newNumlist.add(counter,list.get(i));
            counter++;
        }
        return newNumlist;
    }

    public static Integer makeNumber (List<Integer> listing){
        int temp = 0;
        for (int i=listing.size()-1;i>=0;i--){
            temp = temp*10+listing.get(i);
        }
        return temp;
    }

    public static List<String> makeList(Integer finalNum){
        List<String> resultList = new ArrayList<>();
//        String num = String.valueOf(finalNum);
        String num = String.valueOf(finalNum);
        for (int i =num.length()-1;i>=0;i--){
            resultList.add(String.valueOf(num.charAt(i)));
        }
        return resultList;
    }
}
