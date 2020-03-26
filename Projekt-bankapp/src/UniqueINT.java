import java.util.ArrayList;

public class UniqueINT {

	public int uniqueIntC(ArrayList<Customer> a) {
		String tmp = "01" + (a.size()+1);
		return Integer.valueOf(tmp);
	}
	
	public int uniqueIntB(ArrayList<BankAccount> a) {
		String tmp = "02" + (a.size()+1);
		return Integer.valueOf(tmp);
	}
	
	
}
