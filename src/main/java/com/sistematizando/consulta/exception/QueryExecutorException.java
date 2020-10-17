package com.sistematizando.consulta.exception;
/**
 * @author Cristian Camilo Beltrán <ccamilo2303@gmail.com>
 * @since  17 oct. 2020
 */
public class QueryExecutorException extends Exception {


	private static final long serialVersionUID = 1L;


	public QueryExecutorException() {
		super();
	}

	public QueryExecutorException(String message) {
		super(message);
	}

	public QueryExecutorException(String message, Throwable cause) {
		super(message, cause);
	}

	public QueryExecutorException(Throwable cause) {
		super(cause);
	}

}
