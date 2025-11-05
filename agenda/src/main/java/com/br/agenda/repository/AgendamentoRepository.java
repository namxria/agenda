package com.br.agenda.repository;

import com.br.agenda.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository <Agendamento, Long> {
}
