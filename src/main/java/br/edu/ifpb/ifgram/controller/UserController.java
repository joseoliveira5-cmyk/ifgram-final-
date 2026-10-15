package br.edu.ifpb.ifgram.controller;

import br.edu.ifpb.ifgram.DTO.UserRequest;
import br.edu.ifpb.ifgram.DTO.UserResponse;
import br.edu.ifpb.ifgram.service.EmailDuplicadoException;
import br.edu.ifpb.ifgram.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service){
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
    public UserResponse UpdateUser (UserRequest request) throws Exception {
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