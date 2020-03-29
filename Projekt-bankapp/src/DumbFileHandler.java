import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DumbFileHandler {

	Bank bank;
	File file;
	FileWriter writer;
	Scanner reader; //Var okej enl. Patrik
	
	public DumbFileHandler(Bank bank) throws IOException {
		this.bank = bank;
		file = new File("accounts.txt");
		
		if (!file.exists()) {
			createFile();
		}
			
		reader = new Scanner(file); //throws file not found, men inte construktorn? -m
	}
	
	
	public void safeShutdown() {
		reader.close();
	}
	
	private void createFile() throws IOException {
		file.createNewFile();
	}
	
	public void saveToFile() throws IOException {
		writer = new FileWriter(file, false); //initieras här pga. fil skrivs över
		String allAccs = ""; //måste initieras
		
		for (BankAccount b : bank.accountList) { //TODO kolla så det funkar
			allAccs += b.toString() + "\n";
		}
		
		writer.write(allAccs); //borde skriva över befintligt
		writer.close();
	}
	
	
	private ArrayList<AccountObject> translateFile() {
		ArrayList<AccountObject> listOfAccData = new ArrayList<AccountObject>(); //TODO Skapa objekt istället?
		
		while (reader.hasNextLine()) {
			String rawStr = reader.nextLine();
			int i1;
			i1 = rawStr.indexOf(" (");
			int bankAccNr = Integer.parseInt(rawStr.substring(6, i1)); //Kanske bara ska läsa det som en sträng
			
			
			int i2 = i1;
			while (rawStr.indexOf("): ", i2) > -1) { //TODO optimera
				i2 = rawStr.indexOf("): ", i2) + 3; 
			}
			double money = Double.parseDouble(rawStr.substring(i2));
			
			rawStr = rawStr.substring(i1 + 2, i2 - 3); //TODO kolla så jag klipper bort rätt
			
			i1 = 0; //Återanvänds för att inte skapa onödiga variabler
			while (rawStr.indexOf(", kundnr ", i1) > -1) { //TODO optimera
				i1 = rawStr.indexOf(", kundnr ", i1) + 9; 
			}
			int custNr = Integer.parseInt(rawStr.substring(i1));
			rawStr = rawStr.substring(0, i1 - 9);
			
			i1 = 0; //Återanvänds för att inte skapa onödiga variabler
			while (rawStr.indexOf(", id ", i1) > -1) { //TODO optimera
				i1 = rawStr.indexOf(", id ", i1) + 5; 
			}
			long custID = Long.parseLong(rawStr.substring(i1));
			rawStr = rawStr.substring(0, i1 - 5);
			
			//nu är rawStr = custName
			listOfAccData.add(new AccountObject(rawStr, custID, custNr, bankAccNr, money));
		}
		return listOfAccData;
	}
	
	public void loadFromFile() throws IOException { //Egen throw, osäker på hur det funkar -m (markerar inget laddat)
		ArrayList<AccountObject> accList = translateFile();
		
		//om inga konton togs bort så bör allt ha samma nummer som förut
		//annars kommer de vara i samma ordning, men med nya nummer
		//gäller både Customer och BankAccount
		//AccountObject innehåller information nog till att kunna återskapa exakt.
		//int i grejen hade sluppits om man kunde återskapa konto nummren
		int i = 1;
		if (accList.size() > 0) {
			for (AccountObject acc : accList) {
				bank.addAccount(acc.getName(), acc.getCustID());
				bank.findByNumber(i).deposit(acc.getBalance());
				i++;
			}
		}else throw new IOException(); //TODO utvärdera
		
	}
}

//Hhjälpklass, för att slippa konvertera fram och tillbaka i String[]s..
class AccountObject { //är denna "protected" nu eller? -m
	private String name;
	private long custID;
	private int custNr;
	private int accNr;
	private double balance;
	
	/**
	 * Name, custID, custNr, (bank)accNr, balance.
	 * @param name
	 * @param custID
	 * @param custNr
	 * @param accNr
	 * @param balance
	 */
	public AccountObject(String name, long custID, int custNr, int accNr, double balance) {
		this.name = name;
		this.custID = custID;
		this.custNr = custNr;
		this.accNr = accNr;
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	public long getCustID() {
		return custID;
	}
	public int getCustNr() {
		return custNr;
	}
	public int getAccNr() {
		return accNr;
	}
	public double getBalance() {
		return balance;
	}
	
}
