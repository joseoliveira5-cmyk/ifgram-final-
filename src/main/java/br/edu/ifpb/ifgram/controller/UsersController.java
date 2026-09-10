package br.edu.ifpb.ifgram.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Luiz")
public class UsersController {

    @GetMapping
    public String getUser() {
        return "get user was called";
    }

    @PostMapping
    public String postUser() {
        return "Chamei o endpoint como um post";
    }

    @PutMapping
    public String putUser() {
        return "Chamei o endpoint como um put";
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
