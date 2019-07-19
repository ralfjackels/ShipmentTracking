package com.dhl_miniprojekt;

import com.dhl_miniprojekt.model.LieferstatusEnum;
import com.dhl_miniprojekt.model.Sendung;
import com.dhl_miniprojekt.model.SendungsListe;

import java.util.*;

public class Controller {

//    SendungsListe sendungsliste = new SendungsListe();
    private SendungsListe sendungsHashMap = new SendungsListe();

    // Attribute
    private Integer gesuchteSendung;

    // Konstruktor
    public Controller() {
    }

    // Methoden
    public void fuegeSendungHinzu() {
        // TODO implement here
    }


    public void sucheSendungsnummer(int gesuchteSendung) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gebe eine Sendungsnummer ein");
        Integer sendungsnummer;

        do {
            System.out.println("Bitte gebe eine korrekte Sendungsnummer ein");
            sendungsnummer = scanner.nextInt();
        } while (!sendungsHashMap.getSendungslisteMap().containsKey(sendungsnummer));

        if (sendungsHashMap.getSendungslisteMap().containsKey(sendungsnummer)) {
            System.out.println(sendungsHashMap.getSendungslisteMap().get(sendungsnummer).getLieferstatusEnum());

        }
    }

    public void zeigeSendung() {
        // TODO implement here
    }

}


