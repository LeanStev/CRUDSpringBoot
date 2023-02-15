package com.example.CRUDSpringBoot.repository;

import com.example.CRUDSpringBoot.entidades.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {


}
