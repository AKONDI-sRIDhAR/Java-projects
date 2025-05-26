//This is a simple ASMD calculator
import java.util.Scanner;

class Calculator {
  public static void main(String[] args) {

    int choice;
    double num1, num2, res;

    Scanner sc = new Scanner(System.in);

    System.out.println("Choose an option:");
    System.out.println("1. Addition");
    System.out.println("2. Subtraction");
    System.out.println("3. Multiplication");
    System.out.println("4. Division");

    choice = sc.nextInt();

    System.out.println("Enter first number:");
    num1 = sc.nextDouble();

    System.out.println("Enter second number:");
    num2 = sc.nextDouble();

    switch (choice) {
      case 1:
        res = num1 + num2;
        System.out.println("Result: " + res);
        break;

      case 2:
        res = num1 - num2;
        System.out.println("Result: " + res);
        break;

      case 3:
        res = num1 * num2;
        System.out.println("Result: " + res);
        break;

      case 4:
        if (num2 != 0) {
          res = num1 / num2;
          System.out.println("Result: " + res);
        } else {
          System.out.println("Cannot divide by zero!");
        }
        break;

      default:
        System.out.println("Invalid option!");
    }

    sc.close();
  }
}
