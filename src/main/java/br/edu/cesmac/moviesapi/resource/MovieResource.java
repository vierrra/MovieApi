package br.edu.cesmac.moviesapi.resource;

import br.edu.cesmac.moviesapi.domain.Actor;
import br.edu.cesmac.moviesapi.domain.Genre;
import br.edu.cesmac.moviesapi.domain.Movie;
import br.edu.cesmac.moviesapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieResource {
    @Autowired
    MovieRepository movieRepository;

    @PostMapping
    public Movie saveGenre(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @GetMapping
    public List<Movie> listAll() {
        return movieRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Movie> searchById(@PathVariable("id") Long idMovie) {
        return movieRepository.findById(idMovie);
    }

    @PutMapping
    public void updateMovie(@RequestBody Movie movie) {
        movieRepository.save(movie);
    }

    @DeleteMapping
    public void destroyMovie(@RequestBody Movie movie) {
        movieRepository.delete(movie);
    }

    @DeleteMapping(value = "/{id}")
    public void destoyById(@PathVariable("id") Long idMovie) {
        movieRepository.deleteById(idMovie);
    }
}
