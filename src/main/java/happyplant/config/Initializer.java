package happyplant.config;

import happyplant.model.AccessLevel;
import happyplant.model.PlantModel;
import happyplant.model.AnalysisModel;
import happyplant.model.UserModel;
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
            UserModel admin = new UserModel("Marci", "Varga", "admin", "martonv92@gmail.com", "ssajtocska@gmail.com", "marci", AccessLevel.ADMIN);
            UserModel KovacsJozsef = new UserModel("József", "Kovács","KJ_63", "whatever@gmail.com", "kj_63_agro@gmail.com", "jozsika_63_KJ@gmail.com", AccessLevel.USER);
            PlantModel cucumber = new PlantModel("pickling cucumber", 5.5, 2.0, 180, 20, 180, 486.0, 252.0, 720.0, 252.0, 400.0);

            userRepository.save(KovacsJozsef);
            plantRepository.save(cucumber);
            analysisRepository.save(new AnalysisModel(KovacsJozsef, 450.0, 600.0, 200.0,180.0, 350.0, 4.6, 6.3, 30, 140, cucumber));
        };

    }
}
