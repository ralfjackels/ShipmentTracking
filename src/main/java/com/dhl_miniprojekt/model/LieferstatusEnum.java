package com.dhl_miniprojekt.model;
/**
 * 
 */
public enum LieferstatusEnum {

    AUFGEGEBEN("Aufgegeben"), ZUGESTELLT("Zugestellt"), IN_ZUSTELLUNG("In Zustellung");

    private String lieferstatus;

    LieferstatusEnum(String lieferstatus) {
        this.lieferstatus = lieferstatus;
    }

    public String getLieferstatus() {
        return lieferstatus;
    }

    public void setLieferstatus(String lieferstatus) {
        this.lieferstatus = lieferstatus;
    }

}