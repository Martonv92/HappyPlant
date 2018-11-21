package happyplant.service;

import happyplant.model.UserModel;
import happyplant.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginService {


    final HttpSession session;

    final UserRepository userRepository;

    @Autowired
    public LoginService(HttpSession session, UserRepository userRepository) {
        this.session = session;
        this.userRepository = userRepository;
    }

    public boolean login(String email, String password) {
        Boolean isMatchingPassword = null;

        UserModel user = userRepository.findByEmail(email);
        String hashed;;

        if (user == null) {
            return false;
        } else {
            if (user.getHashedPassword() != null) {
                hashed  = user.getHashedPassword();
                isMatchingPassword = checkPassword(password, hashed);
            }
        }

        if (isMatchingPassword) {
            session.setAttribute("user", user);
            return true;
        } else {
            return false;
        }
    }

    private boolean checkPassword(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);

    }
}
