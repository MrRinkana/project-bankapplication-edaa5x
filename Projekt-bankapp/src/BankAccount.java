
public class BankAccount {
	private Customer holder;
	private double cashMoney;
	
	public BankAccount(String holderName, long holderId) {
		this.holder = new Customer(holderName, holderId);
		cashMoney = 0;
	}
	
	public BankAccount(Customer holder) {
		this.holder = holder;
		cashMoney = 0;
	}
	
	public Customer getHolder() {
		return holder;
	}
	/*
	public int getAccountNumber() {
		return holder.getCustomerNr();
	}
	*/
	public double getAmount() {
		return cashMoney;
	}
	
	void deposit(double amount) {
		cashMoney += amount;
	}
	void withdraw(double amount) {
		cashMoney -= amount;
	}
	
	public String toString() {
		return ("Kontoägare: " + holder.toString() + "Cash money: " + getAmount());
	}
}
