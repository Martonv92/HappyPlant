package happyplant.controller;

import happyplant.model.AccessLevel;
import happyplant.model.UserModel;
import happyplant.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import happyplant.service.RegistrationService;

import javax.servlet.http.HttpSession;

@Controller
public class RegistrationLoginController {

    @Autowired
    HttpSession session;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        loginService.login(email, password);
        return "redirect:/";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam("user_name") String userName, @RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName, @RequestParam("email") String email, @RequestParam("backup_email") String backupEmail, @RequestParam("password") String password) {
        UserModel newUser = new UserModel();
        newUser.setUserName(userName);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setBackupEmail(backupEmail);
        newUser.setHashedPassword(password);
        newUser.setAccessLevel(AccessLevel.USER);
        registrationService.registerUser(newUser);
        return "redirect:/registrationlogin";
    }

    @GetMapping("/registration")
    public String regGet(){
        return "registrationlogin";
    }

}