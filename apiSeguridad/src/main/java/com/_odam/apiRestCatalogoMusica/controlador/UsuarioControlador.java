package com._odam.apiRestCatalogoMusica.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;

import com._odam.apiRestCatalogoMusica.modelos.Usuario;
import com._odam.apiRestCatalogoMusica.servicios.UsuarioServicio;
import com._odam.apiRestCatalogoMusica.utiles.JwtUtil;

@RestController
@RequestMapping("/usuario/autenticacion")
public class UsuarioControlador {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UsuarioServicio usuarioServicio;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public String login(@RequestBody Usuario usuario) {
		     UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(usuario.getUsuario(), usuario.getClave());		
		Authentication authentication = authenticationManager.authenticate(token);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		return jwtUtil.generateToken(userDetails.getUsername());
	}
	@PostMapping("/nuevousuario")
	   public String registerUser(@RequestBody Usuario user) {
			System.out.println("Entoy en alta");
	       if (usuarioServicio.existsByUsuario(user.getUsuario()) != null) {
	           return "Error: Username is already taken!";
	       }
	       // Create new user's account
	       Usuario newUser = new Usuario(null, user.getUsuario(), passwordEncoder.encode(user.getClave()));
	       usuarioServicio.saveUsuario(newUser);
	       return "User registered successfully!";
	   }

}
