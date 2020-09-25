package br.edu.cesmac.moviesapi.repository;

import br.edu.cesmac.moviesapi.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
