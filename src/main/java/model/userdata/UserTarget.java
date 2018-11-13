package model.userdata;

import model.plant.Plant;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    Plant plant;

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
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
