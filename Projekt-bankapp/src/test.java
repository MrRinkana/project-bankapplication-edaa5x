import java.time.Instant;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Instant nu = Instant.now();
		System.out.println(nu.toString());
		System.out.println(Instant.now());
		System.out.println(nu.getNano());
		
		
		String tmp = nu.toString();
		tmp = tmp.substring(0, tmp.length() - 7);
		tmp = tmp.replace("-", "");
		tmp = tmp.replace("T", "");
		tmp = tmp.replace(":", "");
		tmp = tmp.replace(".", "");
		tmp += nu.getNano();
		
		System.out.println(tmp);
	}

}
