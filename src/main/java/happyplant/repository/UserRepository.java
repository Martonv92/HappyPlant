package happyplant.repository;

import happyplant.model.Usr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<Usr, Integer> {
    Usr findByEmail(String email);
}