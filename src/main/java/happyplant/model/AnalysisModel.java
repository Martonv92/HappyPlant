package happyplant.model;

import org.decimal4j.util.DoubleRounder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private Double nitrogen;

    @Min(0)
    @Max(5000)
    private Double phosphorus;

    @Min(0)
    @Max(5000)
    private Double kalium;

    @Min(0)
    @Max(5000)
    private Double magnesium;

    @Min(0)
    @Max(5000)
    private Double calcium;

    @Min(0)
    @Max(12)
    private Double PH;

    @Min(0)
    @Max(20)
    private Double EC;

    @NotNull
    private Integer userAreaInHectar;

    @NotNull
    private Integer tonsPerHectar;

    @OneToOne
    private PlantModel plantType;


    public AnalysisModel() {
    }

    public AnalysisModel(UserModel user, @Min(0) @Max(5000) @NotNull Double nitrogen, @Min(0) @Max(5000) @NotNull Double phosphorus, @Min(0) @Max(5000) @NotNull Double kalium, @Min(0) @Max(5000) @NotNull Double magnesium, @Min(0) @Max(5000) @NotNull Double calcium, @Min(0) @Max(12) @NotNull Double PH, @Min(0) @Max(20) @NotNull Double EC, @NotNull Integer userAreaInHectar, @NotNull Integer tonsPerHectar, PlantModel plantType) {
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
        this.plantType = plantType;
    }

    public PlanModel calculate(List<FertilizerModel> fertilizers){

        Double nitrogenNeededLimes = (plantType.getNitrogenNeedsInKgPerHa()-nitrogen)*0.1;
        Double phosphorusNeededLimes = (plantType.getPhosphorusNeedsInKgPerHa()-phosphorus)*0.6;
        Double kaliumNeededLimes = (plantType.getKaliumNeedsInKgPerHa()-kalium)*0.4;
        Double magnesiumNeededLimes = (plantType.getMagnesiumNeedsInKgPerHa()-magnesium)*0.5;
        Double calciumNeededLimes = (plantType.getCalciumNeedsInKgPerHa()-calcium)*0.1;

        Double nitrogenNeeded = (plantType.getNitrogenNeedsInKgPerHa()-nitrogen);
        Double phosphorusNeeded = (plantType.getPhosphorusNeedsInKgPerHa()-phosphorus);
        Double kaliumNeeded = (plantType.getKaliumNeedsInKgPerHa()-kalium);
        Double magnesiumNeeded = (plantType.getMagnesiumNeedsInKgPerHa()-magnesium);
        Double calciumNeeded = (plantType.getCalciumNeedsInKgPerHa()-calcium);

        List<Double[]> fertilizerAmountList = new ArrayList<>();
        List<Double[]> fertilizerAmountPerHectarList = new ArrayList<>();

        Double[] plantNeeds = {nitrogenNeededLimes, phosphorusNeededLimes, kaliumNeededLimes};

        if (fertilizers.size() == 1){
            FertilizerModel fertilizer = fertilizers.get(0);
            Double[][] basalFertilizerMinMaxAmount = getBasalFertilizer(plantNeeds, fertilizer);
            fertilizerAmountList.add(basalFertilizerMinMaxAmount[0]);
            fertilizerAmountPerHectarList.add(basalFertilizerMinMaxAmount[1]);

            Date date = new Date();
            String dateString = extractDate(date);
            return new PlanModel(dateString, user, this, nitrogenNeeded, phosphorusNeeded, kaliumNeeded, magnesiumNeeded, calciumNeeded, this.plantType, fertilizers, fertilizerAmountList, fertilizerAmountPerHectarList);

        } else if (fertilizers.size() > 1){
            return new PlanModel();
        }
        return new PlanModel();
    }

    private Double[][] getBasalFertilizer(Double[] plantNeeds, FertilizerModel fertilizer) {
        Double[][] results = {null, null};
        Double[] minMaxFertilizerAmountInKilos = {null, null};
        Double[] minMaxFertilizerAmountInTonsPerHectar = {null, null};
        Double smallestValue = plantNeeds[0];
        if (plantNeeds[1] < smallestValue && plantNeeds[1] < plantNeeds[2]){
            smallestValue = plantNeeds[1];
            minMaxFertilizerAmountInKilos[0] = findMaxAmountOfBasalFertilizerInTonsPerHectar(smallestValue, fertilizer.getMinDkgPerM2(), fertilizer.getPhosphorusContentPercentage())*userAreaInHectar;
            minMaxFertilizerAmountInKilos[1] = findMaxAmountOfBasalFertilizerInTonsPerHectar(smallestValue, fertilizer.getMaxDkgPerM2(), fertilizer.getPhosphorusContentPercentage())*userAreaInHectar;
            minMaxFertilizerAmountInTonsPerHectar[0] = findMaxAmountOfBasalFertilizerInTonsPerHectar(smallestValue, fertilizer.getMinDkgPerM2(), fertilizer.getPhosphorusContentPercentage())/1000;
            minMaxFertilizerAmountInTonsPerHectar[1] = findMaxAmountOfBasalFertilizerInTonsPerHectar(smallestValue, fertilizer.getMaxDkgPerM2(), fertilizer.getPhosphorusContentPercentage())/1000;
            results[0] = minMaxFertilizerAmountInKilos;
            results[1] = minMaxFertilizerAmountInTonsPerHectar;
            return results;

        }
        if (plantNeeds[2] < smallestValue){
            smallestValue = plantNeeds[2];
            minMaxFertilizerAmountInKilos[0] = findMaxAmountOfBasalFertilizerInTonsPerHectar(smallestValue, fertilizer.getMinDkgPerM2(), fertilizer.getKaliumContentPercentage())*userAreaInHectar;
            minMaxFertilizerAmountInKilos[1] = findMaxAmountOfBasalFertilizerInTonsPerHectar(smallestValue, fertilizer.getMaxDkgPerM2(), fertilizer.getKaliumContentPercentage())*userAreaInHectar;
            minMaxFertilizerAmountInTonsPerHectar[0] = findMaxAmountOfBasalFertilizerInTonsPerHectar(smallestValue, fertilizer.getMinDkgPerM2(), fertilizer.getKaliumContentPercentage())/1000;
            minMaxFertilizerAmountInTonsPerHectar[1] = findMaxAmountOfBasalFertilizerInTonsPerHectar(smallestValue, fertilizer.getMaxDkgPerM2(), fertilizer.getKaliumContentPercentage())/1000;
            results[0] = minMaxFertilizerAmountInKilos;
            results[1] = minMaxFertilizerAmountInTonsPerHectar;
            return results;

        }
        //minMaxFertilizerAmountInKilos[0] = findMaxAmountOfBasalFertilizerInTonsPerHectar(smallestValue, fertilizer.getMinDkgPerM2(), fertilizer.getNitrogenContentPercentage())*userAreaInHectar;
        //minMaxFertilizerAmountInKilos[1] = findMaxAmountOfBasalFertilizerInTonsPerHectar(smallestValue, fertilizer.getMaxDkgPerM2(), fertilizer.getNitrogenContentPercentage())*userAreaInHectar;
        minMaxFertilizerAmountInTonsPerHectar[0] = findMaxAmountOfBasalFertilizerInTonsPerHectar(smallestValue, fertilizer.getMinDkgPerM2(), fertilizer.getNitrogenContentPercentage())/1000;
        minMaxFertilizerAmountInTonsPerHectar[1] = findMaxAmountOfBasalFertilizerInTonsPerHectar(smallestValue, fertilizer.getMaxDkgPerM2(), fertilizer.getNitrogenContentPercentage())/1000;
        minMaxFertilizerAmountInKilos[0] = minMaxFertilizerAmountInTonsPerHectar[0]*userAreaInHectar;
        minMaxFertilizerAmountInKilos[1] = minMaxFertilizerAmountInTonsPerHectar[1]*userAreaInHectar;
        results[0] = minMaxFertilizerAmountInKilos;
        results[1] = minMaxFertilizerAmountInTonsPerHectar;
        return results;
    }

    private Double findMaxAmountOfBasalFertilizerInTonsPerHectar(Double smallestValue, Integer dkgPerM2, Double nutrientContent) {
        int dkgPerHa = dkgPerM2 * 10000;
        int kgPerHa = dkgPerHa / 100;
        Double result = DoubleRounder.round(smallestValue / (nutrientContent * kgPerHa), 3);
        return result;
    }


    private String extractDate(Date date) {
        String dateString = date.toString();
        String[] dateParts = dateString.split(" ");
        String toReturn = dateParts[5] + " " + dateParts[1] + " " + dateParts[2];
        return toReturn;
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

    public PlantModel getPlantType() {
        return plantType;
    }

    public void setPlantType(PlantModel plantType) {
        this.plantType = plantType;
    }

}
