package com.yaydoo.examen.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yaydoo.examen.model.Usuarios;

/**
 * @author Alan Martinez
 * 
 * Repositorio para tabla usuarios.
 *
 */
@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
	
	List<Usuarios> findAll();
	
	Usuarios findByEmail(String email);
	
	Usuarios findByIdUser(Long id);

}
