package happyplant.controller;

import happyplant.model.AnalysisModel;
import happyplant.model.PlantModel;
import happyplant.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

@Controller
public class AnalysisController {

    private final HttpSession session;

    @Autowired
    public AnalysisController(HttpSession session) {
        this.session = session;
    }

    @GetMapping("/analysis_form")
    public String analysisGet() {

        if (session.getAttribute("user") == null) {
            return "redirect:/registration_login";
        }
        return "analysis_form";
    }

    @GetMapping("/logoutFromAnalysis")
    public String logoutFromAnalysis() {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/backToIndexFromAnalysis")
    public String backToIndexFromAnalysis(){
        session.removeAttribute("plant");
        return "redirect:/index";
    }

    @PostMapping("/submitAnalysis")
    public String submitAnalysis(
            @RequestParam("nitrogen") Double nitrogen,
            @RequestParam("phosphorus") Double phosphorus,
            @RequestParam("kalium") Double kalium,
            @RequestParam("magnesium") Double magnesium,
            @RequestParam("calcium") Double calcium,
            @RequestParam("ph") Double ph,
            @RequestParam("ec") Double ec,
            @RequestParam("area_hectar") Integer area_hectar,
            @RequestParam("tonsPerHectar") Integer tonsPerHectar) {

        AnalysisModel newAnalysis = new AnalysisModel((UserModel) session.getAttribute("user"), nitrogen, phosphorus, kalium, magnesium, calcium, ph, ec, area_hectar, tonsPerHectar, (PlantModel) session.getAttribute("plant"));
        session.setAttribute("analysis", newAnalysis);
        return "fertilizer_questions";
    }
}
