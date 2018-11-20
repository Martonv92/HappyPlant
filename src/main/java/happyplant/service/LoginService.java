package happyplant.service;

import happyplant.model.UserModel;
import happyplant.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    HttpSession session;

    public String login(String email, String password) {
        Boolean isMatchingPassword = null;

        UserModel user = userRepository.findByEmail(email);
        String hashed = user.getHashedPassword();

        if (user == null) {
            return "login";
        } else {
            if (user.getHashedPassword() != null) {
                isMatchingPassword = checkPassword(password, hashed);
            }
        }

        if (isMatchingPassword) {
            session.setAttribute("user", user);
            return "redirect:/";
        } else {
            return "login";
        }
    }

    private boolean checkPassword(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);

    }
}
