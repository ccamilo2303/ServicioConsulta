package com.sistematizando.consulta.dao;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sistematizando.consulta.exception.QueryExecutorException;
import com.sistematizando.consulta.util.Utils;

/**
 * Dao con método genérico que ejecuta la consulta que determina el servicio
 * <br>
 * Realiza unos cast establecidos en las utilidades
 * @author Cristian Camilo Beltrán <ccamilo2303@gmail.com>
 * @since  17 oct. 2020
 */
@Repository
public class QueryExecutorServiceDao implements QueryExecutorServiceDaoInterface{

	
	@Autowired
	@Qualifier("datasourcePrimary")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplateOne;
	
	@Autowired
	private Utils utils;
	
	
	@Override
	public JSONArray executor(Map<String, Object> params, String query) throws QueryExecutorException {
		List<Map<String, Object>> result = namedParameterJdbcTemplateOne.queryForList(query, params);
		return utils.listMapToJsonArray(result);
	}
	
	
	
	
}
