package br.edu.cesmac.moviesapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

import static javax.print.attribute.Size2DSyntax.MM;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovie;
    @NotEmpty(message = "Obrigatório informar o titulo do filme!")
    @Size(max = 200)
    private String title;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date releaseDate;
    @NotEmpty(message = "Obrigatório informar sinopse do filme!")
    private String synopsis;

    @ManyToOne
    private Genre  genre;
    @ManyToMany(mappedBy = "movies", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("movie")
    private List<Actor> actors;

    public Long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Long idMovie) {
        this.idMovie = idMovie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
