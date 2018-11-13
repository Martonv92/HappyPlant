package repository;

import model.userInputData.TargetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface TargetRepository extends JpaRepository<TargetModel, Integer> {
}
