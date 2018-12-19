package org.tz.pos.Lagerverwaltung;


public class UserInterface implements IUserInterface{
	
	Lagerverwaltung lagerverwaltung = new Lagerverwaltung();
	
	@Override
	public void menuErzeugen() {
		int eingabe = 999;
		do {
			System.out.println();
			System.out.println("1...Artikelverwaltung");
			System.out.println("2...Lagerverwaltung");
			System.out.println("3...Lieferantenverwaltung");
			System.out.println("4...Hilfe");
			System.out.println("__________________________________");
			System.out.println("0...Programm schließen");
			System.out.println();
					
			eingabe = new UserEingabe().eingabeZahl(1, 1);		
		
			switch (eingabe) {
				
				case 1:
					ArtikelVerwaltung.getArtikelVerwaltung().menuErzeugen();
				break;
				
				case 2:
					lagerverwaltung.menuErzeugen();
				break;
		
				case 3:
				    LieferantenVerwaltung.getLieferantenverwaltung().menuErzeugen();
				break;
				
				case 4:
					System.out.println("Hilfe Menue"+"\n");
				break;
				
				default:
					if (eingabe != 0) {
					System.out.println("Falsche Eingabe");
					}
				break;
			}			
		}while(eingabe!=0);
	}
}
