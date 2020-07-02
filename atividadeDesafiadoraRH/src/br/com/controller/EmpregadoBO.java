package br.com.controller;

import java.util.ArrayList;

import br.com.model.Departamento;
import br.com.model.Empregado;
import br.com.model.Gerente;

/**
 * Classe que representa os métodos para interagir com as classes Empregado e Gerente
 * @author tf
 *
 */
public class EmpregadoBO {

	/**
	 * Propriedade estática, que pode ser acessada através da classe. Representa uma lista de objetos Empregado (Empregado e Gerente).
	 * Por ser estática também possui o mesmo valor em todos os objetos da classe.
	 */
	static ArrayList<Empregado> empregados = new ArrayList<>();
	
	/**
	 * Propriedade estática, que pode ser acessada através da classe. Representa uma lista de objetos Gerente.
	 * Por ser estática também possui o mesmo valor em todos os objetos da classe.
	 */
	static ArrayList<Gerente> gerentes = new ArrayList<>();

	/**
	 * Método que salva um objeto Empregado, criando-o, a partir das propriedades nome e cpf.
	 * O objeto é guardado na lista empregados. No caso de valor já existente, lança exceção. 
	 * @param cpf
	 * @param nome
	 * @throws ExistingValueException
	 */
	public void save(long cpf, String nome) throws ExistingValueException {

		Empregado empregado = new Empregado(cpf, nome);
		
		if(checarEmpregadoDuplicado(empregado)) {
			return;
		} else {
			empregados.add(empregado);
			System.out.println("\nFuncionário cadastrado com sucesso!\n");
		}
	}

	/**
	 * Método que salva um objeto Gerente, criando-o, a partir das propriedades nome, cpf e nomeDepartamento.
	 * O objeto é guardado tanto na lista empregados como na gerentes. No caso de valor já existente, lança exceção. 
	 * @param cpf
	 * @param nome
	 * @param nomeDepartamento
	 * @throws ExistingValueException
	 */
	public void save(long cpf, String nome, String nomeDepartamento) throws ExistingValueException {

		DepartamentoBO departamentoBO = new DepartamentoBO();
		Departamento departamento = null;
				
		if((null==DepartamentoBO.pesquisarDepartamentoPeloNome(nomeDepartamento))) {
			System.out.println("\nO departamento indicado não existe.\nTente novamente indicando outro a partir da lista abaixo\n");
			departamentoBO.getAll();
			return;
		} else {
			departamento = DepartamentoBO.pesquisarDepartamentoPeloNome(nomeDepartamento);
		}
		
		Gerente gerente = new Gerente(cpf, nome);
		gerente.setDepartamento(departamento);
		
		if(checarEmpregadoDuplicado(gerente)) {
			return;
		} else {
			gerentes.add(gerente);
			empregados.add(gerente);
			System.out.println("\nGerente cadastrado com sucesso!\n");	
		}
	}

	/**
	 * Método que checa se o objeto já existe na lista empregados.
	 * Caso exista retorna o valor boleano true e lança exceção, senão retorna false.
	 * @param empregado
	 * @return Valor boleano true caso o objeto exista, senão retorna false.
	 * @throws ExistingValueException
	 */
	public boolean checarEmpregadoDuplicado(Empregado empregado) throws ExistingValueException {
		for (int i = 0; i < empregados.size(); i++) {
			try {
				if (empregados.get(i).getCpf() == empregado.getCpf()) {
					System.out.println("\nEmpregado com o CPF " + empregado.getCpf() + " já existente!\n");
					throw new ExistingValueException();
				}	
			} catch (Exception e) {
				e.getMessage();
				System.out.println("\nCadastre outro empregado");
				return true;
			}
		}
		return false;
	}

	/**
	 * Método que lista todos os empregados, imprimindo no console. Separados por vírgula.
	 * Caso não exista nenhum objeto Empregado ou Gerente na lista, um aviso será impresso.
	 */
	public void getAll() {

		if (empregados.size() == 0) {
			System.out.println("\nAinda não existem empregados cadastrados!\n");
			return;
		}

		System.out.println("\nLista de Empregados:");

		for (int i = 0; i < empregados.size(); i++) {
			System.out.print(empregados.get(i) + ", ");
		}

	}

	/**
	 * Método que lista todos os gerentes, imprimindo no console. Separados por vírgula.
	 * Caso não exista nenhum objeto Gerente na lista, um aviso será impresso.
	 */
	public void getAllGerentes() {
		System.out.println("\nLista de Gerentes:");

		if (gerentes.size() == 0) {
			System.out.println("\nAinda não existem gerentes cadastrados!\n");
			return;
		}

		for (int i = 0; i < gerentes.size(); i++) {
			System.out.print(gerentes.get(i) + ", ");
		}
	}

	/**
	 * Método que lista todos os empregados não gerentes, imprimindo no console. Separados por vírgula.
	 * Caso não exista nenhum objeto Empregado que não seja Gerente na lista, um aviso será impresso.
	 */
	public void getAllNaoGerentes() {
		System.out.println("\nLista de não Gerentes:");

		if (empregados.size() == gerentes.size()) {
			System.out.println("Ainda não existem empregados não gerentes cadastrados!");
			return;
		}

		for (int i = 0; i < empregados.size(); i++) {
			if (!(empregados.get(i) instanceof Gerente)) {
				System.out.print(empregados.get(i) + ", ");
			}
		}
	}

}
