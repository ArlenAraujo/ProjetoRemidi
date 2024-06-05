package com.remidi.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.remidi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	   /*@Query("SELECT u FROM User u WHERE MONTH(u.dataNascimento) = MONTH(CURRENT_DATE) AND DAY(u.dataNascimento) >= DAY(CURRENT_DATE) ORDER BY DAY(u.dataNascimento)")
	    List<User> findUpcomingBirthdays();	*/
	User findByEmailAndSenha(String email, String senha);
	
  

}
