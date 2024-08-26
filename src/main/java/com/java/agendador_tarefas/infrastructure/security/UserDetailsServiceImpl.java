package com.java.agendador_tarefas.infrastructure.security;


import com.java.agendador_tarefas.business.UsuarioDTO;
import com.java.agendador_tarefas.infrastructure.client.UsuarioClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {

    @Autowired
    private UsuarioClient client;

    public UserDetails carregaDadosDeUsuario(String email, String token) {

        UsuarioDTO usuarioDTO = client.buscaUsuarioPorEmail(email, token);

        return User
        .withUsername(usuarioDTO.getEmail()) // Define o nome de usuário como o e-mail
        .password(usuarioDTO.getSenha()) // Define a senha do usuário
        .build();
    }
}
