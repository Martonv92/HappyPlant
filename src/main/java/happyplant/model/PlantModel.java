package happyplant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class PlantModel {

    @Id
    @GeneratedValue
    private int plantId;

    @NotNull
    @NotEmpty
    private String plantType;

    @NotNull
    @NotEmpty
    private Double idealPH;

    @NotNull
    @NotEmpty
    private Double idealEC;


    @NotNull
    @NotEmpty
    private Integer daysUntilHarvest;

    @NotNull
    @NotEmpty
    private Integer rootDepthInCentimeters;

    @NotNull
    @NotEmpty
    private Integer maxYieldInTonsPerHectar;


    @NotNull
    @NotEmpty
    private Double nitrogenNeeds;

    @NotNull
    @NotEmpty
    private Double phosphorusNeeds;

    @NotNull
    @NotEmpty
    private Double kaliumNeeds;


    @NotNull
    @NotEmpty
    private Double magnesiumNeeds;

    @NotNull
    @NotEmpty
    private Double calciumNeeds;

    /*private Double ironNeeds;
    private Double zincNeeds;
    private Double boronNeeds;
    private Double copperNeeds;
    private Double natriumNeeds;
    private Double chlorineNeeds;
    private Double manganeseNeeds;
    private Double molybdenumNeeds;
    private Double sulfurNeeds;
    private Double siliconNeeds;*/

    public PlantModel() {
    }

    public PlantModel(String plantType,

                      Double idealPH,
                      Double idealEC,

                      Integer daysUntilHarvest,
                      Integer rootDepthInCentimeters,
                      Integer maxYieldInTonsPerHectar,

                      Double nitrogenNeeds,
                      Double phosphorusNeeds,
                      Double kaliumNeeds,

                      Double magnesiumNeeds,
                      Double calciumNeeds

                 /*Double ironNeeds,
                 Double zincNeeds,
                 Double boronNeeds,
                 Double copperNeeds,
                 Double natriumNeeds,
                 Double chlorineNeeds,
                 Double manganeseNeeds,
                 Double molybdenumNeeds,
                 Double sulfurNeeds,
                 Double siliconNeeds*/)
    {

        this.plantType = plantType;
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
        /*this.ironNeeds = ironNeeds;
        this.zincNeeds = zincNeeds;
        this.boronNeeds = boronNeeds;
        this.copperNeeds = copperNeeds;
        this.natriumNeeds = natriumNeeds;
        this.chlorineNeeds = chlorineNeeds;
        this.manganeseNeeds = manganeseNeeds;
        this.molybdenumNeeds = molybdenumNeeds;
        this.sulfurNeeds = sufurNeeds;
        this.siliconNeeds = siliconNeeds;*/
    }

    public Integer getPlantId() {
        return plantId;
    }

    public void setPlantId(Integer plantId) {
        this.plantId = plantId;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
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
