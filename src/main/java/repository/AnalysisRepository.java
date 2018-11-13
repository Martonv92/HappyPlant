package repository;

import model.userInputData.AnalysisModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AnalysisRepository extends JpaRepository<AnalysisModel, Integer> {
}
