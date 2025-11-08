package com.br.agenda.controller;

import com.br.agenda.service.AgendamentoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final AgendamentoService agendamentoService;

    public HomeController(AgendamentoService agendamentoService){
        this.agendamentoService = agendamentoService;
    }

    @GetMapping
    public String home(){
        return "index";
    }
}
