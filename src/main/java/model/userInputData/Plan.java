package model.userInputData;


import org.springframework.beans.factory.annotation.Autowired;
import repository.PlantRepository;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class Plan {

    @Autowired
    PlantRepository plantRepository;

    @Temporal(TemporalType.DATE)
    private Date planDate;

    private UserTarget userTarget;
    private Integer userId;
    private Analysis analysis;

}
