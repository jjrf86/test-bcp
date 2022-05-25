package com.pe.bcp.test.security.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pe.bcp.test.managament.dao.UsuarioDao;
import com.pe.bcp.test.managament.entity.Usuario;
import com.pe.bcp.test.managament.model.api.UsuarioDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = usuarioDao.findByUsername(username).block();
		if (user == null) {
			throw new UsernameNotFoundException("Usuario no encontrado con username: " + username);
		}
		return new User(user.getUsername(), user.getPassword(),new ArrayList<>());
	}
	
	public Usuario save(UsuarioDTO user) {
		return usuarioDao.save(Usuario.builder()
				.username(user.getUsername())
				.password(bcryptEncoder.encode(user.getPassword()))
				.build()).block();
	}
}