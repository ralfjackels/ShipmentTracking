package com.dhl_miniprojekt.model;

public enum StandardversandEnum {

    STANDARD("Standard"), EXPRESS("Express");

    private String versandArt;

    StandardversandEnum(String versandArt) {
        this.versandArt = versandArt;
    }

    public String getVersandArt() {
        return versandArt;
    }

    public void setVersandArt(String versandArt) {
        this.versandArt = versandArt;
    }
}
