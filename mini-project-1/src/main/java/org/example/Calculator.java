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

    // Method to validate if the given operator is one of +, -, *, /
    public static boolean isValidOperator(char operation) {
        return operation == '+' || operation == '-' || operation == '*' || operation == '/';
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

                // To validate the input for operation
                if (!isValidOperator(operation)) {
                    System.out.println("Error: Wrong operator input.");
                    System.out.println("Would you like to try again? (y/n): ");
                    choice = scanner.next().toLowerCase(); 
                    continue;
                }

                System.out.println("Enter First Numerical Value: ");
                double int1 = Double.parseDouble(scanner.next()); // Read and parse the input as double, not limit to single digit

                System.out.println("Enter Second Numerical value: ");
                double int2 =  Double.parseDouble(scanner.next()); // Read and parse the input as double, not limit to single digit

                switch (operation) {
                    case '+':
                        result = add(int1,int2);
                        System.out.println(int1 + " + " + int2 + "= " + result);
                        break;
                    case '-':
                        result = subtract(int1,int2);
                        System.out.println(int1 + " - " + int2 + "= " + result);
                        break;
                    case '*':
                        result = multiply(int1,int2);
                        System.out.println(int1 + " * " + int2 + "= " + result);
                        break;
                    case '/':
                        result = divide(int1,int2);
                        System.out.println(int1 + " / " + int2 + "= " + result);
                        break;

                }

            // Handle arithmetic exceptions: division by zero
            }catch (ArithmeticException e){
                System.out.println(e.getMessage());

            // Handle input format exceptions (e.g., non-numeric input)
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numerical value.");
                scanner.nextLine(); // Consume newline to prevent infinite loop

            // Handle unexpected errors
            } catch (Exception e) {
                System.out.println("Unexpected error occurred: " + e.getMessage());
                scanner.nextLine();
            }

            // Output separator and prompt to try again
            System.out.println("---------------------------");
            System.out.println("Would you like to try again? (y/n): ");
            choice = scanner.next().toLowerCase();

        }
        
        // Close the scanner when done to free resources
        scanner.close();

    }
}