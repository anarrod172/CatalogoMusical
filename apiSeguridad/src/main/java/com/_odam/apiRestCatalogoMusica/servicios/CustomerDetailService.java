package com._odam.apiRestCatalogoMusica.servicios;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com._odam.apiRestCatalogoMusica.modelos.Usuario;
import com._odam.apiRestCatalogoMusica.repositorios.UsuarioRepositorio;


@Service
public class CustomerDetailService implements UserDetailsService{
	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	       Usuario user = usuarioRepositorio.findByUsuario(username);
	       if (user == null) {
	           throw new UsernameNotFoundException("User Not Found with username: " + username);
	       }
	       return new org.springframework.security.core.userdetails.User(
	               user.getUsuario(),
	               user.getClave(),
	               Collections.emptyList()
	       );
	 }
}
