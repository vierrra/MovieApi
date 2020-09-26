package br.edu.cesmac.moviesapi.resource;

import br.edu.cesmac.moviesapi.domain.Genre;
import br.edu.cesmac.moviesapi.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreResource {
    @Autowired
    GenreService genreService;

    @PostMapping
    public ResponseEntity<Void> saveGenre(@Validated @RequestBody Genre genre){
        Genre saveGenre = genreService.saveGenre(genre);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveGenre.getIdGenre()).toUri();
        return ResponseEntity.created(uri).build();
    }
//    public Genre saveGenre(@RequestBody Genre genre) {
//       return genreRepository.save(genre);
//    }

    @GetMapping
    public List<Genre> listAll() {
        return genreService.listAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Genre> searchById(@PathVariable("id") Long idGenre) {
        return genreService.searchById(idGenre).map(genre -> ResponseEntity.ok(genre)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(params = "name")
    public List<Genre> searchByName(@RequestParam String name) {
        return genreService.searchByName(name);
    }

    @PutMapping
    public void updateGenre(@Validated @RequestBody Genre genre) {
        genreService.updateGenre(genre);
    }

    @DeleteMapping
    public void destroyGenre(@RequestBody Genre genre) {
        genreService.destroyGenre(genre);
    }

    @DeleteMapping(value = "/{id}")
    public void destroyById(@PathVariable("id") Long idGenre) {
        genreService.destroyById(idGenre);
    }

}
