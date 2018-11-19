package happyplant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PlantModel")
public class PlantModel {

    @Id
    @GeneratedValue
    private Integer plantId;

    @NotNull
    @NotEmpty
    private String plantName;

    @NotNull
    private Double idealPH;

    @NotNull
    private Double idealEC;


    @NotNull
    private Integer daysUntilHarvest;

    @NotNull
    private Integer rootDepthInCentimeters;

    @NotNull
    private Integer maxYieldInTonsPerHectar;

    @NotNull
    private Double nitrogenNeeds;

    @NotNull
    private Double phosphorusNeeds;

    @NotNull
    private Double kaliumNeeds;

    @NotNull
    private Double magnesiumNeeds;

    @NotNull
    private Double calciumNeeds;


    public PlantModel() {
    }

    public PlantModel(@NotNull @NotEmpty String plantName, @NotNull Double idealPH, @NotNull Double idealEC, @NotNull Integer daysUntilHarvest, @NotNull Integer rootDepthInCentimeters, @NotNull Integer maxYieldInTonsPerHectar, @NotNull Double nitrogenNeeds, @NotNull Double phosphorusNeeds, @NotNull Double kaliumNeeds, @NotNull Double magnesiumNeeds, @NotNull Double calciumNeeds) {
        this.plantName = plantName;
        this.idealPH = idealPH;
        this.idealEC = idealEC;
        this.daysUntilHarvest = daysUntilHarvest;
        this.rootDepthInCentimeters = rootDepthInCentimeters;
        this.maxYieldInTonsPerHectar = maxYieldInTonsPerHectar;
        this.nitrogenNeeds = nitrogenNeeds;
        this.phosphorusNeeds = phosphorusNeeds;
        this.kaliumNeeds = kaliumNeeds;
        this.magnesiumNeeds = magnesiumNeeds;
        this.calciumNeeds = calciumNeeds;
    }

    public Integer getPlantId() {
        return plantId;
    }

    public void setPlantId(Integer plantId) {
        this.plantId = plantId;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public Double getIdealPH() {
        return idealPH;
    }

    public void setIdealPH(Double idealPH) {
        this.idealPH = idealPH;
    }

    public Double getIdealEC() {
        return idealEC;
    }

    public void setIdealEC(Double idealEC) {
        this.idealEC = idealEC;
    }

    public Integer getDaysUntilHarvest() {
        return daysUntilHarvest;
    }

    public void setDaysUntilHarvest(Integer daysUntilHarvest) {
        this.daysUntilHarvest = daysUntilHarvest;
    }

    public Integer getRootDepthInCentimeters() {
        return rootDepthInCentimeters;
    }

    public void setRootDepthInCentimeters(Integer rootDepthInCentimeters) {
        this.rootDepthInCentimeters = rootDepthInCentimeters;
    }

    public Integer getMaxYieldInTonsPerHectar() {
        return maxYieldInTonsPerHectar;
    }

    public void setMaxYieldInTonsPerHectar(Integer maxYieldInTonsPerHectar) {
        this.maxYieldInTonsPerHectar = maxYieldInTonsPerHectar;
    }

    public Double getNitrogenNeeds() {
        return nitrogenNeeds;
    }

    public void setNitrogenNeeds(Double nitrogenNeeds) {
        this.nitrogenNeeds = nitrogenNeeds;
    }

    public Double getPhosphorusNeeds() {
        return phosphorusNeeds;
    }

    public void setPhosphorusNeeds(Double phosphorusNeeds) {
        this.phosphorusNeeds = phosphorusNeeds;
    }

    public Double getKaliumNeeds() {
        return kaliumNeeds;
    }

    public void setKaliumNeeds(Double kaliumNeeds) {
        this.kaliumNeeds = kaliumNeeds;
    }

    public Double getMagnesiumNeeds() {
        return magnesiumNeeds;
    }

    public void setMagnesiumNeeds(Double magnesiumNeeds) {
        this.magnesiumNeeds = magnesiumNeeds;
    }

    public Double getCalciumNeeds() {
        return calciumNeeds;
    }

    public void setCalciumNeeds(Double calciumNeeds) {
        this.calciumNeeds = calciumNeeds;
    }
}
