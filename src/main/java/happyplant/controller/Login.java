package happyplant.controller;

import happyplant.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Login {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password){
        loginService.login(email, password);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginGet(){
        return "login";
    }
}

