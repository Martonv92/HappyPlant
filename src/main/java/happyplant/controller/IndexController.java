package happyplant.controller;

import happyplant.model.PlantModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

public class IndexController {

    @Autowired
    HttpSession session;

    @GetMapping("/")
    public String loginGet(){

        if (session.getAttribute("user") == null){
            return "login";
        }
        return "index";

    }

    @PostMapping("/plant")
    public String choosePlant(@RequestParam PlantModel plant){
        session.setAttribute("plant", plant);
        return "analysisform";
    }
}