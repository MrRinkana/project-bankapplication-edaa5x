
public class test {

	public static void main(String[] args) {
		
		Customer tp = new Customer("Andreas Karlsson", 194203174072L);
		
		System.out.println(tp.getName());
		System.out.println(tp.getIdNr());
		System.out.println(tp.getCustomerNr());
		
		
		System.out.println(tp.getName().indexOf("Karl")); //returnerar "K" index (första bokstaven)
		System.out.println(tp.getName().indexOf("Gustaf")); //returnerar -1
		System.out.println(tp.getName().indexOf("Kurl"));	//returnerar -1
		//man bör nog köra toLowercase på allt
		
	}

}
