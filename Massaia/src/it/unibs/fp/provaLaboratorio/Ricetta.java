package it.unibs.fp.provaLaboratorio;

import java.util.HashMap;

public class Ricetta {
	private String nome;
	private String descrizione;
	private HashMap<Ingrediente, Integer> ingredientiDellaRicetta; //Integer e' la quantita - 100g
	private boolean primoPiatto; //primo piatto = true , invece, secondo piatto = false
	
	public Ricetta(String nome, String descrizione, boolean primoPiatto) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.primoPiatto = primoPiatto;
		ingredientiDellaRicetta = new HashMap<Ingrediente, Integer>();
	}

	public boolean equals(Ricetta r) {
		if (r == null)
			return false;
		return descrizione.equals(r.getDescrizione()) && nome.equals(r.getNome()) &&
				primoPiatto == r.isPrimoPiatto() && ingredientiDellaRicetta.equals(r.getIngredientiDellaRicetta());
	}
	
	public void aggiungiIngrediente(Ingrediente ingrediente, int quantita) {
		ingredientiDellaRicetta.put(ingrediente, quantita);
	}
	
	public int calcoloCalorieTotali() {
		int calorieTotali = 0;
		for(Ingrediente ingrediente: ingredientiDellaRicetta.keySet()) {
			calorieTotali += (ingrediente.getCalorie()*ingredientiDellaRicetta.get(ingrediente));
		}
		return calorieTotali;
	}
	
	@Override
	public String toString() { //cambiare elencoIngredientiRicette
		StringBuffer infoIngredientiRicetta = new StringBuffer();
		for(Ingrediente keyIngrediente : ingredientiDellaRicetta.keySet()) {
			infoIngredientiRicetta.append("\t\t"+keyIngrediente.toString() + " - " + ingredientiDellaRicetta.get(keyIngrediente) + "\n");
		}
		return nome +"-" + (primoPiatto?"e' un primo piatto":"e' un secondo piatto") + ":\t" + descrizione + "\n" +infoIngredientiRicetta; 
	}
	
	public String toStringSenzaIngredienti() {
		return nome +"-" + (primoPiatto?"e' un primo piatto":"e' un secondo piatto") + ":\t" + descrizione; 
	}

	public boolean isPrimoPiatto() {
		return primoPiatto;
	}

	public void setPrimoPiatto(boolean primoPiatto) {
		this.primoPiatto = primoPiatto;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public HashMap<Ingrediente, Integer> getIngredientiDellaRicetta() {
		return ingredientiDellaRicetta;
	}
	
	public void setIngredientiDellaRicetta(HashMap<Ingrediente, Integer> ingredientiDellaRicetta) {
		this.ingredientiDellaRicetta = ingredientiDellaRicetta;
	}
	
}
