package happyplant.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "AnalysisModel")
public class AnalysisModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private UserModel user;

    @Min(0)
    @Max(5000)
    @NotNull
    private Double nitrogen;

    @Min(0)
    @Max(5000)
    @NotNull
    private Double phosphorus;

    @Min(0)
    @Max(5000)
    @NotNull
    private Double kalium;

    @Min(0)
    @Max(5000)
    @NotNull
    private Double magnesium;

    @Min(0)
    @Max(5000)
    @NotNull
    private Double calcium;

    @Min(0)
    @Max(12)
    @NotNull
    private Double PH;

    @Min(0)
    @Max(20)
    @NotNull
    private Double EC;

    @NotNull
    private Integer userAreaInHectar;

    @NotNull
    private Integer tonsPerHectar;

    @OneToOne
    private PlantModel plantModelType;


    public AnalysisModel() {
    }

    public AnalysisModel(UserModel user, @Min(0) @Max(5000) @NotNull Double nitrogen, @Min(0) @Max(5000) @NotNull Double phosphorus, @Min(0) @Max(5000) @NotNull Double kalium, @Min(0) @Max(5000) @NotNull Double magnesium, @Min(0) @Max(5000) @NotNull Double calcium, @Min(0) @Max(12) @NotNull Double PH, @Min(0) @Max(20) @NotNull Double EC, @NotNull Integer userAreaInHectar, @NotNull Integer tonsPerHectar, PlantModel plantModelType) {
        this.user = user;
        this.nitrogen = nitrogen;
        this.phosphorus = phosphorus;
        this.kalium = kalium;
        this.magnesium = magnesium;
        this.calcium = calcium;
        this.PH = PH;
        this.EC = EC;
        this.userAreaInHectar = userAreaInHectar;
        this.tonsPerHectar = tonsPerHectar;
        this.plantModelType = plantModelType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    /*public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }*/

    public Double getNitrogen() {
        return nitrogen;
    }

    public void setNitrogen(Double nitrogen) {
        this.nitrogen = nitrogen;
    }

    public Double getPhosphorus() {
        return phosphorus;
    }

    public void setPhosphorus(Double phosphorus) {
        this.phosphorus = phosphorus;
    }

    public Double getKalium() {
        return kalium;
    }

    public void setKalium(Double kalium) {
        this.kalium = kalium;
    }

    public Double getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(Double magnesium) {
        this.magnesium = magnesium;
    }

    public Double getCalcium() {
        return calcium;
    }

    public void setCalcium(Double calcium) {
        this.calcium = calcium;
    }

    public Double getPH() {
        return PH;
    }

    public void setPH(Double PH) {
        this.PH = PH;
    }

    public Double getEC() {
        return EC;
    }

    public void setEC(Double EC) {
        this.EC = EC;
    }

    public Integer getUserAreaInHectar() {
        return userAreaInHectar;
    }

    public void setUserAreaInHectar(Integer userAreaInHectar) {
        this.userAreaInHectar = userAreaInHectar;
    }

    public Integer getTonsPerHectar() {
        return tonsPerHectar;
    }

    public void setTonsPerHectar(Integer tonsPerHectar) {
        this.tonsPerHectar = tonsPerHectar;
    }

    public PlantModel getPlantModelType() {
        return plantModelType;
    }

    public void setPlantModelType(PlantModel plantModelType) {
        this.plantModelType = plantModelType;
    }

}
