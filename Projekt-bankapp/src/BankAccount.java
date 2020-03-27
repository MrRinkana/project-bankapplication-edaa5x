
public class BankAccount {
	private Customer holder;
	private double cash;
	private int accNbr;
	
	static int totAccounts = 0; //Används för unikt kontonummer
	
	/**
	 *  Skapar ett nytt bankkonto åt en innehavare med namn ’holderName’ och
	 *	id ’holderId’. Kontot tilldelas ett unikt kontonummer och innehåller
	 *  inledningsvis 0 kr.
	 */
	public BankAccount(String holderName, long holderId) {
		this.holder = new Customer(holderName, holderId);
		cash = 0;
		totAccounts++;
		accNbr = totAccounts;
	}
	
	/**
	* Skapar ett nytt bankkonto med innehavare ’holder’. Kontot tilldelas
	* ett unikt kontonummer och innehåller inledningsvis 0 kr.
	*/
	public BankAccount(Customer holder) {
		this.holder = holder;
		cash = 0;
		totAccounts++;
		accNbr = totAccounts;
	}
	
	/** Tar reda på kontots innehavare. */
	public Customer getHolder() {
		return holder;
	}
	
	/** Tar reda på hur mycket pengar som finns på kontot. */
	public double getAmount() {
		return cash;
	}
	
	/** Sätter in beloppet ’amount’ på kontot. */
	void deposit(double amount) {
		cash += amount;
	}
	
	/**
	* Tar ut beloppet ’amount’ från kontot. Om kontot saknar täckning
	* blir saldot negativt.
	*/
	void withdraw(double amount) {
		cash -= amount;
	}
	
	/** Tar reda på det kontonummer som identifierar detta konto. */
	public int getAccountNbr() {
		return accNbr;
	}
	
	/** Returnerar en strängrepresentation av bankkontot. */
	public String toString() {
		return ("konto " + accNbr + " (" + holder.toString() + ") " + ": " + getAmount()); //format identiskt till ex.
	}
}
