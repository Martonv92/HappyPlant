package happyplant.controller;

import happyplant.model.PlanModel;
import happyplant.model.PlantModel;
import happyplant.model.UserModel;
import happyplant.repository.PlanRepository;
import happyplant.repository.PlantRepository;
import happyplant.repository.UserRepository;
import happyplant.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    final HttpSession session;

    final PlanRepository planRepository;

    final PlantRepository plantRepository;

    final UserRepository userRepository;

    final RegistrationService registrationService;

    @Autowired
    public IndexController(HttpSession session, PlantRepository plantRepository, PlanRepository planRepository, UserRepository userRepository, RegistrationService registrationService) {
        this.session = session;
        this.plantRepository = plantRepository;
        this.planRepository = planRepository;
        this.userRepository = userRepository;
        this.registrationService = registrationService;
    }

    @GetMapping("/index")
    public String indexGet(){

        if (session.getAttribute("user") == null) {
            return "redirect:/registration";
        }
        session.setAttribute("viewMode", false);
        if (session.getAttribute("plant") != null) {
            session.removeAttribute("plant");
        }
        if (session.getAttribute("analysis") != null) {
            session.removeAttribute("analysis");
        }
        PlanModel plan;
        if (session.getAttribute("plan") != null) {
            plan = (PlanModel) session.getAttribute("plan");
            if (plan.isSaved())
                session.removeAttribute("plan");
        }
        List<PlanModel> plans = planRepository.findAllByUser((UserModel)session.getAttribute("user"));
        if (session.getAttribute("plans") == null) {
            session.setAttribute("plans", plans);
        }
        return "index";
    }

    @GetMapping("/logoutFromIndex")
    public String logoutFromIndex(){
        session.invalidate();
        return "registration_login";
    }

    @GetMapping("/getFinishedPlansFromIndex")
    public String getFinishedPlans(){
        return "finished_plans";
    }

    @PostMapping("/analysis")
    public String choosePlant(@RequestParam String plantName) {
        PlantModel plant = plantRepository.findByPlantName(plantName);
        session.setAttribute("plant", plant);
        session.setAttribute("plantMaxYield", plant.getMaxYieldInTonsPerHectar());
        return "redirect:/analysis_form";
    }

    @PostMapping("/deleteAccount")
    public String deleteAccount() {
        UserModel user = (UserModel)session.getAttribute("user");
        String email = user.getEmail();
        registrationService.deleteUser(userRepository.findByEmail(email));
        session.invalidate();
        return "redirect:/";
    }
}