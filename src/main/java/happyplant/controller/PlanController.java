package happyplant.controller;

import happyplant.model.AnalysisModel;
import happyplant.model.PlanModel;
import happyplant.service.AnalysisService;
import happyplant.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;

@Controller
public class PlanController {

    final HttpSession session;

    final AnalysisService analysisService;

    final PlanService planService;

    @Autowired
    public PlanController(HttpSession session, AnalysisService analysisService, PlanService planService) {
        this.session = session;
        this.analysisService = analysisService;
        this.planService = planService;
    }


    @GetMapping("/planGet")
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

    @GetMapping("/backToAnalysis")
    public String backToAnalysis(){
        return "redirect:/analysis_form";
    }

    @GetMapping("/backToIndexFromPlan")
    public String backToIndexFromPlan(){
        session.removeAttribute("plant");
        return "redirect:/index";
    }

    @PostMapping("/savePlan")
    public String savePlan(){
        planService.addNewPlan((PlanModel) session.getAttribute("plan"));
        analysisService.addNewAnalysis((AnalysisModel) session.getAttribute("newAnalysis"));
        return "plan";
    }
}
