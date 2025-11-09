package com.br.agenda.repository;

import com.br.agenda.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository <Agendamento, Long> {
    List<Agendamento> findAllByOrderByDataHoraAsc();
    List<Agendamento> findByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);

}
