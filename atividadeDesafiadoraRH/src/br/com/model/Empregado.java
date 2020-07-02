package br.com.model;


/**
 * Classe que representa o modelo de Empregado
 * 
 * @author tf
 *
 */
public class Empregado {
	/**Propriedade cpf*/
	protected long cpf;
	/**Propriedade nome*/
	protected String nome;
	
	/**
	 * Construtor da classe. Dois parâmetros precisam ser informados. 
	 * @param cpf
	 * @param nome
	 */
	public Empregado(long cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}

	/**
	 * Recupera a propriedade cpf do Empregado.
	 * @return Número do CPF do Empregado.
	 */
	public long getCpf() {
		return cpf;
	}

	/**
	 * Configura a propriedade cpf do Empregado.
	 * @param cpf
	 */
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	/**
	 * Recupera a propriedade nome do Empregado.
	 * @return Nome do empregado
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Configura a proriedade nome do Empregado.
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Sobrescrita do método toString para retornar String com os dados do Empregado separados por vírgula
	 */
	@Override
	public String toString() {
		return "Empregado: " + this.nome + ", CPF: " + this.cpf;
	}
	
}
