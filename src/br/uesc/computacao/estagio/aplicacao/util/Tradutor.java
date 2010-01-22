package br.uesc.computacao.estagio.aplicacao.util;

/**
 * Classe utilizada para traduzir Portugues/Ingles
 * @author Zilton José Maciel Cordeiro Junior - Orientadora: Martha Ximena Torres Delgado
 * @version 2.0
 */

public class Tradutor {

	/*
	 * Variaveis Globais
	 *
	 * Caso ENGLISH -> linguage = 1
	 * Caso PORTUGUESE -> linguage = 0
	 */
	private final static int ENGLISH = 1;
	private final static int PORTUGUESE = 0;

	private static int linguage = PORTUGUESE;

	/*
	 * Metodo que retorna o idioma Portugues/Ingles
	 */
	public static String traduzir(String portuguese, String english) {
		if(linguage == PORTUGUESE)
			return portuguese;
		else
			return english;
	}

	public static int getLinguage() {
		return linguage;
	}

	public static void setLinguage(int linguage) {
		Tradutor.linguage = linguage;
	}

	public static int getENGLISH() {
		return ENGLISH;
	}

	public static int getPORTUGUESE() {
		return PORTUGUESE;
	}

}
