package com.br.agenda.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record CriarAgendamentoRequest(String cliente, LocalDate data, LocalTime horario, String procedimento) {
}
