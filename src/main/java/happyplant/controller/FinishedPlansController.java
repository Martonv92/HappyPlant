package happyplant.controller;

import happyplant.model.PlanModel;
import happyplant.model.UserModel;
import happyplant.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FinishedPlansController {

    private final PlanRepository planRepository;
    private final HttpSession session;

    @Autowired
    public FinishedPlansController(PlanRepository planRepository, HttpSession session) {
        this.planRepository = planRepository;
        this.session = session;
    }

    @GetMapping("/finishedPlans")
    public String finishedPlansGet() {

        if (session.getAttribute("user") == null){
            return "redirect:/registration";
        }
        List<PlanModel> plans = planRepository.findAllByUser((UserModel)session.getAttribute("user"));
        session.setAttribute("plans", plans);
        return "finished_plans";
    }

    @GetMapping("/logoutFromFinishedPlans")
    public String logoutFromFinishedPlans(){
        session.invalidate();
        return "registration_login";
    }

    @GetMapping("/backToIndexFromFinishedPlans")
    public String backToIndexFromFinishedPlans(){
        return "redirect:/index";
    }

    @PostMapping("/getSpecificPlan")
    public String getSpecificPlan( @RequestParam("id") Integer id) {
        PlanModel plan = planRepository.findPlanModelById(id);
        session.setAttribute("plan", plan);
        session.setAttribute("viewMode", true);
        return "redirect:/plan";
    }
}
