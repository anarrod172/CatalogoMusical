package com._odam.apiRestCatalogoMusica.excepciones;

public class DiscograficaNotFound extends RuntimeException{
	
	//private static final long serialVersionUID = 5030665213865363481L;

    public DiscograficaNotFound() {
        super();
    }

    public DiscograficaNotFound(String message) {
        super(message);
    }
 
    public DiscograficaNotFound(Integer id) {
        super("Discografica con id: " + id + " no encontrada.");
    }
}
