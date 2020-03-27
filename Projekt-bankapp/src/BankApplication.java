import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {

	static Bank bank;

	public static void main(String[] args) {
		bank = new Bank();

		Scanner scan = new Scanner(System.in);

		while (true) {
			optionsPrint();
			String input = scan.nextLine();
			switch (input) {
			case "1":
				System.out.print("id: ");
				printAccountList(bank.findAccountsForHolder(scan.nextLong())); //TODO utskriften är inte nanocertifierad
				scan.nextLine();
				break;
			case "2":
				System.out.print("namn: ");
				printCustomerList(bank.findByPartofName(scan.nextLine()));
				break;
			case "3":
				System.out.print("konto: ");
				BankAccount account = bank.findByNumber(scan.nextInt());
				System.out.print("belopp: ");
				System.out.print(depositAttempt(account, scan.nextDouble())); //TODO utskriften är inte nanocertifierad
				scan.nextLine();
				break;
			case "4":
				System.out.print("konto: ");
				BankAccount accountWithdraw = bank.findByNumber(scan.nextInt());
				System.out.print("belopp: ");
				System.out.print(withdrawalAttempt(accountWithdraw, scan.nextDouble())); //TODO utskriften är inte nanocertifierad
				scan.nextLine();
				break;
			case "5":
				System.out.print("från konto: ");
				BankAccount aOut = bank.findByNumber(scan.nextInt());
				System.out.print("till konto: ");
				BankAccount aIn = bank.findByNumber(scan.nextInt());
				System.out.print("belopp: ");
				System.out.print(transactionAttempt(aOut, aIn, scan.nextDouble()));
				scan.nextLine();
				break;
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
				scan.nextLine();
				break;
			case "7":
				if(!bank.removeAccount(scan.nextInt())) {
					System.out.print("kontot existerar inte");
				}else System.out.print("Kontot borttaget.");
				scan.nextLine();
				break;
			case "8":
				printAccountList(bank.getAllAccounts());
				//scan.nextLine(); //Ska tydligen inte vara här?
				break;
			case "9":
				System.out.println("Shutting down..");
				//TODO spara till fil (om inte sparas under programmets gång
				scan.close(); //Den gnällde...
				System.out.print("Shut down.");
				System.exit(0);
				break;
			default: 
				System.out.print("Felaktig input, försök igen.");
			} 


		}

	}
	
	private static void optionsPrint() {
		System.out.print("\n- - - - - - - - - - - - - - - - - -" + 
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
		if (accountList.size() > 0) {
			System.out.print("Hittade:");
			for (BankAccount b : accountList) {
				System.out.print("\n" + b.toString());
			}
		}else System.out.print("Hittade inget.");
	}

	private static void printCustomerList(ArrayList<Customer> customerList) {
		if (customerList.size() > 0) {
			System.out.print("Hittade:");
			for (Customer c : customerList) {
				System.out.print("\n" + c.toString());
			}
		}else System.out.print("Hittade ingen.");
	}

	private static String withdrawalAttempt(BankAccount account, double amount) {
		if (account == null) {
			return "Kontot existerar inte";
		}
		if (amount > account.getAmount()) {
			return "uttaget misslyckades, endast " + account.getAmount() + " på kontot!";
		}
		account.withdraw(amount);
		return account.toString() + ": " + account.getAmount();
	}

	private static String depositAttempt(BankAccount account, double amount) {
		if (account == null) {
			return "kontot existerar inte";
		}
		if (amount < 0) {
			return "kan inte sätta in mindre än 0";
		}
		account.deposit(amount);
		return account.toString() + ": " + account.getAmount();
	}

	private static String transactionAttempt(BankAccount aOut, BankAccount aIn, double amount) {
		if (aOut == null || aIn == null) {
			return "en eller flera av konton existerar inte";
		} else if (amount < 0) {
			return "kan inte överföra mindre än 0";
		} else if (amount > aOut.getAmount()) {
			return "bara " + aOut.getAmount() + " på kontot";
		}
		aOut.withdraw(amount);
		aIn.deposit(amount);
		return aOut.toString() + ": " + aOut.getAmount() + "\n" + aIn.toString() + ": " + aIn.getAmount();
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
