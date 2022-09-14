package it.unibs.fp.provaLaboratorio;

import java.util.ArrayList;

import it.unibs.fp.mylib.EstrazioniCasuali;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class MassaiaMain {
	private static final String[] OPZIONI_MENU = {"Gestisci elenco ingredienti","Gestisci elenco ricette","Componi un menu"};
	private static final String TITOLO_MENU= "Menu principale";
	
	private static final String[] OPZIONI_MENU_INGREDIENTI = {"Aggiungi ingrediente all'elenco","Visualizza elenco"};
	private static final String TITOLO_MENU_INGREDIENTI = "Menu di gestione dell'elenco degli ingredienti";
	
	private static final String[] OPZIONI_MENU_RICETTE = {"Aggiungi ricetta all'elenco","Visualizza elenco"};
	private static final String TITOLO_MENU_RICETTE = "Menu di gestione dell'elenco delle ricette";
	private static Elenco<Ingrediente> elencoIngredienti = new Elenco<Ingrediente>();
	private static Elenco<Ricetta> elencoRicette = new Elenco<Ricetta>();

	public static void main(String[] args) {
		MyMenu menuPrincipale = new MyMenu(TITOLO_MENU ,OPZIONI_MENU);

		boolean finito = false;
		while(!finito) {
			switch(menuPrincipale.scegli()) {
			case 0:
				finito = true;
				break;
			case 1:
				gesticiElencoIngredienti();
				break;
			case 2:
				gestisciElencoRicette();
				break;
			case 3:
				componiMenu();
				break;
			default:	//non è necessario grazie alla classe MyMenu
				System.out.println("L'opzione selezionata e' inesistente");
			}
		}
	}

	private static void gesticiElencoIngredienti() {
		MyMenu menuElencoIngredienti = new MyMenu(TITOLO_MENU_INGREDIENTI, OPZIONI_MENU_INGREDIENTI);
		switch(menuElencoIngredienti.scegli()) {
		case 0:
			break;
		case 1:
			aggiungiIngrediente();
			break;
		case 2:
			System.out.println(elencoIngredienti.toString());
			break;
		}
	}

	private static void aggiungiIngrediente() {
		String nomeIngrediente = InputDati.leggiStringa("Inserisci nome dell'ingrediente: ");
		int calorie = InputDati.leggiIntero("Inserisci le calorie per 100g di prodotto: ");
		elencoIngredienti.aggiungiElemento(new Ingrediente(nomeIngrediente, calorie));
	}

	private static void gestisciElencoRicette() {
		MyMenu menuElencoRicette = new MyMenu(TITOLO_MENU_RICETTE, OPZIONI_MENU_RICETTE);
		switch(menuElencoRicette.scegli()) {
		case 0:
			break;
		case 1:
			aggiungiRicetta();
			break;
		case 2:
			System.out.println(elencoRicette.toString());
			break;
		}
		
	}

	private static void aggiungiRicetta() { //da vedere se si puo fare un metodo nel do while
		String nomeRicetta = InputDati.leggiStringa("Inserisci il nome della ricetta: ");
		String descrizioneRicetta = InputDati.leggiStringa("Inserisci la sua descrizione: ");
		boolean primoPiatto = InputDati.yesOrNo("E' un primo piatto (si) o un secondo (no)");
		Ricetta ricetta = new Ricetta(nomeRicetta, descrizioneRicetta, primoPiatto);
		boolean finito = false;
		do {
			ricetta.aggiungiIngrediente(selezionaIngredienteDaAggiungere(), InputDati.leggiIntero("Inserisci la quanita per ogni 100g"));
			if(!InputDati.yesOrNo("Vuoi inserire altri ingredienti?")) 
				finito = true;
		} while(!finito);
		elencoRicette.aggiungiElemento(ricetta);
	}
	
	private static Ingrediente selezionaIngredienteDaAggiungere() {
		System.out.println((elencoIngredienti.toString()));
		int indexIngredienteScelto = InputDati.leggiIntero("Inserisci il numero dell'ingrediente che vuoi aggiungere")-1;
		return elencoIngredienti.getElementoDaElencoConIndice(indexIngredienteScelto);
	}

	private static void componiMenu() { //non mi piace per niente
		int calorieMassime = InputDati.leggiIntero("Inserisci le calorie massime tollerabili");
		ArrayList<Menu> elencoCombinazioniMenu = combinazioniMenu(calorieMassime);
		if(elencoCombinazioniMenu.isEmpty()) {
			System.out.println("Non e' presente un menu adeguato");
		}else {
			Menu menu = estraiMenuCausale(elencoCombinazioniMenu);
			Ricetta primoPiatto = menu.getPrimoPiatto();
			Ricetta secondoPiatto = menu.getSecondoPiatto();
			if(InputDati.yesOrNo("vuoi visualizzare pure gli ingredienti?")) {
				System.out.print("Il menu e' composta da:\n\t");
				System.out.print(primoPiatto.toString());
				System.out.print("\t"+secondoPiatto.toString());
			}else {
				System.out.print("Il menu e' composta da:\n");
				System.out.print(primoPiatto.toStringSenzaIngredienti());
				System.out.print("\t"+ secondoPiatto.toStringSenzaIngredienti());
			}
		}
		
	}

	private static ArrayList<Menu> combinazioniMenu(int calorieMassime) {
		ArrayList<Menu> combinazioniMenu = new ArrayList<>();
		for(int j = 0; j< elencoRicette.getElenco().size(); j++) {
			Ricetta ricetta = elencoRicette.getElenco().get(j);
			for(int i = j+1; i<  elencoRicette.getElenco().size(); i++) {
				Ricetta ricettaConfronto = elencoRicette.getElenco().get(i);
				if(ricetta.isPrimoPiatto() != ricettaConfronto.isPrimoPiatto())
					if(ricetta.calcoloCalorieTotali()+ricettaConfronto.calcoloCalorieTotali()<=calorieMassime)
						combinazioniMenu.add(new Menu(ricetta, ricettaConfronto));
			}
		}
		return combinazioniMenu;
	}

	private static Menu estraiMenuCausale(ArrayList<Menu> combinazioniMenu) {
		Menu menuEstratto = combinazioniMenu.get(EstrazioniCasuali.estraiIntero(0, combinazioniMenu.size()-1));
		return menuEstratto;
	}


}
