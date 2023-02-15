package com.example.CRUDSpringBoot.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "anime")
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    private String nombre;
    @Column(nullable = false,length = 100)
    private String autor;
    @Column(nullable = false)
    private int capitulos;
    @Column(nullable = false)
    private int finalizado;

    public Anime() {}

    public Anime(Long id, String nombre, String autor, int capitulos, int finalizado) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.capitulos = capitulos;
        this.finalizado = finalizado;
    }

    public Anime(String nombre, String autor, int capitulos, int finalizado) {
        this.nombre = nombre;
        this.autor = autor;
        this.capitulos = capitulos;
        this.finalizado = finalizado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(int capitulos) {
        this.capitulos = capitulos;
    }

    public int getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(int finalizado) {
        this.finalizado = finalizado;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", capitulos=" + capitulos +
                ", finalizado=" + finalizado +
                '}';
    }
}
