/* Practical No 6
Write a program in Java to implement a Calculator with simple arithmetic
operations such as add, subtract, multiply, divide, factorial etc. using
switch case and other simple java statements. The objective of this
assignment is to learn Constants, Variables, and Data Types, Operators and
Expressions, Decision making statements in Java.
*/
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to Simple Calculator");

        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Factorial");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    add(sc);
                    break;
                case 2:
                    subtract(sc);
                    break;
                case 3:
                    multiply(sc);
                    break;
                case 4:
                    divide(sc);
                    break;
                case 5:
                    factorial(sc);
                    break;
                case 6:
                    System.out.println("Exiting... Thank you for using Simple Calculator!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    public static void add(Scanner sc) {
        System.out.print("Enter two numbers to add: ");
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        System.out.println("Addition = " + (num1 + num2));
    }

    public static void subtract(Scanner sc) {
        System.out.print("Enter two numbers to subtract: ");
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        System.out.println("Subtraction = " + (num1 - num2));
    }

    public static void multiply(Scanner sc) {
        System.out.print("Enter two numbers to multiply: ");
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        System.out.println("Multiplication = " + (num1 * num2));
    }

    public static void divide(Scanner sc) {
        System.out.print("Enter two numbers to divide: ");
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        if (num2 != 0) {
            System.out.println("Division = " + (num1 / num2));
        } else {
            System.out.println("Cannot divide by zero");
        }
    }

    public static void factorial(Scanner sc) {
        System.out.print("Enter a number to find factorial: ");
        int num = sc.nextInt();
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        System.out.println("Factorial of " + num + " is " + fact);
    }
}
