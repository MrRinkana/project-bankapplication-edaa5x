
public class BankAccount {
	private Customer holder;
	private double cashMoney;
	private int accNbr;
	public int totAccounts = 0;
	
	public BankAccount(String holderName, long holderId) {
		this.holder = new Customer(holderName, holderId);
		cashMoney = 0;
		totAccounts++;
		accNbr = totAccounts;
	}
	
	public BankAccount(Customer holder) {
		this.holder = holder;
		cashMoney = 0;
		totAccounts++;
		accNbr = totAccounts;
	}
	
	
	public Customer getHolder() {
		return holder;
	}
	
	public double getAmount() {
		return cashMoney;
	}
	
	void deposit(double amount) {
		cashMoney += amount;
	}
	void withdraw(double amount) {
		cashMoney -= amount;
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
