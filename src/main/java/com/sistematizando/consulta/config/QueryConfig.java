package com.sistematizando.consulta.config;
/**
 * ENUM que define los álias para cada archivo de consulta,
 * <br> 
 * Ej: <b>TERCEROS("ConsultaTerceros.sql")</b>
 * <br>
 * <b>TERCEROS</b> es el álias que se envía desde el body
 * <br>
 * Lo que está dentro del constructor <b>("ConsultaTerceros.sql")</b>
 * <br>
 * Es el nombre del archivo de consulta
 * @author Cristian Camilo Beltrán <ccamilo2303@gmail.com>
 * @since  17 oct. 2020
 */
public enum QueryConfig {

	TERCEROS("ConsultaTerceros.sql"),
	TERCEROS_2("ConsultaTerceros2.sql");
	
	
	private String description;

	private QueryConfig(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}
