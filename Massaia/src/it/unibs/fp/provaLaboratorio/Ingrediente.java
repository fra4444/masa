package it.unibs.fp.provaLaboratorio;

import java.util.Objects;

public class Ingrediente {
	private String nome;
	private int calorie;
	private final String UNITA_MISURA = "kcal/100g";
	
	public Ingrediente(String nome, int calorie) {
		this.nome = nome;
		this.calorie = calorie;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		return calorie == other.calorie && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return String.format("%-20s", nome) + " " + calorie + " " + UNITA_MISURA;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
}
