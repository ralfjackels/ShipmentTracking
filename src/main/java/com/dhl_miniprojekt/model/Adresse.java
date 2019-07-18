package com.dhl_miniprojekt.model;

public class Adresse {

    private String strasse;
    private String hausnummer;
    private  String stadt;
    private int plz;
    String land;
    private String name;

    public Adresse() {

    }

    public Adresse(String strasse, String hausnummer, String stadt, int plz, String land, String name) {
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.stadt = stadt;
        this.plz = plz;
        this.land = land;
        this.name = name;
    }

}