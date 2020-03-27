import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {
	public static void main(String[] args) {
		Bank bank = new Bank();

		Scanner scan = new Scanner(System.in);

		while (true) {
			optionsPrint();
			String input = scan.nextLine();
			switch (input) {
			case "1":
				System.out.println("id: ");
				printAccountList(bank.findAccountsForHolder(scan.nextLong()));
			case "2":
				System.out.println("namn: ");
				printCustomerList(bank.findByPartofName(scan.nextLine()));
			case "3":
				System.out.println("konto: ");
				BankAccount accChoice = bank.findByNumber(scan.nextInt());
				if (accChoice == null) {
					System.out.println("Kontonr " + accChoice + "existerar inte");
					return;
				}
				System.out.println("belopp: ");
				double amount = scan.nextDouble();
				if (amount < 0) {
					System.out.println("Kan inte lägga till " + amount + ", felaktigt belopp");
					return;
				}
				accChoice.deposit(amount);
				System.out.println(accChoice.toString() + ": " + amount);
			case "4":
				System.out.println("konto: ");
				BankAccount accChoice2 = bank.findByNumber(scan.nextInt());
				if (accChoice2 == null) {
					System.out.println("Kontonr " + accChoice2 + "existerar inte");
					return;
				}
				System.out.println("belopp: ");
				double amount2 = scan.nextDouble();
				if (amount2 > accChoice2.getAmount()) {
					System.out.println("Kan inte dra " + amount2 + ", bara " + accChoice2.getAmount() + " på kontot!");
					return;
				}
				accChoice2.withdraw(amount2);
				System.out.println(accChoice2.toString() + ": " + amount2);
			case "5":
			case "6":
				System.out.print("Skapa nytt konto:\nNamn:");
				String name = scan.nextLine();
				System.out.print("Personnummer:");
				long id = scan.nextLong();
				int accountCheck = bank.addAccount(name, id);
				if (!(accountCheck == 0)) {
					System.out.print("Konto skapat: " + accountCheck);
				} else {
					System.out.print("Inget konto skapat");
				}
			case "7":
				bank.removeAccount(scan.nextInt());
			case "8":
				printAccountList(bank.getAllAccounts());
			case "9":
				System.exit(0);
			default:
			}

		}

	}
	
	private static void optionsPrint() {
		System.out.print("- - - - - - - - - - - - - - - - - -" + 
				" - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
				"1. Hitta konto utifrån innehavare\n" + 
				"2. Sök kontoinnehavare utifrån (del av) namn\n" + 
				"3. Sätt in\n" + 
				"4. Ta ut\n" + 
				"5. Överföring\n" + 
				"6. Skapa konto\n" + 
				"7. Ta bort konto\n" + 
				"8. Skriv ut konton\n" + 
				"9. Avsluta\n" + 
				":>");
	}

	private static void printAccountList(ArrayList<BankAccount> accountList) {
		for (BankAccount b : accountList) {
			System.out.print("\n" + b.toString());
		}
	}
	
	private static void printCustomerList(ArrayList<Customer> customerList) {
		for (Customer c : customerList) {
			System.out.print("\n" + c.toString());
		}
	}
}
/*
1. Hitta konton för en viss kontoinnehavare
2. Sök kontoinnehavare på (del av) namn
3. Sätta in pengar
4. Ta ut pengar
5. Överföring mellan konton
6. Skapa nytt konto
7. Ta bort konto
8. Skriv ut bankens alla konton
9. Avsluta
*/
