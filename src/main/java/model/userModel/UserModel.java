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
    private String name;

    @NotNull
    @NotEmpty
    private String userName;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @NotNull
    @NotEmpty
    private String hashedPassword;

    @NotEmpty
    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @NotEmpty
    @Column(nullable = false, unique = true)
    @Email
    private String backupEmail;

    @OneToMany(mappedBy = "userId")
    private List<TargetModel> targets;

    @OneToMany(mappedBy = "userId")
    private List<PlanModel> planModels;

    @OneToMany(mappedBy = "userId")
    private List<AnalysisModel> analyses;

    public UserModel() {
    }

    public UserModel(String name, String userName, String password, String email, String backupEmail) {
        this.name = name;
        this.userName = userName;
        this.hashedPassword = password;
        this.email = email;
        this.backupEmail = backupEmail;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
