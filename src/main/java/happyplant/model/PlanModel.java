package happyplant.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "PlanModel")
public class PlanModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date planDate;

    @ManyToOne
    private UserModel user;

    @OneToOne
    private AnalysisModel analysis;

    @Min(0)
    @Max(5000)
    @NotNull
    private Double nitrogenResult;

    @Min(0)
    @Max(5000)
    @NotNull
    private Double phosphorusResult;

    @Min(0)
    @Max(5000)
    @NotNull
    private Double kaliumResult;

    @Min(0)
    @Max(5000)
    @NotNull
    private Double magnesiumResult;

    @Min(0)
    @Max(5000)
    @NotNull
    private Double calciumResult;

    public PlanModel() {
    }

    public PlanModel(Date planDate, UserModel user, AnalysisModel analysis,
                     @Min(0) @Max(5000) @NotNull Double nitrogenResult,
                     @Min(0) @Max(5000) @NotNull Double phosphorusResult,
                     @Min(0) @Max(5000) @NotNull Double kaliumResult,
                     @Min(0) @Max(5000) @NotNull Double magnesiumResult,
                     @Min(0) @Max(5000) @NotNull Double calciumResult) {
        this.planDate = planDate;
        this.user = user;
        this.analysis = analysis;
        this.nitrogenResult = nitrogenResult;
        this.phosphorusResult = phosphorusResult;
        this.kaliumResult = kaliumResult;
        this.magnesiumResult = magnesiumResult;
        this.calciumResult = calciumResult;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public AnalysisModel getAnalysis() {
        return analysis;
    }

    public void setAnalysis(AnalysisModel analysis) {
        this.analysis = analysis;
    }

    public Double getNitrogenResult() {
        return nitrogenResult;
    }

    public void setNitrogenResult(Double nitrogenResult) {
        this.nitrogenResult = nitrogenResult;
    }

    public Double getPhosphorusResult() {
        return phosphorusResult;
    }

    public void setPhosphorusResult(Double phosphorusResult) {
        this.phosphorusResult = phosphorusResult;
    }

    public Double getKaliumResult() {
        return kaliumResult;
    }

    public void setKaliumResult(Double kaliumResult) {
        this.kaliumResult = kaliumResult;
    }

    public Double getMagnesiumResult() {
        return magnesiumResult;
    }

    public void setMagnesiumResult(Double magnesiumResult) {
        this.magnesiumResult = magnesiumResult;
    }

    public Double getCalciumResult() {
        return calciumResult;
    }

    public void setCalciumResult(Double calciumResult) {
        this.calciumResult = calciumResult;
    }
}


