package com.yaydoo.examen.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Alan Martinez
 *Modelo de la tabla Usuarios.
 *
 */
@Entity
@Table(name="usuarios")
@Data
public class Usuarios implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(updatable=false,nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
	private Informacion info;
	

}
