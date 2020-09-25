package br.edu.cesmac.moviesapi.service;

import br.edu.cesmac.moviesapi.domain.Actor;
import br.edu.cesmac.moviesapi.domain.Genre;
import br.edu.cesmac.moviesapi.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {
    private ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Actor saveActor(Actor actor){
        return actorRepository.save(actor);
    }

    public List<Actor> listAll() {
        return actorRepository.findAll();
    }

    public Optional<Actor> searchById(Long idActor) {
        return actorRepository.findById(idActor);
    }

    public void updateActor(Actor actor) {
        actorRepository.save(actor);
    }
    public void destroyActor(Actor actor) {
        actorRepository.delete(actor);
    }

    public void destroyById(Long idActor) {
        actorRepository.deleteById(idActor);
    }
}
