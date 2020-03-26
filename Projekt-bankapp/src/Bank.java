import java.util.ArrayList;

public class Bank {
	ArrayList<BankAccount> accountList;
	
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
	
	boolean removeAccount(int number) {
		//detta är inkompatibelt med att använda index som kontonummer, måste hitta annan lösning.
		//Man skulle kunna söka igenom alla saker i listan till man hittar det som ska bort med en sån där halvhalvhalv metod
		
		}
}
