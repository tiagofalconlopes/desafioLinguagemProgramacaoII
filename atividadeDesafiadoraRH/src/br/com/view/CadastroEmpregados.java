package br.com.view;

import br.com.controller.ExistingValueException;
import br.com.util.Teclado;

/**
 * Classe que representa a interação do usuário (tela) porém aqui utilizando o console.
 * Apresenta um menu de opções.
 * @author tf
 *
 */
public class CadastroEmpregados {

	public static void main(String[] args) throws ExistingValueException {

		boolean valor = true;
		Teclado escolha = new Teclado();
		MenuSecundario controller = new MenuSecundario();
		
		

		while (valor) {
			menuPrincipal();
			int opcao = escolha.lerInt();

			switch (opcao) {
			case 1:
				controller.departamento();
				break;
			case 2:
				controller.empregado();
				break;
			case 3:
				controller.gerente();
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
	 * Método que chama o menu principal e apresenta os valores das opções.
	 */
	public static void menuPrincipal() {
		System.out.println("\nEscolha o número da classe que deseja cadastrar");
		System.out.println("Para cadastrar gerentes, deve haver um departamento previamente cadastrado");
		System.out.println("1 - Departamento");
		System.out.println("2 - Funcionário");
		System.out.println("3 - Gerentes");
		System.out.println("99 - Sair");
	}

}
