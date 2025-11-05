package com.br.agenda.service;

import com.br.agenda.dto.CriarAgendamentoRequest;
import com.br.agenda.entity.Agendamento;
import com.br.agenda.repository.AgendamentoRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository){
        this.agendamentoRepository = agendamentoRepository;
    }

    public List<Agendamento> findAll(){
        return agendamentoRepository.findAll();
    }

    public Agendamento criar(CriarAgendamentoRequest request){
        StringBuilder builder = new StringBuilder();
        if(Strings.isBlank(request.cliente())){
            builder.append("Favor, informar o nome do cliente.").append("\n");
        }
        if(Strings.isBlank(String.valueOf(request.data()))){
            builder.append("Favor, informar a data do agendamento.").append("\n");
        }
        if(Strings.isBlank(String.valueOf(request.horario()))){
            builder.append("Favor, informar o horário do agendamento.").append("\n");
        }
        if(Strings.isBlank(request.procedimento())){
            builder.append("Favor, informar o procedimento do agendamento.").append("\n");
        }
        var agendamento = new Agendamento();
        agendamento.setCliente(request.cliente());
        agendamento.setData(request.data());
        agendamento.setHorario(request.horario());
        agendamento.setProcedimento(request.procedimento());
        return agendamentoRepository.save(agendamento);
    }

    public void deletarPeloId(Long id){
        agendamentoRepository.deleteById(id);
    }
}
