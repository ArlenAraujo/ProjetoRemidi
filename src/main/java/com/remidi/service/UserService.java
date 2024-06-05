package com.remidi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remidi.entity.User;
import com.remidi.repository.UserRepository;

@Service
public class UserService {
	
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save(User usuario) {
        return userRepository.save(usuario);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User findByEmailAndPassword(String email, String senha) {
        return userRepository.findByEmailAndSenha(email, senha);
    }

	public List<User> getAniversariantes() {
		// TODO Auto-generated method stub
		return null;
	}
    
   /* public List<User> getAniversariantes() {
        // Implemente a lógica para buscar os aniversariantes
        return userRepository.findUpcomingBirthdays();
    }*/
}


