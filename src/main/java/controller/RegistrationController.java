package controller;

import model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.RegistrationService;

import java.util.Date;

@Controller
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/registration")
    public String registration(@RequestParam("user_name") String userName, @RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName, @RequestParam("email") String email, @RequestParam("backup_email") String backupEmail, @RequestParam("password") String password, @RequestParam("birt_date") Date birtDate) {
        UserModel newUser = new UserModel();
        newUser.setUserName(userName);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setBackupEmail(backupEmail);
        newUser.setHashedPassword(password);
        newUser.setDateOfBirth(birtDate);
        registrationService.registerUser(newUser);
        return "redirect:/login";
    }

    @GetMapping("/registration")
    public String regGet(){
        return "registration";
    }

}