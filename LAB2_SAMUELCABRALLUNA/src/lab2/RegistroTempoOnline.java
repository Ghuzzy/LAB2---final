package lab2;

/**
 * Gerencia o tempo online de estudo de um aluno em determinada disciplina.
 * 
 * @author Samuel Cabral
 */
public class RegistroTempoOnline {
	/**
	 * Representa o tempo online esperado para disciplina.
	 */
	int tempoOnlineEsperado;
	/**
	 * Representa o nome da disciplina.
	 */
	String nomeDisciplina;
	/**
	 * Tempo em horas gasto online estudando a disciplina.
	 */
	int tempo;

	/**
	 * Constrói o registro de tempo online a partir do nome da disciplina e o tempo
	 * de estudos em horas esperado para disciplina.
	 * 
	 * @param nomeDisciplina      nome da disciplina.
	 * @param tempoOnlineEsperado tempo em horas esperados a serem dedicados para
	 *                            disciplina.
	 */
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
	}

	/**
	 * Constrói o registro de tempo online a partir do nome da disciplina, o tempo
	 * de estudos em horas esperado para disciplina é 120 como padrão
	 * 
	 * @param nomeDisciplina nome da disciplina.
	 */
	public RegistroTempoOnline(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = 120;
	}

	/**
	 * Adiciona tempo de estudo online.
	 * 
	 * @param tempo tempo de estudo dedicado a disciplina em horas.
	 */
	public void adicionaTempoOnline(int tempo) {
		this.tempo += tempo;
	}

	/**
	 * Retorna o status do tempo online do aluno e retorna um booleano que
	 * representa se o aluno atingiu ou não o tempo online esperado.
	 * 
	 * @return boolean que indica se o aluno atingiu ou não o tempo de estudo online
	 *         esperado.
	 */
	public boolean atingiuMetaTempoOnline() {
		if (this.tempo >= this.tempoOnlineEsperado) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Retorna a String que representa o status da disciplina. No formato
	 * "DISCIPLINA TEMPOGASTO / TEMPOESPERADO".
	 *
	 * @return a representação em String do status de tempo online da discplina.
	 */
	public String toString() {
		return this.nomeDisciplina + " " + this.tempo + "/" + this.tempoOnlineEsperado;
	}

}