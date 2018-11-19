package happyplant.service;

import happyplant.model.Usr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import happyplant.repository.UserRepository;

@Service
public class RegistrationService {

    @Autowired
    UserRepository userRepository;

    public void registerUser(Usr newUser) {
        userRepository.save(newUser);
    }
}
