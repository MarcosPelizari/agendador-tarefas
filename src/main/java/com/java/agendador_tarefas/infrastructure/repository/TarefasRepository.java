package com.java.agendador_tarefas.infrastructure.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.java.agendador_tarefas.infrastructure.entity.TarefasEntity;
import com.java.agendador_tarefas.infrastructure.enums.StatusNotificacao;

@Repository
public interface TarefasRepository extends MongoRepository<TarefasEntity, String> {

    List<TarefasEntity> findByDataEventoBetweenAndStatusNotificacao(
            LocalDateTime dataInicial,
            LocalDateTime dataFinal,
            StatusNotificacao status);

    List<TarefasEntity> findByEmailUsuario(String email);

}
