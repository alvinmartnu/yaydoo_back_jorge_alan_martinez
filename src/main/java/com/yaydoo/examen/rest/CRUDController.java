package com.yaydoo.examen.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.yaydoo.examen.model.Informacion;
import com.yaydoo.examen.model.Usuarios;
import com.yaydoo.examen.repo.UsuariosRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CRUDController {

	@Autowired
	UsuariosRepository userRepo;

	@Operation(summary = "Agrega un nuevo usuario.")
	@RequestMapping(value = "/agrega", produces = "application/json", method = { RequestMethod.POST })
	public ResponseEntity<Usuarios> agregaUsuario(@RequestBody Usuarios request) {

		Usuarios user = userRepo.save(request);

		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@Operation(summary = "Recupera todos los usuarios.")
	@RequestMapping(value = "/getAll", produces = "application/json", method = { RequestMethod.GET })
	public ResponseEntity<List<Usuarios>> getAllUsuario() {

		List<Usuarios> lstUser = userRepo.findAll();

		return new ResponseEntity<>(lstUser, HttpStatus.OK);
	}

	@Operation(summary = "Recupera a un usuario por email.")
	@RequestMapping(value = "/getByemail", produces = "application/json", method = { RequestMethod.GET })
	public ResponseEntity<Usuarios> getByEmail(@RequestParam String email) {

		Usuarios user = userRepo.findByEmail(email);

		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro ningun usuario con ese correo.");

		}
	}

	@Operation(summary = "Recupera un usuario por ID.")
	@RequestMapping(value = "/usuario/{userId}", produces = "application/json", method = { RequestMethod.GET })
	public ResponseEntity<Usuarios> getByID(@PathVariable("userId") Long userId) {

		Usuarios user = userRepo.findByIdUser(userId);

		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro ningun usuario con ese ID.");

		}
	}

	@Operation(summary = "Actualiza un usuario por ID.")
	@RequestMapping(value = "/update/{userId}", produces = "application/json", method = { RequestMethod.PUT })
	public ResponseEntity<Usuarios> updateUser(@PathVariable("userId") Long id, @RequestBody Usuarios updateUser) {

		Usuarios user = userRepo.findByIdUser(id);
		Informacion info;

		if (user != null) {

			if (updateUser.getName() != null) {
				user.setName(updateUser.getName());
			}
			if (updateUser.getEmail() != null) {
				user.setEmail(updateUser.getEmail());
			}
			if (updateUser.getPassword() != null) {
				user.setPassword(updateUser.getPassword());
			}
			if (updateUser.getInfo() != null) {
				
				if(user.getInfo()!=null) {
					info = user.getInfo();
				}else {
					info = new Informacion();
				}
				if (updateUser.getInfo().getAddress() != null) {
					info.setAddress(updateUser.getInfo().getAddress());
				}
				if (updateUser.getInfo().getBornDate() != null) {
					info.setBornDate(updateUser.getInfo().getBornDate());
				}
				if (updateUser.getInfo().getPhone() != null) {
					info.setPhone(updateUser.getInfo().getPhone());
				}

				user.setInfo(info);
			}

			userRepo.save(user);

			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro ningun usuario con ese ID.");

		}
	}
	
	
	@Operation(summary = "Elimina un usuario por ID.")
	@RequestMapping(value = "/delete/{userId}", produces = "application/json", method = { RequestMethod.DELETE })
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long id) {

		Usuarios user = userRepo.findByIdUser(id);
				
		if(user!=null) {
			userRepo.delete(user);
			return new ResponseEntity<>( HttpStatus.NO_CONTENT);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro ningun usuario con ese ID.");

		}
	}

}
