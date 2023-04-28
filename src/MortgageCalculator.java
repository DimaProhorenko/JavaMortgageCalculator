import java.util.Locale;
import java.util.Scanner;

public class MortgageCalculator {
	private static final int MONTH_IN_A_YEAR = 12;
	
	public static void printResult(String msg, double amount) {
		System.out.println(String.format("%s: $%d", msg, (int) Math.ceil(amount)));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the principal amount: ");
		double principalAmount = scanner.nextDouble();
		
		System.out.println("Enter the anual interest rate: ");
		float anualInterestRate = scanner.nextFloat() / 100;
		
		System.out.println("Enter the term in years: ");
		int termInYears = scanner.nextInt();
		
		int termInMonth = termInYears * MONTH_IN_A_YEAR;
		
		int numberOfPayments = termInMonth;
		float monthlyInterestRate = anualInterestRate / MONTH_IN_A_YEAR;
		
		double divident = monthlyInterestRate * (Math.pow((1 + monthlyInterestRate), numberOfPayments));
		
		double divisor = (Math.pow((1 + monthlyInterestRate), numberOfPayments)) - 1;
		
		double monthlyPayment = principalAmount * (divident / divisor);
		
		double totalPayback = monthlyPayment * numberOfPayments;
		
		double totalInterestPayed = totalPayback - principalAmount;
		
		System.out.println(String.format(Locale.US, "Monthly payment is: %d", (int) Math.ceil(monthlyPayment)));
		printResult("Total interest payed: ", totalInterestPayed);
		printResult("Total payback: ", totalPayback);

	}

}
