package happyplant.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

        Double nitrogenNeeded = (plantType.getNitrogenNeedsInKgPerHa()-nitrogen)*0.1;
        Double phosphorusNeeded = (plantType.getPhosphorusNeedsInKgPerHa()-phosphorus)*0.6;
        Double kaliumNeeded = (plantType.getKaliumNeedsInKgPerHa()-kalium)*0.4;
        Double magnesiumNeeded = (plantType.getMagnesiumNeedsInKgPerHa()-magnesium)*0.5;
        Double calciumNeeded = (plantType.getCalciumNeedsInKgPerHa()-calcium)*0.1;

        Double[] plantNeeds = {nitrogenNeeded, phosphorusNeeded, kaliumNeeded};

        if (fertilizers.size() == 1){
            FertilizerModel fertilizer = fertilizers.get(0);
            Double[] fertilizerData = {fertilizer.getNitrogenContentPercentage(), fertilizer.getPhosphorusContentPercentage(), fertilizer.getKaliumContentPercentage()};
            getBasalFertilizer(plantNeeds, fertilizerData, fertilizer.getMinDkgPerM2(), fertilizer.getMaxDkgPerM2());

            Date date = new Date();
            String dateString = extractDate(date);
            PlanModel result = new PlanModel(dateString, user, this, nitrogenNeeded, phosphorusNeeded, kaliumNeeded, magnesiumNeeded, calciumNeeded, this.plantType, );
            return result;



        } else if (fertilizers.size() > 1){

        }

    }

    private Integer[] getBasalFertilizer(Double[] plantNeeds, Double[] fertilizerData, Integer minDkgPerM2, Integer maxDkgPerM2) {
        Integer[] minMaxFertilizerAmountInKilos = {null, null};
        Double smallestValue = plantNeeds[0];
        if (plantNeeds[1] < smallestValue && plantNeeds[1] < plantNeeds[2]){
            smallestValue = plantNeeds[1];
            minMaxFertilizerAmountInKilos[0] = round(findMaxAmountOfBasalFertilizerInTonsPerHectar(smallestValue, minDkgPerM2, plantNeeds[1]),0);
            minMaxFertilizerAmountInKilos[1] = round(findMaxAmountOfBasalFertilizerInTonsPerHectar(smallestValue, maxDkgPerM2, plantNeeds[1]),0);
            return minMaxFertilizerAmountInKilos;

        }
        if (plantNeeds[2] < smallestValue){
            smallestValue = plantNeeds[2];
            minMaxFertilizerAmountInKilos[0] = round(findMaxAmountOfBasalFertilizerInTonsPerHectar(smallestValue, minDkgPerM2, plantNeeds[2]),0);
            minMaxFertilizerAmountInKilos[1] = round(findMaxAmountOfBasalFertilizerInTonsPerHectar(smallestValue, maxDkgPerM2, plantNeeds[2]),0);
            return minMaxFertilizerAmountInKilos;

        }
        minMaxFertilizerAmountInKilos[0] = round(findMaxAmountOfBasalFertilizerInTonsPerHectar(smallestValue, minDkgPerM2, plantNeeds[0]),0);
        minMaxFertilizerAmountInKilos[1] = round(findMaxAmountOfBasalFertilizerInTonsPerHectar(smallestValue, maxDkgPerM2, plantNeeds[0]),0);

        return minMaxFertilizerAmountInKilos;
    }

    public static Integer round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.intValue();
    }

    private Double findMaxAmountOfBasalFertilizerInTonsPerHectar(Double smallestValue, Integer dkgPerM2, Double nutrientContent) {
        int kgPerHa = dkgPerM2 * 100;
        return smallestValue / nutrientContent * kgPerHa;
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

    public PlantModel getPlantType() {
        return plantType;
    }

    public void setPlantType(PlantModel plantType) {
        this.plantType = plantType;
    }

}
