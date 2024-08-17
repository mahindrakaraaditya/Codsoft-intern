

import java.util.Scanner;

public class STUDENTGRADECALCULATOR {
    public static void Grades() {
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[5];
        int marks=0;
        System.out.println("Enter subject marks:-");
        for(int i=0;i<arr.length;i++){
            switch(i){
                case 0:
                    System.out.print("Enter marathi subject marks:-");
                    arr[i]=sc.nextInt();
                    break;
                
                case 1:
                    System.out.print("Enter Hindi subject marks:-");
                    arr[i]=sc.nextInt();
                    break;
                
                case 2:
                    System.out.print("Enter English subject marks:-");
                    arr[i]=sc.nextInt();
                    break;

                case 3:
                    System.out.print("Enter science subject marks:-");
                    arr[i]=sc.nextInt();
                    break;

                case 4:
                    System.out.print("Enter Maths subject marks:-");
                    arr[i]=sc.nextInt();
                    break;
                case 5:
                    System.out.print("Enter History subject marks:-");
                    arr[i]=sc.nextInt();
                    break;

                default:
                break;
            }
            marks+=arr[i];
        }
        System.out.println("");
        System.out.println("");
        System.out.println("you got total marks:"+marks);
        int totalmarks=marks/5;
        System.out.println("you got average percentage:"+totalmarks+"%");

        if(totalmarks>=90){
            System.out.println("Congrats you got A grade");
        }else if(totalmarks>=80){
            System.out.println("congrats you got B grade");
        }else if(totalmarks>=70){
            System.out.println("congrats you got C grade");
        }else if(totalmarks>=60){
            System.out.println("congrats you got D grade");
        }else if(totalmarks>=40){
            System.out.println("congrats you got E grade");
        }else {
            System.out.println(" you got F grade");
        }
        
    }
    public static void main(String[] args) {
        Grades();
    }
}
