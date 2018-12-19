package org.tz.pos.Lagerverwaltung;


//Erzeugt einen Lagerort und speichert in diesem die Artikel
public class Lager {

	
	private int anzahlReihen;
	private int anzahlStellplaetzeProReihe;
	private Artikel[][]lagerOrt;
	
	public Lager(int anzahlReihen, int anzahlStellplaetzeProReihe) {
		this.anzahlStellplaetzeProReihe = anzahlStellplaetzeProReihe;
		this.anzahlReihen = anzahlReihen;
	}
	
	public Lager() {
		
	}
		
	public int getAnzahlReihen() {
		return anzahlReihen;
	}

	public void setAnzahlReihen(int anzahlReihen) {
		this.anzahlReihen = anzahlReihen;
	}
	
	public int getAnzahlStellplaetzeProReihe() {
		return anzahlStellplaetzeProReihe;
	}

	public void setAnzahlStellplaetzeProReihe(int anzahlStellplaetzeProReihe) {
		this.anzahlStellplaetzeProReihe = anzahlStellplaetzeProReihe;
	}
	
	
	public Artikel[][] getLagerOrt() {
		return lagerOrt;
	}

	public void setLagerOrt(Artikel[][] lagerOrt) {
		this.lagerOrt = lagerOrt;
	}

	public void lagerErzeugen() {
		
		System.out.println("Wie viele Reihen soll ihr Lager aufweisen? (maximal 9 Reihen)");
		setAnzahlReihen(new UserEingabe().eingabeZahl(1,1));
		System.out.println("Wie viele Stellplätze pro Reihe soll ihr Lager aufweisen? (max 9 Stellplätze");
		setAnzahlStellplaetzeProReihe(new UserEingabe().eingabeZahl(1,1));
		
		Artikel[][]lager = new Artikel[getAnzahlReihen()][getAnzahlStellplaetzeProReihe()];
		setLagerOrt(lager);
	}	
	
	
	public void lagerListeAusgeben() {
		System.out.println("Lager Übersicht:"+"\n");
		for(int reihe = 0; reihe < getLagerOrt().length; reihe++) {
			for(int stellplatz = 0; stellplatz < getLagerOrt()[reihe].length; stellplatz++) {
				if(getLagerOrt()[reihe][stellplatz] == null) {
					System.out.print("R:"+(reihe+1)+"/SP:"+(stellplatz+1)+": leer"+"\t");
				}
				else {
				System.out.print("R:"+(reihe+1)+"/SP:"+(stellplatz+1)+": " +getLagerOrt()[reihe][stellplatz]+"\t");
				}
			}
			System.out.println();
		}
	}
	
	/* Artikel dem Array hinzufügen (return beendet die Methode sobald ein freier Platz gefunden wurde.
	 * Am Ende wird der Lagerort in einen String umgewandelt und an den Artikel übergeben
	 */
	public void einlagern(Artikel artikel) {
		
		for (int reihe = 0; reihe < getLagerOrt().length; reihe++) {
			for (int stellplatz = 0; stellplatz < getLagerOrt()[reihe].length; stellplatz++) {
				if(lagerOrt[reihe][stellplatz] == null) {
					lagerOrt[reihe][stellplatz] = artikel;
					String lagerortReihe = String.valueOf(reihe+1);
					String lagerortStellplatz = String.valueOf(stellplatz+1);
					artikel.setArtikelLagerort("Lagerort: R"+lagerortReihe+"/SP"+lagerortStellplatz);
					return;
				}
			}
		}
	}
	
	//Wenn bereits eingelagerter Artikel == in der Lagerverwaltung aufgerufener Artikel -> auf "null" setzen
	public void auslagern(Artikel artikel) {
		for (int reihe = 0; reihe < getLagerOrt().length; reihe++) {
			for (int stellplatz = 0; stellplatz < getLagerOrt()[reihe].length; stellplatz++) {
				if(lagerOrt[reihe][stellplatz].getArtikelNr() == artikel.getArtikelNr()) {
					lagerOrt[reihe][stellplatz] = null;
					artikel.setArtikelLagerort("Nicht eingelagert");
				
				return;
				}
			}
		}
	}	
		
	
}
