
public class Customer {

	private String name;
	private long idNr;
	private int custNbr;
	
	static int totalCustomers = 0; //Denna används för att skapa kundnummer
	

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
	 * Alla befintliga användare MÅSTE läsas in innan nya skapas.
	 */
	public Customer(String name, long idNr, int custNbr) {
		this.name = name;
		this.idNr = idNr;
		this.custNbr = custNbr;
		
		//återuppbygg totalCustomers efter inläsning från fil
		//antar att alla konton läses in innan nya skapas, annars risk för dubbla custNbr
		if (custNbr > totalCustomers) totalCustomers = custNbr;
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
		return name + ", id " + idNr + ", kundnr " + custNbr; //Samma format som i uppgiften
	}

}
