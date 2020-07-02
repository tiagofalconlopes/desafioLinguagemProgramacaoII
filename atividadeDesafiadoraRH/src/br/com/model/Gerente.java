package br.com.model;

/**
 * Classe que representa o modelo de Gerente, que estende a classe Empregado.
 * @author tf
 *
 */
public class Gerente extends Empregado {

	/**Propriedade departamento representada por um objeto Departamento*/
	Departamento departamento;
	
	/**
	 * Método construtor da classe Gerente, que chama o construtor da classe Empregado.
	 * Recebe os parâmetros usados na classe Empregado.
	 * @param cpf
	 * @param nome
	 */
	public Gerente(long cpf, String nome) {
		super(cpf, nome);
	}

	/**
	 * Recupera a propriedade departamento da classe Gerente.
	 * @return objeto departamento.
	 */
	public Departamento getDepartamento() {
		return departamento;
	}

	/**
	 * Configura a propriedade departamento do Gerente.
	 * @param departamento
	 */
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	/**
	 * Sobrescrita do método toString para retornar String com os dados do Gerente separados por vírgula
	 */
	@Override
	public String toString() {
		return "Gerente: " + super.nome + ", CPF: " + super.cpf + ", " + this.departamento;
	}

}
