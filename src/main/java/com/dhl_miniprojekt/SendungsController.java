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
     * Über Thymeleaf wird absichtlich die Versandart eingegeben, um die Nutzereingabe als String verarbeiten zu können.
     *
     * @param sendung wird erstellt um die eingegebene Sendungsnummer einzuspeichern
     */
    @PostMapping(value = "/sendungsSuche")
    public String bearbeiteEingabe(Model model, @ModelAttribute("neueSendung") Sendung sendung) {

        Sendung gefundeneSendung = new Sendung();
        // Falls die Sendung nicht gefunden wurde, wird die Sendungsnummer auf null gesetzt,
        // um die Thymeleaf th:if und th:unless in der html-Seite ausführen zu können.
        gefundeneSendung.setSendungNummer(null);

       if (sendung.getVersandArt().matches("[0-9]+")) {

            sendung.setSendungNummer(Integer.parseInt(sendung.getVersandArt()));

           // Überprüft ob die eingegebene Sendungsnummer in der Datenbank enthalten ist
           if (SendungsRepository.existsById(sendung.getSendungNummer())) {

               Optional<Sendung> optionalSendung = SendungsRepository.findById(sendung.getSendungNummer());
               gefundeneSendung = optionalSendung.get();
           }
       }

        model.addAttribute("gefundeneSendung", gefundeneSendung);
        return "sendungsInfo";

    }

    /**
     * Zeigt die Hilfeseite an
     *
     * @param model
     * @return
     */
    @GetMapping(value = "/hilfe")
    public String zeigeHilfeseiteAn(Model model) {

        model.addAttribute("neueSendung", new Sendung());

        return "hilfe";
    }


}