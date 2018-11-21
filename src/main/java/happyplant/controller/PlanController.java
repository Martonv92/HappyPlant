package happyplant.controller;

import happyplant.model.AnalysisModel;
import happyplant.model.PlanModel;
import happyplant.model.UserModel;
import happyplant.repository.PlanRepository;

import happyplant.service.AnalysisService;
import happyplant.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PlanController {

    final HttpSession session;

    final AnalysisService analysisService;

    final PlanRepository planRepository;

    final PlanService planService;



    @Autowired
    public PlanController(HttpSession session, AnalysisService analysisService, PlanRepository planRepository, PlanService planService) {
        this.session = session;
        this.analysisService = analysisService;
        this.planService = planService;
        this.planRepository = planRepository;
    }


    @GetMapping("/plan")
    public String planGet() {

        if (session.getAttribute("user") == null) {
            return "redirect:/registration_login";
        }
        return "plan";
    }

    @GetMapping("/logoutFromPlan")
    public String logoutFromPlan() {
        session.invalidate();
        return "registration_login";
    }

    @GetMapping("/backToAnalysisFromPlan")
    public String backToAnalysisFromPlan(){
        session.setAttribute("viewMode", false);
        return "redirect:/analysis_form";
    }

    @GetMapping("/backToIndexFromPlan")
    public String backToIndexFromPlan() {
        session.removeAttribute("plant");
        session.setAttribute("viewMode", false);
        return "redirect:/index";
    }

    @GetMapping("/getFinishedPlansFromPlan")
    public String getFinishedPlansFromPlan(){
        session.getAttribute("plans");
        session.setAttribute("viewMode", false);
        return "finished_plans";
    }

    @PostMapping("/savePlan")
    public String savePlan(){
        analysisService.addNewAnalysis((AnalysisModel) session.getAttribute("newAnalysis"));
        PlanModel newPlan = (PlanModel) session.getAttribute("plan");
        planService.addNewPlan(newPlan);
        List<PlanModel> plans = planRepository.findAllByUser((UserModel)session.getAttribute("user"));
        session.setAttribute("plans", plans);
        session.removeAttribute("plan");
        return "plan";
    }
}
