package com.dhl_miniprojekt.model;



import com.dhl_miniprojekt.entities.Sendung;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 
 */
public class SendungsMap {

//    private List<Sendung> sendungsliste;
    private HashMap <String, Sendung> sendungslisteMap = new HashMap<>();

    public SendungsMap() {
        this.sendungslisteMap = erstelleSendungsListe();
    }

    public HashMap erstelleSendungsListe() {

        Adresse adresse1 = new Adresse("Hansstraße", "25", "Köln", 50969, "Deutschland", "Ralf Jackels");
        Adresse adresse2 = new Adresse("Bonzenstr.", "60", "Hamburg", 20257, "Deutschland", "Martin Terens");
        Adresse adresse3 = new Adresse("Neue Landstr.", "1", "Berlin", 10101, "Deutschland", "Laura Lewinski");
        Adresse adresse4 = new Adresse("Autobahnstr.", "99", "München", 89969, "Deutschland", "Maria Gut");
        Adresse adresse5 = new Adresse("Platz", "1", "Köln", 50969, "Deutschland", "Oli Hock");
//
//        Sendung sendung1 = new Sendung("1",StandardversandEnum.STANDARD, adresse1, adresse2, LieferstatusEnum.AUFGEGEBEN, LocalDate.now().minusDays(2), LocalDate.now().plusDays(1));
//        Sendung sendung2 = new Sendung("2", StandardversandEnum.STANDARD, adresse2, adresse1, LieferstatusEnum.IN_ZUSTELLUNG, LocalDate.now().minusDays(2), LocalDate.now().plusDays(1));
//        Sendung sendung3 = new Sendung("3", StandardversandEnum.EXPRESS, adresse3, adresse4, LieferstatusEnum.ZUGESTELLT, LocalDate.now().minusDays(10), LocalDate.now().minusDays(1));
//        Sendung sendung4 = new Sendung("4", StandardversandEnum.STANDARD, adresse4, adresse5, LieferstatusEnum.AUFGEGEBEN, LocalDate.now().minusDays(1), LocalDate.now().plusDays(4));
//        Sendung sendung5 = new Sendung("5", StandardversandEnum.EXPRESS, adresse5, adresse4, LieferstatusEnum.ZUGESTELLT, LocalDate.now().minusDays(50), LocalDate.now().minusDays(20));

//        sendungslisteMap.put("1",sendung1);
//        sendungslisteMap.put("2",sendung2);
//        sendungslisteMap.put("3",sendung3);
//        sendungslisteMap.put("4",sendung4);
//        sendungslisteMap.put("5",sendung5);

        return sendungslisteMap;

    }

    // Getter und Setter

    public HashMap<String, Sendung> getSendungslisteMap() {
        return sendungslisteMap;
    }

    public void setSendungslisteMap(HashMap<String, Sendung> sendungslisteMap) {
        this.sendungslisteMap = sendungslisteMap;
    }

}