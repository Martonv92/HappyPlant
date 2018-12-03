package happyplant.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PlanModel")
public class PlanModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    private String planDate;

    @ManyToOne
    private UserModel user;

    @OneToOne
    private AnalysisModel analysisModel;

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

    @OneToOne
    private PlantModel plantType;

    @OneToMany
    private List<FertilizerModel> fertilizerList;

    @ElementCollection
    private List<Double[]> fertilizerAmount;

    @ElementCollection
    private List<Double[]> fertilizerAmountPerHectar;

    private boolean saved;


    public PlanModel() {
    }

    public PlanModel(String planDate, UserModel user, AnalysisModel analysisModel,
                     @Min(0) @Max(5000) @NotNull Double nitrogenResult,
                     @Min(0) @Max(5000) @NotNull Double phosphorusResult,
                     @Min(0) @Max(5000) @NotNull Double kaliumResult,
                     @Min(0) @Max(5000) @NotNull Double magnesiumResult,
                     @Min(0) @Max(5000) @NotNull Double calciumResult,
                     PlantModel plantType,
                     List<FertilizerModel> fertilizerList,
                     List<Double[]> fertilizerAmount,
                     List<Double[]> fertilizerAmountPerHectar) {
        this.planDate = planDate;
        this.user = user;
        this.analysisModel = analysisModel;
        this.nitrogenResult = nitrogenResult;
        this.phosphorusResult = phosphorusResult;
        this.kaliumResult = kaliumResult;
        this.magnesiumResult = magnesiumResult;
        this.calciumResult = calciumResult;
        this.plantType = plantType;
        this.fertilizerList = fertilizerList;
        this.fertilizerAmount = fertilizerAmount;
        this.fertilizerAmountPerHectar = fertilizerAmountPerHectar;
        this.saved = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public AnalysisModel getAnalysisModel() {
        return analysisModel;
    }

    public void setAnalysisModel(AnalysisModel analysisModel) {
        this.analysisModel = analysisModel;
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

    public PlantModel getPlantType() {
        return plantType;
    }

    public void setPlantType(PlantModel plantType) {
        this.plantType = plantType;
    }

    public List<FertilizerModel> getFertilizerList() {
        return fertilizerList;
    }

    public void setFertilizerList(List<FertilizerModel> fertilizerList) {
        this.fertilizerList = fertilizerList;
    }

    public List<Double[]> getFertilizerAmount() {
        return fertilizerAmount;
    }

    public void setFertilizerAmount(List<Double[]> fertilizerAmount) {
        this.fertilizerAmount = fertilizerAmount;
    }

    public List<Double[]> getFertilizerAmountPerHectar() {
        return fertilizerAmountPerHectar;
    }

    public void setFertilizerAmountPerHectar(List<Double[]> fertilizerAmountPerHectar) {
        this.fertilizerAmountPerHectar = fertilizerAmountPerHectar;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }
}


