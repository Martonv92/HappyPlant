package happyplant.config;

import happyplant.model.PlantModel;
import happyplant.model.AnalysisModel;
import happyplant.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import happyplant.repository.*;

import java.util.Date;

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
            plantRepository.save(new PlantModel("pickling cucumber", 5.5, 2.0, 180, 20, 180, 486.0, 252.0, 720.0, 252.0, 400.0));

            analysisRepository.save(new AnalysisModel(450.0, 600.0, 200.0,180.0, 350.0, 4.6, 6.3, 30, 140, plantRepository.findByPlantName("pickled cucumber")));
            userRepository.save(new UserModel("József", "Kovács","KJ_63", "asdasdas231312", "kj_63_agro@gmail.com", "jozsika_63_KJ@gmail.com", new Date(1963, 10, 11)));
        };

    }
}
