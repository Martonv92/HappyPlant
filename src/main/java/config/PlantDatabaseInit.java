package config;

import model.plant.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import repository.PlantRepository;

@Component
public class PlantDatabaseInit {

    private PlantRepository plantRepository;

    @Autowired
    public PlantDatabaseInit(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @Bean
    public CommandLineRunner initialize() {
        return (String... args) -> {
            plantRepository.save(new Plant("pickling cucumber", 5.5, 2.0, 180, 20, 180, 486.0, 252.0, 720.0, 252.0, 400.0));
        };

    }
}
