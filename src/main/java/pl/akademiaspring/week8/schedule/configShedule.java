package pl.akademiaspring.week8.schedule;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import pl.akademiaspring.week8.models.Weather;
import pl.akademiaspring.week8.repositories.WeatherRepository;

import java.time.LocalDate;

@Configuration
@EnableScheduling
public class configShedule {

    @Value("${weather.url}")
    private String weatherUrl;

    private WeatherRepository weatherRepository;

    @Autowired
    public configShedule(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Scheduled(fixedDelay = 360000)
    public void saveCurrentWeather() {
        RestTemplate restTemplate = new RestTemplate();
        JsonNode jsonNode = restTemplate.getForObject(weatherUrl, JsonNode.class);
        Weather weather = new Weather();
        assert jsonNode != null;
        weather.setMain(jsonNode.get("weather").get(0).get("main").toString());
        weather.setDescription(jsonNode.get("weather").get(0).get("description").toString());
        weather.setTemp(Double.parseDouble(jsonNode.get("main").get("temp").toString()));
        weather.setWindSpeed(Double.parseDouble(jsonNode.get("wind").get("speed").toString()));
        weather.setCurrentData(LocalDate.now());
        weatherRepository.save(weather);
    }
}
