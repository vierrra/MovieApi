package br.edu.cesmac.moviesapi.service;

import br.edu.cesmac.moviesapi.domain.Genre;
import br.edu.cesmac.moviesapi.repository.GenreRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    private GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre saveGenre(Genre genre){
        return genreRepository.save(genre);
    }

    public List<Genre> listAll() {
        return genreRepository.findAll();
    }

    public Optional<Genre> searchById(Long idGenre) {
        return genreRepository.findById(idGenre);
    }

    public void updateGenre(Genre genre) {
        genreRepository.save(genre);
    }
    public void destroyGenre(Genre genre) {
        genreRepository.delete(genre);
    }

    public void destroyById(Long idGenre) {
        genreRepository.deleteById(idGenre);
    }
}
