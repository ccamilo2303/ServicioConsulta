package com.sistematizando.consulta.exception;
/**
 * @author Cristian Camilo Beltrán <ccamilo2303@gmail.com>
 * @since  17 oct. 2020
 */
public class UtilQueryFromAliasException extends Exception {


	private static final long serialVersionUID = 1L;


	public UtilQueryFromAliasException() {
		super();
	}

	public UtilQueryFromAliasException(String message) {
		super(message);
	}

	public UtilQueryFromAliasException(String message, Throwable cause) {
		super(message, cause);
	}

	public UtilQueryFromAliasException(Throwable cause) {
		super(cause);
	}

}
