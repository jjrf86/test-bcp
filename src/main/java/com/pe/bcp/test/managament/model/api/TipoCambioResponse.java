package com.pe.bcp.test.managament.model.api;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TipoCambioResponse implements Serializable {

	private static final long serialVersionUID = 5916841495195220750L;
	
	private Double monto;
	
	private Double montoTipoCambio;
	
	private String monedaOrigen;
	
	private String monedaDestino;
	
	private Double tipoCambio;

}