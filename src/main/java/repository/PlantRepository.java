package repository;

import model.PlantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PlantRepository extends JpaRepository<PlantModel, Integer> {
    PlantModel findByPlantName(String plantName);
}