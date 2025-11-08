package com.br.agenda.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record EditarAgendamentoRequest(Long id, String cliente, LocalDateTime dataHora, String procedimento, BigDecimal valor) {

}
