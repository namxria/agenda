package com.br.agenda.service;

import com.br.agenda.dto.CriarAgendamentoRequest;
import com.br.agenda.dto.EditarAgendamentoRequest;
import com.br.agenda.entity.Agendamento;
import com.br.agenda.repository.AgendamentoRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository){
        this.agendamentoRepository = agendamentoRepository;
    }

    public List<Agendamento> findAllByOrderByDataHoraAsc(){
        return agendamentoRepository.findAllByOrderByDataHoraAsc();
    }

    public Agendamento criar(CriarAgendamentoRequest request){
        StringBuilder builder = new StringBuilder();
        if(Strings.isBlank(request.cliente())){
            builder.append("Favor, informar o nome do cliente.").append("\n");
        }
        if(Strings.isBlank(String.valueOf(request.dataHora()))){
            builder.append("Favor, informar a data e o horário do agendamento.").append("\n");
        }
        if(Strings.isBlank(request.procedimento())){
            builder.append("Favor, informar o procedimento do agendamento.").append("\n");
        }
        if(Strings.isBlank(String.valueOf(request.valor()))){
            builder.append("Favor, informar o valor do procedimento.").append("\n");
        }
        var agendamento = new Agendamento();
        agendamento.setCliente(request.cliente());
        agendamento.setDataHora(request.dataHora());
        agendamento.setProcedimento(request.procedimento());
        agendamento.setValor(request.valor());
        return agendamentoRepository.save(agendamento);
    }

    public Optional<Agendamento> obterPeloId(Long id){
        return  agendamentoRepository.findById(id);
    }

    public Agendamento editar(EditarAgendamentoRequest request){
        StringBuilder builder = new StringBuilder();
        if(Strings.isBlank(request.cliente())){
            builder.append("Favor, informar o nome do cliente.").append("\n");
        }
        if(Strings.isBlank(String.valueOf(request.dataHora()))){
            builder.append("Favor, informar a data e o horário do agendamento.").append("\n");
        }
        if(Strings.isBlank(request.procedimento())){
            builder.append("Favor, informar o procedimento do agendamento.").append("\n");
        }
        if(Strings.isBlank(String.valueOf(request.valor()))){
            builder.append("Favor, informar o valor do procedimento.").append("\n");
        }
        var old = agendamentoRepository.findById(request.id()).orElseThrow();
        old.setCliente(request.cliente());
        old.setDataHora(request.dataHora());
        old.setProcedimento(request.procedimento());
        old.setValor(request.valor());
        return agendamentoRepository.save(old);
    }

    public void deletarPeloId(Long id){
        agendamentoRepository.deleteById(id);
    }

  }
