package model.userModel;

import model.userInputData.AnalysisModel;
import model.userInputData.PlanModel;
import model.userInputData.TargetModel;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "User")
public class UserModel {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @NotNull
    @NotEmpty
    private String userName;

    @NotEmpty
    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @NotEmpty
    @Column(nullable = false, unique = true)
    @Email
    private String backupEmail;

    @NotNull
    @NotEmpty
    private String hashedPassword;


    @OneToMany(mappedBy = "userId")
    private List<TargetModel> targetModels;

    @OneToMany(mappedBy = "userId")
    private List<PlanModel> planModels;

    @OneToMany(mappedBy = "userId")
    private List<AnalysisModel> analysisModels;

    public UserModel() {
    }

    public UserModel(String firstName, String lastName, String userName, String password, String email, String backupEmail, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.hashedPassword = password;
        this.email = email;
        this.backupEmail = backupEmail;
        this.dateOfBirth = dateOfBirth;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String password) {
        this.hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBackupEmail() {
        return backupEmail;
    }

    public void setBackupEmail(String backupEmail) {
        this.backupEmail = backupEmail;
    }


}
