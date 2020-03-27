
public class BankAccount {
	private Customer holder;
	private double cash;
	private int accNbr;
	public int totAccounts = 0;
	
	public BankAccount(String holderName, long holderId) {
		this.holder = new Customer(holderName, holderId);
		cash = 0;
		totAccounts++;
		accNbr = totAccounts;
	}
	
	public BankAccount(Customer holder) {
		this.holder = holder;
		cash = 0;
		totAccounts++;
		accNbr = totAccounts;
	}
	
	
	public Customer getHolder() {
		return holder;
	}
	
	public double getAmount() {
		return cash;
	}
	
	void deposit(double amount) {
		cash += amount;
	}
	void withdraw(double amount) {
		cash -= amount;
	}
	
	/*
	 * Svarar med kontots unika (interna) nummer.
	 */
	public int getAccountNbr() {
		return accNbr;
	}
	
	/*
	 * Svarar med en string beskrivning av kontot
	 */
	public String toString() {
		return ("Kontoägare: " + holder.toString() + "Cash money: " + getAmount());
	}
}
