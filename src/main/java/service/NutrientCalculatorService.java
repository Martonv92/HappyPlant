package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AnalysisRepository;
import repository.PlanRepository;
import repository.PlantRepository;

@Service
public class NutrientCalculatorService {

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
