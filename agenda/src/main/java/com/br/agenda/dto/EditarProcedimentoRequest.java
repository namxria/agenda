package com.br.agenda.dto;

import java.math.BigDecimal;

public record EditarProcedimentoRequest (Long id, String nome, BigDecimal valor) {
}
