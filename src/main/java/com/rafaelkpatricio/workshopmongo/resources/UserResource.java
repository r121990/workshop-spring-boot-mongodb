package com.rafaelkpatricio.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelkpatricio.workshopmongo.domain.User;
import com.rafaelkpatricio.workshopmongo.dto.UserDTO;
import com.rafaelkpatricio.workshopmongo.services.UserService;

@RestController // Anotação de Recurso REST
@RequestMapping(value = "/users") // Anotação de caminho do Endpoint
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping // Anotação de Endpoint REST com método HTTP
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
