package com.rafaelkpatricio.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelkpatricio.workshopmongo.domain.User;
import com.rafaelkpatricio.workshopmongo.repository.UserRepository;
import com.rafaelkpatricio.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired // Instanciar automaticamente um objeto no serviço (injeção de dependência
				// automatica do Spring)
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
