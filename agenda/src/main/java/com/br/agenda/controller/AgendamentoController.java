package com.br.agenda.controller;

import com.br.agenda.dto.CriarAgendamentoRequest;
import com.br.agenda.dto.EditarAgendamentoRequest;
import com.br.agenda.repository.AgendamentoRepository;
import com.br.agenda.service.AgendamentoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/agenda")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @GetMapping
    public ModelAndView index(){
        var mv = new ModelAndView("mostrar_todos");
        var lista = agendamentoService.findAll();
        mv.addAllObjects("agendamentos", lista);
        return mv;
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable("id") Long id) {
        agendamentoService.deletarPeloId(id);
        return "redirect:/agenda";
    }

    @GetMapping("/{id}")
    public ModelAndView vizualizar(@PathVariable("id") Long id) {
        var optional = agendamentoService.obterPeloId(id);
        if(optional.isEmpty()){
            return new ModelAndView("agenda/nao_ha_agendamentos");
        }
        var mv = new ModelAndView("agenda/visualizar_agendamento");
        mv.addObject("agenda", optional.get());
        return mv;
    }

    @GetMapping("/criar")
    public ModelAndView criar() {
        var mv = new ModelAndView("agenda/novo_agendamento");
        mv.addObject("criarAgendamentoRequest", new CriarAgendamentoRequest(null, null, null, null));
        return mv;
    }

    @PostMapping("/criar")
    public ModelAndView criar(@ModelAttribute  CriarAgendamentoRequest request) {
        ModelAndView mv;
        try {
            var pokemon = agendamentoService.criar(request);
            return new ModelAndView("redirect:/agenda/"+agendamento.getId());
        } catch (Exception e) {
            mv = new ModelAndView("agenda/novo_pokemon");
            mv.addObject("criarAgendamentoRequest", request);
            mv.addObject("erro", e.getMessage());
            return mv;
        }
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id) {
        var optional = agendamentoService.obterPeloId(id);
        if(optional.isEmpty()){
            return new ModelAndView("agenda/nao_ha_agendamento");
        }
        var mv = new ModelAndView("agenda/editar_agendamento");
        var pokemon = optional.get();
        var request = new EditarAgendamentoRequest(pokemon.getId(), pokemon.getNome(), pokemon.getTipo(), pokemon.getEstagio(), pokemon.getEstagio());
        mv.addObject("editarAgendamentoRequest", optional.get());
        return mv;
    }
    @PostMapping("/editar")
    public ModelAndView editar(@ModelAttribute EditarAgendamentoRequest request) {
        ModelAndView mv;
        try {
            var pokemon = agendamentoService.editar(request);
            return new ModelAndView("redirect:/agenda/"+pokemon.getId());
        } catch (Exception e) {
            mv = new ModelAndView("agenda/editar_pokemon");
            mv.addObject("editarAgendamentoRequest", request);
            mv.addObject("erro", e.getMessage());
            return mv;
        }
    }
}
