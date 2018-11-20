package happyplant.repository;

import happyplant.model.PlanModel;
import happyplant.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PlanRepository extends JpaRepository<PlanModel, Integer> {
    public List<PlanModel> findAllByUser(UserModel user);
}
