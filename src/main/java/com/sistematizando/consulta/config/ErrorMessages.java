package com.sistematizando.consulta.config;
/**
 * @author Cristian Camilo Beltrán <ccamilo2303@gmail.com>
 * @since  17 oct. 2020
 */
public enum ErrorMessages {
	
	ERROR_LECTURA_ARCHIVO_SQL("No se pudo leer el archivo del recurso: "),
	ERROR_PARAMS_VACIO("Los parámetros no pueden estar vacíos"),
	ERROR_VALIDACION_BODY_VACIO("El body no puede estar vacío"),
	ERROR_NO_EXISTE_CONSULTA("El nombre del reporte no está definido");
	
	private String description;

	private ErrorMessages(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	
}
