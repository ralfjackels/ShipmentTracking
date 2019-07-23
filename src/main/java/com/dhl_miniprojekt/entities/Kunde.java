package com.dhl_miniprojekt.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Kunde {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(nullable = false, updatable = false)
private Integer id;

private String vorName;
private String nachName;
private String strasse;
private String hausNummer;
private String plz;
private String stadt;
private String land;


    @OneToMany(mappedBy = "empfaenger") //@ManyToOne bei empfaenger Objekt in Sendung
    private List<Sendung> empfaengerListe = new ArrayList<>();

    @OneToMany(mappedBy = "absender") //@ManyToOne bei absender Objekt in Sendung
    private List<Sendung> absenderListe = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Sendung> getEmpfaengerListe() {
        return empfaengerListe;
    }

    public void setEmpfaengerListe(List<Sendung> empfaengerListe) {
        this.empfaengerListe = empfaengerListe;
    }

    public List<Sendung> getAbsenderListe() {
        return absenderListe;
    }

    public void setAbsenderListe(List<Sendung> absenderListe) {
        this.absenderListe = absenderListe;
    }

    public String getVorName() {
        return vorName;
    }

    public void setVorName(String vorName) {
        this.vorName = vorName;
    }

    public String getNachName() {
        return nachName;
    }

    public void setNachName(String nachName) {
        this.nachName = nachName;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getHausNummer() {
        return hausNummer;
    }

    public void setHausNummer(String hausNummer) {
        this.hausNummer = hausNummer;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }
}
