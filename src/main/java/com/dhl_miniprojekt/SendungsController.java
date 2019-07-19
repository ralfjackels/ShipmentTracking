package com.dhl_miniprojekt;

import com.dhl_miniprojekt.model.Sendung;
import com.dhl_miniprojekt.model.SendungsMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 */
@Controller
public class SendungsController {

//    SendungsMap sendungsliste = new SendungsMap();

    private SendungsMap sendungsHashMap = new SendungsMap();


    // Konstruktor
    public SendungsController() {
    }

    // Methoden
    public void fuegeSendungHinzu() {
        // TODO implement here
    }

    /**
     * Zeigt die Startseite an und erstellt ein neues Objekt Sendung im Model
     */
    @GetMapping(value = "/")
    public String zeigeStartseiteAn(Model model) {

        model.addAttribute("neueSendung", new Sendung());

        return "sendungsSuche";
    }

    /**
     * Prüft ob die Sendung mit der Sendungsnummer vorhanden ist und ruft die nächste Seite auf
     * @param model
     * @param sendung
     * @return
     */


    @PostMapping(value = "/sendungsSuche")
    public String vergeleicheSendungsNummer (Model model, @ModelAttribute("neueSendung") Sendung sendung){

        Sendung gefundeneSendung = findeSendung(sendung.getSendungNummer());
        model.addAttribute("gefundeneSendung", gefundeneSendung);

        return "sendungsInfo";
    }

    /**
     * Findet die korrekte Sendung. Falls keine Sendung gefunden wurde, wird ein PopUp angezeigt
     * @param sendungNummer des im Model eingestellten Objekts
     * @return
     */
    private Sendung findeSendung(@RequestParam("sendungNummer") String sendungNummer) {

        Sendung gefundeneSendung = null;

        if (sendungsHashMap.getSendungslisteMap().containsKey(sendungNummer)){
            gefundeneSendung = sendungsHashMap.getSendungslisteMap().get(sendungNummer);
        } else {
            // TODO schreibe Methode
            //zeigePopUp();

        }
        return gefundeneSendung;
    }


}

