package pl.akademiaspring.week8.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "weathers")
public class Weather {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String main;
    private String description;
    private double temp;
    @Column(name = "wind_speed")
    private double windSpeed;
    private LocalDate currentData;

    public Weather() {
    }

    public LocalDate getCurrentData() {
        return currentData;
    }

    public void setCurrentData(LocalDate currentData) {
        this.currentData = currentData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
}
