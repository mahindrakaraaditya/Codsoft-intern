
import java.util.Scanner;

public class NumberGuessinggame {
    public static void guessing(int count) {
        int number=(int) (Math.random()*100);
        Scanner sc=new Scanner(System.in);
        int guessing;
        do {
            System.out.print("guess a number:-");
            guessing=sc.nextInt();
            if(number==guessing){
                System.out.println("correct answer");
                break;
            }
            else if(guessing>number){
                System.out.println("number is large");
                count++;
            }else{
                System.out.println("number is small");
                count++;
            }
        } while (count<=4);
        System.out.print("my number is:");
        System.out.println(number);
        switch(count){
            case 0:
            System.out.println("congrats your score is 100%");
            break;

            case 1:
            System.out.println("congrats your score is 80%");
            break;

            case 2:
            System.out.println("congrats your score is 60%");
            break;

            case 3:
            System.out.println("congrats your score is 40%");
            break;

            case 4:
            System.out.println("congrats your score is 20%");
            break;

            default:
            System.out.println(" your score is 0%");
        }

    }
    public static void main(String[] args) {
        int count=0;
        guessing(count);
    }
}
