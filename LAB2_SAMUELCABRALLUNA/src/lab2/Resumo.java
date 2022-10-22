package lab2;

/**
 * Classe Resumo que contém tema e texto como atributos.
 * 
 * @author Samuel Cabral
 */
public class Resumo {
	/**
	 * Tema do resumo.
	 */
	private String tema;
	/**
	 * Conteúdo do resumo.
	 */
	private String texto;

	/**
	 * Constrói um Resumo a partir de tema e texto.
	 * 
	 * @param tema  tema do resumo.
	 * @param texto conteúdo do resumo.
	 */
	public Resumo(String tema, String texto) {
		this.tema = tema;
		this.texto = texto;
	}

	/**
	 * Retorna o tema do resumo.
	 * 
	 * @return String que contém o tema do resumo.
	 */
	public String tema() {
		return this.tema;
	}

	/**
	 * Retorna o conteúdo do resumo.
	 * 
	 * @return String que contém o texto do resumo.
	 */
	public String texto() {
		return this.texto;
	}
}