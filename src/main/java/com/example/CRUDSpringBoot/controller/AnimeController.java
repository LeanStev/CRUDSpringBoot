package com.example.CRUDSpringBoot.controller;

import com.example.CRUDSpringBoot.entidades.Anime;
import com.example.CRUDSpringBoot.repository.AnimeRepository;
import com.example.CRUDSpringBoot.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AnimeController {
//Se hace instancia de la "entidadServicio"
    @Autowired
    private AnimeService animeService;
    @Autowired
    private AnimeRepository animeRepository;


  /*  @RequestMapping("/")
    public String Login(Model modelo){
       return "login";

    }*/
    /*@RequestMapping("/Login")
    public String Login2(Model modelo){
        return "login";

    }*/
   /* @RequestMapping("/Register")
    public String Register(Model modelo){
        return "Register";

    }*/

    //Se hace un requestMapping para extraer todos los datos de la lista
    @RequestMapping("/index")
    public String Home(Model modelo){
        List<Anime> listaAnime = animeService.listAll();
        modelo.addAttribute("listaAnime",listaAnime);
        return "index";

    }

    @RequestMapping("/nuevoAnime")
    public String mostrarAnime(Model modelo){
        Anime anime = new Anime();
        modelo.addAttribute("anime", anime);
        return  "nuevo_anime";
    }
    @RequestMapping(value = "/guardar",method = RequestMethod.POST)
    public String guardarAnime(@ModelAttribute("anime") Anime anime){
        animeService.save(anime);
        return  "redirect:/index";

    }
    @RequestMapping("/editarAnime/{id}")
    public ModelAndView editarAnime(@PathVariable(name = "id")Long id) {
        ModelAndView modelo = new ModelAndView("editar_anime");
        Anime anime = animeService.get(id);
        modelo.addObject("anime", anime);

        return  modelo;
    }
    @RequestMapping("/eliminarAnime/{id}")
    public String eliminarAnime(@PathVariable(name = "id")Long id){
        animeService.delete(id);

        return "redirect:/index";
    }


}
