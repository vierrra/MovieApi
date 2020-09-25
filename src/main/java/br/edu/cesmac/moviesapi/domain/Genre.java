package br.edu.cesmac.moviesapi.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   idGenre;
    @NotEmpty(message = "Obrigatório informar o gênero!")
    @Size(max = 150)
    private String name;
    @NotEmpty(message = "Obrigatório informar descrição!")
    private String description;
//    @OneToMany
//    @JoinColumn(name = "idGenre")
//    private List<Movie> movies;

    public Long getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Long idGenre) {
        this.idGenre = idGenre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<Movie> getMovies() {
//        return movies;
//    }
//
//    public void setMovies(List<Movie> movies) {
//        this.movies = movies;
//    }
}
