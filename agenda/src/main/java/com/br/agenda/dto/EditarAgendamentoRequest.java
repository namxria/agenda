package com.br.agenda.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record EditarAgendamentoRequest(String cliente, LocalDate data, LocalTime horario, String procedimento) {
}
