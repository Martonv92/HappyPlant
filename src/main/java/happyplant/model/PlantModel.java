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
    private Double nitrogenNeedsInKgPerHa;

    @NotNull
    private Double phosphorusNeedsInKgPerHa;

    @NotNull
    private Double kaliumNeedsInKgPerHa;

    @NotNull
    private Double magnesiumNeedsInKgPerHa;

    @NotNull
    private Double calciumNeedsInKgPerHa;

    @NotEmpty
    private String imageURL;


    public PlantModel() {
    }

    public PlantModel(@NotNull @NotEmpty String plantName,
                      @NotNull Double idealPH, @NotNull Double idealEC,
                      @NotNull Integer daysUntilHarvest, @NotNull Integer rootDepthInCentimeters, @NotNull Integer maxYieldInTonsPerHectar,
                      @NotNull Double nitrogenNeedsInKgPerHa, @NotNull Double phosphorusNeedsInKgPerHa, @NotNull Double kaliumNeedsInKgPerHa, @NotNull Double magnesiumNeedsInKgPerHa, @NotNull Double calciumNeedsInKgPerHa,
                      @NotEmpty String imageURL) {
        this.plantName = plantName;
        this.idealPH = idealPH;
        this.idealEC = idealEC;
        this.daysUntilHarvest = daysUntilHarvest;
        this.rootDepthInCentimeters = rootDepthInCentimeters;
        this.maxYieldInTonsPerHectar = maxYieldInTonsPerHectar;
        this.nitrogenNeedsInKgPerHa = nitrogenNeedsInKgPerHa;
        this.phosphorusNeedsInKgPerHa = phosphorusNeedsInKgPerHa;
        this.kaliumNeedsInKgPerHa = kaliumNeedsInKgPerHa;
        this.magnesiumNeedsInKgPerHa = magnesiumNeedsInKgPerHa;
        this.calciumNeedsInKgPerHa = calciumNeedsInKgPerHa;
        this.imageURL = imageURL;
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

    public Double getNitrogenNeedsInKgPerHa() {
        return nitrogenNeedsInKgPerHa;
    }

    public void setNitrogenNeedsInKgPerHa(Double nitrogenNeedsInKgPerHa) {
        this.nitrogenNeedsInKgPerHa = nitrogenNeedsInKgPerHa;
    }

    public Double getPhosphorusNeedsInKgPerHa() {
        return phosphorusNeedsInKgPerHa;
    }

    public void setPhosphorusNeedsInKgPerHa(Double phosphorusNeedsInKgPerHa) {
        this.phosphorusNeedsInKgPerHa = phosphorusNeedsInKgPerHa;
    }

    public Double getKaliumNeedsInKgPerHa() {
        return kaliumNeedsInKgPerHa;
    }

    public void setKaliumNeedsInKgPerHa(Double kaliumNeedsInKgPerHa) {
        this.kaliumNeedsInKgPerHa = kaliumNeedsInKgPerHa;
    }

    public Double getMagnesiumNeedsInKgPerHa() {
        return magnesiumNeedsInKgPerHa;
    }

    public void setMagnesiumNeedsInKgPerHa(Double magnesiumNeedsInKgPerHa) {
        this.magnesiumNeedsInKgPerHa = magnesiumNeedsInKgPerHa;
    }

    public Double getCalciumNeedsInKgPerHa() {
        return calciumNeedsInKgPerHa;
    }

    public void setCalciumNeedsInKgPerHa(Double calciumNeedsInKgPerHa) {
        this.calciumNeedsInKgPerHa = calciumNeedsInKgPerHa;
    }

    public String getImage() {
        return imageURL;
    }

    public void setImage(String imageURL) {
        this.imageURL = imageURL;
    }
}
