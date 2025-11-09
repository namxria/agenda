package com.br.agenda.repository;

import com.br.agenda.entity.Procedimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedimentoRepository extends JpaRepository <Procedimento, Long> {
}
