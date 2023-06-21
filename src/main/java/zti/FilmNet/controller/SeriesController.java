package zti.FilmNet.controller;
import zti.FilmNet.exception.ResourceNotFoundException;
import zti.FilmNet.model.Series;
import zti.FilmNet.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://ztifilmnet-frontend-production.up.railway.app")
@RestController
@RequestMapping("/api/v1/series")
public class SeriesController {

    @Autowired
    private SeriesRepository seriesRepository;

    @GetMapping
    public List<Series> getAllSeries(){
        return seriesRepository.findAll();
    }

    // build create employee REST API
    @PostMapping
    public Series createSeries(@RequestBody Series series) {
        return seriesRepository.save(series);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Series> getSeriesById(@PathVariable  long id){
        Series series = seriesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Series not exist with id:" + id));
        return ResponseEntity.ok(series);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Series> updateSeries(@PathVariable long id, @RequestBody Series seriesDetails) {
        Series updateSeries = seriesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Series not exist with id: " + id));

        updateSeries.setTitle(seriesDetails.getTitle());
        updateSeries.setYear(seriesDetails.getYear());
        updateSeries.setTotalSeasons(seriesDetails.getTotalSeasons());
        updateSeries.setGenre(seriesDetails.getGenre());
        updateSeries.setPlot(seriesDetails.getPlot());
        updateSeries.setPoster(seriesDetails.getPoster());
        updateSeries.setMeanRating(seriesDetails.getMeanRating());
        updateSeries.setStreamingPlatform(seriesDetails.getStreamingPlatform());


        seriesRepository.save(updateSeries);

        return ResponseEntity.ok(updateSeries);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteSeries(@PathVariable long id){

        Series series = seriesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Series not exist with id: " + id));

        seriesRepository.delete(series);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}