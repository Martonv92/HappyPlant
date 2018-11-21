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

    @Autowired
    HttpSession session;

    @Autowired
    AnalysisRepository analysisRepository;

    @Autowired
    PlanRepository planRepository;

    @Autowired
    AnalysisService analysisService;

    @Autowired
    PlanService planService;


    @GetMapping("/analysisGet")
    public String analysisGet() {

        if (session.getAttribute("user") == null) {
            return "redirect:/registrationlogin";
        }
        return "analysisform";
    }

    @GetMapping("/backToIndex")
    public String backToIndex(){
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
