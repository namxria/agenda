package com.br.agenda.dto;

import java.time.LocalDateTime;

public record EditarAgendamentoRequest (Long id, Long cliente, Long procedimento, LocalDateTime dataHora) {

}
