package model.plant;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Plant {

    @NotNull
    @NotEmpty
    private String plantName;

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
    private Integer maxYieldInTonsPerKm2;


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
    private Double sufurNeeds;
    private Double siliconNeeds;*/


    public Plant(String plantName,

                 Double idealPH,
                 Double idealEC,

                 Integer daysUntilHarvest,
                 Integer rootDepthInCentimeters,
                 Integer maxYieldInTonsPerKm2,

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
                 Double sufurNeeds,
                 Double siliconNeeds*/)
    {

        this.plantName = plantName;
        this.idealPH = idealPH;
        this.idealEC = idealEC;
        this.daysUntilHarvest = daysUntilHarvest;
        this.rootDepthInCentimeters = rootDepthInCentimeters;
        this.maxYieldInTonsPerKm2 = maxYieldInTonsPerKm2;
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
        this.sufurNeeds = sufurNeeds;
        this.siliconNeeds = siliconNeeds;*/
    }
}
