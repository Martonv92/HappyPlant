package model.userModel;

import model.userdata.Plan;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class UserModel {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @NotEmpty
    private String name;

    @OneToMany
    private Set<Plan> plans = new HashSet<>();

    @NotNull
    @NotEmpty
    private String userName;

    @NotNull
    @NotEmpty
    private String hashedPassword;

    @Email
    @NotNull

    @NotEmpty
    @Column(unique = true)
    private String email;

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
