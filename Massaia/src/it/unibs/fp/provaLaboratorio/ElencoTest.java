package it.unibs.fp.provaLaboratorio;
//
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ElencoTest {

	@Test
	void testAggiungiElemento() throws Exception{
		Elenco<Ingrediente> elencoIngredienti = new Elenco<>();
		elencoIngredienti.aggiungiElemento(new Ingrediente("prezzemolo", 10));
		assertEquals(elencoIngredienti.getElenco().size(), 1);
	}
	
	/**
	 * verifico che il metodo aggiungiElemento della classe Elenco aggiunga correttamente 
	 * all'ArrayList l'elemento indicato
	 * @throws Exception
	 */
	@Test
	void testAggiungiElementoDovrebbeEssereUguale() throws Exception{
		Elenco<Ingrediente> elencoIngredienti = new Elenco<>();
		elencoIngredienti.aggiungiElemento(new Ingrediente("prezzemolo", 10));
		Ingrediente i = new Ingrediente("prezzemolo", 10);
		Ingrediente a = elencoIngredienti.getElenco().get(0);
		assertEquals(a,i);
	}

	@Test
	void testToString() throws Exception{
		Elenco<Ingrediente> elencoIngredienti = new Elenco<>();
		elencoIngredienti.getElenco().get(0);
	}

}
