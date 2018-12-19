package org.tz.pos.Lagerverwaltung;


public class Lagerverwaltung implements IUserInterface {
	
	private Lager lager = new Lager();
	//private ArtikelVerwaltung artikelVerwaltung = new ArtikelVerwaltung();
	
	public Lagerverwaltung() {
		getLager().lagerErzeugen();
	}

	public Lager getLager() {
		return lager;
	}


	public void setLager(Lager lager) {
		this.lager = lager;
	}


	public void artikelAnlieferung() {
		System.out.println("Welchen Artikel möchten Sie einlagern? Bitte auswählen (Art. Nr eingeben)");
		ArtikelVerwaltung.getArtikelVerwaltung().artikelAusgeben();
		int eingabe = new UserEingabe().eingabeZahl(4, 4);
		for (Artikel artikel : ArtikelVerwaltung.getArtikelVerwaltung().getArtikelstamm()) {
			if(eingabe == artikel.getArtikelNr()) {
				artikel.setArtikelNr(eingabe);
				lager.einlagern(artikel);
			}
		}
		
		lager.lagerListeAusgeben();
		
	}
	
	public void artikelAusliefern() {
					
		System.out.println("Welchen Artikel möchten Sie ausliefern? (Art. Nr eingeben)");
		ArtikelVerwaltung.getArtikelVerwaltung().artikelAusgeben();
		int eingabe = new UserEingabe().eingabeZahl(4, 4);
		for(Artikel artikel : ArtikelVerwaltung.getArtikelVerwaltung().getArtikelstamm()) {				
			if(eingabe == artikel.getArtikelNr()) {
				lager.auslagern(artikel);
			}
		}
	}
	
	public void menuErzeugen() {
		
		int eingabe= 9999;
		do {
			System.out.println();
			System.out.println("Lagerverwaltungs Menü:");
			System.out.println("_________________________");
			System.out.println("1...Artikel anliefern");
			System.out.println("2...Artikel ausliefern");
			System.out.println("3...Lager anzeigen");
			System.out.println("_________________________");
			System.out.println("0...Zurück zum Hauptmenü");
			System.out.println();
			eingabe = new UserEingabe().eingabeZahl(1, 1);
			
			if(eingabe == 1) {
				artikelAnlieferung();
			}
			else if(eingabe == 2) {
				artikelAusliefern();
			}
			else if(eingabe == 3) {
				lager.lagerListeAusgeben();
			}
			else if(eingabe >3) {
				System.out.println("Falsche Eingabe");
			}
			
		}while(eingabe !=0);
	}
}
