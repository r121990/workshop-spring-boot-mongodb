package com.rafaelkpatricio.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelkpatricio.workshopmongo.domain.Post;
import com.rafaelkpatricio.workshopmongo.repository.PostRepository;
import com.rafaelkpatricio.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired // Instanciar automaticamente um objeto no serviço (injeção de dependência
				// automatica do Spring)
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public List<Post> findByTitle(String text) {
		return repo.findByTitleContainingIgnoreCase(text);
	}
}
