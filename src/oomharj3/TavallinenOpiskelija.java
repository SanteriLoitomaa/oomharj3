package oomharj3;

public class TavallinenOpiskelija implements Opiskelija {

	String nimi;
	int opiskelijanumero;
	OOMTilanne oomTilanne;

	public TavallinenOpiskelija(String nimi, int opiskelijanumero) {
		this.nimi = nimi;
		this.opiskelijanumero = opiskelijanumero;
		this.oomTilanne = new OOMTilanne();
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
		oomTilanne.hereillä = true;
	}

	@Override
	public void herää(int aikaaLuennonAlusta) {
		if(oomTilanne.hereillä) return;
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
		// TODO Auto-generated method stub

	}
}