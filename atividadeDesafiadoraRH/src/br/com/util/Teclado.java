package br.com.util;

import java.util.Scanner;

/**
 * Classe de utilitário, Cria objeto que possui métodos para receber input a partir do console.
 * @author tf
 *
 */
public class Teclado {

	/**Propriedade teclado representada por um objeto Scanner*/
	Scanner teclado = new Scanner(System.in);
	
	/**
	 * Método que aceita a leitura de uma String do console.
	 * @return String lida a partir do console.
	 */
	public String lerString() {
		String aux = teclado.nextLine();
		return aux;
	}
	
	/**
	 * Método que aceita a leitura de um escalar long do console.
	 * @return Número do tipo long.
	 */
	public long lerLong() {
		long aux = teclado.nextLong();
		teclado.nextLine(); // para evitar ficar na mesma linha no console
		return aux;
	}
	
	/**
	 * Método que aceita a leitura de um escalar inteiro do console.
	 * @return Número do tipo int.
	 */
	public int lerInt() {
		int aux = teclado.nextInt();
		teclado.nextLine(); // para evitar ficar na mesma linha no console
		return aux;
	}
	
}
