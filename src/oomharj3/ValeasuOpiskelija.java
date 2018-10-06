package oomharj3;

public class ValeasuOpiskelija implements Opiskelija {

	String nimi;
	int opiskelijanumero;
	Opiskelija kohde;
	OOMTilanne oomTilanne;
	
	public ValeasuOpiskelija(String nimi, int opiskelijanumero, Opiskelija kohde) {
		this.nimi = nimi;
		this.opiskelijanumero = opiskelijanumero;
		this.kohde = kohde;
		oomTilanne = new OOMTilanne();
	}

	@Override
	public OOMTilanne annaOOMTilanne() {
		return oomTilanne;
	}

	@Override
	public void asetaNimiJaOpNumero(String nimi, int opiskelijanumero) {
		this.nimi = nimi;
		this.opiskelijanumero = opiskelijanumero;
	}

	@Override
	public void ilmoittauduOOMKurssille() {
		oomTilanne.ilmoittautunut = true;
	}

	@Override
	public void osallistuLuennolle() {
		oomTilanne.luennolla = true;
	}

	@Override
	public void herää(int aikaaLuennonAlusta) {
		if(kohde.annaOOMTilanne().hereillä) return;
		else {
			oomTilanne.hereillä = false;
			oomTilanne.luennolla = false;
		}
	}

	@Override
	public void poistuLuennolta() {
		oomTilanne.luennolla = false;
	}

	@Override
	public void vastaaKysymykseen(int aikaaLuennonAlusta) {
		kohde.vastaaKysymykseen(aikaaLuennonAlusta);
	}
}