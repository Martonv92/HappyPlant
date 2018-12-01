package happyplant.repository;

import happyplant.model.FertilizerModel;
import happyplant.model.FertilizerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FertilizerRepository extends JpaRepository<FertilizerModel, Integer> {
    List<FertilizerModel> getAllByFertilizerType(FertilizerType fertilizerType);

}