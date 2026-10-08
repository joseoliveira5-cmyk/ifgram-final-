package br.edu.ifpb.ifgram.service;

import br.edu.ifpb.ifgram.DTO.UserRequest;
import br.edu.ifpb.ifgram.DTO.UserResponse;
import br.edu.ifpb.ifgram.model.User;
import br.edu.ifpb.ifgram.repositoy.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UserResponse criar (UserRequest request) throws EmailDuplicadoException {

        if (repository.existsByEmail(request.email())) {
            throw new EmailDuplicadoException(request.email());
        }
        User salvo = repository.save(new User(request.nome(), request.email()));
            return UserResponse.from (salvo);
    }
}