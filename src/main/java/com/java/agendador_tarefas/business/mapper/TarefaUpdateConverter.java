package com.java.agendador_tarefas.business.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.java.agendador_tarefas.business.dto.TarefasDTO;
import com.java.agendador_tarefas.infrastructure.entity.TarefasEntity;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaUpdateConverter {

    void updateTArefas(TarefasDTO dto, @MappingTarget TarefasEntity entity);
}
