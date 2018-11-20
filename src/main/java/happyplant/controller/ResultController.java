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
public class ResultController {

    @Autowired
    AnalysisService analysisService;

    @Autowired
    PlanService planService;

    @Autowired
    HttpSession session;

    @GetMapping("/resultGet")
    public String resultGet() {

        if (session.getAttribute("user") == null) {
            return "registrationlogin";
        }
        return "result";
    }

    @GetMapping("/backToAnalysis")
    public String backToAnalysis(){
        return "analysisform";
    }

    @PostMapping("/savePlan")
    public String savePlan(){
        planService.addNewPlan((PlanModel) session.getAttribute("plan"));
        analysisService.addNewAnalysis((AnalysisModel) session.getAttribute("newAnalysis"));
        return "result";
    }

}
