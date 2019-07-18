package com.dhl_miniprojekt.model;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 
 */
public class Sendung {



    // Attribute
    private Integer sendungNummer;
    private boolean standard;
    private  Adresse lieferAdresse;
    private Adresse startAdresse;
    private Lieferstatus lieferstatus;
    private LocalDateTime abgabeZeitpunkt;
    private LocalDateTime lieferZeitpunkt;


    // Konstruktor
    public Sendung() {
    }

    public Sendung(Integer sendungNummer, boolean standard, Adresse lieferAdresse, Adresse startAdresse, Lieferstatus lieferstatus, LocalDateTime abgabeZeitpunkt, LocalDateTime lieferZeitpunkt) {
        this.sendungNummer = sendungNummer;
        this.standard = standard;
        this.lieferAdresse = lieferAdresse;
        this.startAdresse = startAdresse;
        this.lieferstatus = lieferstatus;
        this.abgabeZeitpunkt = abgabeZeitpunkt;
        this.lieferZeitpunkt = lieferZeitpunkt;
    }

}