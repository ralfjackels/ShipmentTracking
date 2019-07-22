package com.dhl_miniprojekt.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Kunde {

    @Id
    @GeneratedValue
private Integer id;

private String vorName;
private String nachName;
private String strasse;
private String hausNummer;
private String plz;
private String stadt;
private String land;

@ManyToOne
@JoinColumn
private Sendung sendung;

    @OneToMany(mappedBy = "sendung")
    private List<Kunde> kommentare = new ArrayList<>();


    public Sendung getSendung() {
        return sendung;
    }

    public void setSendung(Sendung sendung) {
        this.sendung = sendung;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
