package com.sistematizando.consulta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.sistematizando.consulta.config.QueryConfig;
import com.sistematizando.consulta.dao.QueryExecutorServiceDaoInterface;
import com.sistematizando.consulta.dto.QueryBody;
import com.sistematizando.consulta.dto.QueryResponse;
import com.sistematizando.consulta.exception.QueryServiceException;
import com.sistematizando.consulta.util.Utils;
import com.sistematizando.consulta.validator.QueryServiceValidator;

/**
 * @author Cristian Camilo Beltrán <ccamilo2303@gmail.com>
 * @since  17 oct. 2020
 */
@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class QueryService{

	@Autowired
	private QueryServiceValidator queryServiceValidator;

	@Autowired
	private Utils utils;

	@Autowired
	private QueryExecutorServiceDaoInterface queryExecutorServiceDaoInterface;


	@Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = { "Exception" })
	public QueryResponse executeGenericQuery(QueryBody body) throws QueryServiceException {
		try {
			QueryResponse response = new QueryResponse();
			queryServiceValidator.validateBody(body);
			String query = utils.getQueryFromAlias(QueryConfig.valueOf(body.getReportName()));
			JSONArray results = queryExecutorServiceDaoInterface.executor(body.getParams(), query);
			List<Map<String, Object>> resultsCast = new ArrayList<Map<String, Object>>();
			for(int x = 0 ; x < results.length() ; x++)
				resultsCast.add(utils.JsonObjectToMap(results.getJSONObject(x)));
			response.setResults(resultsCast);
			response.setStatus(HttpStatus.OK);
			response.setMessage(HttpStatus.OK.getReasonPhrase());
			response.setStatusCode(HttpStatus.OK.value());
			return response;

		}catch(Exception e) {
			throw new QueryServiceException(e);
		}
	}


}
