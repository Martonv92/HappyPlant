package model.plant;

public abstract class Plant {

    private String plantName;

    private Double idealPH;
    private Double idealEC;

    private Integer daysUntilHarvest;
    private Integer rootDepthInCentimeters;
    Double maxYieldInTonsPerKm2;

    private Double nitrogenNeeds;
    private Double phosphorusNeeds;
    private Double kaliumNeeds;

    private Double magnesiumNeeds;
    private Double calciumNeeds;

    private Double ironNeeds;
    private Double zincNeeds;
    private Double boronNeeds;
    private Double copperNeeds;
    private Double natriumNeeds;
    private Double chlorineNeeds;
    private Double manganeseNeeds;
    private Double molybdenumNeeds;
    private Double sufurNeeds;
    private Double siliconNeeds;


    public Plant(String plantName,

                 Double idealPH,
                 Double idealEC,

                 Integer daysUntilHarvest,
                 Integer rootDepthInCentimeters,
                 Double maxYieldInTonsPerKm2,

                 Double nitrogenNeeds,
                 Double phosphorusNeeds,
                 Double kaliumNeeds,

                 Double magnesiumNeeds,
                 Double calciumNeeds,

                 Double ironNeeds,
                 Double zincNeeds,
                 Double boronNeeds,
                 Double copperNeeds,
                 Double natriumNeeds,
                 Double chlorineNeeds,
                 Double manganeseNeeds,
                 Double molybdenumNeeds,
                 Double sufurNeeds,
                 Double siliconNeeds)
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
        this.ironNeeds = ironNeeds;
        this.zincNeeds = zincNeeds;
        this.boronNeeds = boronNeeds;
        this.copperNeeds = copperNeeds;
        this.natriumNeeds = natriumNeeds;
        this.chlorineNeeds = chlorineNeeds;
        this.manganeseNeeds = manganeseNeeds;
        this.molybdenumNeeds = molybdenumNeeds;
        this.sufurNeeds = sufurNeeds;
        this.siliconNeeds = siliconNeeds;
    }
}
