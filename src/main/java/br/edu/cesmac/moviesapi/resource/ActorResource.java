package br.edu.cesmac.moviesapi.resource;

import br.edu.cesmac.moviesapi.domain.Actor;
import br.edu.cesmac.moviesapi.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorResource {
    @Autowired
    ActorService actorService;

    @PostMapping
    public ResponseEntity<Void> saveActor(@RequestBody Actor actor){
        Actor saveActor = actorService.saveActor(actor);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveActor.getIdActor()).toUri();
        return ResponseEntity.created(uri).build();
    }
//    public Actor saveGenre(@RequestBody Actor actor) {
//        return actorRepository.save(actor);
//    }

    @GetMapping
    public List<Actor> listAll() {
        return actorService.listAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Actor> searchById(@PathVariable("id") Long idActor) {
        return actorService.searchById(idActor).map(actor -> ResponseEntity.ok(actor)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(params = "name")
    public List<Actor> searchByName(String name) {
        return actorService.searchByName(name);
    }

    @PutMapping
    public void updateActor(@RequestBody Actor actor) {
        actorService.updateActor(actor);
    }

    @DeleteMapping
    public void destroyActor(@RequestBody Actor actor) {
        actorService.destroyActor(actor);
    }

    @DeleteMapping(value = "/{id}")
    public void destroyById(@PathVariable("id") Long idActor) {
        actorService.destroyById(idActor);
    }
}
