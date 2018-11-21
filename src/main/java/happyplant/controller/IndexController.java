package happyplant.controller;

import happyplant.model.PlanModel;
import happyplant.model.PlantModel;
import happyplant.model.UserModel;
import happyplant.repository.PlanRepository;
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

    @Autowired
    HttpSession session;

    @Autowired
    PlanRepository planRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RegistrationService registrationService;

    @GetMapping("/index")
    public String loginGet(){

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
    public String choosePlant(@RequestParam PlantModel plant){
        session.setAttribute("plant", plant);
        return "redirect:/analysisform";
    }

    @GetMapping("/logout")
    public String logout(){
        session.invalidate();
        return "registration";
    }

    @PostMapping("/deleteAccount")
    public String deleteAccount(@RequestParam("email") String email, @RequestParam("password") String password){
        registrationService.deleteUser(userRepository.findByEmail(email));
        session.invalidate();
        return "redirect:/registration";
    }
}