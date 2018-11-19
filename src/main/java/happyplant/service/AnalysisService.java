package happyplant.service;

import happyplant.model.Analysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import happyplant.repository.AnalysisRepository;

@Service
public class AnalysisService {

    @Autowired
    AnalysisRepository analysisRepository;

    public void addNewAnalysis(Analysis newAnalysis) { analysisRepository.save(newAnalysis);
    }

}