package pl.akademiaspring.week8.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.akademiaspring.week8.models.Weather;
import pl.akademiaspring.week8.repositories.WeatherRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private WeatherRepository weatherRepository;

    @Autowired
    public WeatherController(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Weather>> getWeathers() {
        return Optional.of(weatherRepository.findAll())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }
}
