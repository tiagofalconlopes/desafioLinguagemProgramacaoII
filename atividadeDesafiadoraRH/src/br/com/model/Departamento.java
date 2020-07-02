package br.com.model;

/**
 * 
 * Classe que representa o modelo de Departamento 
 * 
 * @author tf
 *
 */

public class Departamento {

	/**Propriedade número*/
	private int numero;
	/**Propriedade nome*/
	private String nome;
	
	
	/**
	 * Método construtor da classe. Dois parâmetros precisam se informados.
	 * @param numero
	 * @param nome
	 */
	public Departamento(int numero, String nome) {
		this.numero = numero;
		this.nome = nome;
	}
	
	/**
	 * Recupera a propriedade número do Departamento.
	 * @return Número do departamento.
	 */
	public int getNumero() {
		return numero;
	}
	/**
	 * Configura a propriedade número do Departamento.
	 * @param numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	/**
	 * Recupera a propriedade nome do Departamento.
	 * @return Nome do departamento.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Configura a propriedade nome do Departamento.
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Sobrescrita do método toString para retornar String com os dados do Departamento separados por vírgula
	 */
	@Override
	public String toString() {
		return "Departamento: " + this.nome + ", Dep. número: " + this.numero;
	}
}
