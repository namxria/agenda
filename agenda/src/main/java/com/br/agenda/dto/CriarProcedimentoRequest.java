package com.br.agenda.dto;

import java.math.BigDecimal;

public record CriarProcedimentoRequest (Long id, String nome, BigDecimal valor) {
}
