package com.dhl_miniprojekt;

import com.dhl_miniprojekt.entities.Sendung;
import com.dhl_miniprojekt.model.SendungsMap;
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
 *
 */
@Controller
public class SendungsController {

//    SendungsMap sendungsliste = new SendungsMap();

    @Autowired
    private KundeRepository kundeRepository;

    @Autowired
    private SendungsRepository SendungsRepository;

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


//    @PostMapping(value = "/sendungsSuche")
//    public String vergeleicheSendungsNummer (Model model,  @ModelAttribute("neueSendung") Sendung sendung){
//
//
//        Sendung gefundeneSendung = findeSendung(sendung.getSendungNummer());
//        model.addAttribute("gefundeneSendung", gefundeneSendung);
//
//        return "sendungsInfo";
//    }



// VERSUCH +++++++++++++++++++++++++++++++++++++++++++++++++++++++


    @PostMapping(value = "/sendungsSuche")
    public String vergeleicheSendungsNummer (@RequestParam String action, Model model, @ModelAttribute("neueSendung") Sendung sendung) {

        if(action.equals("Suchen")) {


            Optional<Sendung> optionalSendung = SendungsRepository.findById(sendung.getSendungNummer());
            Sendung gefundeneSendung = optionalSendung.get();


            model.addAttribute("gefundeneSendung", gefundeneSendung);

            return "sendungsInfo";

        } else {

            return "hilfe";

        }

    }




//    Weitere Suchanfragen auf sendungsSuche.Info


    @GetMapping(value = "/sendungsInfo")
    public String sucheWeitereSendungsnummer (Model model) {

        model.addAttribute("neueSendung", new Sendung());

        return "sendungsInfo";
    }


    @PostMapping(value = "/sendungsInfo")
    public String vergleicheWeitereSendungsnummer (Model model, @ModelAttribute("neueSendung") Sendung sendung){
//
//        Sendung gefundeneSendung = findeSendung(sendung.getSendungNummer());
//        model.addAttribute("gefundeneSendung", gefundeneSendung);

        return "sendungsInfo";
    }


// Hilfe


    /**
     * Findet die korrekte Sendung. Falls keine Sendung gefunden wurde, wird ein PopUp angezeigt
     * @param sendungNummer des im Model eingestellten Objekts
     * @return
     */
//    private Sendung findeSendung(@RequestParam("sendungNummer") String sendungNummer) {
//
//        Sendung gefundeneSendung = new Sendung();
//
//        if (sendungsHashMap.getSendungslisteMap().containsKey(sendungNummer)){
//
//            gefundeneSendung.setSendungNummer(sendungsHashMap.getSendungslisteMap().get(sendungNummer).getSendungNummer());
//            gefundeneSendung.setAbgabeZeitpunkt(sendungsHashMap.getSendungslisteMap().get(sendungNummer).getAbgabeZeitpunkt());
//            gefundeneSendung.setLieferAdresse(sendungsHashMap.getSendungslisteMap().get(sendungNummer).getLieferAdresse());
//            gefundeneSendung.setAbgabeZeitpunkt(sendungsHashMap.getSendungslisteMap().get(sendungNummer).getAbgabeZeitpunkt());
//            gefundeneSendung.setLieferstatusEnum(sendungsHashMap.getSendungslisteMap().get(sendungNummer).getLieferstatusEnum());
//            gefundeneSendung.setStartAdresse(sendungsHashMap.getSendungslisteMap().get(sendungNummer).getStartAdresse());
//            gefundeneSendung.setVersandArt(sendungsHashMap.getSendungslisteMap().get(sendungNummer).getVersandArt());
//            gefundeneSendung.setLieferZeitpunkt(sendungsHashMap.getSendungslisteMap().get(sendungNummer).getLieferZeitpunkt());
//
//        } else {
//            // TODO schreibe Methode
//            //zeigePopUp();
//
//        }
//        return gefundeneSendung;
//    }


}


