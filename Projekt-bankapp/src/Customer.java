
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
