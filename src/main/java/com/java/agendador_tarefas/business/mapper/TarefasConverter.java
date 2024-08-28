package com.java.agendador_tarefas.business.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.java.agendador_tarefas.business.dto.TarefasDTO;
import com.java.agendador_tarefas.infrastructure.entity.TarefasEntity;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefasEntity(TarefasDTO dto);

    TarefasDTO paraTarefasDTO(TarefasEntity entity);

    List<TarefasEntity> paraListTarefasEntity(List<TarefasDTO> dto);

    List<TarefasDTO> paraListTarefasDTO(List<TarefasEntity> entity);
}
