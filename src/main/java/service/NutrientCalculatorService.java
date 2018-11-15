package service;

import model.userInputData.PlanModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AnalysisRepository;
import repository.PlanRepository;
import repository.PlantRepository;
import repository.TargetRepository;

@Service
public class NutrientCalculatorService {

    @Autowired
    PlantRepository plantRepository;

    @Autowired
    PlanRepository planRepository;

    @Autowired
    TargetRepository targetRepository;

    @Autowired
    AnalysisRepository analysisRepository;


    /*public static PlanModel calculate(){

        return plan;
    }*/
}
