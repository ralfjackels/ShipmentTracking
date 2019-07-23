package com.dhl_miniprojekt.entities;

import com.dhl_miniprojekt.model.LieferstatusEnum;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Sendung {

    // Attribute
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

//    @ManyToOne
//    @JoinColumn
//    private Kunde kunde;




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