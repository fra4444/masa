package it.unibs.fp.provaLaboratorio;

public class Menu {
	private Ricetta primoPiatto;
	private Ricetta secondoPiatto;
	
	public Menu(Ricetta primoPiatto, Ricetta secondoPiatto) {
		this.primoPiatto = primoPiatto;
		this.secondoPiatto = secondoPiatto;
	}

	public Ricetta getPrimoPiatto() {
		return primoPiatto;
	}

	public Ricetta getSecondoPiatto() {
		return secondoPiatto;
	}
	
	

}
