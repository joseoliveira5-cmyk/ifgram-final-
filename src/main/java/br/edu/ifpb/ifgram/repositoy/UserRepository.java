package br.edu.ifpb.ifgram.repositoy;

import jakarta.validation.constraints.Email;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findByNomeContainingIgnoreCase(String trecho);
    @Query("select u from User u where u.email like concat('%', :dominio)") List<User> doDominio (String dominio);

    boolean existsByEmail(@Email String email);
}