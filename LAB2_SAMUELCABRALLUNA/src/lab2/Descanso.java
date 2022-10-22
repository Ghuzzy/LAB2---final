package lab2;

/**
 * Representação de um sistema para gerenciar as horas de descanso de um aluno
 * durante a semana.
 * 
 * @author Samuel Cabral
 */

public class Descanso {
	/**
	 * Quantidade de descanso que o aluno teve durante semanas, formato em horas.
	 */
	private int hora;
	/**
	 * Quantidade de semanas em que decorreu as horas de descanso.
	 */
	private int semanas;
	/**
	 * Quantidade de descanso em horas por semana.
	 */
	private int horas_por_semana;
	/**
	 * Emoji que indica como o aluno está se sentindo.
	 */
	private String emoji;
	/**
	 * Representa se o aluno está cansado ou não.
	 */
	private String cansado = "cansado";

	/**
	 * Constrói o gerenciador de tempo de descanso. Todo aluno começa cansado, ou
	 * seja, com horas e semanas nulos.
	 */
	public Descanso() {
		this.hora = 0;
		this.semanas = 0;
	}

	/**
	 * Define as horas de descanso do aluno.
	 * 
	 * @param hora as horas de descanso que o aluno teve.
	 */
	public void defineHorasDescanso(int hora) {
		this.hora = hora;
	}

	public void defineHorasDescanso(int hora, String emoji) {
		this.hora = hora;
		this.emoji = "-" + emoji;
	}

	/**
	 * Define o periodo em semanas que decorre as horas de descanso.
	 * 
	 * @param semanas as semanas que decorrem as horas de descanso.
	 */
	public void defineNumeroSemanas(int semanas) {
		this.semanas = semanas;
	}

	/**
	 * Retorna a String que representa o estado de descanso do aluno. com o formato
	 * "descansado" ou "cansado" a depender se o descanso do aluno for maior ou
	 * igual à 26 horas semanais.
	 * 
	 * @return a representação em String do estado de descanso de um aluno e um
	 *         emoji que representa seu último estado.
	 */
	public String getStatusGeral() {
		if (this.semanas > 0) {
			horas_por_semana = this.hora / this.semanas;
			if (horas_por_semana >= 26) {
				if (this.cansado.equals("cansado")) {
					this.cansado = "descansado";
					this.emoji = "";
				}
				return "descansado" + this.emoji;
			} else {
				if (this.cansado.equals("descansado")) {
					this.cansado = "cansado";
					this.emoji = "";
				}
				return "cansado" + this.emoji;
			}
		} else {
			return "cansado";
		}

	}

}