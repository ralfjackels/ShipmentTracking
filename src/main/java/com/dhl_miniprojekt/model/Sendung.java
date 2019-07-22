package com.dhl_miniprojekt.model;
import jdk.vm.ci.meta.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sendung {

    // Attribute
    private String sendungNummer;
    private StandardversandEnum versandArt;
    private  Adresse lieferAdresse;
    private Adresse startAdresse;
    private LieferstatusEnum lieferstatusEnum;
    private LocalDate abgabeZeitpunkt;
    private LocalDate lieferZeitpunkt;

    // Konstruktor


    public Sendung(String sendungNummer) {
        this.sendungNummer = sendungNummer;
    }

    public Sendung() {
    }

    public Sendung(String sendungNummer, StandardversandEnum versandArt, Adresse lieferAdresse, Adresse startAdresse, LieferstatusEnum lieferstatusEnum, LocalDate abgabeZeitpunkt, LocalDate lieferZeitpunkt) {
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

    public LocalDate getAbgabeZeitpunkt() {
        return abgabeZeitpunkt;
    }

    public void setAbgabeZeitpunkt(LocalDate abgabeZeitpunkt) {
        this.abgabeZeitpunkt = abgabeZeitpunkt;
    }

    public LocalDate getLieferZeitpunkt() {
        return lieferZeitpunkt;
    }

    public void setLieferZeitpunkt(LocalDate lieferZeitpunkt) {
        this.lieferZeitpunkt = lieferZeitpunkt;
    }
}