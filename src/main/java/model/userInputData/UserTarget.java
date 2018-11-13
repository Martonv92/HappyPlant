package model.userInputData;

import model.plant.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import repository.PlantRepository;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class UserTarget {

    //tonsPerHectar needs to check MaxYield!

    @Autowired
    private PlantRepository plantRepository;

    @NotEmpty
    @NotNull
    Double userArea;

    @NotNull
    @NotEmpty
    Integer tonsPerHectar;

    @NotNull
    @NotEmpty
    Plant plantType;

    public UserTarget(@NotEmpty @NotNull Double userArea, @NotNull @NotEmpty Integer tonsPerHectar, @NotNull @NotEmpty Plant plantType) {
        this.userArea = userArea;

        //needs solution
        if(tonsPerHectar > )
            this.tonsPerHectar = tonsPerHectar;
        else ();

        this.plantType = plantType;
    }

    public Plant getPlantType() {
        return plantType;
    }

    public void setPlantType(Plant plantType) {
        this.plantType = plantType;
    }

    public Double getUserArea() {
        return userArea;
    }

    public void setUserArea(Double userArea) {
        this.userArea = userArea;
    }

    public Double getTonsPerHectar() {
        return tonsPerHectar;
    }

    public void setTonsPerHectar(Double tonsPerHectar) {
        this.tonsPerHectar = tonsPerHectar;
    }
}
