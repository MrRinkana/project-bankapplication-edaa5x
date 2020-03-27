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
		ArrayList<BankAccount> unsorted = new ArrayList<BankAccount>(accountList); //för att inte paja accountList (tror -m)
		ArrayList<BankAccount> sorted = new ArrayList<BankAccount>();
		
		while (unsorted.size() > 0) {
			int index = 0;
			for (int i = 0; i < unsorted.size()-1; i++) {
				int diff = unsorted.get(i).getHolder().getName().compareTo(unsorted.get(i+1).getHolder().getName());
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
