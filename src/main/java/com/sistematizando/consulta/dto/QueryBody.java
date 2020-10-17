package com.sistematizando.consulta.dto;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Cristian Camilo Beltrán <ccamilo2303@gmail.com>
 * @since  17 oct. 2020
 */
@ApiModel("Query Body")
public class QueryBody {
	
    @ApiModelProperty(value = "Nombre del reporte", required = true)
	private String reportName;
	
    @ApiModelProperty(value = "Objeto JSON con los parámetros del reporte", required = true)
	private Map<String, Object> params;
	
	
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
	@Override
	public String toString() {
		return "QueryBody [reportName=" + reportName + ", params=" + params + "]";
	}
	
	
	
}
