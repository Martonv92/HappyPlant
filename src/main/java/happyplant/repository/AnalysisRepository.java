package happyplant.repository;

import happyplant.model.Analysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AnalysisRepository extends JpaRepository<Analysis, Integer> {
}
