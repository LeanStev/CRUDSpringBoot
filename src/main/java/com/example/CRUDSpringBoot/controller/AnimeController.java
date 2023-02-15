package com.example.CRUDSpringBoot.controller;

import com.example.CRUDSpringBoot.entidades.Anime;
import com.example.CRUDSpringBoot.repository.AnimeRepository;
import com.example.CRUDSpringBoot.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AnimeController {
//Se hace instancia de la "entidadServicio"
    @Autowired
    private AnimeService animeService;
    @Autowired
    private AnimeRepository animeRepository;
//Se hace un requestMapping para extraer todos los datos de la lista
    @RequestMapping("/")
    public String Home(Model modelo){
        List<Anime> listaAnime = animeService.listAll();
        modelo.addAttribute("listaAnime",listaAnime);
        return "index";

    }

}
