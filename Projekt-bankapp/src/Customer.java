
public class Customer {

	private String name;
	private long idNr;
	private int custNbr;
	

	/*
	 * Skapar en ny användare
	 */
	public Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
		this.custNbr = 666;//Bank.giveUserID();
	}

	/*
	 * Laddar in en befintlig användare. (för framtida inläsning från fil tänkte jag)
	 */
	public Customer(String name, long idNr, int custNbr) {
		this.name = name;
		this.idNr = idNr;
		this.custNbr = custNbr;
	}
	
	/*
	 * Svarar med kundens namn utan formattering.
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Svarar med kundens personnummer
	 */
	public long getIdNr() {
		return idNr;
	}
	
	/*
	 * Svarar med kundens unika ID
	 */
	public int getCustomerNr() {
		return custNbr;
	}
	
	/*
	 * Svarar med en strängbeskrivning av kunden.
	 */
	public String toString() {
		return "Namn: " + name + " | Personnummer: " + idNr; //Osäker på formatet, hittar inte i uppgiften.
	}

}
