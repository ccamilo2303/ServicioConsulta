package com.sistematizando.consulta.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistematizando.consulta.dto.QueryBody;
import com.sistematizando.consulta.dto.QueryResponse;
import com.sistematizando.consulta.exception.QueryServiceException;
import com.sistematizando.consulta.service.QueryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Cristian Camilo Beltrán <ccamilo2303@gmail.com>
 * @since  17 oct. 2020
 */
@RestController
@RequestMapping("/query")
@Api(value = "Query Controller", description = "Api que dispone de un método POST que ejecuta un reporte de acuerdo a los parámetros establecidos")
public class QueryController {

	
	@Autowired
	private QueryService queryService;
	
	
	@RolesAllowed({"consulta"})
	@PostMapping( consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Ejecuta un reporte según el parámetro", notes = "Retorna un JSON con la información de la ejecución del reporte" )
	public QueryResponse executeGenericQuery(@RequestBody QueryBody body) {
		
		QueryResponse response = new QueryResponse();
		
		try {
			
			response = queryService.executeGenericQuery(body);
			
		}catch(QueryServiceException e) {
			e.printStackTrace();
			response.setResults(null);
			response.setMessage(e.getMessage());
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}catch(Exception e) {
			e.printStackTrace();
			response.setResults(null);
			response.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		
		return response;
	}
	
}
