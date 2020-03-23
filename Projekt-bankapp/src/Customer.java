
public class Customer {

	private String name;
	private long idNr;
	private double custNbr; //long too short
	/*
	 * Insåg senare att det var nog meningen det unika customer id skulle vara 
	 * typ 1, 2, 3 osv (bokstavligen kund-nummer x). Men vet inte hur det ska 
	 * implementeras isf. eftersom:
	 * 1: denna klass kommer inte och ska inte ha tillgång till andra objekt av samma typ.
	 * 2: konstruktorn ska bara ha namn och personnummer
	 * 
	 * Måste custNbr vara ev typen double som i ledningen så är det bara att byta till
	 * longGenerator i UniqueIDGen
	 */
	

	/*
	 * Skapar en ny användare
	 */
	public Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
		this.custNbr = UniqueIDGen.generator((byte) 1); //1 representerar typ "customer", se UniqueIDGen för mer info
	}

	/*
	 * Laddar in en befintlig användare. (för framtida inläsning från fil tänkte jag)
	 */
	public Customer(String name, long idNr, double custNbr) {
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
	public double getCustomerNr() {
		return custNbr;
	}
	
	/*
	 * Svarar med en strängeskrivning av kunden.
	 */
	public String toString() {
		return "Namn: " + name + " | Personnummer: " + idNr; //Osäker på formatet, hittar inte i uppgiften.
	}

}
