package br.edu.ifpb.ifgram.controller;

import br.edu.ifpb.ifgram.DTO.UserRequest;
import br.edu.ifpb.ifgram.DTO.UserResponse;
import br.edu.ifpb.ifgram.model.User;
import br.edu.ifpb.ifgram.repositoy.UserRepository;
import br.edu.ifpb.ifgram.service.EmailDuplicadoException;
import br.edu.ifpb.ifgram.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UserService service;

    public UsersController (UserService service){
        this.service = service;
    }

    @PostMapping
    public UserResponse criar(@Valid @RequestBody UserRequest request) throws EmailDuplicadoException {
        return service.criar(request);
    }

    @GetMapping
    public String getUser() {
        return "get user was called";
    }

    @GetMapping
    public List<UserResponse> getUsers(){
        List<UserResponse> listaUsuarios = service.buscarTodosUsuarios();
        return listaUsuarios;
    }

    @PutMapping
    public String putUser() {
        return "Chamei o endpoint como um put";
    }

    @PutMapping
    public UserResponse UpdateUser (UserRequest request){
        return service.atualizarUsuario(request);
    }

    @PatchMapping
    public String patchUser() {
        return "Chamei o endpoint como um patch";
    }

    @DeleteMapping
    public String deletar() {
        return null;
    }
}