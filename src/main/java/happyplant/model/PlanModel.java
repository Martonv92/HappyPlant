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
    private int planId;

    @Temporal(TemporalType.DATE)
    private Date planDate;

    @OneToOne
    private int userId;

    @OneToOne
    private int analysisModelId;

    @OneToOne
    private int targetModelId;

    @Min(0)
    @Max(5000)
    @NotNull
    @NotEmpty
    private Double nitrogenResult;

    @Min(0)
    @Max(5000)
    @NotNull
    @NotEmpty
    private Double phosphorusResult;

    @Min(0)
    @Max(5000)
    @NotNull
    @NotEmpty
    private Double kaliumResult;

    @Min(0)
    @Max(5000)
    @NotNull
    @NotEmpty
    private Double magnesiumResult;

    @Min(0)
    @Max(5000)
    @NotNull
    @NotEmpty
    private Double calciumResult;

    public PlanModel() {
    }

    public PlanModel(Date planDate, Integer userId, Integer analysisModelId, Integer targetModelId,
                     @Min(0) @Max(5000) @NotNull @NotEmpty Double nitrogenResult,
                     @Min(0) @Max(5000) @NotNull @NotEmpty Double phosphorusResult,
                     @Min(0) @Max(5000) @NotNull @NotEmpty Double kaliumResult,
                     @Min(0) @Max(5000) @NotNull @NotEmpty Double magnesiumResult,
                     @Min(0) @Max(5000) @NotNull @NotEmpty Double calciumResult) {
        this.planDate = planDate;
        this.userId = userId;
        this.analysisModelId = analysisModelId;
        this.targetModelId = targetModelId;
        this.nitrogenResult = nitrogenResult;
        this.phosphorusResult = phosphorusResult;
        this.kaliumResult = kaliumResult;
        this.magnesiumResult = magnesiumResult;
        this.calciumResult = calciumResult;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAnalysisModelId() {
        return analysisModelId;
    }

    public void setAnalysisModelId(Integer analysisModelId) {
        this.analysisModelId = analysisModelId;
    }

    public Integer getTargetModelId() {
        return targetModelId;
    }

    public void setTargetModelId(Integer targetModelId) {
        this.targetModelId = targetModelId;
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
