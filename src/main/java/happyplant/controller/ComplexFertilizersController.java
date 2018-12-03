package happyplant.controller;

import happyplant.model.AnalysisModel;
import happyplant.model.FertilizerModel;
import happyplant.model.PlanModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ComplexFertilizersController {

    private final HttpSession session;

    @Autowired
    public ComplexFertilizersController(HttpSession session) {
        this.session = session;
    }

    @GetMapping("/complex_fertilizer_questions")
    public String complexFertilizerQuestionsGet() {

        if (session.getAttribute("user") == null) {
            return "redirect:/registration_login";
        }
        return "fertilizer_questions";
    }

    @GetMapping("/logoutFromComplexFertilizers")
    public String logoutFromComplexFertilizers() {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/backToIndexFromComplexFertilizers")
    public String backToIndexFromComplexFertilizers(){
        session.removeAttribute("plant");
        session.removeAttribute("fertilizers");
        return "redirect:/index";
    }

    @PostMapping("/calculateWithFertilizer")
    public String calculateWithFertilizer(@RequestParam("fertilizer")FertilizerModel fertilizer){
        List<FertilizerModel> fertilizerList = new ArrayList<>();
        fertilizerList.add(fertilizer);
        session.setAttribute("fertilizers", fertilizerList);
        AnalysisModel analysis = (AnalysisModel)session.getAttribute("analysis");
        PlanModel plan = analysis.calculate(fertilizerList);
        session.setAttribute("plan", plan);
        return "plan";
    }
}
