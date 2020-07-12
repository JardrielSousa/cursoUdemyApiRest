package br.com.cursoapirest.exceptions;

public class EmpresaNaoEncontradaExceptions extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EmpresaNaoEncontradaExceptions(){
		super();
	}
	
	public EmpresaNaoEncontradaExceptions(String message) {
        super(message);
    }
}
