package happyplant.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "FertilizerModel")
public class FertilizerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String dealer;

    private String name;

    @Enumerated
    private FertilizerType fertilizerType;

    @Min(0)
    @Max(5000)
    private Double nitrogenContent;

    @Min(0)
    @Max(5000)
    private Double phosphorusContent;

    @Min(0)
    @Max(5000)
    private Double kaliumContent;

    @Min(0)
    @Max(5000)
    private Double magnesiumContent;

    @Min(0)
    @Max(5000)
    private Double calciumContent;

    @Min(0)
    @Max(25)
    private Integer dkgPerM2;

    public FertilizerModel() {
    }

    public FertilizerModel(String dealer, String name, FertilizerType fertilizerType, @Min(0) @Max(5000) Double nitrogenContent, @Min(0) @Max(5000) Double phosphorusContent, @Min(0) @Max(5000) Double kaliumContent, @Min(0) @Max(5000) Double magnesiumContent, @Min(0) @Max(5000) Double calciumContent, @Min(0) @Max(12) Integer dkgPerM2) {
        this.dealer = dealer;
        this.name = name;
        this.fertilizerType = fertilizerType;
        this.nitrogenContent = nitrogenContent;
        this.phosphorusContent = phosphorusContent;
        this.kaliumContent = kaliumContent;
        this.magnesiumContent = magnesiumContent;
        this.calciumContent = calciumContent;
        this.dkgPerM2 = dkgPerM2;
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

    public Double getNitrogenContent() {
        return nitrogenContent;
    }

    public void setNitrogenContent(Double nitrogenContent) {
        this.nitrogenContent = nitrogenContent;
    }

    public Double getPhosphorusContent() {
        return phosphorusContent;
    }

    public void setPhosphorusContent(Double phosphorusContent) {
        this.phosphorusContent = phosphorusContent;
    }

    public Double getKaliumContent() {
        return kaliumContent;
    }

    public void setKaliumContent(Double kaliumContent) {
        this.kaliumContent = kaliumContent;
    }

    public Double getMagnesiumContent() {
        return magnesiumContent;
    }

    public void setMagnesiumContent(Double magnesiumContent) {
        this.magnesiumContent = magnesiumContent;
    }

    public Double getCalciumContent() {
        return calciumContent;
    }

    public void setCalciumContent(Double calciumContent) {
        this.calciumContent = calciumContent;
    }

    public Integer getDkgPerM2() {
        return dkgPerM2;
    }

    public void setDkgPerM2(Integer dkgPerM2) {
        this.dkgPerM2 = dkgPerM2;
    }
}
