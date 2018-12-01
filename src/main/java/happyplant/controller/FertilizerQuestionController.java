package happyplant.controller;

import happyplant.model.AnalysisModel;
import happyplant.model.FertilizerModel;
import happyplant.model.FertilizerType;
import happyplant.model.PlanModel;
import happyplant.repository.AnalysisRepository;
import happyplant.repository.PlanRepository;
import happyplant.service.AnalysisService;
import happyplant.service.FertilizerService;
import happyplant.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FertilizerQuestionController {

    private final HttpSession session;
    private final FertilizerService fertilizerService;

    @Autowired
    public FertilizerQuestionController(HttpSession session, FertilizerService fertilizerService) {
        this.session = session;
        this.fertilizerService = fertilizerService;
    }

    @GetMapping("/fertilizer_questions")
    public String fertilizerQuestionsGet() {

        if (session.getAttribute("user") == null) {
            return "redirect:/registration_login";
        }
        return "fertilizer_questions";
    }

    @GetMapping("/logoutFromFertilizerQuestions")
    public String logoutFromFertilizerQuestions() {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/backToIndexFromFertilizerQuestions")
    public String backToIndexFromFertilizerQuestions(){
        session.removeAttribute("plant");
        return "redirect:/index";
    }

    @PostMapping("/submitFertilizerType")
    public String submitFertilizerType(@RequestParam String fertilizerType){
        List<FertilizerModel> fertilizerList = null;
        if (fertilizerType.equals("mono_fertilizer")){
            fertilizerList = fertilizerService.getFertilizersByType(FertilizerType.BASAL_MONO_FERTILIZER);
            session.setAttribute("fertilizers", fertilizerList);
        }
        else if (fertilizerType.equals("complex_fertilizer")){
            fertilizerList = fertilizerService.getFertilizersByType(FertilizerType.BASAL_COMPLEX_FERTILIZER);
            session.setAttribute("fertilizers", fertilizerList);
            return "complex_fertilizers";
        }
        else if (fertilizerType.equals("no_basal_fertilizer")){
            fertilizerList = fertilizerService.getFertilizersByType(FertilizerType.TOP_DRESSING_FERTILIZER);
            session.setAttribute("fertilizers", fertilizerList);
        }

        if (fertilizerList != null) {
            AnalysisModel analysis = (AnalysisModel)session.getAttribute("analysis");
            PlanModel plan = analysis.calculate(fertilizerList);
            session.setAttribute("plan", plan);
            return "plan";
        }
        return "fertilizer_questions";
    }
}
