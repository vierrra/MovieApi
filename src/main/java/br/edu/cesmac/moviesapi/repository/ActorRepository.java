package br.edu.cesmac.moviesapi.repository;

import br.edu.cesmac.moviesapi.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    List<Actor> findByName(String name);
}
