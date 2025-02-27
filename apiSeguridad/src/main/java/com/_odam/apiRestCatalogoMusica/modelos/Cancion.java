package com._odam.apiRestCatalogoMusica.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cancion")
public class Cancion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCancion;
	@Column
	private String titulo;
	@Column
	private int duracion;
	
	@ManyToOne
	@JoinColumn(name = "idCodigo")
	@JsonBackReference //Evita la recursion
	@JsonProperty("album")
	private Album album;

}
