package lab2;

import java.util.Arrays;

public class CoisaBonus {

	public static void main(String[] args) {
		registrarDescanso();
		System.out.println("-----");
		controlarDisciplina();
		System.out.println("-----");
		registrarResumos();
	}

	public static void registrarDescanso() {
		Descanso descanso = new Descanso();
		// Testa se emoji é apagado quando o status muda.
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(26);
		descanso.defineNumeroSemanas(1);
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(26, "8)");
		descanso.defineNumeroSemanas(1);
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(27, ":D");
		descanso.defineNumeroSemanas(1);
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(25);
		descanso.defineNumeroSemanas(1);
		System.out.println(descanso.getStatusGeral());
	}

	private static void controlarDisciplina() {
		// Testando criar Disciplina apenas com parametro nomeDaDisciplina.
		Disciplina prog2 = new Disciplina("PROG 2");
		// Testando criar Disciplina apenas com parametro nomeDaDisciplina e
		// numeroDeNotas.
		Disciplina calculo = new Disciplina("CALCULO 1", 3);
		// Testando criar Disciplina com parametro nomeDaDisciplina, numeroDeNotas e o
		// array pesos.
		Disciplina direito = new Disciplina("DIREITO", 2, new int[] { 7, 3 });

		System.out.println("PROG 2:");
		prog2.cadastraHoras(4);
		prog2.cadastraNota(1, 5.0);
		prog2.cadastraNota(2, 6.0);
		prog2.cadastraNota(3, 7.0);
		System.out.println(prog2.aprovado());
		prog2.cadastraNota(4, 10.0);
		System.out.println(prog2.aprovado());
		System.out.println(prog2.toString());

		System.out.println("###");

		System.out.println("CALCULO 1:");
		calculo.cadastraHoras(8);
		calculo.cadastraNota(1, 7.0);
		calculo.cadastraNota(2, 7.0);
		calculo.cadastraNota(3, 6.0);
		System.out.println(calculo.aprovado());
		calculo.cadastraNota(3, 10.0);
		System.out.println(calculo.aprovado());
		System.out.println(calculo.toString());

		System.out.println("###");

		System.out.println("DIREITO:");
		direito.cadastraHoras(12);
		direito.cadastraNota(1, 9.0);
		direito.cadastraNota(2, 0.0);
		System.out.println(direito.aprovado());
		direito.cadastraNota(1, 10.0);
		System.out.println(direito.aprovado());
		System.out.println(direito.toString());
	}

	public static void registrarResumos() {
		RegistroResumos meusResumos = new RegistroResumos(100); // 100 resumos.
		RegistroResumos testeResumos = new RegistroResumos(3); // 3 resumos para testar estouro de resumos.

		// Testando procurar resumos que têm determinada palavra no texto e se a String
		// retornada está em ordem alfabetica.
		meusResumos.adiciona("D", "Classes definem um tipo e a base de código para criação de objetos. teste");
		meusResumos.adiciona("C", "Identifica a semântica (operações e significados) de um conjunto de dados. teste");
		meusResumos.adiciona("A", "Classes definem um tipo e a base de código para criação de objetos. teste");
		meusResumos.adiciona("B", "Identifica a semântica (operações e significados) de um conjunto de dados. teste");
		System.out.println(Arrays.toString(meusResumos.busca("teste")));
		// Testando se quando o número de Resumos passa o tamanho predefinido da lista
		// de resumos, os próximos a serem registrados sobrepõem os primeiros.
		testeResumos.adiciona("Resumo 1", "...");
		testeResumos.adiciona("Resumo 2", "...");
		testeResumos.adiciona("Resumo 3", "...");
		String[] resumos = testeResumos.pegaResumos();

		for (int i = 0; i < testeResumos.conta(); i++) {
			System.out.println(resumos[i]);
		}
		System.out.println("###");
		testeResumos.adiciona("Resumo 4", "...");
		testeResumos.adiciona("Resumo 5", "...");
		String[] resumos2 = testeResumos.pegaResumos();

		for (int i = 0; i < testeResumos.conta(); i++) {
			System.out.println(resumos2[i]);
		}

	}
}