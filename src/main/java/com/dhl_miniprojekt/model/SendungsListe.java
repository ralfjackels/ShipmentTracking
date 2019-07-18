package com.dhl_miniprojekt.model;

import jdk.vm.ci.meta.Local;

import java.time.LocalDateTime;
import java.util.*;

/**
 * 
 */
public class SendungsListe {

    private List<Sendung> sendungsliste;


    public SendungsListe() {
        this.sendungsliste = erstelleSendungsListe();
    }

    public List erstelleSendungsListe() {

        Adresse adresse1 = new Adresse("Hansstraße", "25", "Köln", 50969, "Deutschland", "Ralf Jaeckels");
        Adresse adresse2 = new Adresse("Bonzenstr.", "60", "Hamburg", 20257, "Deutschland", "Martin Terens");
        Adresse adresse3 = new Adresse("Neue Landstr.", "1", "Berlin", 10101, "Deutschland", "Laura Lewinski");
        Adresse adresse4 = new Adresse("Autobahnstr.", "99", "München", 89969, "Deutschland", "Maria Gut");
        Adresse adresse5 = new Adresse("Platz", "1", "Köln", 50969, "Deutschland", "Oli Hock");

        Sendung sendung1 = new Sendung(1,true, adresse1, adresse2, LieferstatusEnum.AUFGEGEBEN, LocalDateTime.now().minusDays(2), LocalDateTime.now().plusDays(1));
        Sendung sendung2 = new Sendung(2, true, adresse2, adresse1, LieferstatusEnum.IN_ZUSTELLUNG, LocalDateTime.now().minusDays(2), LocalDateTime.now().plusDays(1));
        Sendung sendung3 = new Sendung(3, false, adresse3, adresse4, LieferstatusEnum.ZUGESTELLT, LocalDateTime.now().minusDays(10), LocalDateTime.now().minusDays(1));
        Sendung sendung4 = new Sendung(4, true, adresse4, adresse5, LieferstatusEnum.AUFGEGEBEN, LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(4));
        Sendung sendung5 = new Sendung(5, false, adresse5, adresse4, LieferstatusEnum.ZUGESTELLT, LocalDateTime.now().minusDays(50), LocalDateTime.now().minusDays(20));

        sendungsliste.add(sendung1);
        sendungsliste.add(sendung2);
        sendungsliste.add(sendung3);
        sendungsliste.add(sendung4);
        sendungsliste.add(sendung5);

        return sendungsliste;

    }

    // Getter und Setter
    public List<Sendung> getSendungsliste() {
        return sendungsliste;
    }

    public void setSendungsliste(List<Sendung> sendungsliste) {
        this.sendungsliste = sendungsliste;
    }
}