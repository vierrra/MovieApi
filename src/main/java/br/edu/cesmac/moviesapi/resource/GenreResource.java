package br.edu.cesmac.moviesapi.resource;

import br.edu.cesmac.moviesapi.domain.Genre;
import br.edu.cesmac.moviesapi.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genre")
public class GenreResource {
    @Autowired
    GenreRepository genreRepository;

    @PostMapping
    public ResponseEntity<Void> saveGenre(@RequestBody Genre genre){
        genreRepository.save(genre);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(genre.getIdGenre()).toUri();
        return ResponseEntity.created(uri).build();
    }
//    public Genre saveGenre(@RequestBody Genre genre) {
//       return genreRepository.save(genre);
//    }

    @GetMapping
    public List<Genre> listAll() {
        return genreRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Genre> searchById(@PathVariable("id") Long idGenre) {
        return genreRepository.findById(idGenre).map(genre -> ResponseEntity.ok(genre)).orElse(ResponseEntity.notFound().build());
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
