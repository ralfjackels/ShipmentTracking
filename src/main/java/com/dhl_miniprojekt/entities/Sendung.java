package com.dhl_miniprojekt.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Sendung {

    /**
     * Spring erstellt eine automatisierte ID, die hier als Sendungsnummer benutzt wird.
     * für die Datenbankanbindung über MariaDB/HeidiSQL wird folgendes Mapping verwendet:
     * 1 Kunde(Absender/Empfänger) hat viele Sendungen. Eine Sendung hat immer nur 1 Empfänger und 1 Absender.
     * Schnittstelle ist somit die KundenID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer sendungNummer;

    private String versandArt;
    private String lieferstatus;
    private LocalDate abgabedatum;
    private LocalDate lieferdatum;

    @ManyToOne
    private Kunde absender;

    @ManyToOne
    private Kunde empfaenger;

    public Sendung() {
    }

    public Sendung(String versandArt, String lieferstatus, LocalDate abgabedatum, LocalDate lieferdatum,
                   Kunde absender, Kunde empfaenger) {
        this.versandArt = versandArt;
        this.lieferstatus = lieferstatus;
        this.abgabedatum = abgabedatum;
        this.lieferdatum = lieferdatum;
        this.absender = absender;
        this.empfaenger = empfaenger;
    }

    // Getter & Setter
    public LocalDate getAbgabedatum() {
        return abgabedatum;
    }

    public void setAbgabedatum(LocalDate abgabedatum) {
        this.abgabedatum = abgabedatum;
    }

    public LocalDate getLieferdatum() {
        return lieferdatum;
    }

    public void setLieferdatum(LocalDate lieferdatum) {
        this.lieferdatum = lieferdatum;
    }

    public Kunde getAbsender() {
        return absender;
    }

    public void setAbsender(Kunde absender) {
        this.absender = absender;
    }

    public Kunde getEmpfaenger() {
        return empfaenger;
    }

    public void setEmpfaenger(Kunde empfaenger) {
        this.empfaenger = empfaenger;
    }

    public Integer getSendungNummer() {
        return sendungNummer;
    }

    public void setSendungNummer(Integer sendungNummer) {
        this.sendungNummer = sendungNummer;
    }

    public String getVersandArt() {
        return versandArt;
    }

    public void setVersandArt(String versandArt) {
        this.versandArt = versandArt;
    }

    public String getLieferstatus() {
        return lieferstatus;
    }

    public void setLieferstatus(String lieferstatus) {
        this.lieferstatus = lieferstatus;
    }
}