package happyplant.service;

import happyplant.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import happyplant.repository.UserRepository;

@Service
public class RegistrationService {

    @Autowired
    UserRepository userRepository;

    public void registerUser(UserModel newUser) {
        userRepository.save(newUser);
    }
}
