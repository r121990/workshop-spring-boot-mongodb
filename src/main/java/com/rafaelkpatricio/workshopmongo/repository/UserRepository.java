package com.rafaelkpatricio.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rafaelkpatricio.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> { // <tipo da classe de domínio, tipo do id da
																		// classe>
	
}
