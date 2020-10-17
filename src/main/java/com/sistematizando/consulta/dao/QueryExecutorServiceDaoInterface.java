package com.sistematizando.consulta.dao;

import java.util.Map;

import org.json.JSONArray;

import com.sistematizando.consulta.exception.QueryExecutorException;

/**
 * @author Cristian Camilo Beltrán <ccamilo2303@gmail.com>
 * @since  17 oct. 2020
 */
public interface QueryExecutorServiceDaoInterface {

	/**
	 * @param params
	 * @param query
	 * @return
	 * @throws QueryExecutorException
	 */
	public JSONArray executor(Map<String, Object> params, String query) throws QueryExecutorException;
	
}
