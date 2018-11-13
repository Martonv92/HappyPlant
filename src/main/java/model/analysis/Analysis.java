package model.analysis;

import model.enums.SoilType;

public class Analysis {

    private Double nitrogen;
    private Double phosphorus;
    private Double kalium;

    private Double magnesium;
    private Double calcium;

    private Double iron;
    private Double zinc;
    private Double boron;
    private Double copper;
    private Double natrium;
    private Double chlorine;
    private Double manganese;
    private Double molybdenum;

    private Double PH;
    private Double EC;

    private SoilType soilType;

    public Analysis(Double nitrogen, Double phosphorus, Double kalium, Double magnesium, Double calcium, Double PH, Double EC) {
        this.nitrogen = nitrogen;
        this.phosphorus = phosphorus;
        this.kalium = kalium;
        this.magnesium = magnesium;
        this.calcium = calcium;
        this.PH = PH;
        this.EC = EC;
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

    public Double getIron() {
        return iron;
    }

    public void setIron(Double iron) {
        this.iron = iron;
    }

    public Double getZinc() {
        return zinc;
    }

    public void setZinc(Double zinc) {
        this.zinc = zinc;
    }

    public Double getBoron() {
        return boron;
    }

    public void setBoron(Double boron) {
        this.boron = boron;
    }

    public Double getCopper() {
        return copper;
    }

    public void setCopper(Double copper) {
        this.copper = copper;
    }

    public Double getNatrium() {
        return natrium;
    }

    public void setNatrium(Double natrium) {
        this.natrium = natrium;
    }

    public Double getChlorine() {
        return chlorine;
    }

    public void setChlorine(Double chlorine) {
        this.chlorine = chlorine;
    }

    public Double getManganese() {
        return manganese;
    }

    public void setManganese(Double manganese) {
        this.manganese = manganese;
    }

    public Double getMolybdenum() {
        return molybdenum;
    }

    public void setMolybdenum(Double molybdenum) {
        this.molybdenum = molybdenum;
    }
}
