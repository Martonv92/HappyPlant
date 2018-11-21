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

    @Autowired
    HttpSession session;

    @Autowired
    AnalysisService analysisService;

    @Autowired
    PlanService planService;


    @GetMapping("/resultGet")
    public String resultGet() {

        if (session.getAttribute("user") == null) {
            return "redirect:/registrationlogin";
        }
        return "plan";
    }

    @GetMapping("/backToAnalysis")
    public String backToAnalysis(){
        return "redirect:/analysisform";
    }

    @GetMapping("/backToIndex")
    public String backToIndex(){
        return "redirect:/index";
    }

    @PostMapping("/savePlan")
    public String savePlan(){
        planService.addNewPlan((PlanModel) session.getAttribute("plan"));
        analysisService.addNewAnalysis((AnalysisModel) session.getAttribute("newAnalysis"));
        return "plan";
    }

}
