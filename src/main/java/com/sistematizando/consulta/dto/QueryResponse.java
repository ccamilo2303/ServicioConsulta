package com.sistematizando.consulta.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author Cristian Camilo Beltrán <ccamilo2303@gmail.com>
 * @since  17 oct. 2020
 */
@ApiModel("Query Response")
public class QueryResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Status de la respuesta", required = true)
	private HttpStatus status;
	
	@ApiModelProperty(value = "Código de Status de la respuesta", required = true)
	private int statusCode;
	
	@ApiModelProperty(value = "Mensaje de la respuesta", required = true)
	private String message;
	
	@ApiModelProperty(value = "Información del reporte", required = true)
	private List<Map<String, Object>> results;

	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Map<String, Object>> getResults() {
		return results;
	}
	public void setResults(List<Map<String, Object>> results) {
		this.results = results;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	
}
