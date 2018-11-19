package happyplant.config;

import happyplant.model.Plant;
import happyplant.model.Analysis;
import happyplant.model.Usr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import happyplant.repository.*;


@Component
public class Initializer {

    private PlantRepository plantRepository;
    private PlanRepository planRepository;
    private UserRepository userRepository;
    private AnalysisRepository analysisRepository;

    @Autowired
    public Initializer(PlantRepository plantRepository, PlanRepository planRepository, UserRepository userRepository, AnalysisRepository analysisRepository) {
        this.plantRepository = plantRepository;
        this.planRepository = planRepository;
        this.userRepository = userRepository;
        this.analysisRepository = analysisRepository;
    }

    @Bean
    public CommandLineRunner initialize() {
        return (String... args) -> {
            Usr KovacsJozsef = new Usr("József", "Kovács","KJ_63", "whatever@gmail.com", "kj_63_agro@gmail.com", "jozsika_63_KJ@gmail.com");
            Plant cucumber = new Plant("pickling cucumber", 5.5, 2.0, 180, 20, 180, 486.0, 252.0, 720.0, 252.0, 400.0);

            userRepository.save(KovacsJozsef);
            plantRepository.save(cucumber);
            analysisRepository.save(new Analysis(KovacsJozsef, 450.0, 600.0, 200.0,180.0, 350.0, 4.6, 6.3, 30, 140, cucumber));
        };

    }
}
