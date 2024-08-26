package com.java.agendador_tarefas.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.agendador_tarefas.business.UsuarioDTO;

@FeignClient(name = "usuario", url= "${usuario.url}")
public interface UsuarioClient {
    
    @GetMapping
    UsuarioDTO buscaUsuarioPorEmail(@RequestParam("email") String email, @RequestParam("Authorization") String token);

}
