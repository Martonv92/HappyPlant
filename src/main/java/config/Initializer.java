package config;

import model.plant.PlantModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import repository.*;

@Component
public class Initializer {

    private PlantRepository plantRepository;
    private PlanRepository planRepository;
    private UserRepository userRepository;
    private TargetRepository targetRepository;
    private AnalysisRepository analysisRepository;

    @Autowired
    public Initializer(PlantRepository plantRepository, PlanRepository planRepository, UserRepository userRepository, TargetRepository targetRepository, AnalysisRepository analysisRepository) {
        this.plantRepository = plantRepository;
        this.planRepository = planRepository;
        this.userRepository = userRepository;
        this.targetRepository = targetRepository;
        this.analysisRepository = analysisRepository;
    }

    @Bean
    public CommandLineRunner initialize() {
        return (String... args) -> {
            plantRepository.save(new PlantModel("pickling cucumber", 5.5, 2.0, 180, 20, 180, 486.0, 252.0, 720.0, 252.0, 400.0));
        };

    }
}
