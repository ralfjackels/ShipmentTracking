package com.dhl_miniprojekt.model;
import java.time.LocalDateTime;

public class Sendung {

    // Attribute
    private String sendungNummer;
    private StandardversandEnum versandArt;
    private Adresse lieferAdresse;
    private Adresse startAdresse;
    private LieferstatusEnum lieferstatusEnum;
    private LocalDateTime abgabeZeitpunkt;
    private LocalDateTime lieferZeitpunkt;

    // Konstruktor


    public Sendung(String sendungNummer) {
        this.sendungNummer = sendungNummer;
    }

    public Sendung() {
    }

    public Sendung(String sendungNummer, StandardversandEnum versandArt, Adresse lieferAdresse, Adresse startAdresse, LieferstatusEnum lieferstatusEnum, LocalDateTime abgabeZeitpunkt, LocalDateTime lieferZeitpunkt) {
        this.sendungNummer = sendungNummer;
        this.versandArt = versandArt;
        this.lieferAdresse = lieferAdresse;
        this.startAdresse = startAdresse;
        this.lieferstatusEnum = lieferstatusEnum;
        this.abgabeZeitpunkt = abgabeZeitpunkt;
        this.lieferZeitpunkt = lieferZeitpunkt;
    }

    // Getter und Setter
    public String getSendungNummer() {
        return sendungNummer;
    }

    public void setSendungNummer(String sendungNummer) {
        this.sendungNummer = sendungNummer;
    }

    public StandardversandEnum getVersandArt() {
        return versandArt;
    }

    public void setVersandArt(StandardversandEnum versandArt) {
        this.versandArt = versandArt;
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