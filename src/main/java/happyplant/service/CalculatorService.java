package happyplant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import happyplant.repository.AnalysisRepository;
import happyplant.repository.PlanRepository;
import happyplant.repository.PlantRepository;

@Service
public class CalculatorService {

    @Autowired
    PlantRepository plantRepository;

    @Autowired
    PlanRepository planRepository;

    @Autowired
    AnalysisRepository analysisRepository;


    /*public static PlanModel calculate(){

        return plan;
    }*/
}
