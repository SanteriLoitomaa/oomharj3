package oomharj3;

public class OpiskelijaAllas {

	private static Opiskelija[] opiskelijat = new Opiskelija[0];
	
	/**
	 * Metodi joka luo uusia opiskelijoita vain tarpeen vaatiessa.
	 * @param uhriMäärä
	 * @param vuosi
	 */
	public static void hankiOpiskelijat(int uhriMäärä, int vuosi) {
		Opiskelija[] uusiAllas = new Opiskelija[uhriMäärä];
		if(uhriMäärä > opiskelijat.length) {
			for(int i = 0; i < opiskelijat.length; i++) {
				uusiAllas[i] = opiskelijat[i];
			}
			for(int i = opiskelijat.length; i < uhriMäärä; i++) {
				uusiAllas[i] = new ValeasuOpiskelija(new TavallinenOpiskelija("Uniikki Lumihiutale", 1234567 + i, false));
			}
		}
		else {
			for(int i = 0; i < uhriMäärä; i++) {
				uusiAllas[i] = opiskelijat[i];
			}
		}
		for (int i = 0; i < uhriMäärä; i++) {
			uusiAllas[i].asetaNimiJaOpNumero("Uniikki Lumihiutale", 1234567 + i + vuosi);
		}
		opiskelijat = uusiAllas;
	}
	
	/**
	 * Metodi joka luo aina uudet opiskelijat.
	 * @param uhriMäärä
	 */
	public static void hankiOpiskelijat(int uhriMäärä) {
		Opiskelija[] uusiAllas = new Opiskelija[uhriMäärä];
		for (int i = 0; i<uhriMäärä; i++)
		uusiAllas[i] = new TavallinenOpiskelija("Uniikki Lumihiutale", 1234567+i, true);
		opiskelijat = uusiAllas;
	}

	/**
	 * Palauttaa opiskelijat.
	 * @return
	 */
	public static Opiskelija[] opiskelijat() {
		return opiskelijat;
	}
	
}
