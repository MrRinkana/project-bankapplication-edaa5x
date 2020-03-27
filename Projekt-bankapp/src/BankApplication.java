import java.util.Scanner;

public class BankApplication {
	static Scanner scan;
	
	static Bank bank;
	
	
	public static void main(String[] args) {
		bank = new Bank();
		
		scan = new Scanner(System.in);
		
		optionsPrint();
		
		while (true) {
			uiHandler();
		}
		
	}
	
	private  static void uiHandler() {
		String input = scan.nextLine();
		switch (input) {
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6": 
			int acc = createAcc();
			if (!(acc == 0)) {
				System.out.print("Konto skapat: " + acc);
			}else {System.out.print("Inget konto skapat");}
		case "7":
		case "8": printAllAcc();
		case "9":
		default:
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

	private static int createAcc()	{
		System.out.print("Skapa nytt konto:\nNamn:");
		String name = scan.nextLine();
		System.out.print("Personnummer:");
		long id = scan.nextLong();
		return bank.addAccount(name, id);
		
	}
	
	private static void printAllAcc() {
		for (BankAccount b : bank.getAllAccounts()) {
			System.out.print("\n" + b.toString());
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
