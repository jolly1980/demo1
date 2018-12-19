package org.tz.pos.Lagerverwaltung;



public class Artikel {
	
	private int artikelNr;
	private String artikelBez;
	private Lieferant lieferant;
	private double artikelPreis;
	private String artikelLagerort;
		
	
	public Artikel(int artikelNr, String artikelBez, double artikelPreis, Lieferant lieferant) {
		this.artikelNr = artikelNr;
		this.artikelBez = artikelBez;
		this.artikelPreis = artikelPreis;
		this.lieferant = lieferant;
	}
	
	public Artikel() {
		
	}
	
	public int getArtikelNr() {
		return artikelNr;
	}
	public void setArtikelNr(int artikelNr) {
		this.artikelNr = artikelNr;
	}
	public String getArtikelBez() {
		return artikelBez;
	}
	public void setArtikelBez(String artikelBez) {
		this.artikelBez = artikelBez;
	}
	
	public Lieferant getLieferant() {
		return lieferant;
	}

	public void setLieferant(Lieferant lieferant) {
		this.lieferant = lieferant;
	}

	public double getArtikelPreis() {
		return artikelPreis;
	}

	public void setArtikelPreis(double artikelPreis) {
		this.artikelPreis = artikelPreis;
	}
		
	
	public String getArtikelLagerort() {
		return artikelLagerort;
	}

	public void setArtikelLagerort(String artikelLagerort) {
		this.artikelLagerort = artikelLagerort;
	}

	// Umwandlung der Artikel-Objekte in ArtikelNummern
	@Override
	public String toString() {
		return Integer.toString(getArtikelNr());
	}
	

		
}
