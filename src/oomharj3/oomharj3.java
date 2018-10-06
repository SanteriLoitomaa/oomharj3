package oomharj3;

public class oomharj3 {
	static Opiskelija[] hankiOpiskelijat(int uhriMäärä) {
		Opiskelija[] opiskelijat = new Opiskelija[uhriMäärä];
		boolean vale = false;
		for (int i = 0; i < uhriMäärä; i++) {
			if(vale) {
				opiskelijat[i] = new ValeasuOpiskelija("Uniikki Lumihiutale", 1234567 + i, opiskelijat[i-1]);
				vale = false;
			}
			else{
				opiskelijat[i] = new TavallinenOpiskelija("Uniikki Lumihiutale", 1234567 + i);
				vale = true;
			}
		}
		return opiskelijat;
	}

	// älä muuta tätä! muutoksien tulee kohdistua muualle! (kohdat b) ja d) siis)
	// tämä simuloi hienosti yhtä vuosi-instanssia myös kohtien b) ja d) tilanteissa
	final void pidäVuosittainenInstanssi(Opiskelija[] opiskelijat) {
		for (Opiskelija o : opiskelijat)
			o.ilmoittauduOOMKurssille();

		for (int luento = 0; luento < 8; luento++) {
			for (Opiskelija o : opiskelijat)
				o.osallistuLuennolle();

			opiskelijat[22].vastaaKysymykseen(30);
			opiskelijat[42].vastaaKysymykseen(60);
			opiskelijat[62].vastaaKysymykseen(75);

			for (Opiskelija o : opiskelijat)
				o.poistuLuennolta();
		}
	}

	public static void main(String[] args) {
		int vuosi = 2018;
		int uhriMäärä = 100 + new java.util.Random().nextInt(10 * (vuosi - 2000));
		Opiskelija[] opiskelijat = hankiOpiskelijat(uhriMäärä);
		new oomharj3().pidäVuosittainenInstanssi(opiskelijat);
	}
}