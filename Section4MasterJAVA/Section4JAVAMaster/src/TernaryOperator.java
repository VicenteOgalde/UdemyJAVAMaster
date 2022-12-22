import java.util.Scanner;

public class TernaryOperator {

    public static void main(String[] args){
        int max=0;
        Scanner s= new Scanner(System.in);

        System.out.println("type your first number: ");
        int num1= s.nextInt();
        System.out.println("type your second number: ");
        int num2= s.nextInt();
        System.out.println("type your third number: ");
        int num3= s.nextInt();

        max=(num1>num2)?num1:num2;
        max=(max>num3)?max:num3;
        System.out.println("max number is : "+max);



    }





}
