package com._odam.apiRestCatalogoMusica.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CancionDto {
	
	private int idCancion;
	private String titulo;
	private int duracion;
	private int idCodigo;
}
