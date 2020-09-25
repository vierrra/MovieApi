package br.edu.cesmac.moviesapi.resource;

import br.edu.cesmac.moviesapi.domain.Movie;
import br.edu.cesmac.moviesapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieResource {
    @Autowired
    MovieService movieService;

    @PostMapping
    public ResponseEntity<Void> saveMovie(@Validated @RequestBody Movie movie){
        Movie saveMovie = movieService.saveMovie(movie);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveMovie.getIdMovie()).toUri();
        return ResponseEntity.created(uri).build();
    }
//    public Movie saveGenre(@RequestBody Movie movie) {
//        return movieRepository.save(movie);
//    }

    @GetMapping
    public List<Movie> listAll() {
        return movieService.listAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> searchById(@PathVariable("id") Long idMovie) {
        return movieService.searchById(idMovie).map(movie -> ResponseEntity.ok(movie)).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public void updateMovie(@Validated @RequestBody Movie movie) {
        movieService.updateMovie(movie);
    }

    @DeleteMapping
    public void destroyMovie(@RequestBody Movie movie) {
        movieService.destroyMovie(movie);
    }

    @DeleteMapping(value = "/{id}")
    public void destroyById(@PathVariable("id") Long idMovie) {
        movieService.destroyById(idMovie);
    }
}
