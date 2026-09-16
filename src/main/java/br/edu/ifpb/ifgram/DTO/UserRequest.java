package br.edu.ifpb.ifgram.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequest(

    @Email
    String email,

    @Size(min=3)
    @NotNull
    String nome,

    @Size(min=4)
    @NotNull
    String senha

) { }

//public record UserResponse(String email, String nome, String senha){
//
//    public static UserResponse from(User user){
//        return new UserResponse(user.getEmail(), user.getNome(), user.getSenha());
//    }
//}