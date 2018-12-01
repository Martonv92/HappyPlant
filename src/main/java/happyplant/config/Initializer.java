package happyplant.config;

import happyplant.model.FertilizerModel;
import happyplant.model.FertilizerType;
import happyplant.model.PlantModel;
import happyplant.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import happyplant.repository.*;


@Component
public class Initializer {

    private final PlantRepository plantRepository;
    private final PlanRepository planRepository;
    private final UserRepository userRepository;
    private final AnalysisRepository analysisRepository;
    private final FertilizerRepository fertilizerRepository;

    @Autowired
    public Initializer(PlantRepository plantRepository, PlanRepository planRepository, UserRepository userRepository, AnalysisRepository analysisRepository, FertilizerRepository fertilizerRepository) {
        this.plantRepository = plantRepository;
        this.planRepository = planRepository;
        this.userRepository = userRepository;
        this.analysisRepository = analysisRepository;
        this.fertilizerRepository = fertilizerRepository;
    }

    @Bean
    public CommandLineRunner initialize() {
        return (String... args) -> {
            UserModel admin = new UserModel("Marci", "Varga", "admin", "martonv92@gmail.com", "ssajtocska@gmail.com", "marci");
            PlantModel cucumber = new PlantModel("pickling_cucumber", 5.5, 2.0, 180, 20, 180, 486.0, 252.0, 720.0, 252.0, 400.0, "https://parkseed.com/images/xxl/05510-pk-p1.jpg");
            FertilizerModel volldunger_granulatum = new FertilizerModel("Kwizda", "Volldünger Granulátum", FertilizerType.BASAL_COMPLEX_FERTILIZER, 6.0, 10.0, 21.0, 9.0, 2.0, 15);
            userRepository.save(admin);
            plantRepository.save(cucumber);
        };

    }
}
