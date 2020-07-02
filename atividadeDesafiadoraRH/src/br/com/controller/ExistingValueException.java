package br.com.controller;

/**
 * Classe representando a exceção exigida pela atividade no caso de valores repetidos.
 * Estende Exception.
 * 
 * @author tf
 *
 */
public class ExistingValueException extends Exception {

	/**
	 * Valor utilizado para remover avisos no eclipse. Sugerido pela própria IDE.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Sobrescrita do método toString para retornar String com a informação da exceção.
	 */
	@Override
	public String toString() {
		return "ExistingValueException - o valor escolhido já existe!";
	}

}
