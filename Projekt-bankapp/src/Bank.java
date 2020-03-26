import java.util.ArrayList;

public class Bank {
	ArrayList<BankAccount> accountList;
	ArrayList<Customer> listOfCustomers; //Tror detta underlättar, alltså att bankaccount bara får pekare till objekt i denna
	UniqueINT uniqID = new UniqueINT();
	
	public Bank() {
		accountList = new ArrayList<BankAccount>();
	}
	
	public int addAccount(String holderName, long idNr) {
		//TODO: söka igenom så att man inte får redundant account
		BankAccount account = new BankAccount(holderName, idNr);
		accountList.add(account);
		return(accountList.indexOf(account) + 1);
	}
	
	public Customer findHolder(long idNr) {
		for (BankAccount c : accountList) {
			if (c.getHolder().getIdNr() == idNr) {
				return(c.getHolder());
			}
		}
		return null;
	}
	
	/*
	 * Dessa två funkar inte då de måste vara static, annars måste customer och 
	 * bankaccount ha ett bank objekt, och det går ju inte. Skulle vilja bara skicka in deet genom construktooorn!
	 * -m
	 */
	
	
	/*
	 * Används av Customer för unikt användarnummer
	 */
	public int giveUserID() {
		return uniqID.uniqueIntC(listOfCustomers);
	}
	
	/*
	 * Används av BankAccount för unikt kontonummer
	 */
	public int giveAccountID() {
		return uniqID.uniqueIntB(accountList);
	}
	
	
	boolean removeAccount(int number) {
		//detta är inkompatibelt med att använda index som kontonummer, måste hitta annan lösning.
		//Man skulle kunna söka igenom alla saker i listan till man hittar det som ska bort med en sån där halvhalvhalv metod
		
		}
}
