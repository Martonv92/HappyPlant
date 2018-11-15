package model.userInputData;

import model.plant.PlantModel;
import org.springframework.beans.factory.annotation.Autowired;
import repository.PlantRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Target")
public class TargetModel {


    @Autowired
    private PlantRepository plantRepository;


    @Id
    @GeneratedValue
    private Integer targetId;

    @NotEmpty
    @NotNull
    Double userArea;

    @NotNull
    @NotEmpty
    Integer tonsPerHectar;

    @NotNull
    @NotEmpty
    PlantModel plantModelType;

    public TargetModel() {
    }

    public TargetModel(@NotEmpty @NotNull Double userArea, @NotNull @NotEmpty Integer tonsPerHectar, @NotNull @NotEmpty PlantModel plantModelType) {
        this.userArea = userArea;

        if(tonsPerHectar > plantModelType.getMaxYieldInTonsPerHectar()){
            this.tonsPerHectar = plantModelType.getMaxYieldInTonsPerHectar();
        } else {
            this.tonsPerHectar = tonsPerHectar;
        }

        this.plantModelType = plantModelType;
    }

    public PlantModel getPlantModelType() {
        return plantModelType;
    }

    public void setPlantModelType(PlantModel plantModelType) {
        this.plantModelType = plantModelType;
    }

    public Double getUserArea() {
        return userArea;
    }

    public void setUserArea(Double userArea) {
        this.userArea = userArea;
    }

    public Integer getTonsPerHectar() {
        return tonsPerHectar;
    }

    public void setTonsPerHectar(Integer tonsPerHectar) {
        this.tonsPerHectar = tonsPerHectar;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }
}
