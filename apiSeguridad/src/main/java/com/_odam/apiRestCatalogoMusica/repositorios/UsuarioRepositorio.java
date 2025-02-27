package com._odam.apiRestCatalogoMusica.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._odam.apiRestCatalogoMusica.modelos.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	Usuario findByUsuario(String username);
    boolean existsByUsuario(String username);
}
