package happyplant.repository;

import happyplant.model.PlanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PlanRepository extends JpaRepository<PlanModel, Integer> {
}
