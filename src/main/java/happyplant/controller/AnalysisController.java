package happyplant.controller;

import happyplant.model.AnalysisModel;
import happyplant.model.PlanModel;
import happyplant.model.PlantModel;
import happyplant.model.UserModel;
import happyplant.repository.AnalysisRepository;
import happyplant.repository.PlanRepository;
import happyplant.service.AnalysisService;
import happyplant.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class AnalysisController {

    final HttpSession session;

    final AnalysisRepository analysisRepository;

    final PlanRepository planRepository;

    final AnalysisService analysisService;

    final PlanService planService;

    @Autowired
    public AnalysisController(HttpSession session, AnalysisRepository analysisRepository, PlanRepository planRepository, AnalysisService analysisService, PlanService planService) {
        this.session = session;
        this.analysisRepository = analysisRepository;
        this.planRepository = planRepository;
        this.analysisService = analysisService;
        this.planService = planService;
    }


    @GetMapping("/analysisform")
    public String analysisGet() {

        if (session.getAttribute("user") == null) {
            return "redirect:/registrationlogin";
        }
        return "analysisform";
    }

    @GetMapping("/backToIndexFromAnalysis")
    public String backToIndexFromAnalysis(){
        return "redirect:/index";
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam("user") UserModel user,
            @RequestParam("nitrogen") Double nitrogen,  @RequestParam("phosphorus") Double phosphorus, @RequestParam("kalium") Double kalium,
            @RequestParam("magnesium") Double magnesium, @RequestParam("calcium") Double calcium,
            @RequestParam("ph") Double ph, @RequestParam("ec") Double ec,
            @RequestParam("area_hectar") Integer area_hectar, @RequestParam("tonsPerHectar") Integer tonsPerHectar) {

        AnalysisModel newAnalysis = new AnalysisModel(user, nitrogen, phosphorus, kalium, magnesium, calcium, ph, ec, area_hectar, tonsPerHectar, (PlantModel) session.getAttribute("plant"));
        PlanModel plan = newAnalysis.calculate();
        planService.addNewPlan(plan);
        session.setAttribute("plan", plan);
        session.setAttribute("analysis", newAnalysis);
        return "redirect:/plan";
    }
}
