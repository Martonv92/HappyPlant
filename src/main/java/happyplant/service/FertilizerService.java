package happyplant.service;

import happyplant.model.FertilizerModel;
import happyplant.model.FertilizerType;
import happyplant.repository.FertilizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FertilizerService {

    @Autowired
    FertilizerRepository fertilizerRepository;

    public List<FertilizerModel> getFertilizersByType(FertilizerType fertilizerType){
        List<FertilizerModel> list = fertilizerRepository.getAllByFertilizerType(fertilizerType);
        return list;
    }
}
