package com._odam.apiRestCatalogoMusica.servicios;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com._odam.apiRestCatalogoMusica.modelos.Usuario;

public interface UsuarioServicio {
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	public Usuario existsByUsuario(String nombre);
	public void saveUsuario(Usuario u);
}

