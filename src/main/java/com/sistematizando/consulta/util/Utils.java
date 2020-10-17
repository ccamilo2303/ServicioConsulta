package com.sistematizando.consulta.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.sistematizando.consulta.config.ErrorMessages;
import com.sistematizando.consulta.config.QueryConfig;
import com.sistematizando.consulta.exception.UtilQueryFromAliasException;

/**
 * @author Cristian Camilo Beltrán <ccamilo2303@gmail.com>
 * @since  17 oct. 2020
 */
@Component
public class Utils {

	@Autowired
	private ResourceLoader resourceLoader;

	
	/**
	 * @param config
	 * @return
	 * @throws UtilQueryFromAliasException
	 */
	public String getQueryFromAlias(QueryConfig config) throws UtilQueryFromAliasException{
		try {
//			Resource resource = new ClassPathResource(config.getDescription());
//			File file = new ClassPathResource(config.getDescription()).getFile();
			InputStream file = resourceLoader.getResource("classpath:static/"+config.getDescription()).getInputStream();
			
			if(file == null)
				throw new UtilQueryFromAliasException(ErrorMessages.ERROR_LECTURA_ARCHIVO_SQL.getDescription()+config.getDescription());
			
			byte[] buffer = new byte[file.available()];
			file.read(buffer);
			String sql = new String(buffer, Charset.defaultCharset());
			file.close();
			
			if(sql == null || sql.length() == 0)
				throw new UtilQueryFromAliasException(ErrorMessages.ERROR_LECTURA_ARCHIVO_SQL.getDescription()+config.getDescription());
			
			return sql;
			
		}catch(Exception e) {
			throw new UtilQueryFromAliasException(e);
		}

	}
	
	/**
	 * 
	 * @param jsonObject
	 * @return
	 */
	public Map<String, Object> JsonObjectToMap(JSONObject jsonObject){
		
		Map<String, Object> cast = new HashMap<String, Object>();
		
		if(jsonObject != null) 
			jsonObject.keys().forEachRemaining( item -> cast.put(item, jsonObject.get(item)));
		
		return cast;
		
	}
	
	/**
	 * @param result
	 * @return
	 */
	public JSONArray listMapToJsonArray(List<Map<String, Object>> result) {
		JSONArray info = new JSONArray();
		
		if(result != null) {
			result.forEach(item -> {
				JSONObject obj = new JSONObject();
				item.forEach( (k, v) -> obj.put(k, v) );
				info.put(obj);
			});
		}
		return info;
	}
	

}
