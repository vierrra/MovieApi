package br.edu.cesmac.moviesapi.resource;

import br.edu.cesmac.moviesapi.domain.Actor;
import br.edu.cesmac.moviesapi.domain.Genre;
import br.edu.cesmac.moviesapi.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actor")
public class ActorResource {
    @Autowired
    ActorRepository actorRepository;

    @PostMapping
    public Actor saveGenre(@RequestBody Actor actor) {
        return actorRepository.save(actor);
    }

    @GetMapping
    public List<Actor> listAll() {
        return actorRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Actor> searchById(@PathVariable("id") Long idActor) {
        return actorRepository.findById(idActor);
    }

    @PutMapping
    public void updateActor(@RequestBody Actor actor) {
        actorRepository.save(actor);
    }

    @DeleteMapping
    public void destroyActor(@RequestBody Actor actor) {
        actorRepository.delete(actor);
    }

    @DeleteMapping(value = "/{id}")
    public void destoyById(@PathVariable("id") Long idActor) {
        actorRepository.deleteById(idActor);
    }
}
