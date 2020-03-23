import java.math.BigInteger;

public class Customer {

	private String name;
	private long idNr;
	private BigInteger custNbr; //long too short
	/*
	 * Insåg senare att det var nog meningen det unika customer id skulle vara 
	 * typ 1, 2, 3 osv (bokstavligen kund nummer: x).
	 * Eftersom denna klass inte har och ej bör ha tillgång till andra objekt av samma typ
	 * så kan ett sådant id endast genereras utanför i en annan klass som har rätt att räkna
	 * objekt eller håller koll på senast skapade konto-nummret. Tycker ett sådant system 
	 * är lite fult. Min lösning är även thread-safe ;)
	 * 
	 * Måste custNbr vara ev typen long som i ledningen så är det bara att byta till
	 * longGenerator i UniqueIDGen
	 */
	

	/*
	 * Skapar en ny användare
	 */
	public Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
		this.custNbr = UniqueIDGen.generator((byte) 1); //1 representerar typen "customer", se UniqueIDGen för mer info
	}

	/*
	 * Laddar in en befintlig användare. (för framtida inläsning från fil tänkte jag)
	 */
	public Customer(String name, long idNr, BigInteger custNbr) {
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
	public BigInteger getCustomerNr() {
		return custNbr;
	}
	
	public String getCustomerNrAsString() {
		return custNbr.toString();
	}
	
	/*
	 * Svarar med en strängbeskrivning av kunden.
	 */
	public String toString() {
		return "Namn: " + name + " | Personnummer: " + idNr; //Osäker på formatet, hittar inte i uppgiften.
	}

}
