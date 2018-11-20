package happyplant.model;

import org.mindrot.jbcrypt.BCrypt;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "UserModel")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

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

    @NotEmpty
    private String hashedPassword;

    @OneToMany(mappedBy = "user", targetEntity = PlanModel.class)
    private List<PlanModel> planModels;

    @OneToMany(mappedBy = "user", targetEntity = AnalysisModel.class)
    private List<AnalysisModel> analyses;

    @Enumerated
    @NotEmpty
    private AccessLevel accessLevel;

    public UserModel() {
    }

    public UserModel(@NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty String userName, @NotEmpty @Email String email, @NotEmpty @Email String backupEmail, @NotEmpty String hashedPassword, @NotEmpty AccessLevel accessLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.backupEmail = backupEmail;
        this.hashedPassword = BCrypt.hashpw(hashedPassword, BCrypt.gensalt());
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }


}
