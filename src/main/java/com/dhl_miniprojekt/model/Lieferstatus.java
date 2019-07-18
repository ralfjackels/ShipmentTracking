package com.dhl_miniprojekt.model;
/**
 * 
 */
public enum Lieferstatus {

    AUFGEGEBEN("Aufgegeben"), ZUGESTELLT("Zugestellt"), IN_ZUSTELLUNG("In Zustellung");

    private String lieferstatus;

    Lieferstatus(String lieferstatus) {
        this.lieferstatus = lieferstatus;
    }

    public String getLieferstatus() {
        return lieferstatus;
    }

    public void setLieferstatus(String lieferstatus) {
        this.lieferstatus = lieferstatus;
    }


}