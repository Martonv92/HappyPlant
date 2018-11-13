package model.userInputData;

import model.plant.Plant;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class UserTarget {

    //tonsPerKm2 needs to check MaxYield!

    @NotEmpty
    @NotNull
    Double userArea;

    @NotNull
    @NotEmpty
    Double tonsPerKm2;

    @NotNull
    @NotEmpty
    Plant plantType;

    public UserTarget(@NotEmpty @NotNull Double userArea, @NotNull @NotEmpty Double tonsPerKm2, @NotNull @NotEmpty Plant plantType) {
        this.userArea = userArea;
        if(tonsPerKm2 > )
            this.tonsPerKm2 = tonsPerKm2;
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

    public Double getTonsPerKm2() {
        return tonsPerKm2;
    }

    public void setTonsPerKm2(Double tonsPerKm2) {
        this.tonsPerKm2 = tonsPerKm2;
    }
}
