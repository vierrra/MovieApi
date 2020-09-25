package br.edu.cesmac.moviesapi.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   idMovie;
    private String title;
    private Date   releaseDate;
    @ManyToOne
    private Genre  genre;
    @ManyToMany
    @JoinTable(name               = "movie_actor",
               joinColumns        = @JoinColumn(name = "idMovie"),
               inverseJoinColumns = @JoinColumn(name = "idActor"))
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
