package com._odam.apiRestCatalogoMusica.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "discografica")
public class Discografica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDiscografica;
	@Column
	private String nombre;
	@Column
	private String direccion;
	@Column
	private String telefono;
}
