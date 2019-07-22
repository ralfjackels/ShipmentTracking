package com.dhl_miniprojekt.entities;


import com.dhl_miniprojekt.model.Adresse;
import com.dhl_miniprojekt.model.LieferstatusEnum;
import com.dhl_miniprojekt.model.StandardversandEnum;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Sendung {

    // Attribute
    @Id
    @GeneratedValue
    private Integer id;



    private String sendungNummer;
    private StandardversandEnum versandArt;
    private Kunde absender;
    private Kunde empfaenger;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}