package org.tz.pos.Lagerverwaltung;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomas Zoller
 */

public class ArtikelVerwaltung implements IUserInterface{
	
	private List<Artikel> artikelstamm = new ArrayList<Artikel>();
	
	//Singleton Pattern
	private static ArtikelVerwaltung artikelVerwaltung = new ArtikelVerwaltung();
	
	
	private ArtikelVerwaltung() {
		
	}
	
	/**
	 * Singleton Pattern 
	 * Erstellung einer statischen Instanz artikelVerwaltung
	 */
	public static ArtikelVerwaltung getArtikelVerwaltung() {
		return artikelVerwaltung;
	}
	
	public List<Artikel> getArtikelstamm() {
		return artikelstamm;
	}

	public void setArtikelstamm(List<Artikel> artikelstamm) {
		this.artikelstamm = artikelstamm;
	}
	
	/**
	 * Erzeugt mittels Usereingaben einen neuen Artikel
	 * @return den neu angelegten Artikel
	 */
	public Artikel artikelHinzufuegen() {
		Artikel artikel = new Artikel();
		System.out.println("Bitte geben Sie die die Artikel-Nummer ein: (4 Stellen)");
		artikel.setArtikelNr(new UserEingabe().eingabeZahl(4, 4));
		
		System.out.println("Bitte geben Sie die Artikel Bezeichnung ein: (max 30 Zeichen)");
		artikel.setArtikelBez(new UserEingabe().eingabeText(30));
		
		System.out.println("Bitte geben Sie den ArtikelPreis:");
		artikel.setArtikelPreis(new UserEingabe().eingabeDezimalZahl(10));
			
		System.out.println("Treffen Sie eine Auswahl: (Lieferanten Nummer eingeben)");
		
		LieferantenVerwaltung.getLieferantenverwaltung().lieferantenAusgeben();
		int eingabe = new UserEingabe().eingabeZahl(6,6);
		
		for (Lieferant lieferant : LieferantenVerwaltung.getLieferantenverwaltung().getLieferantenstamm()) {
			if(eingabe == lieferant.getLieferantenNr()) {
				artikel.setLieferant(lieferant);
			}
		}
		
		artikel.setArtikelLagerort("Nicht eingelagert");
		
		artikelstamm.add(artikel);
		return artikel;
	}
	
	/**
	 * Gibt alle Artikel aus der artikelstamm-Liste aus
	 */
	
	public void artikelAusgeben() {
		System.out.println("Übersicht Artikel:"+"\n");
		for (Artikel artikel : artikelstamm) {
			
			System.out.println(artikel.getArtikelNr() +"\t"+ artikel.getArtikelBez()+"\t"+artikel.getArtikelPreis()+"\t"+artikel.getArtikelLagerort()+"\t"+artikel.getLieferant().toString());
			System.out.println();
		}	
	}
	/**
	 * Erzeugt ein Untermenu im Userinterface
	 */
	@Override
	public void menuErzeugen() {
		
		int eingabe= 9999;
		do {
			System.out.println();
			System.out.println("Artikelverwaltungs Menü:");
			System.out.println("_________________________");
			System.out.println("1...Artikel anlegen");
			System.out.println("2...Alle Artikel anzeigen");
			System.out.println("_________________________");
			System.out.println("0...Zurück zum Hauptmenü");
			System.out.println();
			eingabe = new UserEingabe().eingabeZahl(1, 1);
			
			if(eingabe == 1) {
				artikelHinzufuegen();
			}
			else if(eingabe == 2) {
				artikelAusgeben();
			}
			else if(eingabe > 2){
				System.out.println("Falsche Eingabe");
			}
		}while(eingabe !=0);
		
		
	}
	
	
}
