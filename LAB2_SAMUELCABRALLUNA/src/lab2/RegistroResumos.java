package lab2;

import java.util.*;

/**
 * Representação de um sistema para gerenciar material de estudo(resumo).
 * 
 * @author Samuel Cabral
 */
public class RegistroResumos {

	/**
	 * Array de Resumos que irá conter os resumos.
	 */
	private Resumo[] resumos;
	/**
	 * Váriavel auxiliar, para toda vez que o array resumos seja completo os novos
	 * resumos sejam registrados no lugar dos primeiros.
	 */
	private int indice = 0;

	/**
	 * Acumula a quantidade de resumos cadastrados.
	 */
	private int conta = 0;

	/**
	 * Define a quantidade de resumos.
	 * 
	 * @param num tamanho do array de resumos.
	 */
	public RegistroResumos(int num) {
		this.resumos = new Resumo[num];
	}

	/**
	 * Adiciona um resumo no array resumos.
	 * 
	 * @param tema  tema do resumo.
	 * @param texto conteúdo textual do resumo.
	 */
	public void adiciona(String tema, String texto) {
		Resumo auxiliar = new Resumo(tema, texto);
		this.resumos[this.indice % this.resumos.length] = auxiliar; // quando o indice maior que tamanho de resumo pega
																	// o modulo, sendo assim repõem nos primeiros
																	// valores.
		this.indice += 1;
		this.conta += 1;
	}

	/**
	 * Conta a quantidade de resumos cadastrados.
	 * 
	 * @return retorna inteiro que representa a quantidade de resumos cadastrados.
	 */
	public int conta() {
		if (this.conta >= this.resumos.length) {
			return this.resumos.length;
		}
		return this.conta;
	}

	/**
	 * Recebe um tema e verifica se existe algum resumo cadastrado com esse tema.
	 * 
	 * @param tema tema do resumo a ser procurado.
	 * 
	 * @return retorna um booleano se tem ou não o resumo.
	 */
	public boolean temResumo(String tema) {
		for (int i = 0; i < conta(); i++) {
			if (this.resumos[i].tema().equals(tema)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Retorna todos os resumos em um array de Strings no formato "TEMA : TEXTO".
	 * 
	 * @return String[] com cada elemento no formato "TEMA : TEXTO"
	 */
	public String[] pegaResumos() {
		String[] resumos = new String[conta()];
		for (int i = 0; i < conta(); i++) {
			resumos[i] = this.resumos[i].tema() + " : " + this.resumos[i].texto();
		}
		return resumos;
	}

	/**
	 * Método auxiliar que retorna apenas os temas dos resumos.
	 * 
	 * @return String[] com todos os temas de resumos.
	 */
	private String[] pegaTemas() {
		String[] temas = new String[conta()];
		for (int i = 0; i < conta(); i++) {
			temas[i] = this.resumos[i].tema();
		}
		return temas;
	}

	/**
	 * Retorna um string que representa o status dos resumos cadastrados mostrando a
	 * quantidade e os temas.
	 * 
	 * @return String que representa status dos resumos com o formato "-
	 *         quantidadeDeResumos resumo(s) cadastrado(s) \n - tema1 | tema2 |
	 *         tema..." .
	 */
	public String imprimeResumos() {

		String resumosCadastrados = "- " + conta() + " resumo(s) cadastrado(s)" + "\n" + "- ";
		String[] temas = pegaTemas();
		String stringFormatada = resumosCadastrados + String.join(" | ", temas);
		return stringFormatada;
	}

	public String[] busca(String palavra) {
		String[] temasTextosComPalavra;
		String[] auxiliar = new String[this.resumos.length];
		int conta = 0;
		for (int i = 0; i < conta(); i++) {
			if (this.resumos[i].texto().toLowerCase().contains(palavra.toLowerCase())) {
				auxiliar[i] = this.resumos[i].tema();
				conta += 1;
			}
		}
		temasTextosComPalavra = new String[conta];
		for (int i = 0; i < conta; i++) {
			temasTextosComPalavra[i] = auxiliar[i];
		}

		if (conta == 0) {
			return new String[] { "Nenhum resumo encontrado" };
		}
		Arrays.sort(temasTextosComPalavra);
		return temasTextosComPalavra;
	}

}