package service;

import model.userInputData.PlanModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PlanRepository;

@Service
public class PlanService {

    @Autowired
    PlanRepository planRepository;

    public void addNewPlan(PlanModel newPlan) { planRepository.save(newPlan);
    }
}
