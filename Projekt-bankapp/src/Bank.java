import java.util.ArrayList;

public class Bank {
	ArrayList<BankAccount> accountList;
	ArrayList<Customer> listOfCustomers; //Tror detta underlättar, alltså att bankaccount bara får pekare till objekt i denna
	
	public Bank() {
		accountList = new ArrayList<BankAccount>();
	}
	
	public int addAccount(String holderName, long idNr) {
		//TODO: söka igenom så att man inte får redundant account
		BankAccount account = new BankAccount(holderName, idNr);
		accountList.add(account);
		return(account.getAccountNbr());
	}
	
	public Customer findHolder(long idNr) {
		for (BankAccount c : accountList) {
			if (c.getHolder().getIdNr() == idNr) {
				return(c.getHolder());
			}
		}
		return null;
	}

	
	public boolean removeAccount(int number) {
		for (BankAccount a : accountList) {
			if (a.getAccountNbr() == number) {
				accountList.remove(a);
				return true;
			}
		}
		return false;
		//Man skulle kunna söka igenom alla saker i listan till man hittar det som ska bort med en sån där halvhalvhalv metod	
	}
	
	public ArrayList<BankAccount> getAllAccounts() {
		return accountList;
	}
	
	public BankAccount findByNumber(int accountNumber) {
		for (BankAccount a : accountList) {
			if (a.getAccountNbr() == accountNumber) {
				return a;
			}
		}
		return null;
		
	}
	
	public ArrayList<BankAccount> findAccountsForHolder(long idNr) {
		ArrayList<BankAccount> returnList = new ArrayList<BankAccount>();
		for (BankAccount a : accountList) {
			if (a.getHolder().getIdNr() == idNr) {
				returnList.add(a);
			}
		}
		return returnList;
	}
	public ArrayList<Customer> findByPartofName(String namePart) {
		ArrayList<Customer> returnList = new ArrayList<Customer>();
		for (BankAccount a : accountList) {
			if (a.getHolder().getName().toLowerCase().indexOf(namePart.toLowerCase()) != -1) {
				returnList.add(a.getHolder());
			}
		}
		return returnList;
	}
}
