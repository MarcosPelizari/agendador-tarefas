package com.java.agendador_tarefas.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.agendador_tarefas.business.TarefasService;
import com.java.agendador_tarefas.business.dto.TarefasDTO;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefasController {

    private final TarefasService tarefaService;

    

    @PostMapping
    public ResponseEntity<TarefasDTO> gravarTarefa(@RequestBody TarefasDTO dto,
        @RequestHeader("Authorization") String token) {

            System.out.println("DTO log: " + dto);
        
        return ResponseEntity.ok(tarefaService.gravarTarefa(token, dto));
    }

    @GetMapping("/eventos")
    public ResponseEntity<List<TarefasDTO>>buscaListaTarefaPorPeriodo(
        @RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
        @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal) {

            return ResponseEntity.ok(tarefaService.buscaTarefaAgendadaPorPeriodo(dataInicial, dataFinal));
        }

    @GetMapping
    public ResponseEntity<List<TarefasDTO>> buscaTarefaPorEmail(@RequestHeader("Authorization")String token) {

        return ResponseEntity.ok(tarefaService.buscaTarefaPorEmail(token));
    }

}
