package happyplant.repository;

import happyplant.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    UserModel findByEmail(String email);
}