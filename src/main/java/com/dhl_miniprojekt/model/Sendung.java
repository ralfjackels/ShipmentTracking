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

    // Getter und Setter
    public Integer getSendungNummer() {
        return sendungNummer;
    }

    public void setSendungNummer(Integer sendungNummer) {
        this.sendungNummer = sendungNummer;
    }

    public boolean isStandard() {
        return standard;
    }

    public void setStandard(boolean standard) {
        this.standard = standard;
    }

    public Adresse getLieferAdresse() {
        return lieferAdresse;
    }

    public void setLieferAdresse(Adresse lieferAdresse) {
        this.lieferAdresse = lieferAdresse;
    }

    public Adresse getStartAdresse() {
        return startAdresse;
    }

    public void setStartAdresse(Adresse startAdresse) {
        this.startAdresse = startAdresse;
    }

    public Lieferstatus getLieferstatus() {
        return lieferstatus;
    }

    public void setLieferstatus(Lieferstatus lieferstatus) {
        this.lieferstatus = lieferstatus;
    }

    public LocalDateTime getAbgabeZeitpunkt() {
        return abgabeZeitpunkt;
    }

    public void setAbgabeZeitpunkt(LocalDateTime abgabeZeitpunkt) {
        this.abgabeZeitpunkt = abgabeZeitpunkt;
    }

    public LocalDateTime getLieferZeitpunkt() {
        return lieferZeitpunkt;
    }

    public void setLieferZeitpunkt(LocalDateTime lieferZeitpunkt) {
        this.lieferZeitpunkt = lieferZeitpunkt;
    }
}