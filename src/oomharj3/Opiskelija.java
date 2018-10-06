package oomharj3;

public interface Opiskelija {
	/**
	 * @.pre true
	 * @.post RESULT == (Palauttaa tilanneolion)
	 */
	OOMTilanne annaOOMTilanne();

	/**
	 * Asettaa opiskelijan nimen ja op. numeron
	 * 
	 * @.pre nimi != null && opNumero>0
	 * @.post (nimi & op.numero asetettu)
	 **/
	void asetaNimiJaOpNumero(String nimi, int opNumero);

	/**
	 * @.pre true
	 * @.post annaOOMTilanne().ilmoittautunut == true && annaOOMTilanne().hereillä
	 *        == false && annaOOMTilanne().luennolla == false &&
	 *        (OLD(annaOOMTilanne().ilmoittautunut) || Maailma.tuskanMäärä ==
	 *        OLD(Maailma.tuskanMäärä) + 1000)
	 */
	void ilmoittauduOOMKurssille();

	/**
	 * @.pre annaOOMTilanne().ilmoittautunut == true && annaOOMTilanne().hereillä ==
	 *       false
	 * @.post Maailma.tuskanMäärä == OLD(Maailma.tuskanMäärä) + 10 &&
	 *        annaOOMTilanne().luennolla == true
	 */
	void osallistuLuennolle();

	/**
	 * @.pre 0 ≤ aikaaLuennonAlusta < 90
	 * @.post annaOOMTilanne().hereillä == true
	 */
	void herää(int aikaaLuennonAlusta);

	/**
	 * @.pre annaOOMTilanne().luennolla == true
	 * @.post annaOOMTilanne().luennolla == false && annaOOMTilanne().hereillä ==
	 *        false
	 */
	void poistuLuennolta();

	/**
	 * @.pre annaOOMTilanne().ilmoittautunut == true && annaOOMTilanne().hereillä ==
	 *       true
	 * @.post Maailma.tuskanMäärä == OLD(tuskanMäärä) + 90 -
	 *        hereilläAlkaenMinuutista && annaOOMTilanne().hereillä == true
	 */
	void vastaaKysymykseen(int aikaaLuennonAlusta);
}