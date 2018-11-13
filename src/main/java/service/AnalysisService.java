package service;

import model.userInputData.AnalysisModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AnalysisRepository;

@Service
public class AnalysisService {

    @Autowired
    AnalysisRepository analysisRepository;

    public void addNewAnalysis(AnalysisModel newAnalysis) { analysisRepository.save(newAnalysis);
    }


}
