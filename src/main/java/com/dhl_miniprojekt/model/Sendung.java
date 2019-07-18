package com.dhl_miniprojekt.model;
import java.time.LocalDateTime;

/**
 * 
 */
public class Sendung {



    // Attribute
    private Integer sendungNummer;
    private boolean standard;
    private  Adresse lieferAdresse;
    private Adresse startAdresse;
    private LieferstatusEnum lieferstatusEnum;
    private LocalDateTime abgabeZeitpunkt;
    private LocalDateTime lieferZeitpunkt;


    // Konstruktor
    public Sendung() {
    }

    public Sendung(Integer sendungNummer, boolean standard, Adresse lieferAdresse, Adresse startAdresse, LieferstatusEnum lieferstatusEnum, LocalDateTime abgabeZeitpunkt, LocalDateTime lieferZeitpunkt) {
        this.sendungNummer = sendungNummer;
        this.standard = standard;
        this.lieferAdresse = lieferAdresse;
        this.startAdresse = startAdresse;
        this.lieferstatusEnum = lieferstatusEnum;
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

    public LieferstatusEnum getLieferstatusEnum() {
        return lieferstatusEnum;
    }

    public void setLieferstatusEnum(LieferstatusEnum lieferstatusEnum) {
        this.lieferstatusEnum = lieferstatusEnum;
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