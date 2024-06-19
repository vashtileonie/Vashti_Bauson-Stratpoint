package org.example;
import java.util.Scanner;

public class Calculator {
    static double result;
    static char operation;
    static double int1, int2;

    public static void Add(){
        result = int1 + int2;
        System.out.println(result);
    }
    public static void Sub(){
        result = int1 - int2;
        System.out.println(result);
    }
    public static void Multiply(){
        result = int1 * int2;
        System.out.println(result);
    }
    public static void Div(){
        if(int2 != 0){
            result = int1 / int2;
            System.out.println(result);

        }else{
            System.out.println("Error: Division by Zero.");
        }
    }
    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);

       System.out.println("Choose your operation:\n + = Addition \n - = Subtraction \n * = Multiplication \n / = Division");
       operation = scanner.next().charAt(0);

       System.out.println("Enter First Numerical Value: ");
       int1 = scanner.nextDouble();

       System.out.println("Enter Second Numerical value: ");
       int2 = scanner.nextDouble();

       System.out.println("========================");

       switch(operation){
           case '+':
               Add();
               break;
           case '-':
               Sub();
               break;
           case '*':
               Multiply();
               break;
           case '/':
               Div();
               break;
           default: System.out.println("Error: Wrong operator input.");
       }

    }


}