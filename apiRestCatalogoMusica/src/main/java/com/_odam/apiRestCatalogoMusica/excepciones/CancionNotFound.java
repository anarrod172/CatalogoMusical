package com._odam.apiRestCatalogoMusica.excepciones;

public class CancionNotFound extends RuntimeException{
	
	public CancionNotFound() {
        super();
    }

    public CancionNotFound(String message) {
        super(message);
    }
 
    public CancionNotFound(Integer id) {
        super("Cancion con id: " + id + " no encontrada.");
    }
}
