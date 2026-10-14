package br.edu.ifpb.ifgram.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.GetMapping;

public record UserRequest(

    @Email
    String email,

    @Size(min=3)
    @NotNull
    String nome,

    @Size(min=4)
    @NotNull
    String senha

) {

}