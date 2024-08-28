package com.java.agendador_tarefas.business.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.java.agendador_tarefas.infrastructure.enums.StatusNotificacao;

import lombok.*;

@Builder
public class TarefasDTO {

    private String id;
    private String nomeTarefa;
    private String descricao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataCriacao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataEvento;
    private String emailUsuario;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataAlteracao;
    private StatusNotificacao statusNotificacao;
    
    public TarefasDTO() {
    }

    public TarefasDTO(String id, String nomeTarefa, String descricao, LocalDateTime dataCriacao,
            LocalDateTime dataEvento, String emailUsuario, LocalDateTime dataAlteracao,
            StatusNotificacao statusNotificacao) {
        this.id = id;
        this.nomeTarefa = nomeTarefa;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataEvento = dataEvento;
        this.emailUsuario = emailUsuario;
        this.dataAlteracao = dataAlteracao;
        this.statusNotificacao = statusNotificacao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDateTime dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public StatusNotificacao getStatusNotificacao() {
        return statusNotificacao;
    }

    public void setStatusNotificacao(StatusNotificacao statusNotificacao) {
        this.statusNotificacao = statusNotificacao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nomeTarefa == null) ? 0 : nomeTarefa.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
        result = prime * result + ((dataEvento == null) ? 0 : dataEvento.hashCode());
        result = prime * result + ((emailUsuario == null) ? 0 : emailUsuario.hashCode());
        result = prime * result + ((dataAlteracao == null) ? 0 : dataAlteracao.hashCode());
        result = prime * result + ((statusNotificacao == null) ? 0 : statusNotificacao.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TarefasDTO other = (TarefasDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nomeTarefa == null) {
            if (other.nomeTarefa != null)
                return false;
        } else if (!nomeTarefa.equals(other.nomeTarefa))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (dataCriacao == null) {
            if (other.dataCriacao != null)
                return false;
        } else if (!dataCriacao.equals(other.dataCriacao))
            return false;
        if (dataEvento == null) {
            if (other.dataEvento != null)
                return false;
        } else if (!dataEvento.equals(other.dataEvento))
            return false;
        if (emailUsuario == null) {
            if (other.emailUsuario != null)
                return false;
        } else if (!emailUsuario.equals(other.emailUsuario))
            return false;
        if (dataAlteracao == null) {
            if (other.dataAlteracao != null)
                return false;
        } else if (!dataAlteracao.equals(other.dataAlteracao))
            return false;
        if (statusNotificacao != other.statusNotificacao)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TarefasDTO [id=" + id + ", nomeTarefa=" + nomeTarefa + ", descricao=" + descricao + ", dataCriacao="
                + dataCriacao + ", dataEvento=" + dataEvento + ", emailUsuario=" + emailUsuario + ", dataAlteracao="
                + dataAlteracao + ", statusNotificacao=" + statusNotificacao + "]";
    }
    
}
