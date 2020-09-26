package br.edu.cesmac.moviesapi.repository;

import br.edu.cesmac.moviesapi.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    List<Genre> findByName(String name);
}
