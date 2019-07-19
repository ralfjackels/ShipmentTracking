package com.dhl_miniprojekt;

import com.dhl_miniprojekt.model.Sendung;
import com.dhl_miniprojekt.model.SendungsMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 */
@Controller
public class SendungsController {

//    SendungsMap sendungsliste = new SendungsMap();

    private SendungsMap sendungsHashMap = new SendungsMap();

    // Attribute
    private Integer gesuchteSendung;

    // Konstruktor
    public SendungsController() {
    }

    // Methoden
    public void fuegeSendungHinzu() {
        // TODO implement here
    }

    @GetMapping(value = "/")
    public String sucheSendungsnummer(Model model, @RequestParam("sendungNummer") String sendungNummer) {

        model.addAttribute("neueSendung", new Sendung());

        Sendung gefundeneSendung = findeSendung(sendungNummer);


        return "sendungsInfo";
    }

    private Sendung findeSendung(@RequestParam("sendungNummer") String sendungNummer) {

        Sendung gefundeneSendung = null;

        if (sendungsHashMap.getSendungslisteMap().containsKey(sendungNummer)){
            gefundeneSendung = sendungsHashMap.getSendungslisteMap().get(sendungNummer);
        }
        return gefundeneSendung;
    }
}


