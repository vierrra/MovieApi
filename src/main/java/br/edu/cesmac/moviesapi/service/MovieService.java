package br.edu.cesmac.moviesapi.service;

import br.edu.cesmac.moviesapi.domain.Actor;
import br.edu.cesmac.moviesapi.domain.Movie;
import br.edu.cesmac.moviesapi.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public List<Movie> listAll() {
        return movieRepository.findAll();
    }

    public Optional<Movie> searchById(Long idMovie) {
        return movieRepository.findById(idMovie);
    }

    public void updateMovie(Movie movie) {
        movieRepository.save(movie);
    }
    public void destroyMovie(Movie movie) {
        movieRepository.delete(movie);
    }

    public void destroyById(Long idMovie) {
        movieRepository.deleteById(idMovie);
    }

    public List<Movie> searchByTitle(String title) {
        return movieRepository.findByTitle(title);
    }
}
