package oomharj3;

public class ValeasuOpiskelija implements Opiskelija {

	Opiskelija opiskelija;
	
	public ValeasuOpiskelija(Opiskelija opiskelija) {
		this.opiskelija = opiskelija;
	}

	/**
	 * @.pre true
	 * @.post RESULT == (Palauttaa tilanneolion)
	 */
	@Override
	public OOMTilanne annaOOMTilanne() {
		return opiskelija.annaOOMTilanne();
	}

	/**
	 * Asettaa opiskelijan nimen ja op. numeron
	 * 
	 * @.pre nimi != null && opNumero>0
	 * @.post (nimi & op.numero asetettu)
	 **/
	@Override
	public void asetaNimiJaOpNumero(String nimi, int opNumero) {
		opiskelija.asetaNimiJaOpNumero(nimi, opNumero);
	}

	/**
	 * @.pre true
	 * @.post annaOOMTilanne().ilmoittautunut == true && annaOOMTilanne().hereillä
	 *        == false && annaOOMTilanne().luennolla == false &&
	 *        (OLD(annaOOMTilanne().ilmoittautunut) || Maailma.tuskanMäärä ==
	 *        OLD(Maailma.tuskanMäärä) + 1000)
	 */
	@Override
	public void ilmoittauduOOMKurssille() {
		opiskelija.ilmoittauduOOMKurssille();
	}

	/**
	 * @.pre annaOOMTilanne().ilmoittautunut == true && annaOOMTilanne().hereillä ==
	 *       false
	 * @.post Maailma.tuskanMäärä == OLD(Maailma.tuskanMäärä) + 10 &&
	 *        annaOOMTilanne().luennolla == true
	 */
	@Override
	public void osallistuLuennolle() {
		opiskelija.osallistuLuennolle();
	}

	/**
	 * @.pre 0 ≤ aikaaLuennonAlusta < 90
	 * @.post annaOOMTilanne().hereillä == true
	 */
	@Override
	public void herää(int aikaaLuennonAlusta) {
		opiskelija.herää(aikaaLuennonAlusta);
	}

	/**
	 * @.pre annaOOMTilanne().luennolla == true
	 * @.post annaOOMTilanne().luennolla == false && annaOOMTilanne().hereillä ==
	 *        false
	 */
	@Override
	public void poistuLuennolta() {
		opiskelija.poistuLuennolta();
	}

	/**
	 * @.pre annaOOMTilanne().ilmoittautunut == true && annaOOMTilanne().hereillä ==
	 *       true
	 * @.post Maailma.tuskanMäärä == OLD(tuskanMäärä) + 90 -
	 *        hereilläAlkaenMinuutista && annaOOMTilanne().hereillä == true
	 */
	@Override
	public void vastaaKysymykseen(int aikaaLuennonAlusta) {
		opiskelija.vastaaKysymykseen(aikaaLuennonAlusta);
	}
}