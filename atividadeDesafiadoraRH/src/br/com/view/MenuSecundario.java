package br.com.view;

import br.com.controller.DepartamentoBO;
import br.com.controller.EmpregadoBO;
import br.com.controller.ExistingValueException;
import br.com.util.Teclado;

/**
 * Classe que apresenta os métodos de interação do menu às classes BO
 * @author tf
 *
 */
public class MenuSecundario {

	/**
	 * Método que gerencia as opções de operações realizadas na sobre a lista de departamentos.
	 * Lança exceção no caso de cadastrar valores duplicados.
	 * @throws ExistingValueException
	 */
	public void departamento() throws ExistingValueException {

		Teclado teclado = new Teclado();
		boolean valor = true;

		DepartamentoBO departamentoBO = new DepartamentoBO();
		String nome;
		int numero;

		while (valor) {
			menuSecundario();
			int opcao = teclado.lerInt();
			switch (opcao) {
			case 1:
				System.out.println("\nDigite o nome do Departamento para cadastrar\n");
				nome = teclado.lerString();
				System.out.println("\nDigite o número do Departamento para cadastrar\n");
				numero = teclado.lerInt();
				departamentoBO.save(nome, numero);
				break;
			case 2:
				departamentoBO.getAll();
				break;
			case 99:
				System.out.println("\nRetornando ao menu principal\n");
				valor = false;
				break;
			default:
				System.out.println("\nOpção inválida! Escolha novamente!");
				break;
			}
		}

	}

	/**
	 * Método que gerencia as opções de operações realizadas na sobre a lista de empregados.
	 * Lança exceção no caso de cadastrar valores duplicados.
	 * @throws ExistingValueException
	 */
	public void empregado() throws ExistingValueException {

		Teclado teclado = new Teclado();
		boolean valor = true;

		EmpregadoBO empregadoBO = new EmpregadoBO();
		String nome;
		long cpf;

		while (valor) {
			menuSecundario();
			int opcao = teclado.lerInt();
			switch (opcao) {
			case 1:
				System.out.println("\nDigite o nome do Empregado para cadastrar\n");
				nome = teclado.lerString();
				System.out.println("\nDigite o cpf do Empregado para cadastrar\n");
				cpf = teclado.lerLong();
				empregadoBO.save(cpf, nome);
				break;
			case 2:
				empregadoBO.getAll();
				empregadoBO.getAllNaoGerentes();
				break;
			case 99:
				System.out.println("\nSaindo do Sistema\n");
				valor = false;
				break;
			default:
				System.out.println("\nOpção inválida! Escolha novamente!");
				break;
			}
		}

	}

	/**
	 * Método que gerencia as opções de operações realizadas na sobre a lista de gerentes.
	 * Lança exceção no caso de cadastrar valores duplicados.
	 * @throws ExistingValueException
	 */
	public void gerente() throws ExistingValueException {

		Teclado teclado = new Teclado();
		boolean valor = true;

		EmpregadoBO empregadoBO = new EmpregadoBO();
		String nome;
		String nomeDepartamento;
		long cpf;

		while (valor) {
			menuSecundario();
			int opcao = teclado.lerInt();
			switch (opcao) {
			case 1:
				System.out.println("\nDigite o nome do Gerente para cadastrar\n");
				nome = teclado.lerString();
				System.out.println("\nDigite o cpf do Gerente para cadastrar\n");
				cpf = teclado.lerLong();
				System.out.println("\nDigite o departamento do Gerente para cadastrar\n");
				nomeDepartamento = teclado.lerString();
				
				empregadoBO.save(cpf, nome, nomeDepartamento);
				break;
			case 2:
				empregadoBO.getAllGerentes();
				break;
			case 99:
				System.out.println("\nSaindo do Sistema\n");
				valor = false;
				break;
			default:
				System.out.println("\nOpção inválida! Escolha novamente!");
				break;
			}
		}

	}

	/**
	 * Método que chama o menu secundário e apresenta as opções das opções.
	 */
	private void menuSecundario() {
		System.out.println("\nEscolha a atividade que deseja realizar");
		System.out.println("1 - Cadastrar item");
		System.out.println("2 - Listar itens");
		System.out.println("99 - Retornar ao menu principal");
	}

}
