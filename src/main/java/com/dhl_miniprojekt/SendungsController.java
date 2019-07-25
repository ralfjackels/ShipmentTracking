package com.dhl_miniprojekt;

import com.dhl_miniprojekt.entities.Sendung;
import com.dhl_miniprojekt.services.SendungsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * In dieser Klasse passiert die Steuerung der Webanwendung.
 */
@Controller
public class SendungsController {

    @Autowired
    SendungsService sendungsService;
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
     * Über Thymeleaf wird absichtlich die Versandart eingegeben, um die Nutzereingabe als String verarbeiten zu können.
     * @param sendung wird erstellt um die eingegebene Sendungsnummer einzuspeichern
     */
    @PostMapping(value = "/sendungsSuche")
    public String bearbeiteEingabe(Model model, @ModelAttribute("neueSendung") Sendung sendung) {

        Sendung gefundeneSendung = sendungsService.pruefeSendung(sendung);

        model.addAttribute("gefundeneSendung", gefundeneSendung);

        return "sendungsInfo";
    }

    /**
     * Zeigt die Hilfeseite an
     */
    @GetMapping(value = "/hilfe")
    public String zeigeHilfeseiteAn(Model model) {

        model.addAttribute("neueSendung", new Sendung());

        return "hilfe";
    }
}