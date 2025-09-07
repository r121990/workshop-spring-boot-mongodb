package com.rafaelkpatricio.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelkpatricio.workshopmongo.domain.User;
import com.rafaelkpatricio.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired // Instanciar automaticamente um objeto no serviço (injeção de dependência
				// automatica do Spring)
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}
}
