package br.edu.ifpb.ifgram.service;

import jakarta.validation.constraints.Email;

public class EmailDuplicadoException extends Throwable {
    public EmailDuplicadoException(@Email @Email String email) {
    }
}
