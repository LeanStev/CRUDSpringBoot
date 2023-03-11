package com.example.CRUDSpringBoot.controller;

import com.example.CRUDSpringBoot.entidades.Anime;
import com.example.CRUDSpringBoot.repository.AnimeRepository;
import com.example.CRUDSpringBoot.repository.UsuarioRepository;
import com.example.CRUDSpringBoot.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.CRUDSpringBoot.entidades.Usuario;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioRepository usuarioRepository;


    @RequestMapping("/Register")
    public String mostrarUsuario(Model modelo){
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return  "Register";
    }

        @RequestMapping(value = "/guardarUsuario",method = RequestMethod.POST)
        public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario){
            usuarioService.save(usuario);
            return  "redirect:/";


    }
}
