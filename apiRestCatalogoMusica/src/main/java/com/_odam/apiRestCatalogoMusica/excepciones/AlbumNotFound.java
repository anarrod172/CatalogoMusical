package com._odam.apiRestCatalogoMusica.excepciones;

public class AlbumNotFound extends RuntimeException{
	
	public AlbumNotFound() {
        super();
    }

    public AlbumNotFound(String message) {
        super(message);
    }
 
    public AlbumNotFound(Integer id) {
        super("Album con id: " + id + " no encontrado.");
    }
}
