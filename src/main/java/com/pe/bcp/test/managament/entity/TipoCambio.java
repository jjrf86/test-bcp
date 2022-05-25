package com.pe.bcp.test.managament.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Table("TIPO_CAMBIO")
public class TipoCambio implements Serializable {

	private static final long serialVersionUID = 6982117213683262271L;
	
	@Id
	private Long id;
	
	@Column("moneda_origen")
	private String monedaOrigen;
	
	@Column("moneda_destino")
	private String monedaDestino;
	
	@Column("tipo_cambio")
	private Double tipoCambio;
}