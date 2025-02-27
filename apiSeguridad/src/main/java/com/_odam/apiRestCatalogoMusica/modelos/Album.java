package com._odam.apiRestCatalogoMusica.modelos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "album")
public class Album {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCodigo;
	@Column
	private String nombre;
	@Column
	private int anyoLanzamiento;
	
	@ManyToOne
	@JoinColumn(name = "idDiscografica")
	@JsonBackReference
	@JsonProperty("discografica")
	private Discografica discografica;
	
	@OneToMany(mappedBy = "album", cascade = CascadeType.MERGE)
	@JsonManagedReference
	private List<Cancion> canciones;

	@Override
	public String toString() {
		 String toString = "Album [idCodigo=" + idCodigo + ", nombre=" + nombre + ", anyoLanzamiento=" + anyoLanzamiento
				+ ", discografica=" + discografica + ", canciones= ";
		 for(Cancion cancion:canciones) {
			 toString+=cancion.getTitulo() + " , ";
		 }
		 toString +="]";
		 return toString;
	}

}
