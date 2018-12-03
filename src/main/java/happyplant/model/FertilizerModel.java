package happyplant.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "FertilizerModel")
public class FertilizerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    private String dealer;

    @NotEmpty
    private String name;

    @Enumerated
    private FertilizerType fertilizerType;

    @Min(0)
    @Max(40)
    private Double nitrogenContentPercentage;

    @Min(0)
    @Max(55)
    private Double phosphorusContentPercentage;

    @Min(0)
    @Max(55)
    private Double kaliumContentPercentage;

    @Min(0)
    @Max(25)
    private Double magnesiumContentPercentage;

    @Min(0)
    @Max(10)
    private Double calciumContentPercentage;

    @Min(0)
    @Max(25)
    private Integer minDkgPerM2;

    @Min(0)
    @Max(25)
    private Integer maxDkgPerM2;

    public FertilizerModel() {
    }

    public FertilizerModel(String dealer, String name,
                           FertilizerType fertilizerType,
                           @Min(0) @Max(5000) Double nitrogenContentPercentage,
                           @Min(0) @Max(5000) Double phosphorusContentPercentage,
                           @Min(0) @Max(5000) Double kaliumContentPercentage,
                           @Min(0) @Max(5000) Double magnesiumContentPercentage,
                           @Min(0) @Max(5000) Double calciumContentPercentage,
                           @Min(0) @Max(25) Integer minDkgPerM2,
                           @Min(0) @Max(12) Integer maxDkgPerM2) {
        this.dealer = dealer;
        this.name = name;
        this.fertilizerType = fertilizerType;
        this.nitrogenContentPercentage = nitrogenContentPercentage;
        this.phosphorusContentPercentage = phosphorusContentPercentage;
        this.kaliumContentPercentage = kaliumContentPercentage;
        this.magnesiumContentPercentage = magnesiumContentPercentage;
        this.calciumContentPercentage = calciumContentPercentage;
        this.minDkgPerM2 = minDkgPerM2;
        this.maxDkgPerM2 = maxDkgPerM2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FertilizerType getFertilizerType() {
        return fertilizerType;
    }

    public void setFertilizerType(FertilizerType fertilizerType) {
        this.fertilizerType = fertilizerType;
    }

    public Double getNitrogenContentPercentage() {
        return nitrogenContentPercentage;
    }

    public void setNitrogenContentPercentage(Double nitrogenContentPercentage) {
        this.nitrogenContentPercentage = nitrogenContentPercentage;
    }

    public Double getPhosphorusContentPercentage() {
        return phosphorusContentPercentage;
    }

    public void setPhosphorusContentPercentage(Double phosphorusContentPercentage) {
        this.phosphorusContentPercentage = phosphorusContentPercentage;
    }

    public Double getKaliumContentPercentage() {
        return kaliumContentPercentage;
    }

    public void setKaliumContentPercentage(Double kaliumContentPercentage) {
        this.kaliumContentPercentage = kaliumContentPercentage;
    }

    public Double getMagnesiumContentPercentage() {
        return magnesiumContentPercentage;
    }

    public void setMagnesiumContentPercentage(Double magnesiumContentPercentage) {
        this.magnesiumContentPercentage = magnesiumContentPercentage;
    }

    public Double getCalciumContentPercentage() {
        return calciumContentPercentage;
    }

    public void setCalciumContentPercentage(Double calciumContentPercentage) {
        this.calciumContentPercentage = calciumContentPercentage;
    }

    public Integer getMinDkgPerM2() {
        return minDkgPerM2;
    }

    public void setMinDkgPerM2(Integer minDkgPerM2) {
        this.minDkgPerM2 = minDkgPerM2;
    }

    public Integer getMaxDkgPerM2() {
        return maxDkgPerM2;
    }

    public void setMaxDkgPerM2(Integer maxDkgPerM2) {
        this.maxDkgPerM2 = maxDkgPerM2;
    }
}
