package oomharj3;

public class oomharj3 {

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

	/**
	 * Kertoo paljonko tuskaa syntyy ensimmäisen viiden vuoden aikana käytännön aloituksesta.
	 * @param args
	 */
	public static void main(String[] args) {
		int vuosi = 2018;
		int uhriMäärä = 100 + new java.util.Random().nextInt(10 * (vuosi - 2000));
		long vuoden1Tuska = 0;
		long vuoden2Tuska = 0;
		long vuoden3Tuska = 0;
		long vuoden4Tuska = 0;
		long vuoden5Tuska = 0;
		OpiskelijaAllas.hankiOpiskelijat(uhriMäärä);
		for(int i = 0; i < 5; i++) {
			new oomharj3().pidäVuosittainenInstanssi(OpiskelijaAllas.opiskelijat());
			if(i == 0) {
				vuoden1Tuska = Maailma.annaTuska();
			} else if(i == 1) {
				vuoden2Tuska = Maailma.annaTuska();
			} else if(i == 2) {
				vuoden3Tuska = Maailma.annaTuska();
			} else if(i == 3) {
				vuoden4Tuska = Maailma.annaTuska();
			} else if(i == 4) {
				vuoden5Tuska = Maailma.annaTuska();
			}
			vuosi++;
			uhriMäärä = 100 + new java.util.Random().nextInt(10 * (vuosi - 2000));
			OpiskelijaAllas.hankiOpiskelijat(uhriMäärä, vuosi);
			//OpiskelijaAllas.hankiOpiskelijat(uhriMäärä);
		}
		System.out.println("Vuoden 1 tuska: " + vuoden1Tuska);
		System.out.println("Vuoden 2 tuska: " + (vuoden2Tuska - vuoden1Tuska));
		System.out.println("Vuoden 3 tuska: " + (vuoden3Tuska - vuoden2Tuska));
		System.out.println("Vuoden 4 tuska: " + (vuoden4Tuska - vuoden3Tuska));
		System.out.println("Vuoden 5 tuska: " + (vuoden5Tuska - vuoden4Tuska));
		System.out.println("Tuska yhteensä: " + vuoden5Tuska);
	}
}