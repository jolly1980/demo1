package org.tz.pos.Lagerverwaltung;

public class Lieferant {

	private int lieferantenNr;
	private String lieferantenName;
	
	public Lieferant(int lieferantenNr, String lieferantenName) {
		this.lieferantenNr = lieferantenNr;
		this.lieferantenName = lieferantenName;
	}
	
	public Lieferant() {
		
	}
	
	public int getLieferantenNr() {
		return lieferantenNr;
	}
	public void setLieferantenNr(int lieferantenNr) {
		this.lieferantenNr = lieferantenNr;
	}
	public String getLieferantenName() {
		return lieferantenName;
	}
	public void setLieferantenName(String lieferantenName) {
		this.lieferantenName = lieferantenName;
	}
	
	public String toString() {
		return Integer.toString(getLieferantenNr());
		
	}
	
}
