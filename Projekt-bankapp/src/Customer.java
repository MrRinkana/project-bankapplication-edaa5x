
public class Customer {

	private String name;
	private long idNr;
	private int custNbr;
	
	static int totalCustomers = 0; //Denna används för att skapa kundnummer
	

	/**
	* Skapar en kund (kontoinnehavare) med namnet ’name’ och id-nummer ’idNr’.
	* Kunden tilldelas också ett unikt kundnummer.
	*/
	public Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
		totalCustomers++;
		this.custNbr = totalCustomers;
	}

	
	//Denna ska nog bort, att customers skulle ligga i bank istället för bankaccount bryter
	//nog mot implementationskraven. Dock så finns inte stöd för att behålla kundnummer isf.
	//att diskutera vidare -m
	/**
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
	
	/** Tar reda på kundens namn (ingen formattering). */
	public String getName() {
		return name;
	}
	
	/** Tar reda på kundens personnummer (ingen formattering). */
	public long getIdNr() {
		return idNr;
	}
	
	/** Tar reda på kundens kundnummer (ingen formattering). */
	public int getCustomerNr() {
		return custNbr;
	}
	
	/** Returnerar en formatterad strängbeskrivning av kunden. */
	public String toString() {
		return name + ", id " + idNr + ", kundnr " + custNbr; //Samma format som i uppgiften
	}

}
