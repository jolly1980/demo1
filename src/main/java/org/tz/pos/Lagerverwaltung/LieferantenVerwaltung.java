package org.tz.pos.Lagerverwaltung;


import java.util.ArrayList;
import java.util.List;

public class LieferantenVerwaltung implements IUserInterface{
	
	//Singleton Pattern
	
	private List<Lieferant> lieferantenstamm = new ArrayList<Lieferant>();
	private static LieferantenVerwaltung lieferantenVerwaltung = new LieferantenVerwaltung();
		
	private LieferantenVerwaltung() {
		
	}
		
	public static LieferantenVerwaltung getLieferantenverwaltung(){
		
		return lieferantenVerwaltung;
	}

	public List<Lieferant> getLieferantenstamm() {
		return lieferantenstamm;
	}

	public void setLieferantenstamm(List<Lieferant> lieferantenstamm) {
		this.lieferantenstamm = lieferantenstamm;
	}

	public Lieferant lieferantlHinzufuegen() {
		Lieferant lieferant = new Lieferant();
		System.out.println("Bitte geben Sie die die Lieferantennummer ein: (6 Stellen)");
		lieferant.setLieferantenNr(new UserEingabe().eingabeZahl(6, 6));
			
		System.out.println("Bitte geben Sie den Lieferantennamen ein: (max 30 Zeichen)");
		lieferant.setLieferantenName(new UserEingabe().eingabeText(30));
			
		lieferantenstamm.add(lieferant);
		return lieferant;
	}
			
	public void lieferantenAusgeben() {
		System.out.println("Übersicht alle Lieferanten:"+"\n");
		for (Lieferant lieferant : lieferantenstamm) {
				
			System.out.println(lieferant.getLieferantenNr() +"\t"+ lieferant.getLieferantenName());
			System.out.println();
		}	
	}
	@Override
	public void menuErzeugen() {
			
		int eingabe= 9999;
		do {
			System.out.println();
			System.out.println("Lieferantenverwaltungs Menü:");
			System.out.println("_________________________");
			System.out.println("1...Lieferant anlegen");
			System.out.println("2...Alle Lieferanten anzeigen");
			System.out.println("_________________________");
			System.out.println("0...Zurück zum Hauptmenü");
			System.out.println();	
			eingabe = new UserEingabe().eingabeZahl(1, 1);
				
			if(eingabe == 1) {
				lieferantlHinzufuegen();
			}
			else if(eingabe == 2) {
				lieferantenAusgeben();;
			}
			else if(eingabe > 2){
				System.out.println("Falsche Eingabe");
			}
		}while(eingabe !=0);
	}
	
}
	
	
	

