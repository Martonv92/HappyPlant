package service;

import model.userInputData.TargetModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TargetRepository;

@Service
public class TargetService {

    @Autowired
    TargetRepository targetRepository;

    public void addNewTarget(TargetModel newTarget) { targetRepository.save(newTarget);
    }

}
