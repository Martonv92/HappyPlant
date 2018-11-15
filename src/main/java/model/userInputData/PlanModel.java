package model.userInputData;


import org.springframework.beans.factory.annotation.Autowired;
import repository.PlanRepository;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PlanModel")
public class PlanModel {

    @Autowired
    PlanRepository planRepository;

    @Id
    @GeneratedValue
    private Integer planId;

    @Temporal(TemporalType.DATE)
    private Date planDate;

    private TargetModel targetModel;

    @OneToOne
    private Integer userId;

    @OneToOne
    private AnalysisModel analysisModel;

    //needs more fields

    public PlanModel() {
    }
}
