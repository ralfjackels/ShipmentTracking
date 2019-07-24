package com.dhl_miniprojekt;

import com.dhl_miniprojekt.entities.Kunde;
import com.dhl_miniprojekt.entities.Sendung;

import com.dhl_miniprojekt.repositories.KundeRepository;
import com.dhl_miniprojekt.repositories.SendungsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

/**
 * In dieser Klasse passiert die Steuerung der Webanwendung.
 */
@Controller
public class SendungsController {

    @Autowired
    private SendungsRepository SendungsRepository;

//    Für zukünftige Erweiterungen:
//    @Autowired
//    private KundeRepository kundeRepository;

    /**
     * Zeigt die Startseite an und erstellt ein neues Objekt Sendung im Model
     */
    @GetMapping(value = "/")
    public String zeigeStartseiteAn(Model model) {

        model.addAttribute("neueSendung", new Sendung());

        return "sendungsSuche";
    }

    /**
     * Bearbeitet die Nutzereingabe über das Formular.
     * Über Thymeleaf wird absichtlich die Versandart eingegeben, um eine NumberFormatException zu umgehen..
     */
    @PostMapping(value = "/sendungsSuche")
    public String bearbeiteEingabe(Model model, @ModelAttribute("neueSendung") Sendung sendung) {

        Sendung gefundeneSendung = new Sendung();

        // Falls die Eingabe
        if (sendung.getVersandArt().matches("[0-9]+")) {

            return vergleicheSendungsNummer(model, sendung, gefundeneSendung);

        } else {
            // Falls die Eingabe nicht nur aus Zahlen besteht, wird
            return setzeSendungsNummeraufNull(model, gefundeneSendung);
        }
    }

    /**
     * Diese Methode überprüft, ob die Sendungsnummer in der Datenbank vorhanden ist und gibt entweder ein leeres
     * Sendungsobjekt zurück oder ein mit Daten aus der Datenbank befülltes Objekt.
     */
    private String vergleicheSendungsNummer(Model model, @ModelAttribute("neueSendung") Sendung sendung, Sendung gefundeneSendung) {

        sendung.setSendungNummer(Integer.parseInt(sendung.getVersandArt()));

        // Überprüft ob die eingegebene Sendungsnummer in der Datenbank enthalten ist
        if (SendungsRepository.existsById(sendung.getSendungNummer())) {

            Optional<Sendung> optionalSendung = SendungsRepository.findById(sendung.getSendungNummer());
            gefundeneSendung = optionalSendung.get();

            // Empfänger und Absender Objekte werden erstellt, um auf der html-Seite auf die Attribute zugreifen zu können
            Kunde empfaenger = gefundeneSendung.getEmpfaenger();
            Kunde absender = gefundeneSendung.getAbsender();

            model.addAttribute("gefundeneSendung", gefundeneSendung);
            model.addAttribute("empfaenger", empfaenger);
            model.addAttribute("absender", absender);

            return "sendungsInfo";

        } else {

            return setzeSendungsNummeraufNull(model, gefundeneSendung);
        }
    }

    /**
     * Zeigt die Hilfeseite an
     */
    @GetMapping(value = "/hilfe")
    public String zeigeHilfeseiteAn(Model model) {

        model.addAttribute("neueSendung", new Sendung());

        return "hilfe";
    }

    /**
     * Diese Methode setzte die Sendungsnummer der gefundenen Sendung auf null und zeigt th:unless in der
     * sendungsInfo.html an
     */
    private String setzeSendungsNummeraufNull(Model model, Sendung gefundeneSendung) {
        gefundeneSendung.setSendungNummer(null);

        model.addAttribute("gefundeneSendung", gefundeneSendung);

        return "sendungsInfo";
    }
}