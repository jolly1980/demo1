package org.tz.pos.Lagerverwaltung;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserEingabe{

	
	public int eingabeZahl(int eingabeMax, int eingabeMin) {
		int eingabeZahl=0;
				
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.print("Eingabe:");
					
				eingabeZahl = scanner.nextInt();
				scanner.nextLine();
				System.out.println();
			}
		
			catch (InputMismatchException e) {
				System.out.println("Bitte eine Zahl eingeben!");
			}
			
			String temp = String.valueOf(eingabeZahl);
				
			if(temp.length() >eingabeMax){
				System.out.println("Zu viele Zeichen! - Es sind maximal "+eingabeMax+" Zeichen erlaubt.\"");
				eingabeZahl(eingabeMax, eingabeMin);
			}
			
			if(temp.length() < eingabeMin){
				System.out.println("Zu wenige Zeichen! - Es müssen min. "+eingabeMin+" Zeichen sein.\"");
				eingabeZahl(eingabeMax, eingabeMin);
			}
			return eingabeZahl;
			
	}

	public String eingabeText(int eingabeLänge) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Eingabe:");
		
		String eingabeText = scanner.next();
		System.out.println();
		
		if(eingabeText.length() > eingabeLänge) {
			System.out.println("Zu viele Zeichen! - Es sind maximal "+eingabeLänge+" erlaubt.");
		}
		
		return eingabeText;
	}
	
	public double eingabeDezimalZahl(int eingabeLänge) {
		double eingabeZahl=0;
		
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Eingabe:");
							
			eingabeZahl = scanner.nextDouble();
			System.out.println();
		}
	
		catch (InputMismatchException f) {
			System.out.println("Bitte eine Dezimalzahl eingeben!");
		}
		
		String temp = String.valueOf(eingabeZahl);
			
		if(temp.length() >eingabeLänge){
			System.out.println("Zu viele Zeichen! - Es sind maximal "+eingabeLänge+" erlaubt.\"");
		}
		return eingabeZahl;
	}
	
}
