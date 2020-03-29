import java.util.ArrayList;

public class Bank {
	ArrayList<BankAccount> accountList;
	
	//Tror detta underlättar, alltså att bankaccount bara får pekare till objekt i denna
	//Men det kanske bryter mot angivna implementationen.
	//ArrayList<Customer> listOfCustomers; 
	
	
	/** Skapar en ny bank utan konton. */
	public Bank() {
		accountList = new ArrayList<BankAccount>();
	}
	
	/**
	* Öppna ett nytt konto i banken. Om det redan finns en kontoinnehavare
	* med de givna uppgifterna kommer inte en ny Customer skapas, utan istället
	* den befintliga användas. Det nya kontonumret returneras.
	*/
	public int addAccount(String holderName, long idNr) {
		BankAccount account;
		Customer holder = findHolder(idNr); //Offra minne för ett färre anrop till findHolder. 
		if (holder == null) {
			account = new BankAccount(holderName, idNr);
		}else {
			account = new BankAccount(holder);
		}
		accountList.add(account);
		return(account.getAccountNbr());
	}
	
	/**
	* Returnerar den kontoinnehavaren som har det givna id-numret,
	* eller null om ingen sådan finns.
	*/
	public Customer findHolder(long idNr) {
		for (BankAccount c : accountList) {
			if (c.getHolder().getIdNr() == idNr) {
				return(c.getHolder());
			}
		}
		return null;
	}

	/**
	* Tar bort konto med nummer ’number’ från banken. Returnerar true om
	* kontot fanns (och togs bort), annars false.
	*/
	public boolean removeAccount(int number) {
		for (BankAccount a : accountList) {
			if (a.getAccountNbr() == number) {
				accountList.remove(a);
				return true;
			}
		}
		return false;	
	}
	
	/**
	* Returnerar en lista innehållande samtliga bankkonton i banken.
	* Listan är sorterad på kontoinnehavarnas namn (bokstavsordning).
	*/
	public ArrayList<BankAccount> getAllAccounts() {
		ArrayList<BankAccount> unsorted = new ArrayList<BankAccount>(accountList); //för att inte paja accountList (tror -m)
		ArrayList<BankAccount> sorted = new ArrayList<BankAccount>();
		
		//Hyfsat effektiv sort? Kan vara minnestung om väldigt många konton finns (skapas en* till ArrayList, se ovan)
		//*en som i en med alla konton i sig vid ett visst tillfälle.
		while (unsorted.size() > 0) {
			int index = 0;
			for (int i = 0; i < unsorted.size()-1; i++) {
				int diff = unsorted.get(i).getHolder().getName().compareToIgnoreCase(unsorted.get(i+1).getHolder().getName());
				if (diff > 0) {
					index = i+1;
				}else if (diff == 0) {
					if (unsorted.get(i).getAccountNbr() > unsorted.get(i+1).getAccountNbr()) {
						index = i+1;
					}
				}
				
			}
			sorted.add(unsorted.get(index));
			unsorted.remove(index);
		}
		return sorted;
	}
	
	/**
	* Söker upp och returnerar bankkontot med kontonummer ’accountNumber’.
	* Returnerar null om inget sådant konto finns.
	*/
	public BankAccount findByNumber(int accountNumber) { //TODO göra binärsökning? accountList bör redan vara sorterad
		for (BankAccount a : accountList) {
			if (a.getAccountNbr() == accountNumber) {
				return a;
			}
		}
		return null;
		
	}
	
	/**
	* Söker upp alla bankkonton som innehas av kunden med id-nummer ’idNr’.
	* Kontona returneras i en lista. Kunderna antas ha unika id-nummer.
	*/
	public ArrayList<BankAccount> findAccountsForHolder(long idNr) {
		ArrayList<BankAccount> returnList = new ArrayList<BankAccount>();
		for (BankAccount a : accountList) {
			if (a.getHolder().getIdNr() == idNr) {
				returnList.add(a);
			}
		}
		return returnList;
	}
	
	/**
	* Söker upp kunder utifrån en sökning på namn eller del av namn. Alla
	* personer vars namn innehåller strängen ’namePart’ inkluderas i
	* resultatet, som returneras som en lista. Samma person kan förekomma
	* flera gånger i resultatet. Sökningen är "case insensitive", det vill
	* säga gör ingen skillnad på stora och små bokstäver.
	*/
	public ArrayList<Customer> findByPartofName(String namePart) { //TODO söka igenom så att man inte får dubbla resultat
		ArrayList<Customer> returnList = new ArrayList<Customer>();
		for (BankAccount a : accountList) {
			if (a.getHolder().getName().toLowerCase().indexOf(namePart.toLowerCase()) != -1) {
				returnList.add(a.getHolder());
			}
		}
		return returnList;
	}
}
