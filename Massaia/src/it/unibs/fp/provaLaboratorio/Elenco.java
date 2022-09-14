package it.unibs.fp.provaLaboratorio;

import java.util.ArrayList;
/**
 * 
 * @author Francesco
 *
 * @param <E>
 */
public class Elenco <E> {
	private ArrayList<E> elenco;

	public Elenco() {
		elenco = new ArrayList<>();
	}
	
	public void aggiungiElemento(E elemento) {
		elenco.add(elemento);
	}
	
	public String toString() {
		StringBuffer stringaElenco = new StringBuffer("L'Elenco e':\n");
		int i=1;
		for(E elemento: elenco) {
			stringaElenco.append(String.format("\t%d) " + elemento.toString(), i) + "\n");
			i++;
		}
		return stringaElenco.toString();		
	}

	public ArrayList<E> getElenco() {
		return elenco;
	}
	
	public E getElementoDaElencoConIndice(int index) {
		return elenco.get(index);
	}

	public void setElenco(ArrayList<E> elenco) {
		this.elenco = elenco;
	}
	
}
