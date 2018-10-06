package oomharj3;

public final class Maailma {
	private static long tuskanMäärä = 0;

	static void lisääTuskaa(int i) {
		tuskanMäärä += i;
		System.out.println("Tuskaa jo " + tuskanMäärä + " yksikköä!");
	}
	
	static long annaTuska() {
		return tuskanMäärä;
	}
}