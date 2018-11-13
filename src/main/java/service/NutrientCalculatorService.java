package service;

import model.userInputData.PlanModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PlantRepository;

@Service
public class NutrientCalculatorService {

    @Autowired
    PlantRepository plantRepository;


    public static PlanModel calculate(){

        return plan;
    }
}
