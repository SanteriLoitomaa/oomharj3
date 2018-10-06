package oomharj3;

public final class Maailma {
	private static long tuskanMäärä = 0;

	static void lisääTuskaa(int i) {
		tuskanMäärä += i;
	}
	
	static long annaTuska() {
		return tuskanMäärä;
	}
}