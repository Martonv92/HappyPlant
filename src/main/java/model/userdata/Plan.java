package model.userdata;

import model.userModel.UserModel;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class Plan {

    @Temporal(TemporalType.DATE)
    private Date planDate;

    private UserTarget userTarget;
    private Integer userId;
    private Analysis analysis;

}
