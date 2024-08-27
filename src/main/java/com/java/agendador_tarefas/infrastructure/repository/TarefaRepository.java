package com.java.agendador_tarefas.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.java.agendador_tarefas.infrastructure.entity.TarefaEntity;

@Repository
public interface TarefaRepository extends MongoRepository<TarefaEntity, String> {

}
