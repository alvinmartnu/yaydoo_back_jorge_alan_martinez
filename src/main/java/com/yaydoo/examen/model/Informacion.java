package com.yaydoo.examen.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * @author Alan Martinez
 *Modelo de la tabla informacion.
 */
@Entity
@Table(name="informacion")
@Data
public class Informacion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInfo;
	@Column
	private String address;
	@Column
	private String phone;
	@Column
	private String age;
	@Column
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date bornDate;
		

}
