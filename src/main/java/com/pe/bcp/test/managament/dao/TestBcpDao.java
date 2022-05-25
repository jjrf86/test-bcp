package com.pe.bcp.test.managament.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.pe.bcp.test.managament.entity.TipoCambio;

import reactor.core.publisher.Mono;

@Repository
public interface TestBcpDao extends ReactiveCrudRepository<TipoCambio, Long> {
	
	public Mono<TipoCambio> findByMonedaOrigenAndMonedaDestino(String monedaOrigen,String monedaDestino);
}