package com.sistematizando.consulta.exception;
/**
 * @author Cristian Camilo Beltrán <ccamilo2303@gmail.com>
 * @since  17 oct. 2020
 */
public class QueryServiceException extends Exception {


	private static final long serialVersionUID = 1L;


	public QueryServiceException() {
		super();
	}

	public QueryServiceException(String message) {
		super(message);
	}

	public QueryServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public QueryServiceException(Throwable cause) {
		super(cause);
	}

}
