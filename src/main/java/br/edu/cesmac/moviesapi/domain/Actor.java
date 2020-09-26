package br.edu.cesmac.moviesapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   idActor;
    @NotEmpty(message = "Obrigatório informar o nome do ator!")
    @Size(max = 100)
    private String name;
    private Date birthDate;
    @NotEmpty(message = "Obrigatório informar o sexo!")
    @Size(max = 1)
    private String sex;
    @NotEmpty(message = "Obrigatório informar biografia do autor!")
    private String biography;
    @ManyToMany
    @JsonIgnoreProperties("actor")
    @JoinTable(name               = "movie_actor",
               joinColumns        = @JoinColumn(name = "idActor"),
               inverseJoinColumns = @JoinColumn(name = "idMovie"))
    private List<Movie> movies;

    public Long getIdActor() {
        return idActor;
    }

    public void setIdActor(Long idActor) {
        this.idActor = idActor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
