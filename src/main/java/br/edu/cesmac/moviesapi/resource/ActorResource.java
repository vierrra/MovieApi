package br.edu.cesmac.moviesapi.resource;

import br.edu.cesmac.moviesapi.domain.Actor;
import br.edu.cesmac.moviesapi.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actor")
public class ActorResource {
    @Autowired
    ActorRepository actorRepository;

    @PostMapping
    public ResponseEntity<Void> saveActor(@RequestBody Actor actor){
        actorRepository.save(actor);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(actor.getIdActor()).toUri();
        return ResponseEntity.created(uri).build();
    }
//    public Actor saveGenre(@RequestBody Actor actor) {
//        return actorRepository.save(actor);
//    }

    @GetMapping
    public List<Actor> listAll() {
        return actorRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Actor> searchById(@PathVariable("id") Long idActor) {
        return actorRepository.findById(idActor).map(actor -> ResponseEntity.ok(actor)).orElse(ResponseEntity.notFound().build());
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
