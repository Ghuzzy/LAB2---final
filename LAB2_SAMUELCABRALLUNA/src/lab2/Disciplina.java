package lab2;

import java.util.Arrays;

/**
 * Representação do estado de um aluno em determinado disciplina, na qual contém
 * notas, horas de estudo necessárias para disciplina e estado de aprovação.
 * 
 * @author Samuel Cabral
 */
public class Disciplina {
	/**
	 * Nome da disciplina.
	 */
	private String nomeDisciplina;
	/**
	 * Horas de estudo dedicadas à esta disciplina.
	 */
	private int horas;
	/**
	 * Array de doubles que contém as notas desta disciplina.
	 */
	private double[] notas;
	/**
	 * Array de inteiros que contém o peso de cada nota da disciplina.
	 */
	int[] pesos;

	/**
	 * Constrói uma disciplina a partir do nome da disciplina. Toda disciplina
	 * começa com 0 horas de estudo. Toda disciplina tem como padrão 4 notas e pesos
	 * equivalentes.
	 * 
	 * @param nomeDisciplina nome da disciplina.
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.horas = 0;
		this.notas = new double[4];
		this.pesos = new int[4];
		for (int i = 0; i < 4; i++) {
			this.pesos[i] = 1;
		}
	}

	/**
	 * Constrói uma disciplina a partir do nome da disciplina. Toda disciplina
	 * começa com 0 horas de estudo. Toda disciplina pesos equivalentes.
	 * 
	 * @param nomeDisciplina nome da disciplina.
	 * @param numeroDeNotas  número de notas que esta disciplina possui.
	 */
	public Disciplina(String nomeDisciplina, int numeroDeNotas) {
		this.nomeDisciplina = nomeDisciplina;
		this.horas = 0;
		this.notas = new double[numeroDeNotas];
		this.pesos = new int[numeroDeNotas];
		for (int i = 0; i < numeroDeNotas; i++) {
			this.pesos[i] = 1;
		}
	}

	/**
	 * Constrói uma disciplina a partir do nome da disciplina. Toda disciplina
	 * começa com 0 horas de estudo.
	 * 
	 * @param nomeDisciplina nome da disciplina.
	 * @param numeroDeNotas  número de notas que esta disciplina possui.
	 * @param pesos[]        array de inteiros com os pesos que cada nota da
	 *                       disciplina possui.
	 */
	public Disciplina(String nomeDisciplina, int numeroDeNotas, int[] pesos) {
		this.nomeDisciplina = nomeDisciplina;
		this.horas = 0;
		this.notas = new double[numeroDeNotas];
		this.pesos = new int[numeroDeNotas];
		for (int i = 0; i < numeroDeNotas; i++) {
			this.pesos[i] = pesos[i];
		}
	}

	/**
	 * Soma horas de estudo a disciplina.
	 * 
	 * @param horas horas de estudo a serem registradas.
	 */
	public void cadastraHoras(int horas) {
		this.horas += horas;

	}

	/**
	 * Cadastra as notas do aluno na disciplina.
	 * 
	 * @param indice    a nota a qual vai ser registrada.
	 * @param valorNota a nota do aluno.
	 */
	public void cadastraNota(int indice, double valorNota) {
		this.notas[indice - 1] = valorNota;
	}

	/**
	 * Retorna o boolean que representa se o aluno está aprovado ou reprovado na
	 * disciplina.
	 * 
	 * @return o boolean que representa o estado de aprovação na disciplina.
	 */
	public boolean aprovado() {
		if (media() >= 7.0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Retorna a média das notas do aluno.
	 * 
	 * @return double o valor da média de notas.
	 */
	private double media() {
		double somaNotas = 0.0;
		int somaPesos = 0;
		for (int i = 0; i < this.notas.length; i++) {
			somaNotas += (this.notas[i] * this.pesos[i]);
			somaPesos += this.pesos[i];
		}
		return somaNotas / somaPesos;
	}

	/**
	 * Retorna a String que representa o status da disciplina. formato "NOME DA
	 * DISCIPLINA HORAS DEDICADAS MÉDIA NOTAS"
	 * 
	 *
	 * @return a representação em String do status da disciplina.
	 */
	public String toString() {
		return this.nomeDisciplina + " " + this.horas + " " + media() + " " + Arrays.toString(this.notas);
	}

}