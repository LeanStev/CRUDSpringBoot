package com.example.CRUDSpringBoot.service;

import com.example.CRUDSpringBoot.entidades.Anime;
import com.example.CRUDSpringBoot.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {

    @Autowired

    private AnimeRepository animeRepository;

    public List<Anime> listAll(){
        return animeRepository.findAll();
    }
    public void save(Anime anime){
        animeRepository.save(anime);
    }
    public Anime get(Long id){
        return animeRepository.findById(id).get();
    }
    public void delete (Long id){
        animeRepository.deleteById(id);
    }
}
