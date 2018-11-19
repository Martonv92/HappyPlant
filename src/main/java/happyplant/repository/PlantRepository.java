package happyplant.repository;

import happyplant.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PlantRepository extends JpaRepository<Plant, Integer> {
    Plant findByPlantName(String plantName);
}