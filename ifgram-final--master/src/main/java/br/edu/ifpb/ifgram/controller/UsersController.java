package br.edu.ifpb.ifgram.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Luiz")
public class UsersController {

    @GetMapping
    public String getUsersController() {
        return "get users was called";
    }

    @PostMapping
    public String postUsers() {
        return "chamei o ednpoint como post";
    }

    @PatchMapping
    public String pathUsers() {
        return "atualizei o usuario com path";
    }

    @DeleteMapping
    public String delUsers() {
        return null;
    }
}