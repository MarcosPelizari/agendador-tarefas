package com.java.agendador_tarefas.business.mapper;

import org.mapstruct.Mapper;

import com.java.agendador_tarefas.business.dto.TarefaDTO;
import com.java.agendador_tarefas.infrastructure.entity.TarefaEntity;

@Mapper(componentModel = "spring")
public interface TarefaConverter {
    

    TarefaEntity paraTarefaEntity(TarefaDTO dto);

    TarefaDTO paraTarefaDTO(TarefaEntity entity);
}
