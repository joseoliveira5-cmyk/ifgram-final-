package br.edu.ifpb.ifgram.service;

import br.edu.ifpb.ifgram.DTO.UserRequest;
import br.edu.ifpb.ifgram.DTO.UserResponse;
import br.edu.ifpb.ifgram.model.User;
import br.edu.ifpb.ifgram.repository.UserRepository;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<UserResponse> buscarTodosUsuarios() {
        List<User> listaUsuarios = repository.findAll();
        List<UserResponse> listaUsuariosResponse = new ArrayList<>();
        for(User user : listaUsuarios) {
            UserResponse userReponse = new UserResponse(
                    user.getId(),
                    user.getNome(),
                    user.getEmail()
            );
            listaUsuariosResponse.add(userReponse);
        }
        return listaUsuariosResponse;
    }

    public UserResponse atualizarUsuario(UserRequest userRequest) throws Exception{
        Optional<User> usuario = repository.findByEmail(userRequest.email());
        if (usuario.isEmpty()){
            throw new Exception( "Usuario não existe na base de dados" );
        }
        User usuario_salvo = usuario.get();
        usuario.setNome(userRequest.nome());
        repository.save(usuario_salvo);

        return UserResponse.from(usuario_salvo);
    }
}