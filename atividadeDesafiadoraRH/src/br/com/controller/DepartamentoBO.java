package br.com.controller;

import java.util.ArrayList;

import br.com.model.Departamento;

/**
 * Classe que representa os métodos para interagir com a classe Departamento
 * @author tf
 *
 */
public class DepartamentoBO {

	/**
	 * Propriedade estática, que pode ser acessada através da classe. Representa uma lista de objetos Departamento.
	 * Por ser estática também possui o mesmo valor em todos os objetos da classe.
	 */
	static ArrayList<Departamento> departamentos = new ArrayList<Departamento>();

	/**
	 * Método para salvar novos objetos Departamento, adicionando-os à lista departamentos, a partir de suas propriedades nome e numero.
	 * Lança exceção no caso de valores duplicados.
	 * @param nome
	 * @param numero
	 * @throws ExistingValueException
	 */
	public void save(String nome, int numero) throws ExistingValueException {
		
		for (int i = 0; i < departamentos.size(); i++) {

			try {
				if (departamentos.get(i).getNome().equals(nome)) {
					System.out.println("\nDepartamento com o nome " + nome + " já existente!\n");
					throw new ExistingValueException();
				}
			} catch (Exception e) {
				e.getMessage();
				System.out.println("\nCadastre outro departamento");
				return;
			}
			
			try {
				if (departamentos.get(i).getNumero() == numero) {
					System.out.println("\nDepartamento com o número " + numero + " já existente!\n");
					throw new ExistingValueException();
				}
			} catch (Exception e) {
				e.getMessage();
				System.out.println("\nCadastre outro departamento");
				return;
			}
			
		}

		departamentos.add(new Departamento(numero, nome));
	}
	
	/**
	 * Método que lista todos os departamentos, imprimindo no console. Separados por vírgula.
	 * Caso não exista nenhum objeto Departamento na lista, um aviso será impresso.
	 */
	public void getAll() {
		
		if(departamentos.size() == 0) {
			System.out.println("\nAinda não existem departamentos cadastrados!\n");
			return;
		}
		
		System.out.println("\nLista de Departamentos:");
		
		for (int i = 0; i < departamentos.size(); i++) {
			System.out.print(departamentos.get(i) + ", ");
		}
		
		
	}
	
	/**
	 * Método que recebe o nome do departamento como parâmetro, retornando o objeto Departamento a partir da lista.
	 * Caso não seja encontrado, um aviso é impresso e retorna null.
	 * É usado no método save, classe EmpregadoBO, para objetos Gerente.
	 * @param nome
	 * @return objeto Departamento, se encontrado, ou null
	 */
	public static Departamento pesquisarDepartamentoPeloNome(String nome) {
		for (int i = 0; i < departamentos.size(); i++) {

			if (departamentos.get(i).getNome().equals(nome)) {
				System.out.println("\nDepartamento com o nome " + nome + " foi encontrado!\n");
				return departamentos.get(i);
			}
		}
		
		System.out.println("\nDepartamento com o nome " + nome + " não encontrado!\n");
		return null;
		
	}

}
