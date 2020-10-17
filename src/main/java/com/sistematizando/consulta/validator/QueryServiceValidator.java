package com.sistematizando.consulta.validator;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.sistematizando.consulta.config.ErrorMessages;
import com.sistematizando.consulta.config.QueryConfig;
import com.sistematizando.consulta.dto.QueryBody;
import com.sistematizando.consulta.exception.QueryServiceException;

/**
 * @author Cristian Camilo Beltrán <ccamilo2303@gmail.com>
 * @since  17 oct. 2020
 */
@Service
public class QueryServiceValidator {

	
	public void validateBody(QueryBody body) throws QueryServiceException{
		
		if(body == null)
			throw new QueryServiceException(ErrorMessages.ERROR_VALIDACION_BODY_VACIO.getDescription());
		
		if(Arrays.asList(QueryConfig.values()).stream().filter(item->item.name().equals(body.getReportName())).count() == 0 )
			throw new QueryServiceException(ErrorMessages.ERROR_NO_EXISTE_CONSULTA.getDescription());
		
		if(body.getParams() == null){
			throw new QueryServiceException(ErrorMessages.ERROR_VALIDACION_BODY_VACIO.getDescription());
		}
		
	}
	
}
