package com.example.CRUDSpringBoot.service;

import com.example.CRUDSpringBoot.entidades.Anime;
import com.example.CRUDSpringBoot.entidades.Usuario;
import com.example.CRUDSpringBoot.repository.AnimeRepository;
import com.example.CRUDSpringBoot.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listAll(){

        return usuarioRepository.findAll();
    }
    public void save(Usuario usuario){

        usuarioRepository.save(usuario);
    }
    public Usuario get(Integer id){

        return (Usuario) usuarioRepository.findById(id).get();
    }
    public void delete (Integer id){
        usuarioRepository.deleteById(id);
    }
}
