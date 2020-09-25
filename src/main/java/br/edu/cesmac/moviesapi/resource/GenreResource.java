package br.edu.cesmac.moviesapi.resource;

import br.edu.cesmac.moviesapi.domain.Genre;
import br.edu.cesmac.moviesapi.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genre")
public class GenreResource {
    @Autowired
    GenreRepository genreRepository;

    @PostMapping
    public Genre saveGenre(@RequestBody Genre genre) {
       return genreRepository.save(genre);
    }

    @GetMapping
    public List<Genre> listAll() {
        return genreRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Genre> searchById(@PathVariable("id") Long idGenre) {
        return genreRepository.findById(idGenre);
    }

    @PutMapping
    public void updateGenre(@RequestBody Genre genre) {
        genreRepository.save(genre);
    }

    @DeleteMapping
    public void destroyGenre(@RequestBody Genre genre) {
        genreRepository.delete(genre);
    }

    @DeleteMapping(value = "/{id}")
    public void destroyById(@PathVariable("id") Long idGenre) {
        genreRepository.deleteById(idGenre);
    }
}
