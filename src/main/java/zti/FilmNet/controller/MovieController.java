package zti.FilmNet.controller;
import zti.FilmNet.exception.ResourceNotFoundException;
import zti.FilmNet.model.Movie;
import zti.FilmNet.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://ztifilmnet-frontend-production.up.railway.app")
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    // build create employee REST API
    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable  long id){
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not exist with id:" + id));
        return ResponseEntity.ok(movie);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable long id, @RequestBody Movie movieDetails) {
        Movie updateMovie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not exist with id: " + id));

        updateMovie.setTitle(movieDetails.getTitle());
        updateMovie.setYear(movieDetails.getYear());
        updateMovie.setRuntime(movieDetails.getRuntime());
        updateMovie.setGenre(movieDetails.getGenre());
        updateMovie.setPlot(movieDetails.getPlot());
        updateMovie.setPoster(movieDetails.getPoster());
        updateMovie.setMeanRating(movieDetails.getMeanRating());
        updateMovie.setStreamingPlatform(movieDetails.getStreamingPlatform());


        movieRepository.save(updateMovie);

        return ResponseEntity.ok(updateMovie);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteMovie(@PathVariable long id){

        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not exist with id: " + id));

        movieRepository.delete(movie);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}