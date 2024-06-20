package org.example;
import java.util.Scanner;

public class Calculator {

    public static double add(double int1, double int2){
        return int1 + int2;
    }
    public static double subtract(double int1, double int2){
        return int1 - int2;
    }
    public static double multiply(double int1, double int2){
        return int1 * int2;
    }
    public static double divide(double int1, double int2){
        if(int2 != 0){
            return int1 / int2;
        }else{
           throw new ArithmeticException("Error: Division by zero.");
        }
    }
    public static void main(String[] args) {
        char operation;
        double result;
        String choice = "y";

        Scanner scanner = new Scanner(System.in);



        while (choice.equals("y")) {
            try {

                System.out.println("Choose your operation:\n + = Addition \n - = Subtraction \n * = Multiplication \n / = Division");
                operation = scanner.next().charAt(0);

                System.out.println("Enter First Numerical Value: ");
                double int1 = scanner.nextDouble();

                System.out.println("Enter Second Numerical value: ");
                double int2 = scanner.nextDouble();

                switch (operation) {
                    case '+':
                        result = add(int1,int2);
                        System.out.println(int1 + "+" + int2 + "=" + result);
                        break;
                    case '-':
                        result = subtract(int1,int2);
                        System.out.println(int1 + "-" + int2 + "=" + result);
                        break;
                    case '*':
                        result = multiply(int1,int2);
                        System.out.println(int1 + "*" + int2 + "=" + result);
                        break;
                    case '/':
                        result = divide(int1,int2);
                        System.out.println(int1 + "/" + int2 + "=" + result);
                        break;
                    default:
                        System.out.println("Error: Wrong operator input.");
                        continue;
                }
            }catch (ArithmeticException e){
                System.out.println(e.getMessage());

            }catch (Exception e){
                System.out.println("Please enter a numerical value");

            }
            System.out.println("Would you like to try again? (y/n): ");
            choice = scanner.next().toLowerCase();

        }

    }
}