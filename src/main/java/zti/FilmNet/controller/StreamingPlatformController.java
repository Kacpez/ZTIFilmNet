package zti.FilmNet.controller;
import zti.FilmNet.exception.ResourceNotFoundException;
import zti.FilmNet.model.StreamingPlatform;
import zti.FilmNet.repository.StreamingPlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/streaming_platforms")
public class StreamingPlatformController {
    @Autowired
    private StreamingPlatformRepository streamingPlatformRepository;

    @GetMapping
    public List<StreamingPlatform> getAllMovies(){
        return streamingPlatformRepository.findAll();
    }
}
