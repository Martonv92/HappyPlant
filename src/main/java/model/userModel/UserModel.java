package model.userModel;

import model.userInputData.Plan;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Email
    @NotNull

    @NotEmpty
    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @NotEmpty
    @Column(nullable = false, unique = true)
    @Email
    private String backupEmail;

    @ElementCollection
    @CollectionTable(name = "Plan")
    @Column(name = "plan")
    List<Plan> planList;

    @OneToMany
    private Set<Plan> planSet = new HashSet<>();

    public UserModel() {
    }

    public UserModel(String name, String userName, String password, String email) {
        this.name = name;
        this.userName = userName;
        this.hashedPassword = password;
        this.email = email;
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
