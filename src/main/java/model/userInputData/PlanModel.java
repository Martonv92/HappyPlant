package model.userInputData;


import org.springframework.beans.factory.annotation.Autowired;
import repository.PlantRepository;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PlanModel")
public class PlanModel {

    @Autowired
    PlantRepository plantRepository;

    @Temporal(TemporalType.DATE)
    private Date planDate;

    private TargetModel targetModel;

    @OneToOne
    private Integer userId;

    @OneToOne
    private AnalysisModel analysisModel;

}
