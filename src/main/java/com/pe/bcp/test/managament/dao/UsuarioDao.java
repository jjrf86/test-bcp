package com.pe.bcp.test.managament.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.pe.bcp.test.managament.entity.Usuario;

import reactor.core.publisher.Mono;

@Repository
public interface UsuarioDao extends ReactiveCrudRepository<Usuario, Integer> {
	
	public Mono<Usuario> findByUsername(String username);
	
}