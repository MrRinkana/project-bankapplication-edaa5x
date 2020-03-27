
public class Customer {

	private String name;
	private long idNr;
	private int custNbr;
	static int totalCustomers = 0;
	

	/*
	 * Skapar en ny användare
	 */
	public Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
		totalCustomers++;
		this.custNbr = totalCustomers;
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
	 * Svarar med kundens unika (interna) nummer
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
