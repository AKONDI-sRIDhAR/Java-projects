//This is a currency converter
import java.util.Scanner;

class CurrencyCon {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    double inr, result;
    int option;

    System.out.println("Enter amount in Indian Rupees (INR): ");
    inr = sc.nextDouble();

    System.out.println("Choose currency to convert into:");
    System.out.println("1. US Dollar (USD)");
    System.out.println("2. British Pound (GBP)");
    System.out.println("3. Euro (EUR)");
    System.out.println("4. Japanese Yen (JPY)");
    System.out.println("5. Chinese Yuan (CNY)");
    System.out.println("6. UAE Dirham (AED)");
    System.out.println("7. Australian Dollar (AUD)");
    System.out.println("8. Canadian Dollar (CAD)");

    option = sc.nextInt();

    switch (option) {
      case 1:
        result = inr * 0.012; 
        System.out.println("USD: " + result);
        break;
      case 2:
        result = inr * 0.0093; 
        System.out.println("GBP: " + result);
        break;
      case 3:
        result = inr * 0.011; 
        System.out.println("EUR: " + result);
        break;
      case 4:
        result = inr * 1.67; 
        System.out.println("JPY: " + result);
        break;
      case 5:
        result = inr * 0.086; 
        System.out.println("CNY: " + result);
        break;
      case 6:
        result = inr * 0.044; 
        System.out.println("AED: " + result);
        break;
      case 7:
        result = inr * 0.018; 
        System.out.println("AUD: " + result);
        break;
      case 8:
        result = inr * 0.016; 
        System.out.println("CAD: " + result);
        break;
      default:
        System.out.println("Invalid option. Please select from 1 to 8.");
    }

    sc.close();
  }
}
