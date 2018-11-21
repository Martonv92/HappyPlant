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

        if (session.getAttribute("user") == null){
            return "redirect:/registrationlogin";
        }
        return "index";
    }

    @GetMapping("/plans")
    public String getPreviousPlans(){
        List<PlanModel> plans = planRepository.findAllByUser((UserModel)session.getAttribute("user"));
        return "plans";
    }

    @PostMapping("/analysis")
    public String choosePlant(@RequestParam String plantName){
        PlantModel plant = plantRepository.findByPlantName(plantName);
        session.setAttribute("plant", plant);
        return "redirect:/analysisform";
    }

    @GetMapping("/logout")
    public String logout(){
        session.invalidate();
        return "registrationlogin";
    }

    @PostMapping("/deleteAccount")
    public String deleteAccount() {
        UserModel user = (UserModel)session.getAttribute("user");
        String email = user.getEmail();
        registrationService.deleteUser(userRepository.findByEmail(email));
        session.invalidate();
        return "redirect:/registrationlogin";
    }
}