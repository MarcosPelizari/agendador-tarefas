package com.java.agendador_tarefas.business;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.java.agendador_tarefas.business.dto.TarefaDTO;
import com.java.agendador_tarefas.business.mapper.TarefaConverter;
import com.java.agendador_tarefas.infrastructure.entity.TarefaEntity;
import com.java.agendador_tarefas.infrastructure.enums.StatusNotificacao;
import com.java.agendador_tarefas.infrastructure.repository.TarefaRepository;
import com.java.agendador_tarefas.infrastructure.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final TarefaConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefaDTO gravarTarefa(String token, TarefaDTO dto) {
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacao(StatusNotificacao.PENDENTE);
        dto.setEmailUsuario(email);
        TarefaEntity entity = tarefaConverter.paraTarefaEntity(dto);

        return tarefaConverter.paraTarefaDTO(tarefaRepository.save(entity));
    }

}
