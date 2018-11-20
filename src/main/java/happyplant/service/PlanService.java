package happyplant.service;

import happyplant.model.PlanModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import happyplant.repository.PlanRepository;

@Service
public class PlanService {

    @Autowired
    PlanRepository planRepository;

    public void addNewPlan(PlanModel newPlanModel) { planRepository.save(newPlanModel); }
}
