package com.java.agendador_tarefas.business;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.agendador_tarefas.business.dto.TarefasDTO;
import com.java.agendador_tarefas.business.mapper.TarefaUpdateConverter;
import com.java.agendador_tarefas.business.mapper.TarefasConverter;
import com.java.agendador_tarefas.infrastructure.entity.TarefasEntity;
import com.java.agendador_tarefas.infrastructure.enums.StatusNotificacao;
import com.java.agendador_tarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.java.agendador_tarefas.infrastructure.repository.TarefasRepository;
import com.java.agendador_tarefas.infrastructure.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefaRepository;
    private final TarefasConverter tarefaConverter;
    private final JwtUtil jwtUtil;
    private final TarefaUpdateConverter tarefaUpdateConverter;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto) {
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacao(StatusNotificacao.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefaConverter.paraTarefasEntity(dto);

        return tarefaConverter.paraTarefasDTO(
                tarefaRepository.save(entity));
    }

    public List<TarefasDTO> buscaTarefaAgendadaPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal) {
        return tarefaConverter.paraListTarefasDTO(
                tarefaRepository.findByDataEventoBetweenAndStatusNotificacao(dataInicial, dataFinal,
                        StatusNotificacao.PENDENTE));
    }

    public List<TarefasDTO> buscaTarefaPorEmail(String token) {
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        List<TarefasEntity> listaTarefas = tarefaRepository.findByEmailUsuario(email);

        return tarefaConverter.paraListTarefasDTO(listaTarefas);
    }

    public void deletarPorId(String id) {
        try {
            tarefaRepository.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Erro ao deletar tarefa, id inexistente " + id,
                    e.getCause());
        }
    }

    public TarefasDTO alteraStatus(StatusNotificacao status, String id) {
        try {
            TarefasEntity entity = tarefaRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada " + id));
            entity.setStatusNotificacao(status);

            return tarefaConverter.paraTarefasDTO(tarefaRepository.save(entity));
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Erro ao alterar o status da tarefa." + e.getCause());
        }
    }

    public TarefasDTO updateTarefas(TarefasDTO dto, String id) {
        try {
            TarefasEntity entity = tarefaRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada " + id));
            tarefaUpdateConverter.updateTArefas(dto, entity);

            return tarefaConverter.paraTarefasDTO(tarefaRepository.save(entity));

        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Erro ao alterar o status da tarefa." + e.getCause());
        }
    }

}
