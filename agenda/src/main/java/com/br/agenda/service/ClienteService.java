package com.br.agenda.service;

import com.br.agenda.dto.CriarClienteRequest;
import com.br.agenda.dto.EditarClienteRequest;
import com.br.agenda.entity.Cliente;
import com.br.agenda.repository.ClienteRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente criar(CriarClienteRequest request){
        StringBuilder builder = new StringBuilder();
        if(Strings.isBlank(request.nome())){
            builder.append("Favor, informar o nome do cliente.").append("\n");
        }
        if(Strings.isBlank(request.telefone())){
            builder.append("Favor, informar o telefone do cliente.").append("\n");
        }
        var cliente = new Cliente();
        cliente.setNome(request.nome());
        cliente.setTelefone(request.telefone());
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> obterPeloId(Long id){
        return  clienteRepository.findById(id);
    }

    public Cliente editar(EditarClienteRequest request){
        StringBuilder builder = new StringBuilder();
        if(Strings.isBlank(request.nome())){
            builder.append("Favor, informar o nome do cliente.").append("\n");
        }
        if(Strings.isBlank(request.telefone())){
            builder.append("Favor, informar o telefone do cliente.").append("\n");
        }
        var old = clienteRepository.findById(request.id()).orElseThrow();
        old.setNome(request.nome());
        old.setTelefone(request.telefone());
        return clienteRepository.save(old);
    }

    public void deletarPeloId(Long id){
        clienteRepository.deleteById(id);
    }

}
