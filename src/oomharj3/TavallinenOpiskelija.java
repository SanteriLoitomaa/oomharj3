package oomharj3;

public class TavallinenOpiskelija implements Opiskelija {

	String nimi;
	int opNumero;
	OOMTilanne oomTilanne;

	public TavallinenOpiskelija(String nimi, int opNumero, boolean hereillä) {
		this.nimi = nimi;
		this.opNumero = opNumero;
		this.oomTilanne = new OOMTilanne();
		oomTilanne.hereillä = hereillä;
	}

	/**
	 * @.pre true
	 * @.post RESULT == (Palauttaa tilanneolion)
	 */
	@Override
	public OOMTilanne annaOOMTilanne() {
		return oomTilanne;
	}

	/**
	 * Asettaa opiskelijan nimen ja op. numeron
	 * 
	 * @.pre nimi != null && opNumero>0
	 * @.post (nimi & op.numero asetettu)
	 **/
	@Override
	public void asetaNimiJaOpNumero(String nimi, int opNumero) {
		this.nimi = nimi;
		this.opNumero = opNumero;
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
		if(!oomTilanne.ilmoittautunut) {
			oomTilanne.ilmoittautunut = true;
			Maailma.lisääTuskaa(1000);
		}
	}

	/**
	 * @.pre annaOOMTilanne().ilmoittautunut == true && annaOOMTilanne().hereillä ==
	 *       false
	 * @.post Maailma.tuskanMäärä == OLD(Maailma.tuskanMäärä) + 10 &&
	 *        annaOOMTilanne().luennolla == true
	 */
	@Override
	public void osallistuLuennolle() {
		oomTilanne.luennolla = true;
		Maailma.lisääTuskaa(10);
		if(oomTilanne.hereillä) {
			Maailma.lisääTuskaa(90);
		}
	}

	/**
	 * @.pre 0 ≤ aikaaLuennonAlusta < 90
	 * @.post annaOOMTilanne().hereillä == true
	 */
	@Override
	public void herää(int aikaaLuennonAlusta) {
		oomTilanne.hereillä = true;
	}

	/**
	 * @.pre annaOOMTilanne().luennolla == true
	 * @.post annaOOMTilanne().luennolla == false && annaOOMTilanne().hereillä ==
	 *        false
	 */
	@Override
	public void poistuLuennolta() {
		oomTilanne.luennolla = false;
		oomTilanne.hereillä = false;
	}

	/**
	 * @.pre annaOOMTilanne().ilmoittautunut == true && annaOOMTilanne().hereillä ==
	 *       true
	 * @.post Maailma.tuskanMäärä == OLD(tuskanMäärä) + 90 -
	 *        hereilläAlkaenMinuutista && annaOOMTilanne().hereillä == true
	 */
	@Override
	public void vastaaKysymykseen(int aikaaLuennonAlusta) {
		herää(aikaaLuennonAlusta);
		Maailma.lisääTuskaa(90-aikaaLuennonAlusta);
	}
}