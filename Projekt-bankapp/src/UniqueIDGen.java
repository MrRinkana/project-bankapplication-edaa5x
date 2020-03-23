import java.math.BigInteger;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

public class UniqueIDGen {

	/*
	 * Genererar en BigInteger utifrån Time Instant som ska anändas som unikt id för användaren. 
	 * lägger till type (byte, xxx) samt ett slumptal yyy på slutet för extra unikhet. 
	 * type representerar vad för typ av objekt id tillhör, tex customer = 001 
	 * type är alltid siffrorna 24 - 27. 
	 * slumptalet är alltid de sista tre sifforna (28 - 31).
	 * Om negativt type anges, omvandlas det till motsvarande positiva tal.
	 */
	public static BigInteger generator(byte type) {
		Instant timeWas = Instant.now();

		// Tar bort onödiga karaktärer
		String tmp = timeWas.toString();
		tmp = tmp.substring(0, tmp.length() - 8);
		tmp = tmp.replace("-", "");
		tmp = tmp.replace("T", "");
		tmp = tmp.replace(":", "");

		// Gör type till tre siffror
		String typeStr;
		type = (byte) Math.abs(type);
		if (type < 10) {
			typeStr = "00" + type;
		} else if (type < 100) {
			typeStr = "0" + type;
		} else {
			typeStr = "" + type; // java löser inte to string själv
		}

		// Nanosekunder fungarar inte på alla datorer. nanosekunderna blir då 000
		tmp += timeWas.getNano() + typeStr + ThreadLocalRandom.current().nextInt(100, 1000);

		return new BigInteger(tmp);
	}

	/*
	 * Enklare unikt id -genrator som endast bildar en long från nuvarande tid.
	 * Kommer ge konton skapade inom samma mikro? -sekund samma id.
	 */
	public static long longGenerator() {
		Instant timeWas = Instant.now();
		
		// Tar bort onödiga karaktärer
		String tmp = timeWas.toString();
		tmp = tmp.substring(0, tmp.length() - 2);
		tmp = tmp.replace("-", "");
		tmp = tmp.replace("T", "");
		tmp = tmp.replace(":", "");
		tmp = tmp.replace(".", "");

		return Long.valueOf(tmp);
	}

}
